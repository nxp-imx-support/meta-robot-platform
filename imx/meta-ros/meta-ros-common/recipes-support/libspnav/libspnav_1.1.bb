SUMMARY  = "Libspnav is a C library for receiving input from 6 degrees-of-freedom (6dof) input devices"
HOMEPAGE = "https://spacenav.sourceforge.net"
DESCRIPTION = "Libspnav is a C library for receiving input from 6 degrees-of-freedom (6dof) input devices, also known as spacemice, spaceballs, etc. 6dof input is very useful for fluidly manipulating objects or viewpoints in 3D space, and fundamendally comprises of relative movement (translation) across 3 axes (TX/TY/TZ), and rotation about 3 axes (RX/RY/RZ)."
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f36e954c2e2d280ef1b4927c29f43195"
SECTION = "lib"


SRC_URI = "https://github.com/FreeSpacenav/libspnav/archive/refs/tags/v${PV}.tar.gz"
SRC_URI[sha256sum] = "04b297f68a10db4fa40edf68d7f823ba7b9d0442f2b665181889abe2cea42759"

S = "${WORKDIR}/libspnav-${PV}"

DEPENDS = "libx11"

do_configure () {
    ./configure --prefix=${prefix}
}

do_compile () {
    oe_runmake 
}

do_install () {
    oe_runmake DESTDIR=${D} install
}
