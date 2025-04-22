# Copyright 2017 Northern.tech AS
# Copyright 2022 Microchip Technology Inc
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# This class implements a MTD image to be written to a flash device
# Based largely on meta-mender-core/classes/mender-part-images.bbclass

do_image_mtd[recrdeptask] += "do_deploy"

def make_mtdparts_shell_array(d):
    """Makes a string that can be shell-eval'ed to get the components of the
    mtdparts string. See the "local mtd_..." definitions below."""

    mtdparts = d.getVar('MPFS_MTDPARTS')

    if mtdparts is None:
        return "bbfatal 'MPFS_MTDPARTS is not defined.'"

    if len(mtdparts) == 0:
        return "bbfatal 'MPFS_MTDPARTS is empty.'"

    active_mtdid = d.getVar('MPFS_IS_ON_MTDID')

    if active_mtdid is None:
        return "bbfatal 'MPFS_IS_ON_MTDID is not defined.'"

    if len(active_mtdid) == 0:
        return "bbfatal 'MPFS_IS_ON_MTDID is empty. Please set it to the mtdid inside MPFS_MTDPARTS that you want to use.'"

    import re

    # Breaking up the mtdparts string in shell is tricky, so do it here, and
    # just return a string that can be eval'ed in the shell. Can't use real bash
    # arrays though... sigh.
    count = 0
    total_offset = 0
    shell_cmd = ""
    remaining_encountered = False

    # Pick the mtdid that matches MPFS_IS_ON_MTDID.
    current_mtdparts = None
    for part in mtdparts.split(";"):
        if part.split(":")[0] == active_mtdid:
            current_mtdparts = part

    if current_mtdparts is None:
        return ("bbfatal 'Cannot find a valid mtdparts string inside MPFS_MTDPARTS (\"%s\"), "
                + "corresponding to MPFS_IS_ON_MTDID (\"%s\").'"
                % (mtdparts, active_mtdid))

    mtdparts = current_mtdparts

    # Skip first component (the ID).
    for component in mtdparts.split(":")[1].split(","):
        if len(component) == 0:
            continue

        if remaining_encountered:
            return "bbfatal \"'-' entry was not last entry in mtdparts: '%s'\"" % mtdparts

        match = re.match("^([0-9]+|-)([kmg]?)(?:@([0-9]+)([kmg]?))?\(([^)]+)\)(?:ro)?$", component)
        if match is None:
            return "bbfatal \"'%s' is not a valid mtdparts string. Please set MPFS_MTDPARTS to a valid value\"" % mtdparts

        # Make a shell array out of the mtdparts.
        if match.group(3) is None:
            offset = total_offset
        else:
            offset = mtdparts_convert_units_to_bytes(match.group(3), match.group(4))

        if match.group(1) == '-':
            size = '-'
            kbsize = '-'
            remaining_encountered = True
        else:
            size = mtdparts_convert_units_to_bytes(match.group(1), match.group(2))
            kbsize = int(size / 1024)
            total_offset = offset + size

        name = match.group(5)

        shell_cmd += "local mtd_sizes_%d='%s'\n" % (count, size)
        shell_cmd += "local mtd_kbsizes_%d='%s'\n" % (count, kbsize)
        shell_cmd += "local mtd_offsets_%d='%d'\n" % (count, offset)
        shell_cmd += "local mtd_kboffsets_%d='%d'\n" % (count, offset / 1024)
        shell_cmd += "local mtd_names_%d='%s'\n" % (count, name)

        count += 1

    shell_cmd += "local mtd_count=%d\n" % count

    return shell_cmd

def mtdparts_convert_units_to_bytes(number, unit):
    if unit is None or unit.lower() == '':
        to_return = int(number)
    elif unit.lower() == 'k':
        to_return = int(number) * 1024
    elif unit.lower() == 'm':
        to_return = int(number) * 1048576
    elif unit.lower() == 'g':
        to_return = int(number) * 1073741824
    else:
        bb.fatal("Cannot parse number '%s' and unit '%s'" % (number, unit))

    if to_return % 1024 != 0:
        bb.fatal("Numbers in mtdparts must be aligned to a KiB boundary")

    return to_return

flash_mtdpart() {
    local file="$1"
    local size="$2"
    local kbsize="$3"
    local kboffset="$4"
    local name="$5"

    if [ "$size" = "-" ]; then
        # Remaining space.
        local total_space_kb=$(expr 128 \* 1024)
        kbsize=$(expr $total_space_kb - $kboffset)
        size=$(expr $kbsize \* 1024)
    fi

    if [ "$file" != "/dev/zero" ]; then
        local file_size=$(stat -Lc '%s' "$file")
        if [ $file_size -gt $size ]; then
            bbfatal "$file is too big to fit inside '$name' mtdpart of size $size."
        fi
    fi
    # Flash zeros first to make sure that a shorter ubimg doesn't truncate the
    # write.
    dd if="/dev/zero" \
        of="${IMGDEPLOYDIR}/${IMAGE_NAME}.${MPFS_MTD_TYPE}.mtdimg" \
        bs=1024 \
        seek=$kboffset \
        count=$kbsize \
        conv=notrunc
    dd if="$file" \
        of="${IMGDEPLOYDIR}/${IMAGE_NAME}.${MPFS_MTD_TYPE}.mtdimg" \
        bs=1024 \
        seek=$kboffset \
        count=$kbsize \
        conv=notrunc
}

IMAGE_CMD:mtd () {

    set -ex

    ${@make_mtdparts_shell_array(d)}

    local remaining_encountered=0
    local i=0
    while [ $i -lt $mtd_count ]; do
        eval local name="\"\$mtd_names_$i\""
        eval local size="\"\$mtd_sizes_$i\""
        eval local kbsize="\"\$mtd_kbsizes_$i\""
        eval local kboffset="\"\$mtd_kboffsets_$i\""

        if [ "$name" = "payload" ]; then
            flash_mtdpart "${DEPLOY_DIR_IMAGE}/payload.bin" $size $kbsize $kboffset $name
        elif [ "$name" = "ubi" ]; then
            flash_mtdpart "${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.ubimg" $size $kbsize $kboffset $name
        else
            bbwarn "Don't know how to flash mtdparts '$name'. Filling with zeros."
            flash_mtdpart "/dev/zero" $size $kbsize $kboffset $name
        fi

        i=$(expr $i + 1)
    done

    ln -sfn "${IMAGE_NAME}.${MPFS_MTD_TYPE}.mtdimg" "${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.${MPFS_MTD_TYPE}.mtdimg"

}
