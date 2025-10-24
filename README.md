# Microchip Yocto Project BSP

Collection of OpenEmbedded/Yocto Project layers to support various
Microchip device families including the MPU series and PolarFire SoC.

- **meta-mchp-common**: layer containing core recipes for the common
  components like Linux, U-Boot, dt-overlay, etc.

- **meta-mchp-mpu**: layer containing the platform/machine configurations
  for the 32-bit and 64-bit MPUs.

- **meta-mchp-polarfire-soc**: layer containing platform/machine configurations
  for the PolarFire SoC evaluation kits.

- **meta-mchp-pic64**: layer containing platform/machine configurations
  for the PIC64 MPU evaluation kits.

Please see the meta-mchp-common [README](meta-mchp-common/README.md)
section for detailed steps on how to setup and start a build for any of the
supported devices.
