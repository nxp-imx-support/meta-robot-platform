
SUMMARY = "Xenomai is a Free Software project in which engineers from a wide background collaborate to build a versatile real-time framework for the Linux© platform. "
HOMEPAGE = "http://www.xenomai.org"
SECTION = "kernel/real-time"

LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://lib/cobalt/COPYING;md5=68ad62c64cc6c620126241fd429e68fe"

DEPENDS = "hostperl-runtime-native"

SRC_URI = "https://source.denx.de/Xenomai/xenomai/-/archive/${PV}/xenomai-${PV}.tar.bz2"
SRC_URI[md5sum] = "ce1bf6f6ec5c01dc17e184003f740321"
SRC_URI[sha256sum] = "6d04d17262746c94290c7e314c11bc5ca6a7f53a204b1509d91a2c0b4d3a36d6"

SRC_URI += "file://0001-Update-Xenomai-to-v3.2.2.patch \
file://0002-Fix-the-issue-which-expected-next-time-is-less-than-.patch \
file://0003-Fix-the-issue-which-altency-use-legacy-and-wrong-api.patch \
file://0004-Fix-the-issue-which-results-to-bus-error.patch \
file://0005-Disable-testcase-gdb-in-smokey-because-this-testcase.patch \
file://add-configure-file.patch \
"

inherit lib_package 

B = "${WORKDIR}/build"
do_configure[cleandirs] = "${B}"

EXTRA_OECONF = "--disable-debug --enable-smp ${@bb.utils.contains('XENOMAI_KERNEL_MODE', 'cobalt', '--with-core=cobalt', '--with-core=mercury', d)}"

do_configure () {

	os=${HOST_OS}
	case $os in
	linux-gnueabi |\
	linux-gnuspe |\
	linux-musleabi |\
	linux-muslspe |\
	linux-musl )
		os=linux
		;;
	*)
		;;
	esac
	target="$os-${HOST_ARCH}"
	case $target in
	linux-arm)
		host=arm-poky-linux-gnueabi
		;;
	linux-armeb)
		host=arm-poky-linux-gnueabi
		;;
	linux-aarch64*)
		host=aarch64-poky-linux
		;;		
	esac
	perl ${S}/configure --build=i686-pc-linux-gnu --host=$host ${EXTRA_OECONF}
}

do_install() {
    oe_runmake DESTDIR=${D} install
}

PACKAGE_DEBUG_SPLIT_STYLE = "debug-file-directory"
FILES:${PN} += "/usr"
INSANE_SKIP:${PN} += "dev-so staticdev libdir"
