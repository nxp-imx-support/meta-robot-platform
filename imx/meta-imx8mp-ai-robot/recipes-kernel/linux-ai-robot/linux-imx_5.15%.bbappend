
FILESEXTRAPATHS:prepend := "${THISDIR}/ai-robot:"
SRC_URI:append = " \
file://0001-Add-i.MX8M-Plus-AI-Robot-board.patch \
"

do_install:append () {
	mv ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/ethernet/freescale ${D}${nonarch_base_libdir}/modules/
}

INSANE_SKIP_${PN} += " installed-vs-shipped"
