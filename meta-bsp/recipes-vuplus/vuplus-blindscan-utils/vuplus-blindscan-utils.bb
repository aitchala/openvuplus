DESCRIPTION = "Utilities for transponder & dvb-s blindscan"
SECTION = "base"
PRIORITY = "optional"
RDEPENDS_${PN} = "ncurses"

LICENSE = "CLOSED"
require conf/license/license-close.inc

PV = "4.3"
PV_arm = "5.0"

PR = "r10"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "http://archive.vuplus.com/download/utils/vuplus-blindscan-utils-${PV}.tar.bz2"
SRC_URI_arm = "http://archive.vuplus.com/download/utils/vuplus-blindscan-utils-${PV}_arm.tar.bz2;name=arm"

S = "${WORKDIR}/blindscan-utils"

PLUGABLE_MIPSEL_BLINDSCAN = " \
	tda1002x \
	vuplus_blindscan \
	vuplus_6211_blindscan \
	vuplus_6222_blindscan \
	ssh108 \
	ssh108_t2_scan \
	tt3l10 \
	tt3l10_t2_scan \
	tt2l08 \
	tt2l08_t2_scan \
"

PLUGABLE_ARM_BLINDSCAN = " \
	vuplus_blindscan \
	vuplus_6211_blindscan \
	vuplus_6222_blindscan \
	ssh108 \
	ssh108_t2_scan \
	tt3l10 \
	tt3l10_t2_scan \
	tt2l08 \
	tt2l08_t2_scan \
	bcm3148 \
"

do_install() {
	install -d "${D}/${bindir}"
	install -m 0755 "${S}/tda1002x" "${D}/${bindir}"
}

do_install_vuuno() {
	install -d "${D}/${bindir}"
	for f in ${PLUGABLE_MIPSEL_BLINDSCAN}; do
		install -m 0755 "${S}/$f" "${D}/${bindir}"
	done
}

do_install_vuultimo() {
	install -d "${D}/${bindir}"
	for f in ${PLUGABLE_MIPSEL_BLINDSCAN}; do
		install -m 0755 "${S}/$f" "${D}/${bindir}"
	done
}

do_install_vusolo2() {
	install -d "${D}/${bindir}"
	install -m 0755 "${S}/tda1002x" "${D}/${bindir}"
	install -m 0755 "${S}/vuplus_bcm7346_blindscan" "${D}/${bindir}"
}

do_install_vuduo2() {
	install -d "${D}/${bindir}"
	for f in ${PLUGABLE_MIPSEL_BLINDSCAN}; do
		install -m 0755 "${S}/$f" "${D}/${bindir}"
	done
}

do_install_vusolose() {
	install -d "${D}/${bindir}"
	for f in ${PLUGABLE_MIPSEL_BLINDSCAN}; do
		install -m 0755 "${S}/$f" "${D}/${bindir}"
	done
}

do_install_vusolo4k() {
	install -d "${D}/${bindir}"
	for f in ${PLUGABLE_ARM_BLINDSCAN}; do
		install -m 0755 "${S}/$f" "${D}/${bindir}"
	done
}

do_install_vuuno4k() {
	install -d "${D}/${bindir}"
	for f in ${PLUGABLE_ARM_BLINDSCAN}; do
		install -m 0755 "${S}/$f" "${D}/${bindir}"
	done
}

do_install_vuultimo4k() {
	install -d "${D}/${bindir}"
	for f in ${PLUGABLE_ARM_BLINDSCAN}; do
		install -m 0755 "${S}/$f" "${D}/${bindir}"
	done
}

do_install_vuuno4kse() {
	install -d "${D}/${bindir}"
	for f in ${PLUGABLE_ARM_BLINDSCAN}; do
		install -m 0755 "${S}/$f" "${D}/${bindir}"
	done
}

do_install_vuzero4k() {
	install -d "${D}/${bindir}"
	install -m 0755 "${S}/tt2l08b" "${D}/${bindir}/tt2l08"
	install -m 0755 "${S}/tt2l08b_t2_scan" "${D}/${bindir}/tt2l08_t2_scan"
	install -m 0755 "${S}/vuplus_si2166_blindscan" "${D}/${bindir}/vuplus_si2166_blindscan"
}

SRC_URI[md5sum] = "a8ca2f8ce06d37b7d01b729b1e4e4abb"
SRC_URI[sha256sum] = "ec9b5dd552e72a0d775a77212350b71f5ea6f3619687c40c2bf97b12c5d7abd9"

SRC_URI[arm.md5sum] = "deb347c9910e2d6c7861b018d6e682c7"
SRC_URI[arm.sha256sum] = "635e7b5b23c865292b026742f0014ea3fd280d3dfe0b95647b8ae7f72aafe6a4"

INSANE_SKIP_${PN} = "already-stripped"

