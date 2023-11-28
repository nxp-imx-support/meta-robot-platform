# Copyright 2019-2023 NXP

ROS_BUILD_DEPENDS += " \
    sensor-msgs \
"

ROS_EXPORT_DEPENDS += " \
    sensor-msgs \
"

ROS_EXEC_DEPENDS += " \
    sensor-msgs \
"
ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-ros-native \
    python3-numpy-native \
    rosidl-adapter-native \
    rosidl-generator-c-native \
    rosidl-generator-cpp-native \
    rosidl-generator-py-native \
    rosidl-typesupport-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-introspection-cpp-native \    
"
