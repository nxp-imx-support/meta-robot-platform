# Copyright 2019-2023 NXP

DEPENDS += "libglu"

ROS_BUILD_DEPENDS:remove = " \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

ROS_EXEC_DEPENDS:remove = " \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

ROS_BUILD_DEPENDS += " \
    suitesparse \
"

ROS_EXEC_DEPENDS += " \
    suitesparse \
"

# Don't try to read /proc/cpuinfo as we're cross-compling
EXTRA_OECMAKE += " \
    -DDO_SSE_AUTODETECT=OFF \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse2", "", "-DDISABLE_SSE2=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse3", "", "-DDISABLE_SSE3=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.1", "", "-DDISABLE_SSE4_1=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.2", "", "-DDISABLE_SSE4_2=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.A", "", "-DDISABLE_SSE4_A=ON", d)} \
"
