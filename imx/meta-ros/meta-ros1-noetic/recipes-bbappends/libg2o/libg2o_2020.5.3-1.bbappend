# Copyright 2019-2023 NXP

ROS_BUILD_DEPENDS:remove = " \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

ROS_EXPORT_DEPENDS:remove = " \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

ROS_EXEC_DEPENDS:remove = " \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

ROS_BUILD_DEPENDS += " \
    suitesparse \
"

ROS_EXPORT_DEPENDS += " \
    suitesparse \
"

ROS_EXEC_DEPENDS += " \
    suitesparse \
"