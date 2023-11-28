require recipes-imported-labgrid/python/python-u-msgpack-python.inc

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

SRC_URI[md5sum] = "8c2a628b26f7e2d5857fdddeca8478a0"
SRC_URI[sha256sum] = "2f31fc1b6dd8632c230ea7012470e40f77119f20999274dda6f1afa9c305e590"
