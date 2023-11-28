# Copyright 2019-2023 NXP

ROS_BUILD_DEPENDS += " \
    rclcpp \
    sensor-msgs \
    pluginlib \
"

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

CXXFLAGS += " -Wno-error=format-security"