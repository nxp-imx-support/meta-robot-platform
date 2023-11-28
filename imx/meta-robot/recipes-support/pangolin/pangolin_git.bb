
SUMMARY = "Pangolin is a lightweight portable rapid development library for managing OpenGL display / interaction and abstracting video input."
HOMEPAGE = "http://stevenlovegrove.com/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE;md5=37611e574d0acc5cc68f827d28a9ce8a"

inherit cmake pkgconfig

DEPENDS = "glfw ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'virtual/egl virtual/libgles2 libxkbcommon', '', d)}"

SRCREV = "1a94ff787bc042b4b00db371668e2544240588ed"
SRC_URI = "git://github.com/stevenlovegrove/Pangolin.git;protocol=https;branch=master \
file://0001-Enable-Pangolin-to-support-GLES-with-wayland-backend.patch \
"

CXXFLAGS += "-std=c++11 ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '-DWL_EGL_PLATFORM', '', d)}"
BUILD_CXXFLAGS += "-std=c++11 ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '-DWL_EGL_PLATFORM', '', d)}"

S = "${WORKDIR}/git"


EXTRA_OECMAKE += "\
  -DCMAKE_BUILD_TYPE=Release \
  -DBUILD_EXAMPLES=ON \
  -DBUILD_PANGOLIN_VARS=ON \
  -DBUILD_PANGOLIN_ZSTD=OFF \
  ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '-DBUILD_WITH_WAYLAND=ON', '', d)} \
"

FILES:${PN} = "\
        ${libdir}/lib*.so \
        ${libdir}/cmake \
"
FILES:${PN}-dev = "\
        ${includedir}/* \
"
