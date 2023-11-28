
SUMMARY = "DBoW2 is an improved version of the DBow library, an open source C++ library for indexing and converting images into a bag-of-word representation. It implements a hierarchical tree for approximating nearest neighbours in the image feature space and creating a visual vocabulary."

HOMEPAGE = "http://doriangalvez.com"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a40f1140f1638a6a38ba967cd7c95f83"

DEPENDS = "opencv boost dlib"

SRC_URI = "https://github.com/dorian3d/DBoW2/archive/refs/tags/v${PV}-free.tar.gz \
    file://0001-Added-functions-Save-and-Load-from-text-files-withou.patch \
"
SRC_URI[sha256sum] = "b5d68c4097a45ec2fabe10d7d0dc731c2ecd931ac3886d8f2ade2e942670143c"

S = "${WORKDIR}/DBoW2-${PV}-free"

EXTRA_OECMAKE += "\
  -DCMAKE_BUILD_TYPE=Release \
"
inherit cmake

do_install:append () {
    install -d ${D}${bindir}
    cp ${B}/demo ${D}${bindir}
}

FILES:${PN} += "\
        ${bindir}/* \
        ${libdir}/* \
"
FILES:${PN}-dev = "${includedir}"
