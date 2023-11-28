
SUMMARY = "ORB-SLAM2 is a real-time SLAM library for Monocular, Stereo and RGB-D cameras . "
HOMEPAGE = "http://webdiis.unizar.es/~raulmur/"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9f7421fb91aef33332dbdfab7e243c01"

DEPENDS = "gtk+ opencv libeigen pangolin"

SRCREV = "f2e6f51cdc8d067655d90a78c06261378e07e8f3"
SRC_URI = "git://github.com/raulmur/ORB_SLAM2.git;protocol=git; \
file://0001-fix-the-build-error.patch \
file://0002-Add-supporting-OpenGL-ES.patch \
${@bb.utils.contains('ROS_DISTRO_TYPE', 'ros2', 'file://0003-Add-support-to-OpenCV-4.patch', '', d)} \
"
CXXFLAGS += " -fopenmp ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '-DWL_EGL_PLATFORM', '', d)}"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "\
  -DCMAKE_BUILD_TYPE=Release \
"
inherit cmake

do_install () {
		install -d ${D}${libdir}
		cp ${S}/lib/libORB-SLAM2.so ${D}${libdir}
		cp ${S}/Thirdparty/DBoW2/lib/libDBoW2.so ${D}${libdir}
		cp ${S}/Thirdparty/g2o/lib/libg2o.so ${D}${libdir}
		install -d ${D}${bindir}
		cp ${S}/Examples/Monocular/mono_euroc ${D}${bindir}
		cp ${S}/Examples/Monocular/mono_kitti ${D}${bindir}
		cp ${S}/Examples/Monocular/mono_tum ${D}${bindir}		
		cp ${S}/Examples/RGB-D/rgbd_tum ${D}${bindir}
		cp ${S}/Examples/Stereo/stereo_euroc ${D}${bindir}
		cp ${S}/Examples/Stereo/stereo_kitti ${D}${bindir}
}

FILES:${PN} += "\
        ${libdir}/* \
        ${bindir}/* \
"
FILES:${PN}-dev = ""

INSANE_SKIP:${PN} += "rpaths"