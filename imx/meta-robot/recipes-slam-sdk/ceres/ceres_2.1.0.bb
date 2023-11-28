
SUMMARY = "Ceres Solver is an open source C++ library for modeling and solving large, complicated optimization problems. It is a feature rich, mature and performant library which has been used in production at Google since 2010. Ceres Solver can solve two kinds of problems."

HOMEPAGE = "http://ceres-solver.org/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bb761279816b72be19d7ce646e4e2a14"

DEPENDS = "libeigen"

SRC_URI = "https://github.com/ceres-solver/ceres-solver/archive/refs/tags/${PV}.tar.gz "
SRC_URI[sha256sum] = "ccbd716a93f65d4cb017e3090ae78809e02f5426dce16d0ee2b4f8a4ba2411a8"

S = "${WORKDIR}/ceres-solver-${PV}"

EXTRA_OECMAKE += "\
  -DCMAKE_BUILD_TYPE=Release \
  -DSUITESPARSE=OFF \
  -DCXSPARSE=OFF \
  -DGFLAGS=OFF \
  -DMINIGLOG=ON \
  -DBUILD_SHARED_LIBS=ON \
"
inherit cmake
