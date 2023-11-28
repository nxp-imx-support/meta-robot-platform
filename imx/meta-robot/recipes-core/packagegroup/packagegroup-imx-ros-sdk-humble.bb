# Copyright 2020 NXP
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "ros sdk package group for i.MX Robot platform"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    action-tutorials-cpp \
    action-tutorials-interfaces \
    action-tutorials-py \
    angles \
    automotive-navigation-msgs \
    automotive-platform-msgs \
    automotive-autonomy-msgs \
    autoware-auto-msgs \
    composition \
    demo-nodes-cpp \
    demo-nodes-cpp-rosnative \
    demo-nodes-py \
    depthimage-to-laserscan \
    dummy-map-server \
    dummy-robot-bringup \
    dummy-sensors \
    examples-rclcpp-minimal-action-client \
    examples-rclcpp-minimal-action-server \
    examples-rclcpp-minimal-client \
    examples-rclcpp-minimal-composition \
    examples-rclcpp-minimal-publisher \
    examples-rclcpp-minimal-service \
    examples-rclcpp-minimal-subscriber \
    examples-rclcpp-minimal-timer \
    examples-rclcpp-multithreaded-executor \
    examples-rclpy-executors \
    examples-rclpy-minimal-action-client \
    examples-rclpy-minimal-action-server \
    examples-rclpy-minimal-client \
    examples-rclpy-minimal-publisher \
    examples-rclpy-minimal-service \
    examples-rclpy-minimal-subscriber \
    image-tools \
    intra-process-demo \
    joy \
    lifecycle \
    logging-demo \
    pcl-conversions \
    quality-of-service-demo-cpp \
    quality-of-service-demo-py \
    ros-base \
    rviz-ogre-vendor \
    tlsf \
    tlsf-cpp \
    topic-monitor \
    rclcpp-dev \
    std-msgs-dev \
    ecl-tools \
    compressed-depth-image-transport \
    compressed-image-transport \
    moveit-ros-planning \
    moveit-servo \
    moveit-ros-planning-interface \
    moveit-common \
    moveit-ros-robot-interaction \
    octomap \
    realsense2-camera \
    rclcpp \
    rclc \
    rcl-yaml-param-parser \
    gpsd-client \
    image-pipeline \
    depth-image-proc \
    image-common \
    image-transport \
    camera-calibration-parsers \
    imu-complementary-filter \
    imu-filter-madgwick \
    swri-prefix-tools \
    swri-roscpp \
    marti-can-msgs \
    marti-common-msgs \
    marti-dbw-msgs \
    marti-nav-msgs \
    marti-perception-msgs \
    marti-sensor-msgs \
    marti-status-msgs \
    marti-visualization-msgs \
    libmavconn \
    laser-filters \
    cartographer-ros \
    fastrtps \
    mavros \
    mavros-msgs \
    navigation2 \
    octomap-server \
    octomap-mapping \
    odom-to-tf-ros2 \
    pendulum-control \
    raspimouse-msgs \
    rcdiscover \
    rc-genicam-api \
    rc-reason-msgs \
    ros2-control \
    ros2-controllers \
    ros2launch-security-examples \
    rosapi \
    rosapi-msgs \
    rosbridge-library \
    rosbridge-server \
    sros2 \
    v4l2-camera \
    vision-msgs \
"

