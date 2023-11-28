# Copyright (c) 2020 LG Electronics, Inc.

ROS_EXPORT_DEPENDS += " \
    rosidl-generator-c \
    rosidl-typesupport-c \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Fix-error-message-Multiple-shlib-providers-when-run-.patch"