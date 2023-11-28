
SUMMARY = "ORB-SLAM3 is the first real-time SLAM library able to perform Visual, Visual-Inertial and Multi-Map SLAM with monocular, stereo and RGB-D cameras, using pin-hole and fisheye lens models. In all sensor configurations, ORB-SLAM3 is as robust as the best systems available in the literature, and significantly more accurate."
HOMEPAGE = "http://webdiis.unizar.es/~raulmur/"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

DEPENDS = "gtk+ opencv boost libeigen pangolin librealsense2"

SRCREV = "0df83dde1c85c7ab91a0d47de7a29685d046f637"
SRC_URI = "git://github.com/UZ-SLAMLab/ORB_SLAM3.git;protocol=https; \
file://0001-Add-supporting-OpenGL-ES.patch \
"
CXXFLAGS += " -fopenmp ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '-DWL_EGL_PLATFORM', '', d)}"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "\
  -DCMAKE_BUILD_TYPE=Release \
"
inherit cmake pkgconfig

do_install () {
		install -d ${D}${libdir}
		cp ${S}/lib/libORB-SLAM3.so ${D}${libdir}
		cp ${S}/Thirdparty/DBoW2/lib/libDBoW2.so ${D}${libdir}
		cp ${S}/Thirdparty/g2o/lib/libg2o.so ${D}${libdir}
		install -d ${D}${bindir}
		cp ${S}/Examples/Monocular/mono_euroc ${D}${bindir}
		cp ${S}/Examples/Monocular/mono_kitti ${D}${bindir}
		cp ${S}/Examples/Monocular/mono_tum ${D}${bindir}
		cp ${S}/Examples/Monocular/mono_tum_vi ${D}${bindir}
		cp ${S}/Examples/Monocular-Inertial/mono_inertial_euroc ${D}${bindir}
		cp ${S}/Examples/Monocular-Inertial/mono_inertial_tum_vi ${D}${bindir}
		cp ${S}/Examples/RGB-D/rgbd_tum ${D}${bindir}
		cp ${S}/Examples/Stereo/stereo_euroc ${D}${bindir}
		cp ${S}/Examples/Stereo/stereo_kitti ${D}${bindir}
		cp ${S}/Examples/Stereo/stereo_tum_vi ${D}${bindir}
		cp ${S}/Examples/Stereo-Inertial/stereo_inertial_euroc ${D}${bindir}
		cp ${S}/Examples/Stereo-Inertial/stereo_inertial_tum_vi ${D}${bindir}
}

FILES:${PN} += "\
        ${libdir}/* \
        ${bindir}/* \
"
FILES:${PN}-dev = ""

INSANE_SKIP:${PN} += "rpaths"