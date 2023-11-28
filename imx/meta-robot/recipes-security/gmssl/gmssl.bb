
SUMMARY = "GmSSL is an open source cryptographic toolbox that supports SM2 / SM3 / SM4 / SM9 "
HOMEPAGE = "http://gmssl.org/english.html"
SECTION = "libs/network"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ede559f2991be538508d2883d54e0d1e"

DEPENDS = "hostperl-runtime-native"

SRC_URI = " file://gmssl.tar.gz"
SRC_URI[md5sum] = "655f2349fdd4de0fa01ab2b422d93786"
SRC_URI[sha256sum] = "b32c324b7f16b66a37840d1db44586833e9e87bc401010ed32c069643a6acd68"
SRC_URI += " \
file://porting_for_imx_caam.patch \
file://change_lib_name_to_gmcrypto_gmssl.patch \
"

inherit lib_package multilib_header 

PACKAGECONFIG ?= "cryptodev-linux"

PACKAGECONFIG[cryptodev-linux] = "-DHAVE_CRYPTODEV -DUSE_CRYPTODEV_DIGESTS,,cryptodev-linux"
PACKAGECONFIG[perl] = ",,,"

# Remove this to enable SSLv3. SSLv3 is defaulted to disabled due to the POODLE
# vulnerability 
EXTRA_OECONF = "no-ssl3"

EXTRA_OECONF += "no-saf no-sdf no-skf no-sof no-zuc"

EXTRA_OECONF:remove = "--disable-static"

EXTRA_OECONF:append:aarch64 = " no-afalgeng -DHW_ENDIAN_SWAP"

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure () {
	# The crypto_use_bigint patch means that perl's bignum module needs to be
	# installed, but some distributions (for example Fedora 23) don't ship it by
	# default.  As the resulting error is very misleading check for bignum before
	# building.
	if ! perl -Mbigint -e true; then
		bbfatal "The perl module 'bignum' was not found but this is required to build GmSSL.  Please install this module (often packaged as perl-bignum) and re-run bitbake."
	fi

	os=${HOST_OS}
	case $os in
	linux-gnueabi |\
	linux-gnuspe |\
	linux-musleabi |\
	linux-muslspe |\
	linux-musl )
		os=linux
		;;
	*)
		;;
	esac
	target="$os-${HOST_ARCH}"
	case $target in
	linux-arm)
		target=linux-armv4
		;;
	linux-armeb)
		target=linux-elf-armeb
		;;
	linux-aarch64*)
		target=linux-aarch64
		;;		
	linux-riscv32)
		target=linux-generic32
		;;
	linux-riscv64)
		target=linux-generic64
		;;
	esac

	# inject machine-specific flags
	sed -i -e "s|^\(\"$target\",\s*\"[^:]\+\):\([^:]\+\)|\1:${CFLAG}|g" Configure

	useprefix=${prefix}
	if [ "x$useprefix" = "x" ]; then
		useprefix=/
	fi

	perl ./Configure ${EXTRA_OECONF} ${PACKAGECONFIG_CONFARGS} shared --prefix=$useprefix --openssldir=/etc/gmssl --libdir=/lib $target
}

do_compile () {
	oe_runmake depend
	oe_runmake
}

do_install () {
	# Create ${D}/${prefix} to fix parallel issues
	mkdir -p ${D}/${prefix}/

	oe_runmake DESTDIR="${D}" install
	oe_multilib_header openssl/opensslconf.h
	rm ${D}/usr/bin/openssl ${D}/usr/bin/c_rehash
	mv ${D}/usr/include/openssl ${D}/usr/include/gmssl
}

PACKAGES =+ "${PN}-engines"

FILES:${PN} =+ "${libdir}/*"
FILES:${PN}-engines = "${libdir}/engines-1.1/*"
