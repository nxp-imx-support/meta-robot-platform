# Copyright 2019-2023 NXP

# PN package in zstd-vendor is empty and not created, remove runtime dependency on it
ROS_EXEC_DEPENDS:remove = "zstd-vendor"
ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"
inherit pkgconfig
