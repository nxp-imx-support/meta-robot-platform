# Copyright 2019-2023 NXP

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Be-a-bit-more-strict-when-checking-the-symbols-defin.patch \
"

inherit pkgconfig
