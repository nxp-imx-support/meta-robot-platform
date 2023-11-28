
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-fix-build-error-in-Yocto.patch"

ROS_BUILD_DEPENDS += " \
    std-srvs \
    libusb1 \
    pkgconfig \
    glog \
"
ROS_EXEC_DEPENDS += " \
    libusb1 \
"

FILES:${PN} += "\
    ${ros_libdir}/astra_camera/* \
    ${ros_libdir}/OpenNI2/* \
"

INSANE_SKIP:${PN}-dev += " dev-elf file-rdeps ldflags arch staticdev"
INSANE_SKIP:${PN} += " ldflags"