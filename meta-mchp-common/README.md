# OpenEmbedded/Yocto Project BSP layer for Microchip's SoCs

## Description

The meta-mchp-common layer consolidates common Board Support Package (BSP)
components and metadata for Microchip platforms, streamlining development
across various Microchip devices for use with OpenEmbedded and/or Yocto
Project.

## Supported Machines

The meta-mchp-common layer provides support for various Microchip platforms.
For detailed information about supported machines, please refer to the
documentation in the relevant sub-layers:

- [MPU layer README](https://github.com/linux4microchip/meta-mchp/blob/scarthgap/meta-mchp-mpu/README.md)

- [PolarFire SoC layer README](https://github.com/linux4microchip/meta-mchp/blob/scarthgap/meta-mchp-polarfire-soc/README.md)

## Prerequisites

Before starting, please refer to the `Required Packages for Build Host` section in the [Yocto Project Documentation](https://docs.yoctoproject.org/current/ref-manual/system-requirements.html#required-packages-for-the-build-host) to install required dependencies for the build environment:

> **Note:** Make sure to install `git-lfs`  and `repo` in addition to the required packages for your Linux distribution.

For instance, on Ubuntu or debian, these packages need to be installed on
your development host:

```bash
sudo apt-get install gawk wget git-core git-lfs diffstat unzip texinfo gcc-multilib \
     build-essential chrpath socat cpio python3 python3-pip python3-pexpect \
     xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev \
     pylint3 xterm repo
```

## Usage

To integrate this layer into your Yocto Project build environment:

1. **Clone the necessary repositories:**

    Create an empty directory to hold the workspace:

      ```bash
      mkdir yocto-dev
      cd yocto-dev
      ```

    Use the repo tool to fetch all the required repositories

    > Make sure to install the [repo](https://gerrit.googlesource.com/git-repo/+/HEAD/README.md) utility first.

    ```bash
    repo init -u https://github.com/linux4microchip/meta-mchp-manifest.git -b <branch> -m <target>/default.xml
    ```

    Replace `<branch>` and `<target>` with the Yocto release branch and the manifest required. For example:

    For the MPU layer:

      ```bash
      repo init -u https://github.com/linux4microchip/meta-mchp-manifest.git -b refs/tags/linux4microchip-2025.04 -m mpu/default.xml
      ```

    For the PolarFire SoC layer:

      ```bash
      repo init -u https://github.com/linux4microchip/meta-mchp-manifest.git -b refs/tags/linux4microchip+fpga-2025.10 -m polarfire-soc/default.xml
      ```

    For the PIC64GX Curiosity Kit layer:

      ```bash
      repo init -u https://github.com/linux4microchip/meta-mchp-manifest.git -b refs/tags/linux4microchip+fpga-2025.10 -m pic64/pic64gx/default.xml
      ```
    Fetch all the required repositories using the following repo command:

      ```bash
      repo sync
      ```

2. **Initialize the build environment:**

    The `meta-mchp` repository provides sample configuration templates that help set up BitBake layers and key configuration files in the Yocto build directory.

    Set the `TEMPLATECONF` environment variable to point to the appropriate configuration template before initializing the build environment:

    ```bash
    export TEMPLATECONF=${TEMPLATECONF:-../meta-mchp/<meta-layer>/conf/templates/default}
    ```

    Replace `meta-layer` above with the desired layer based on your target platform. For example:

    For MPU boards:

      ```bash
      export TEMPLATECONF=${TEMPLATECONF:-../meta-mchp/meta-mchp-mpu/meta-mchp-mpu-apps/conf/templates/default}
      ```

    For PolarFire SoC boards:

      ```bash
      export TEMPLATECONF=${TEMPLATECONF:-../meta-mchp/meta-mchp-polarfire-soc/meta-mchp-polarfire-soc-bsp/conf/templates/default}
      ```

    For PIC64GX Curiosity Kit:

      ```bash
      export TEMPLATECONF=${TEMPLATECONF:-../meta-mchp/meta-mchp-pic64/conf/templates/pic64gx}
      ```

    > Note: Setting `TEMPLATECONF` is only needed the first time you will run the source command.

    Then initialize the Yocto build environment:

    ```bash
    source openembedded-core/oe-init-build-env
    ```

3. **Set the target machine and build the image:**

    ```bash
    MACHINE=<machine> bitbake mchp-base-image
    ```

    Each sub-layer provides several images that include demos and applications tailored for
    its respective platform.

    For more information on the supported images, please refer to the corresponding README:

   - [MPU layer README](https://github.com/linux4microchip/meta-mchp/blob/scarthgap/meta-mchp-mpu/README.md)

   - [PolarFire SoC layer README](https://github.com/linux4microchip/meta-mchp/blob/scarthgap/meta-mchp-polarfire-soc/README.md)

## Layer Dependencies

This layer depends on the following layers:

```text
- openembedded-core
  - URI: git://git.openembedded.org/openembedded-core
  - Layers: meta
```

For information on the specific revisions used, refer to the
[meta-mchp manifest](https://github.com/linux4microchip/meta-mchp-manifest) repository.

## Licensing

The contents of this layer are licensed under the MIT License. See COPYING.MIT for details.

## Contributing

If you want to contribute changes, you can send Github pull requests at
**<https://github.com/linux4microchip/meta-mchp/pulls>**.

See [CONTRIBUTING.md](CONTRIBUTING.md) for additional information about
contribution guidelines.

## Maintainers

- Valentina Fernandez Alanis <valentina.fernandezalanis@microchip.com>
- Dharma Balasubiramani <dharma.b@microchip.com>
