SUMMARY  = "CWiid Wiimote Interface"
HOMEPAGE = "https://cwiid.org"
DESCRIPTION = "The CWiid package contains the following parts: \
1.libcwiid - wiimote API. \
2.cwiid module - python interface to libcwiid \
3.wmgui - GTK gui to the wiimote. \
4.wminput - an event/joystick/mouse driver for the wiimote. \
5.lswm - list wiimote devices (in the spirit of ls{,pci,usb}, etc. \
6.wmdemo - a minimal demonstration of the libwiimote API. (not installed)"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
SECTION = "lib"


SRC_URI = "https://github.com/abstrakraft/cwiid/archive/refs/tags/${PV}_history.tar.gz \
file://0001-wmdemo-fix-linking-by-adding-the-missing-lbluetooth-.patch \
file://0002-configure-make-wmgui-build-optional.patch \
file://0001-fix-linking-by-adding-the-missing-lbluetooth-to-LDLI.patch \
"
SRC_URI[sha256sum] = "31d3e843c107f07e2b425bee17dafa215937c582b3b4d9c7bc71f4edcfe5ea68"

S = "${WORKDIR}/cwiid-${PV}_history"

inherit autotools pkgconfig

EXTRA_OECONF = " \
    PYTHON='${STAGING_BINDIR_NATIVE}'/python-native/python \
    --disable-wmgui \
"

DEPENDS = "gawk bison-native python-native flex-native bluez5 gtk+"

do_configure:append () {
    cd ${S}
    cp -rf ${B}/* ./
}

do_compile () {
    cd ${S}
    oe_runmake 'CC=${CC}' 
}

do_install () {
    cd ${S}
    oe_runmake DESTDIR=${D} install
}
