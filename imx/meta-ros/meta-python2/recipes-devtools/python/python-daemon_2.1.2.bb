DESCRIPTION = "Library to implement a well-behaved Unix daemon process"
HOMEPAGE = "https://pagure.io/python-daemon/"
SECTION = "devel/python"

DEPENDS += "python-docutils-native"
RDEPENDS:${PN} = "python-docutils \
                  python-lockfile (>= 0.10) \
                  python-resource \
"

LICENSE = "Apache-2.0 & GPL-3.0-only"
LIC_FILES_CHKSUM = "file://README;md5=2695c853a2cafc33e68a1d972889ebd2"

inherit pypi setuptools

SRC_URI[md5sum] = "9c57343d81f2a96c51cffeab982b04d2"
SRC_URI[sha256sum] = "261c859be5c12ae7d4286dc6951e87e9e1a70a882a8b41fd926efc1ec4214f73"

# Fix for build error in Yocto:
#     i = p.rfind('/') + 1
# AttributeError: 'NoneType' object has no attribute 'rfind'
#S = "${WORKDIR}/python-daemon"
SRC_URI:append = " \
                  file://0001-Workaround-for-issue-2-1.patch \
"

PYPI_PACKAGE = "python-daemon"

SKIP_RECIPE[python-daemon] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
