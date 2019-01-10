DESCRIPTION = "Bootlogo support"
SECTION = "base"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PRIORITY = "required"

PROVIDES += "vuplus-bootlogo"
RPROVIDES_${PN} += "vuplus-bootlogo"

IMAGES_VERSION = "1"
BINARY_VERSION = "7"

PV = "${BINARY_VERSION}.${IMAGES_VERSION}"
INC_PR = "r10"

SRC_URI = "file://bootlogo.mvi file://backdrop.mvi file://bootlogo_wait.mvi"

S = "${WORKDIR}/"
PACKAGES = "${PN}"
INHIBIT_PACKAGE_STRIP = "1"

do_install() {
	install -d ${D}/boot ${D}${datadir}/vuplus-bootlogo
	install -d ${D}/usr/share
	for file in *.mvi; do
                install -m 0644 $file ${D}${datadir}/vuplus-bootlogo
                ln -s vuplus-bootlogo/$file ${D}${datadir}
		ln -sf ${datadir}/vuplus-bootlogo/$file ${D}/boot/$file;
        done
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/boot ${datadir} ${sysconfdir}"

inherit update-rc.d

INITSCRIPT_PARAMS = "start 70 S . stop 89 0 ."
INITSCRIPT_NAME = "vuplus-bootlogo"

SRC_URI += "file://${INITSCRIPT_NAME}.sysvinit"

do_install_append() {
        if [ -f ${WORKDIR}/${INITSCRIPT_NAME}.sysvinit ]; then
                install -d ${D}${INIT_D_DIR}
                install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME}.sysvinit ${D}${INIT_D_DIR}/${INITSCRIPT_NAME}
        fi
}

do_populate_sysroot[noexec] = "1"
