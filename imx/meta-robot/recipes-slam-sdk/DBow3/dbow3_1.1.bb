
SUMMARY = "DBoW3 is an improved version of the DBow2 library, an open source C++ library for indexing and converting images into a bag-of-word representation. It implements a hierarchical tree for approximating nearest neighbours in the image feature space and creating a visual vocabulary."

HOMEPAGE = "http://doriangalvez.com"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=60f79cea6ae499b6f2a1495dd5198c14"

DEPENDS = "opencv boost"

SRCREV = "c5ae539abddcef43ef64fa130555e2d521098369"
SRC_URI = "git://github.com/rmsalinas/DBow3;protocol=https \
    file://0001-Fix-the-compile-error-which-error-string-in-namespac.patch \
    file://0001-Add-member-serialize-in-class-BowVector-and-FeatureV.patch \
"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "\
  -DCMAKE_BUILD_TYPE=Release \
"
inherit cmake

INSANE_SKIP:${PN}-dev = "dev-elf"
