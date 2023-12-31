# Copyright 2019-2023 NXP

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

# The version used by foxy is missing:
# https://github.com/ros-perception/perception_pcl/commit/4156c71c025d9111113673bc891aeab4c602086f
# and ament-cmake-ros depends on ament-cmake-gmock
DEPENDS += " \
    ament-cmake-ros \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-pytest \
"
