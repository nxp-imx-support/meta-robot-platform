FILESEXTRAPATHS:prepend := "${@bb.utils.contains('XENOMAI_KERNEL_MODE', 'cobalt', '${THISDIR}/cobalt:', '${THISDIR}/mercury:', d)}"

SRC_URI += " ${@bb.utils.contains('XENOMAI_KERNEL_MODE', 'cobalt', \
'file://0001-Add-Dovetail-patch-for-Xenomai.patch \
file://0002-Add-Cobalt-kernel-and-RTDM-based-drivers-patch-for-x.patch \
file://0003-Use-the-CPUFreq-governor-performance-as-default-in-i.patch \
file://enable-Xenomai-driver.config', \
' ', d)} "

SRC_URI += " ${@bb.utils.contains('XENOMAI_KERNEL_MODE', 'mercury', \
'file://Preempt-RT-Linux-patches-rt51-for-5.15.71.patch \
file://0001-arm64-and-arm-imx_defconfig-enable-Preempt-RT.patch \
file://0001-Use-the-CPUFreq-governor-performance-as-default-in-i.patch', \
' ', d)} "

python do_xenomai_kernel_config() {
    for uri in d.getVar('SRC_URI').split():
        if uri.endswith(".config"):
            fdefconfig = os.path.join(d.getVar('B'), "../defconfig")
            fconfig = os.path.join(d.getVar('B'), ".config")
            with open(fdefconfig, "a") as defconfig, open(fconfig, "a") as config:
                with open(os.path.join(d.getVar('B'),uri.replace("file://","../"))) as cfg:
                    extra_config = cfg.read()
                    defconfig.write(extra_config)
                    config.write(extra_config)
}
addtask do_xenomai_kernel_config after do_kernel_localversion before do_configure
