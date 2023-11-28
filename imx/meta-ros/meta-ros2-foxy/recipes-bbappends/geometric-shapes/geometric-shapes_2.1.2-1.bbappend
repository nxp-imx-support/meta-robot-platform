# Copyright 2019-2023 NXP

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-jammy-Fix-assimp-linking-and-cmake-error-215.patch \
"

# ERROR: geometric-shapes-2.0.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: geometric-shapes path '/work/raspberrypi4-webos-linux-gnueabi/geometric-shapes/2.0.0-1-r0/packages-split/geometric-shapes/usr/lib/libgeometric_shapes.so' [dev-so]
inherit pkgconfig ros_insane_dev_so
