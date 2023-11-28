
SUMMARY = "i.MX-HC-SLAM is derive from ORB-SLAM3, and using ARM Neon, GPU OpenCL to accelerate ORB feature extraction. ORB-SLAM3 is the first real-time SLAM library able to perform Visual, Visual-Inertial and Multi-Map SLAM with monocular, stereo and RGB-D cameras, using pin-hole and fisheye lens models. In all sensor configurations, ORB-SLAM3 is as robust as the best systems available in the literature, and significantly more accurate."

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"
DBOW_TYPE = "DBOW3"

DEPENDS = "gtk+ opencv boost libeigen pangolin imx-mv pcl libg2o sophus librealsense2 ${@bb.utils.contains('DBOW_TYPE', 'DBOW3', 'dbow3 ', 'dbow2 dlib ', d)}"

SRCREV = "0df83dde1c85c7ab91a0d47de7a29685d046f637"
SRC_URI = "git://github.com/UZ-SLAMLab/ORB_SLAM3.git;protocol=https; \
file://0001-Fork-ORB-SLAM3-v1.0-release-and-add-supporting-OpenG.patch \
file://0002-Rename-ORB-SLAM3-to-imx-hc-slam-add-imx-prefix-to-ap.patch \
file://0003-Add-the-change-of-i.MX-HC-SLAM-for-release.patch \
"
CXXFLAGS += " ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '-DWL_EGL_PLATFORM', '', d)}"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "\
  -DCMAKE_BUILD_TYPE=Release \
  -DBUILD_MULTI_THREADS=ON \
  -DENABLE_DISPLAY=OFF \
  ${@bb.utils.contains('DBOW_TYPE', 'DBOW3', '-DENABLE_USING_DBOW3=ON ', '-DENABLE_USING_DBOW3=OFF ', d)} \
"
inherit cmake pkgconfig

do_install () {
		install -d ${D}${includedir}
		cp ${S}/include/* ${D}${includedir} -r
		cp ${S}/include/CameraModels/*.h ${D}${includedir}
		install -d ${D}${libdir}
		cp ${S}/lib/libimx-hc-slam.so ${D}${libdir}
		install -d ${D}${bindir}
		cp ${S}/Examples/Monocular/imx_mono_camera ${D}${bindir}
		cp ${S}/Examples/Monocular/imx_mono_euroc ${D}${bindir}
		cp ${S}/Examples/Monocular/imx_mono_kitti ${D}${bindir}
		cp ${S}/Examples/Monocular/imx_mono_tum ${D}${bindir}
		cp ${S}/Examples/Monocular/imx_mono_tum_vi ${D}${bindir}
		cp ${S}/Examples/Monocular-Inertial/imx_mono_inertial_euroc ${D}${bindir}
		cp ${S}/Examples/Monocular-Inertial/imx_mono_inertial_tum_vi ${D}${bindir}
		cp ${S}/Examples/RGB-D/imx_rgbd_tum ${D}${bindir}
		cp ${S}/Examples/RGB-D-Inertial/imx_rgbd_inertial_realsense_D435i ${D}${bindir}
		cp ${S}/Examples/Stereo/imx_stereo_euroc ${D}${bindir}
		cp ${S}/Examples/Stereo/imx_stereo_kitti ${D}${bindir}
		cp ${S}/Examples/Stereo/imx_stereo_tum_vi ${D}${bindir}
		cp ${S}/Examples/Stereo-Inertial/imx_stereo_inertial_euroc ${D}${bindir}
		cp ${S}/Examples/Stereo-Inertial/imx_stereo_inertial_tum_vi ${D}${bindir}
}

FILES:${PN} += "\
        ${libdir}/* \
        ${bindir}/* \
"
FILES:${PN}-dev = "${includedir}"

INSANE_SKIP:${PN} += "rpaths"