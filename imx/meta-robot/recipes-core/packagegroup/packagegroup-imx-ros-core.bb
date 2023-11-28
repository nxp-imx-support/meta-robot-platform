# Copyright 2020 NXP
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "ros core package group for i.MX Robot platform"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    packagegroup-ros-comm \
"

