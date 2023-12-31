require cryptodev.inc

SUMMARY = "A test suite for /dev/crypto device driver"

DEPENDS += "openssl"

SRC_URI += " \
file://0001-Add-the-compile-and-install-rules-for-cryptodev-test.patch \
file://0001-tests-Makefile-do-not-use-Werror.patch \
file://0001-Change-head-file-for-supporting-asymmetric-cryptogra.patch \
file://0001-Add-the-testing-of-asymmetric-cryptography.patch \
"

EXTRA_OEMAKE='KERNEL_DIR="${STAGING_EXECPREFIXDIR}" PREFIX="${D}"'

do_compile() {
	oe_runmake testprogs
}

do_install() {
	oe_runmake install_tests
}

FILES:${PN} = "${bindir}/*"
