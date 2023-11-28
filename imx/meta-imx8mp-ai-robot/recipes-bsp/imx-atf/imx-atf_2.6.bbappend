FILESEXTRAPATHS:prepend := "${THISDIR}/ai-robot:"

SRC_URI:append = " \
file://0001-Change-console-to-UART1-for-iMX8MP-AI-ROBOT-board.patch \
"
EXTRA_OEMAKE += 'IMX_BOOT_UART_BASE=0x30860000'