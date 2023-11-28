DESCRIPTION = "ECM, adds to the modules provided by CMake, including ones used by find_package() to find common software, ones that can be used directly in CMakeLists.txt files to perform common tasks and toolchain files that must be specified on the commandline by the user." 
SUMMARY = "Extra CMake Modules package" 
HOMEPAGE = "https://api.kde.org/ecm/" 
SECTION = "libs" 
LICENSE = "MIT" 
LIC_FILES_CHKSUM = "file://LICENSES/MIT.txt;md5=38aa75cf4c4c87f018227d5ec9638d75"


SRC_URI = "git://github.com/KDE/extra-cmake-modules" 
SRC_URI[md5sum] = "56211e7036054751202083b3974ee377"
SRC_URI[sha256sum] = "04ced15a5650e40b85a9772306fa9862a65c93a628f98e781e327cb67a24f12c"

# Modify these as desired
SRCREV = "17d053b86054e3bf75d5d299534e3efe6290ae92"

S = "${WORKDIR}/git" 

inherit cmake

INSANE_SKIP:${PN} = "installed-vs-shipped"