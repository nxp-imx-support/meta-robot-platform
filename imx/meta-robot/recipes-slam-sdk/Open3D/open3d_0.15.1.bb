
SUMMARY = "Open3D is an open-source library that supports rapid development of software that deals with 3D data. "

HOMEPAGE = "http://www.open3d.org/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a33c9e6ebccc6f2b25f8b5184f2011eb"

DEPENDS = "libeigen python3 glfw lapack libpng jpeg glew zeromq cppzmq jsoncpp msgpack-c curl openssl python3-pybind11-native"

SRC_URI = " https://github.com/isl-org/Open3D/archive/refs/tags/v${PV}.tar.gz  \
    file://0001-Fix-compile-issue-on-Yocto.patch \
    file://workaound-cross-compile-shader-file-issue.patch \
"
SRC_URI[sha256sum] = "4bcfbaa6fcbcc14fba46a4d719b9256fffac09b23f8344a7d561b26394159660"

S = "${WORKDIR}/Open3D-${PV}"

EXTRA_OECMAKE += "\
  -DCMAKE_BUILD_TYPE=Release \
  -DBUILD_SHARED_LIBS=ON \
  -DBUILD_CACHED_CUDA_MANAGER=OFF \
  -DBUILD_GUI=OFF \
  -DWITH_IPPICV=OFF \
  -DUSE_SYSTEM_EIGEN3=ON \
  -DUSE_BLAS=ON \
  -DUSE_SYSTEM_BLAS=ON \
  -DBUILD_ISPC_MODULE=OFF \
  -DUSE_SYSTEM_GLFW=ON \
  -DUSE_SYSTEM_GLEW=ON \
  -DUSE_SYSTEM_PNG=ON \
  -DUSE_SYSTEM_JPEG=ON \
  -DUSE_SYSTEM_ZEROMQ=ON \
  -DUSE_SYSTEM_JSONCPP=ON \
  -DUSE_SYSTEM_MSGPACK=ON \
"
inherit cmake python3native

do_install:append () {
    rm ${D}/home -rf
    install -d ${D}${bindir}
    cp ${B}/bin/* ${D}${bindir} -r
}

FILES:${PN}     += "${libdir}/*" 
FILES:${PN}-dev = "${includedir}"
INSANE_SKIP:${PN} += "installed-vs-shipped dev-deps"
INSANE_SKIP:${PN}-dev = "dev-elf"
