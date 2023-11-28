# Copyright 2020-2023 NXP

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Add-250ms-delay-in-odometry.patch \
"

inherit pkgconfig
