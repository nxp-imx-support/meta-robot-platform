DESCRIPTION = "CLBlast is a modern, lightweight, performant and tunable OpenCL BLAS library written in C++11." 
SUMMARY = "CLBlast : a tunable OpenCL BLAS library" 
HOMEPAGE = "http://www.cedricnugteren.nl/" 
SECTION = "libs" 
LICENSE = "Apache-2.0" 
LIC_FILES_CHKSUM = "file://LICENSE;md5=aeb40f7c58956a1eb8441f0b51f900bb"

DEPENDS = "make" 

SRC_URI = "git://github.com/CNugteren/CLBlast.git;protocol=https \
file://0001-tuning-for-Vivante-OpenCL-Device-GPU.patch \
" 

# Modify these as desired
PV = "1.5.0"
SRCREV = "0c9411c84465d14d2de33046536403648909eb9f"

S = "${WORKDIR}/git" 

DEPENDS = "imx-gpu-viv"

inherit cmake

EXTRA_OECMAKE += "\
  -DOPENCL_ROOT=${STAGING_DIR_HOST}/usr/ \
  -DTESTS=ON \
  -DCLIENTS=ON \
  -DTUNERS=ON  \
"

