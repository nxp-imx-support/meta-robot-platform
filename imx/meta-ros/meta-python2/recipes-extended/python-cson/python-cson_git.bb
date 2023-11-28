# Copyright (C) 2015 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Python library for CSON (schema-compressed JSON)"
HOMEPAGE = "https://github.com/gt3389b/python-cson/"
LICENSE = "MIT"
SECTION = "devel/python"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7709d2635e63ab96973055a23c2a4cac"

SRCREV = "f3f2898c44bb16b951d3e9f2fbf6d1c4158edda2"
SRC_URI = "git://github.com/gt3389b/python-cson.git;branch=master;protocol=https"

S = "${WORKDIR}/git"

RDEPENDS:${PN}:class-native = ""
DEPENDS:append:class-native = " python-native "

inherit setuptools

BBCLASSEXTEND = "native"


SKIP_RECIPE[python-cson] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
