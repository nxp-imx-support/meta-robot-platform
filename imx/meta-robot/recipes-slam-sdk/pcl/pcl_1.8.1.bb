DESCRIPTION = "The Point Cloud Library (or PCL) for point cloud processing."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=5b8a2a1aa14e6de44b4273134946a34c"

DEPENDS = "boost libflann libeigen qhull"

SRCREV = "39732f5a7c8455ed51fd0f6278d8b25322a68dd9"
# pcl-1.8.1 tag isn't in any branch
ROS_BRANCH ?= "nobranch=1"
SRC_URI = "git://github.com/PointCloudLibrary/pcl;${ROS_BRANCH};protocol=https \
    file://0001-Dereference-shared_ptr-fix-for-GCC8.patch \
    file://0001-Fix-deprecated-boost-endians.patch \
    file://0002-pcl_pclconfig.cmake-don-t-pass-SSE_FLAGS-as-DEFINITI.patch \
"
S = "${WORKDIR}/git"


EXTRA_OECMAKE += "\
  -DCMAKE_SKIP_RPATH=ON \
  -DHAVE_MM_MALLOC_EXITCODE=0 -DHAVE_MM_MALLOC_EXITCODE__TRYRUN_OUTPUT=0 \
  -DHAVE_POSIX_MEMALIGN_EXITCODE=0 -DHAVE_POSIX_MEMALIGN_EXITCODE__TRYRUN_OUTPUT=0 \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.2", "-DHAVE_SSE4_2_EXTENSIONS_EXITCODE=0 -DHAVE_SSE4_2_EXTENSIONS_EXITCODE__TRYRUN_OUTPUT=0", "-DHAVE_SSE4_2_EXTENSIONS_EXITCODE=1 -DHAVE_SSE4_2_EXTENSIONS_EXITCODE__TRYRUN_OUTPUT=1", d)} \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.1", "-DHAVE_SSE4_1_EXTENSIONS_EXITCODE=0 -DHAVE_SSE4_1_EXTENSIONS_EXITCODE__TRYRUN_OUTPUT=0", "-DHAVE_SSE4_1_EXTENSIONS_EXITCODE=1 -DHAVE_SSE4_1_EXTENSIONS_EXITCODE__TRYRUN_OUTPUT=1", d)} \
  -DHAVE_SSSE3_EXTENSIONS_EXITCODE=0 -DHAVE_SSSE3_EXTENSIONS_EXITCODE__TRYRUN_OUTPUT=0 \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse3", "-DHAVE_SSE3_EXTENSIONS_EXITCODE=0 -DHAVE_SSE3_EXTENSIONS_EXITCODE__TRYRUN_OUTPUT=0", "-DHAVE_SSE3_EXTENSIONS_EXITCODE=1 -DHAVE_SSE3_EXTENSIONS_EXITCODE__TRYRUN_OUTPUT=1", d)} \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse2", "-DHAVE_SSE2_EXTENSIONS_EXITCODE=0 -DHAVE_SSE2_EXTENSIONS_EXITCODE__TRYRUN_OUTPUT=0", "-DHAVE_SSE2_EXTENSIONS_EXITCODE=1 -DHAVE_SSE2_EXTENSIONS_EXITCODE__TRYRUN_OUTPUT=1", d)} \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse", "-DHAVE_SSE_EXTENSIONS_EXITCODE=0 -DHAVE_SSE_EXTENSIONS_EXITCODE__TRYRUN_OUTPUT=0", "-DHAVE_SSE_EXTENSIONS_EXITCODE=1 -DHAVE_SSE_EXTENSIONS_EXITCODE__TRYRUN_OUTPUT=1", d)} \
  -DWITH_LIBUSB=FALSE \
  -DWITH_PNG=FALSE \
  -DWITH_QHULL=TRUE \
  -DWITH_CUDA=FALSE \
  -DWITH_QT=FALSE \
  -DWITH_VTK=FALSE \
  -DWITH_PCAP=FALSE \
  -DWITH_OPENGL=FALSE \
"

#Setting -ffloat-store to alleviate 32bit vs 64bit discrepancies on non-SSE platforms.
CXXFLAGS += "${@bb.utils.contains("TARGET_CC_ARCH", "-mfpmath=sse", "", "-ffloat-store", d)}"

# pcl/1.8.1-r0/git/recognition/include/pcl/recognition/3rdparty/metslib/abstract-search.hh:137:7: error: ISO C++17 does not allow dynamic exception specifications
#  137 |       throw(no_moves_error) = 0;
#      |       ^~~~~
CXXFLAGS += "-std=gnu++14"

inherit cmake

FILES:${PN}-dev += "${datadir}/${PN}-1.8/*.cmake"

# The build is really memory hungry (at least with gcc8), even with just -j 8 it triggers OOMK on system with 32GB ram
# High memory needs mentioned in: https://github.com/PointCloudLibrary/pcl/issues/2284
# Setting just empty doesn't work, ninja will by default use number of cores available

PARALLEL_MAKE = "-j1"
