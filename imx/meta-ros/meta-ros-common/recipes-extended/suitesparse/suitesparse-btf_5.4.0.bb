# Copyright (c) 2019-2023 NXP

require suitesparse-5.4.0.inc

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=99ef727a9426a71dacc4e6dcbad36a2e"

DEPENDS = " \
    suitesparse-config \
    suitesparse-amd \
    suitesparse-colamd \
    suitesparse-cholmod \
    lapack \
"

S = "${WORKDIR}/SuiteSparse/BTF"

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
