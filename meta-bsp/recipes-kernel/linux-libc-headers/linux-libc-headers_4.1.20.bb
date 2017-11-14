FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PV = "4.1.20"
PR .= "-bsp1"

require linux-libc-headers.inc

SRC_URI_append_vuultimo4k = " \
	file://linux_4.1.20_dmx_source_dvr.patch \
"

SRC_URI[md5sum] = "075c38a3a23ca5bc80437b13606df00a"
SRC_URI[sha256sum] = "faa56b8550fee0647f92bff3d4ceee2dfd983b51600c634ffd3294215f43f8b6"
