
SUMMARY = "g2o is an open-source C++ framework for optimizing graph-based nonlinear error functions. "
HOMEPAGE = "http://www.informatik.uni-freiburg.de/~kuemmerl"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://README.md;md5=91fafda3dba16822e6e87736d61c6f34"

DEPENDS = "libeigen suitesparse"

SRC_URI = "https://github.com/RainerKuemmerle/g2o/archive/refs/tags/${PV}_git.tar.gz \
    file://0001-Fix-wrong-CMAKE_SYSTEM_PROCESSOR-for-ARM-poky-toolch.patch \
    file://0002-Fix-wrong-git-branch-in-github-of-googletest.patch \
    file://0003-The-imported-target-g2o_cli_application-in-g2oTarget.patch \
"
SRC_URI[sha256sum] = "20af80edf8fd237e29bd21859b8fc734e615680e8838824e8b3f120c5f4c1672"

S = "${WORKDIR}/g2o-${PV}_git"

EXTRA_OECMAKE += "\
  -DCMAKE_BUILD_TYPE=Release \
  -DG2O_BUILD_APPS=ON \
  -DBUILD_UNITTESTS=OFF \
"
inherit cmake

do_install:append () {
    install -d ${D}${libdir}
    cp ${S}/lib/*.so ${D}${libdir}
    install -d ${D}${bindir}    
    cp ${S}/bin/* ${D}${bindir}
}

FILES:${PN} += "\
        ${libdir}/* \
        ${bindir}/* \
"
FILES:${PN}-dev = "${includedir}"

INSANE_SKIP:${PN} += "rpaths installed-vs-shipped"
