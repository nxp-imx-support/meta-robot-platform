# Copyright (c) 2019-2020 LG Electronics, Inc.

# Missing license version in package.xml
LICENSE = "LGPL-2.1+"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-add-missing-includes.patch \
    file://0001-Add-scan_frame_id-to-match-output-frame-id-of-depthi.patch \
"