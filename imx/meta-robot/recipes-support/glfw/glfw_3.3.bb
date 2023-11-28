SUMMARY  = "A multi-platform library for OpenGL, OpenGL ES, Vulkan, window and input"
HOMEPAGE = "https://www.glfw.org/"
DESCRIPTION = "GLFW is an Open Source, multi-platform library for OpenGL, \
OpenGL ES and Vulkan application development. It provides a simple, \
platform-independent API for creating windows, contexts and surfaces, reading \
input, handling events, etc."
LICENSE  = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=98d93d1ddc537f9b9ea6def64e046b5f"
SECTION = "lib"

inherit pkgconfig cmake

SRC_URI = "git://github.com/glfw/glfw;protocol=https;branch=3.3-stable"
SRCREV = "2a5ac9a6d6cbe9f4113c0f17158cb13ab7f263bf"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DGLFW_USE_WAYLAND=ON -DGLFW_BUILD_DOCS=OFF -DBUILD_SHARED_LIBS=ON"

CFLAGS += "-fPIC"

DEPENDS = "ecm libxkbcommon wayland wayland-protocols virtual/egl virtual/libgles2 wayland-native"
REQUIRED_DISTRO_FEATURES = "wayland"

COMPATIBLE_HOST_libc-musl = "null"