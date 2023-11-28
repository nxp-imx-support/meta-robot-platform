FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += " \
file://enable-joystick.config \
"
python do_joystick_config() {
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
addtask do_joystick_config after do_kernel_localversion before do_configure
