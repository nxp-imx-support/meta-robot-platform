DESCRIPTION = "i.MX Machine Vison for vSLAM." 
SUMMARY = "imx-mv : Machine Vison library" 
SECTION = "libs" 
LICENSE = "Proprietary" 
LIC_FILES_CHKSUM = "file://LICENSE;md5=be5ff43682ed6c57dfcbeb97651c2829"

SRC_URI = " file://imx-mv.tar.gz" 
SRC_URI[md5sum] = "da2610fcaa7d16f57f204941af9cb3a7"
SRC_URI[sha256sum] = "863f76b03df2ee03e45253f71968416ec4ac7fdb087f8fb32c744e1a6942edf3"

DEPENDS = "deepview-rt opencv"
RDEPENDS:${PN} += "deepview-rt"

S = "${WORKDIR}/imx-mv" 

do_install () {
		install -d ${D}${libdir}
		cp ${S}/lib/libimx-mv.so ${D}${libdir}
		cp ${S}/lib/*.cl ${D}${libdir}
		cp ${S}/lib/fast_scnn.rtm ${D}${libdir}
		install -d ${D}${includedir}
		cp ${S}/include/*.h ${D}${includedir}
}

FILES:${PN} += "\
        ${libdir}/* \
        ${bindir}/* \
"
FILES:${PN}-dev = "\
        ${includedir}/* \
"

INSANE_SKIP:${PN} += " rpaths file-rdeps already-stripped"
