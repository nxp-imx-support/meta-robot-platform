do_install:append () {
    mv -f ${D}${bindir}/futurize ${D}${bindir}/futurize3
    mv -f ${D}${bindir}/pasteurize ${D}${bindir}/pasteurize3
}
