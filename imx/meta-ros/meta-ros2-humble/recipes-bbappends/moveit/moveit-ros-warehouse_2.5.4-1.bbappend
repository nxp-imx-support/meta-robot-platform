# Copyright 2019-2023 NXP

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

# ERROR: moveit-ros-warehouse-2.1.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-warehouse path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-warehouse/2.1.0-1-r0/packages-split/moveit-ros-warehouse/usr/lib/libmoveit_warehouse.so' [dev-so]
inherit ros_insane_dev_so
