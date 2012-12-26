DESCRIPTION = "Linux kernel for vuplus"
SECTION = "kernel"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KV = "2.6.37"

PR = "r3"
SRCREV = ""

MODULE = "linux-2.6.37"

SRC_URI += "http://archive.vuplus.com/download/kernel/stblinux-3.3.6-1.2.tar.bz2 \
        file://brcm_3.3.patch;patch=1;pnum=1 \
        file://fix_cpu_proc.patch;patch=1;pnum=1 \
        file://brcm_mtd_mac.patch;patch=1;pnum=1 \
        file://dvb_core_5.5.patch;patch=1;pnum=1 \
	file://brcm_remove_entire_mtd.patch;patch=1;pnum=1 \
        file://${MACHINE}_defconfig \
	"

S = "${WORKDIR}/linux"

inherit kernel

FILES_kernel-vmlinux = "/boot/vmlinux-*"
FILES_kernel-image = "/boot/vmlinux.gz"

export OS = "Linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"
KERNEL_OBJECT_SUFFIX = "ko"


do_configure_prepend() {
        oe_machinstall -m 0644 ${WORKDIR}/${MACHINE}_defconfig ${S}/.config
        oe_runmake oldconfig
}

kernel_do_install_append() {
        install -d ${D}/${KERNEL_IMAGEDEST}
        install -m 0755 ${KERNEL_OUTPUT} ${D}/${KERNEL_IMAGEDEST}
        gzip ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
}

pkg_postinst_kernel-image () {
        if [ -d /proc/stb ] ; then
                flash_eraseall -j /dev/mtd2
                nandwrite -p /dev/mtd2 /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        fi
        rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        true
}

SRC_URI[md5sum] = "64bc9b526a668d6cad1ea83646137026"
SRC_URI[sha256sum] = "da99dc00ad47696a7cf1f56fc90e42b51f3dbd2982a6f11a2ac5dc2d12f22b4f"

