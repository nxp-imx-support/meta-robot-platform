# Copyright 2020 NXP
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "ros sdk package group for i.MX Robot platform"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    ros-base \
"

