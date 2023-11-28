# Copyright 2019-2023 NXP

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

# nav2-behavior-tree/0.4.1-1-r0/git/include/nav2_behavior_tree/bt_action_node.hpp:229:43: error: 'using FutureReturnCode = enum class rclcpp::FutureReturnCode' is deprecated: use rclcpp::FutureReturnCode instead [-Werror=deprecated-declarations]
#   229 |       rclcpp::executor::FutureReturnCode::SUCCESS)
#       |                                           ^~~~~~~
CXXFLAGS += " -Wno-error=deprecated -Wno-error=deprecated-declarations -Wno-error=format-security"
