# OpenEmbedded/Yocto Project BSP layer for Microchip's SoCs

## Description

The meta-mchp-common layer consolidates common Board Support Package (BSP)
components and metadata for Microchip platforms, streamlining development
across various Microchip devices for use with OpenEmbedded and/or Yocto
Project.

## Layer Dependencies

This layer depends on the following layers:

```text
- **meta-openembedded**
  - URI: git://git.openembedded.org/meta-openembedded
  - Layers: meta-oe, meta-networking, meta-python

- **openembedded-core**
  - URI: git://git.openembedded.org/openembedded-core
  - Layers: meta
```

Ensure these layers are included in your `bblayers.conf` to maintain compatibility.

## Supported Machines

The meta-mchp-common layer supports a range of Microchip platforms. For
detailed information on supported machines, please refer to the specific
sub-layers and their documentation.

## Prerequisites

Before starting, please refer to the `Build Host Packages` section in the [Yocto Project's guide](https://docs.yoctoproject.org/current/brief-yoctoprojectqs/index.html#build-host-packages) to install required dependencies for the build environment:

> **Note:** Make sure to install `git-lfs` in addition to the required packages for your Linux distribution.

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

    > Make sure all repositories are checked out to branches that are compatible with the branch of the meta-mchp layer you intend to use.

2. **Initialize the build environment:**

    The `meta-mchp` repository provides sample configuration templates that help set up BitBake layers and key configuration files in the Yocto build directory.

    Set the `TEMPLATECONF` environment variable to point to the appropriate configuration template before initializing the build environment:

    ```bash
    export TEMPLATECONF=${TEMPLATECONF:-../meta-mchp/meta-layer/conf/templates/default}
    ```

    Replace `meta-layer` above with the desired layer based on your target platform. For example:

    For MPU boards:

      ```bash
      export TEMPLATECONF=${TEMPLATECONF:-../meta-mchp/meta-mchp-mpu/conf/templates/default}
      ```

    For PolarFire SoC boards:

      ```bash
      export TEMPLATECONF=${TEMPLATECONF:-../meta-mchp/meta-mchp-polarfire-soc/meta-mchp-polarfire-soc-bsp/conf/templates/default}
      ```

    > Note: Setting `TEMPLATECONF` is only needed the first time you will run the source command.

    Then initialize the Yocto build environment:

    ```bash
    source openembedded-core/oe-init-build-env
    ```

3. **Set the target machine and build the image:**

    ```bash
    MACHINE=<machine> bitbake core-image-minimal
    ```

    The list of supported machines and images is provided in the sub-layers' READMEs.

## Licensing

The contents of this layer are licensed under the MIT License. See COPYING.MIT for details.

## Contributing

If you want to contribute changes, you can send Github pull requests at
**<https://github.com/linux4microchip/meta-mchp/pulls>**.

See [CONTRIBUTING.md](CONTRIBUTING.md) for additional information about
contribution guidelines.

## Maintainers

- Hari Prasath G E <hari.prasathge@microchip.com>
- Valentina Fernandez Alanis <valentina.fernandezalanis@microchip.com>
- Dharma Balasubiramani <dharma.b@microchip.com>
