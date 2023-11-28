FILESEXTRAPATHS:prepend := "${THISDIR}/ai-robot:"

SRC_URI:append = " \
file://0001-Let-OP-TEE-to-use-UART1-for-i.MX8M-Plus-AI-Robot-boa.patch \
"
