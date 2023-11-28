
SUMMARY = "This is a c++ implementation of Lie groups commonly used for 2d and 3d geometric problems (i.e. for Computer Vision or Robotics applications). Among others, this package includes the special orthogonal groups SO(2) and SO(3) to present rotations in 2d and 3d as well as the special Euclidean group SE(2) and SE(3) to represent rigid body transformations (i.e. rotations and translations) in 2d and 3d."

HOMEPAGE = "https://github.com/strasdat/sophus"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8f78120fdd8782ba44f0f9cd9a4a393b"

DEPENDS = "libeigen"

BRANCH ?= "branch=release/noetic/sophus"
SRC_URI = "git://github.com/yujinrobot-release/sophus-release;${BRANCH};protocol=https \
          file://0001-Fix-the-abort-issue-by-removing-abort-function.patch \
"
SRCREV = "d703a30647a1b8114cd36bd5bc1f3bee9a0a9a49"
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "\
  -DBUILD_SOPHUS_EXAMPLES=OFF \
"
inherit cmake
