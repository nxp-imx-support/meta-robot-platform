# Copyright (c) 2020 Intel Corp.

ROS_BUILD_DEPENDS:append = " rosidl-typesupport-fastrtps-cpp rosidl-typesupport-fastrtps-c"
ROS_BUILDTOOL_DEPENDS:append = " rosidl-default-generators-native rosidl-typesupport-fastrtps-cpp-native rosidl-typesupport-fastrtps-c-native"
ROS_EXPORT_DEPENDS:append = " ceres-solver"
ROS_EXEC_DEPENDS:append = " rosidl-typesupport-fastrtps-cpp rosidl-typesupport-fastrtps-c"
ROS_EXEC_DEPENDS:remove = "ceres-solver"

ROS_BUILD_DEPENDS:remove += " \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
"
ROS_EXPORT_DEPENDS:remove += " \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
"
ROS_EXEC_DEPENDS:remove += " \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
"

FILES:${PN}-dev += "${datadir}/karto_sdk ${datadir}/solver_plugins.xml"
