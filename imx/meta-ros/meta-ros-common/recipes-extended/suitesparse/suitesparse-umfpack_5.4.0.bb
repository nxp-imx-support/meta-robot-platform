# Copyright (c) 2019-2023 NXP

require suitesparse-5.4.0.inc

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=a01bebe5675a294f07597691bedc3c5b"

DEPENDS = " \
    suitesparse-config \
    suitesparse-amd \
    suitesparse-colamd \
    suitesparse-cholmod \
    lapack \
"

S = "${WORKDIR}/SuiteSparse/UMFPACK"

EXTRA_OEMAKE = "CC='${CC}' BLAS='-lblas'"

do_compile() {
    # build only the library, not the demo
    oe_runmake library
}

do_install() {
    oe_runmake install INSTALL=${D}${prefix}
}

DEPENDS:append:class-target = " chrpath-replacement-native"

do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
