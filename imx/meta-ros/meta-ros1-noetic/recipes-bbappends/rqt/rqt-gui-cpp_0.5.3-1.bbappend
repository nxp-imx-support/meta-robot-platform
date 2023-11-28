# This is needed to set OE_QMAKE_PATH_EXTERNAL_HOST_BINS to resolve:
# | CMake Error at CMakeLists.txt:24 (qt5_wrap_cpp):
# | Unknown CMake command "qt5_wrap_cpp".
# |-- Configuring incomplete, errors occurred!
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt6', 'pyqt6'], '', 'qt6-cmake', d)}

