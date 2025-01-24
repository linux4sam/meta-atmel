# OpenEmbedded/Yocto Project BSP layer for Microchip's SoCs

## Description

The meta-mchp-common layer consolidates common Board Support Package (BSP)
components and metadata for Microchip platforms, streamlining development
across various Microchip devices for use with OpenEmbedded and/or Yocto
Project.

## Layer Dependencies

This layer depends on the following layers:

- **meta-openembedded**
  - URI: git://git.openembedded.org/meta-openembedded
  - Layers: meta-oe, meta-networking, meta-python

- **openembedded-core**
  - URI: git://git.openembedded.org/openembedded-core
  - Layers: meta

Ensure these layers are included in your bblayers.conf to maintain
compatibility.

## Supported Machines

The meta-mchp-common layer supports a range of Microchip platforms. For
detailed information on supported machines, please refer to the specific
sub-layers and their documentation.

## Prerequisite

Here are the reference pages for setting up a Yocto Project building
environment: [What You Need](https://docs.yoctoproject.org/current/brief-yoctoprojectqs/index.html#build-host-packages).

Note: add git-lfs to the package requirement list from whichever Linux
distribution you use.

For instance, on Ubuntu or debian, these packages need to be installed on
your development host:

```bash
sudo apt-get install gawk wget git-core git-lfs diffstat unzip texinfo gcc-multilib \
     build-essential chrpath socat cpio python3 python3-pip python3-pexpect \
     xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev \
     pylint3 xterm
```

## Usage

To integrate this layer into your Yocto Project build environment:

1. **Clone the necessary repositories:**

```bash
git clone git://git.openembedded.org/bitbake
git clone git://git.openembedded.org/openembedded-core
git clone git://git.openembedded.org/meta-openembedded
git clone https://github.com/microchip/meta-mchp
```
Ensure that the branches of all repositories are kept in sync with the
corresponding branch of the meta-mchp layer.

2. **Initialize the build environment:**

```bash
source openembedded-core/oe-init-build-env
```
3. **Add the layers:**

```bash
bitbake-layers add-layer ../meta-openembedded/meta-oe
bitbake-layers add-layer ../meta-openembedded/meta-python
bitbake-layers add-layer ../meta-openembedded/meta-networking
bitbake-layers add-layer ../meta-mchp/meta-mchp-common
```

4. **Set the target machine and build the image:**

```bash
MACHINE = <machine> bitbake core-image-minimal
```

The list of supported machines are provided in the sub-layers.

## Licensing

The contents of this layer are licensed under the MIT License. See COPYING.MIT for details.

## Contributing

If you want to contribute changes, you can send Github pull requests at
**https://github.com/linux4microchip/meta-mchp/pulls**.

See [CONTRIBUTING.md](CONTRIBUTING.md) for additional information about
contribution guidelines.

## Maintainers

- Hari Prasath G E <hari.prasathge@microchip.com>
- Valentina Fernandez Alanis <valentina.fernandezalanis@microchip.com>
- Dharma Balasubiramani <dharma.b@microchip.com>
