FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:remove = "file://0002-e_devcrypto-add-support-for-TLS1.2-algorithms-offloa.patch "
SRC_URI += "file://0001-Enhance-cryptodev-s-engine-by-CAAM-public-key-crypto.patch "
