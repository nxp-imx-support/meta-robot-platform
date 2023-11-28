
SUMMARY = "DLib is a collection of C++ classes to solve common tasks in C++ programs, as well as to offer additional functionality to use OpenCV data and to solve computer vision problems."

HOMEPAGE = "http://doriangalvez.com"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d5dfda376b8fb70bfe59053408e8b0e8"

DEPENDS = "opencv"

SRC_URI = "https://github.com/dorian3d/DLib/archive/refs/tags/v${PV}-free.tar.gz \
    file://0001-Fix-compile-issue-which-CV_REDUCE_SUM-was-not-declar.patch \
"
SRC_URI[sha256sum] = "be5076b8bcced4c39c08ff00c9ccf478c757bb52be2ebb44513eccec1766f2a6"

S = "${WORKDIR}/DLib-${PV}-free"

EXTRA_OECMAKE += "\
  -DCMAKE_BUILD_TYPE=Release \
  -DBUILD_DUtilsCV=OFF \
"
inherit cmake

do_install:append () {
    install -d ${D}${libdir}
    cp ${B}/*.so* ${D}${libdir}
    install -d ${D}${includedir}
    cp ${S}/include ${D}${includedir} -rf
}

FILES:${PN}     += " ${libdir}/* "
FILES:${PN}-dev = "${includedir}"

INSANE_SKIP:${PN}-dev = "dev-elf"
