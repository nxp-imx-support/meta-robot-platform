#!/bin/sh
#
# NXP Build Enviroment Setup Script
#
# Copyright (C) 2015-2016 Freescale Semiconductor
#
# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation; either version 2 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program; if not, write to the Free Software
# Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

echo -e "\n----------------\n"
imx-robot_exit_message()
{
   echo "i.MX Robot setup complete"
}

imx-robot_usage()
{
    echo -e "\nDescription: setup-imx-robot.sh will setup the bblayers and local.conf for an i.MX Robot build."
    echo -e "\nUsage: source setup-imx-robot.sh
    Optional parameters: [-b build-dir] [-r noetic] [-h]"
    echo "
    * [-b build-dir]: Build directory, if unspecified, script uses 'build-imx-robot' as the output directory
    * [-r ROS_DISTRO]: the ROS distro (noetic, foxy or humble)
    * [-h]: help
"
}

imx-robot_cleanup()
{
    echo "Cleaning up variables"
    unset BUILD_DIR
    unset nxp_setup_help nxp_setup_error nxp_setup_flag
}

echo Reading command line parameters
# Read command line parameters
while getopts "k:r:t:b:e:gh" nxp_setup_flag
do
    case $nxp_setup_flag in
        b) BUILD_DIR="$OPTARG";
           echo -e "\n Build directory is $BUILD_DIR" ;
           ;;
        r) ros_distro="$OPTARG";
           echo -e "\n ROS distro is $ros_distro" ;
           ;;   
        h) nxp_setup_help='true';
           ;;
        ?) nxp_setup_error='true';
           ;;
    esac
done

RELEASEPROGNAME="./imx-setup-release.sh"

# get command line options
OLD_OPTIND=$OPTIND

if [ -z "$BUILD_DIR" ]; then
    BUILD_DIR=build-imx-robot
fi

echo EULA=1 source $RELEASEPROGNAME -b $BUILD_DIR
EULA=1 source $RELEASEPROGNAME -b $BUILD_DIR

echo -e "\n## Robot platform layers" >> $BUILD_DIR/conf/bblayers.conf
case $ros_distro in
    noetic)
      echo -e "\n the ROS distro is $ros_distro" ;
      echo "ROS_DISTRO = \"noetic\"" >> $BUILD_DIR/conf/bblayers.conf      
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros1-noetic \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros1 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros-common \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-python2 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros-python2 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "hostname:pn-base-files = \"imx-robot-noetic\"" >> $BUILD_DIR/conf/local.conf
      ;;  
    foxy)
      echo -e "\n the ROS distro is $ros_distro" ;
      echo "ROS_DISTRO = \"foxy\"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros2-foxy \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros2 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros-common \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-python2 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros-python2 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "hostname:pn-base-files = \"imx-robot-foxy\"" >> $BUILD_DIR/conf/local.conf
      ;;
    humble)
      echo -e "\n the ROS distro is $ros_distro" ;
      echo "ROS_DISTRO = \"humble\"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros2-humble \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros2 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros-common \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-python2 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros-python2 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "hostname:pn-base-files = \"imx-robot-humble\"" >> $BUILD_DIR/conf/local.conf
      ;;           
    *) 
      echo -e "\n the ROS distro is $ros_distro" ;
      echo "ROS_DISTRO = \"noetic\"" >> $BUILD_DIR/conf/bblayers.conf      
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros1-noetic \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros1 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros-common \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-python2 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-ros/meta-ros-python2 \"" >> $BUILD_DIR/conf/bblayers.conf
      echo "hostname:pn-base-files = \"imx-robot-noetic\"" >> $BUILD_DIR/conf/local.conf
      ;;
esac
echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-robot \"" >> $BUILD_DIR/conf/bblayers.conf
echo "BBLAYERS += \" \${BSPDIR}/sources/meta-robot-platform/imx/meta-imx8mp-ai-robot \"" >> $BUILD_DIR/conf/bblayers.conf
echo "INHERIT += \"rm_work\"" >> $BUILD_DIR/conf/local.conf

echo done except for cleanup

imx-robot_exit_message
imx-robot_cleanup
