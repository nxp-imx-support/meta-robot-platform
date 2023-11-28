FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Add-libusb-in-cmake-file.patch"
ROS_BUILD_DEPENDS += " \
    libusb1 \
    pkgconfig \
"
ROS_EXEC_DEPENDS += " \
    jpeg \
    libusb1 \
"