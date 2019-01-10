DESCRIPTION = "Enigma2 is an experimental, but useful framebuffer-based frontend for DVB functions"
MAINTAINER = "vuplus team"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c9e255efa454e0155c1fd758df7dcaf3"

DEPENDS = " \
        jpeg \
        giflib \
        libmad \
        libpng \
        libsigc++-1.2 \
        gettext-native \
        dreambox-dvbincludes \
        freetype \
        libdvbsi++ \
        python \
        swig-native \
        libfribidi \
        libxml2 \
        libxmlccwrap \
        libdreamdvd \
        ${@base_contains("GST_VERSION", "1.0", "gstreamer1.0-plugins-base gstreamer1.0", "gst-plugins-base gstreamer", d)} \
        python-wifi \
        hostapd \
        bridge-utils \
        ntfs-3g \
        dosfstools \
        util-linux \
        fuse-exfat \
        satipclient \
	"

DEPENDS += " \
	wireless-tools \
	wpa-supplicant \
	python-twisted \
	curlftpfs \
	fuse \
	virtual/kernel \
	aio-grab \
	librtmp \
	cdrkit \
	libcddb \
	libcdio \
	avahi \
	gstreamer1.0-plugins-good \
	gstreamer1.0-plugins-bad \
	"

DEPENDS += " \
	vuplus-3gcommand \
	vuplus-dlnaserver \
	"

RDEPENDS_${PN} = " \
	alsa-conf \
        ethtool \
	glibc-gconv-iso8859-15 \
        parted \
	${PYTHON_RDEPS} \
	${GST_RDEPENDS} \
	fuse-exfat \
	util-linux-partx \
	vuplus-skins \
	${@base_contains("VUPLUS_FEATURES", "dvbproxy", "vuplus-dvb-proxy libgles vuplus-platform-util", "vuplus-dvb-modules", d)} \
	${@base_contains("VUPLUS_FEATURES", "bluetooth", "bluetoothsetup-${MACHINE}", "", d)} \
	udev \
	"

PYTHON_RDEPS = " \
        python-codecs \
        python-core \
        python-lang \
        python-re \
        python-threading \
        python-xml \
        python-fcntl \
        python-stringold \
        python-pickle \
        python-netclient \
	"

GST_RDEPENDS = "${@base_contains('GST_VERSION', '1.0', ' \
	gstreamer1.0-plugin-dvbmediasink \
	gstreamer1.0-plugin-subsink \
	gstreamer1.0-plugins-base-alsa \
	gstreamer1.0-plugins-base-app \
	gstreamer1.0-plugins-base-audioconvert \
	gstreamer1.0-plugins-base-audioresample \
	gstreamer1.0-plugins-base-ogg \
	gstreamer1.0-plugins-base-playback \
	gstreamer1.0-plugins-base-subparse \
	gstreamer1.0-plugins-base-typefindfunctions \
	gstreamer1.0-plugins-base-vorbis \
	gstreamer1.0-plugins-good-apetag \
	gstreamer1.0-plugins-good-audioparsers \
	gstreamer1.0-plugins-good-autodetect \
	gstreamer1.0-plugins-good-avi \
	gstreamer1.0-plugins-good-flac \
	gstreamer1.0-plugins-good-flv \
	gstreamer1.0-plugins-good-icydemux \
	gstreamer1.0-plugins-good-id3demux \
	gstreamer1.0-plugins-good-isomp4 \
	gstreamer1.0-plugins-good-matroska \
	gstreamer1.0-plugins-good-rtp \
	gstreamer1.0-plugins-good-rtpmanager \
	gstreamer1.0-plugins-good-rtsp \
	gstreamer1.0-plugins-good-souphttpsrc \
	gstreamer1.0-plugins-good-udp \
	gstreamer1.0-plugins-good-wavparse \
	gstreamer1.0-plugins-bad-faad \
	gstreamer1.0-plugins-bad-fragmented \
	gstreamer1.0-plugins-bad-videoparsersbad \
	gstreamer1.0-plugins-bad-mms \
	gstreamer1.0-plugins-bad-mpegpsdemux \
	gstreamer1.0-plugins-bad-mpegtsdemux \
	gstreamer1.0-plugins-ugly-asf \
	gstreamer1.0-plugins-ugly-cdio \
	gstreamer1.0-plugins-ugly-dvdsub \
	gstreamer1.0-plugins-ugly-mad \
	gstreamer1.0-plugins-ugly-amrnb \
	gstreamer1.0-plugins-ugly-amrwbdec \
	', ' \
	gst-plugin-dvbmediasink \
	gst-plugin-subsink \
	gst-plugins-base-alsa \
	gst-plugins-base-app \
	gst-plugins-base-audioconvert \
	gst-plugins-base-audioresample \
	gst-plugins-base-decodebin \
	gst-plugins-base-decodebin2 \
	gst-plugins-base-ogg \
	gst-plugins-base-playbin \
	gst-plugins-base-subparse \
	gst-plugins-base-typefindfunctions \
	gst-plugins-base-vorbis \
	gst-plugins-good-apetag \
	gst-plugins-good-audioparsers \
	gst-plugins-good-autodetect \
	gst-plugins-good-avi \
	gst-plugins-good-flac \
	gst-plugins-good-flv \
	gst-plugins-good-icydemux \
	gst-plugins-good-id3demux \
	gst-plugins-good-isomp4 \
	gst-plugins-good-matroska \
	gst-plugins-good-rtp \
	gst-plugins-good-rtpmanager \
	gst-plugins-good-rtsp \
	gst-plugins-good-souphttpsrc \
	gst-plugins-good-udp \
	gst-plugins-good-wavparse \
	gst-plugins-bad-cdxaparse \
	gst-plugins-bad-faad \
	gst-plugins-bad-mms \
	gst-plugins-bad-mpegdemux \
	gst-plugins-bad-vcdsrc \
	gst-plugins-bad-fragmented \
	gst-plugins-ugly-asf \
	gst-plugins-ugly-cdio \
	gst-plugins-ugly-dvdsub \
	gst-plugins-ugly-mad \
	gst-plugins-ugly-mpegstream \
	gst-plugins-ugly-mpegaudioparse \
	gst-plugins-ugly-amrnb \
	gst-plugins-ugly-amrwbdec \
	', d)}"

# 'forward depends' - no two providers can have the same PACKAGES_DYNAMIC, however both
# enigma2 and enigma2-plugins produce enigma2-plugin-*.
#DEPENDS += "enigma2-plugins"
#PACKAGES_DYNAMIC = "enigma2-plugin-*"

SUMMARY_enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
RDEPENDS_enigma2-plugin-extensions-cutlisteditor = "aio-grab"
SUMMARY_enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
SUMMARY_enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
SUMMARY_enigma2-plugin-systemplugins-frontprocessorupdate = "keeps your frontprocessor up to date."
SUMMARY_enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
SUMMARY_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
SUMMARY_enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
SUMMARY_enigma2-plugin-systemplugins-skinselector = "shows a menu with selectable skins."
SUMMARY_enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
DEPENDS_enigma2-plugin-extensions-dvdplayer = "libdreamdvd0"
RDEPENDS_enigma2-plugin-systemplugins-nfiflash = "python-twisted-web"
RDEPENDS_enigma2-plugin-systemplugins-softwaremanager = "python-twisted-web"
RCONFLICTS_enigma2-plugin-systemplugins-softwaremanager = "enigma2-plugin-systemplugins-configurationbackup enigma2-plugin-systemplugins-softwareupdate"
RREPLACES_enigma2-plugin-systemplugins-softwaremanager = "enigma2-plugin-systemplugins-configurationbackup enigma2-plugin-systemplugins-softwareupdate"
SUMMARY_enigma2-plugin-systemplugins-crashlogautosubmit = "automatically send crashlogs to Dream Multimedia"
RDEPENDS_enigma2-plugin-systemplugins-crashlogautosubmit = "python-twisted-mail python-twisted-names python-compression python-mime python-email"
SUMMARY_enigma2-plugin-systemplugins-cleanupwizard = "informs you on low internal memory on system startup."
SUMMARY_enigma2-plugin-extenstions-modem = "opens a menu to connect to internet via builtin modem."
RDEPENDS_enigma2-plugin-extensions-modem = "dreambox-modem-ppp-scripts ppp"
SUMMARY_enigma2-plugin-systemplugins-wirelesslan = "helps you configuring your wireless lan"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslan = "wpa-supplicant wireless-tools python-wifi"
SUMMARY_enigma2-plugin-systemplugins-wirelesslansetup = "configure wireless lan"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslansetup = "wpa-supplicant wireless-tools python-wifi"
SUMMARY_enigma2-plugin-systemplugins-networkwizard = "provides easy step by step network configuration"
RDEPENDS_enigma2-plugin-extensions-webbrowser = "python-gdata libqtwebkite4 vuplus-webbrowser-utils qt4-embedded-fonts qt4-embedded-plugin-imageformat-gif qt4-embedded-plugin-imageformat-ico qt4-embedded-plugin-imageformat-jpeg qt4-embedded-plugin-imageformat-mng qt4-embedded-plugin-imageformat-svg qt4-embedded-plugin-imageformat-tiff qt4-embedded-plugin-iconengine-svgicon "
SUMMARY_enigma2-plugin-systemplugins-crashreport = "automatically send crashlogs to Vu+"
RDEPENDS_enigma2-plugin-systemplugins-crashreport = "python-twisted-mail python-twisted-names python-compression python-mime python-email"
RDEPENDS_enigma2-plugin-systemplugins-wirelessaccesspoint = "hostapd bridge-utils"

RDEPENDS_enigma2-plugin-extensions-streamtv = " \
	librtmp \
	${@base_contains("GST_VERSION", "1.0", "gstreamer1.0-plugins-bad-rtmp", "gst-plugins-bad-rtmp", d)} \
"

DEPENDS += "djmount minidlna"
RDEPENDS_enigma2-plugin-extensions-dlnaserver = "minidlna vuplus-dlnaserver"
RDEPENDS_enigma2-plugin-extensions-dlnabrowser = "djmount kernel-module-fuse fuse-utils"

DEPENDS += "${@base_contains("VUPLUS_FEATURES", "hbbtv", "opera-hbbtv" , "", d)}"
RDEPENDS_enigma2-plugin-extensions-hbbtv = "${@base_contains("VUPLUS_FEATURES", "hbbtv", "opera-hbbtv" , "", d)}"

DEPENDS += "${@base_contains("VUPLUS_FEATURES", "webkithbbtv", "webkit-hbbtv-browser" , "", d)}"

DEPENDS += "wvdial wvstreams ppp usb-modeswitch usb-modeswitch-data"
RDEPENDS_enigma2-plugin-systemplugins-3gmodemmanager = "ppp usb-modeswitch usb-modeswitch-data wvdial wvstreams \
	kernel-module-ppp-async kernel-module-ppp-deflate kernel-module-ppp-synctty kernel-module-ppp-generic kernel-module-usbserial \
	vuplus-3gcommand \
"

RDEPENDS_enigma2-plugin-systemplugins-devicemanager = "util-linux-blkid ntfs-3g dosfstools"
RDEPENDS_enigma2-plugin-systemplugins-netdrive = "curlftpfs kernel-module-fuse fuse"

RDEPENDS_enigma2-plugin-systemplugins-backupsuitehdd = "mtd-utils-mkfs.ubifs mtd-utils-nanddump mtd-utils-ubinize"
RDEPENDS_enigma2-plugin-systemplugins-backupsuiteusb = "enigma2-plugin-extensions-backupsuitehdd"

RDEPENDS_enigma2-plugin-extensions-satipclient = "satipclient"

DEPENDS += "${@base_contains("VUPLUS_FEATURES", "uianimation", "libgles libvugles2" , "", d)}"
RDEPENDS_${PN}_append_vuplus += "${@base_contains("VUPLUS_FEATURES", "uianimation", "libvugles2" , "", d)}"

PN = "enigma2"
PR = "r189"

inherit gitpkgv pythonnative

####################################################
SRCDATE = "20121128"
PV = "experimental-git${SRCDATE}"
BRANCH = "vuplus_experimental"
SRCREV = ""
####################################################

# enigma2_vuplus_mediaplayer.patch is for trick-play in media player

SRC_URI = "git://code.vuplus.com/git/dvbapp.git;protocol=http;branch=${BRANCH};rev=${SRCREV} \
	file://enigma2_vuplus_skin.patch \
	file://enigma2_vuplus_mediaplayer.patch \
	file://enigma2_vuplus_remove_dreambox_enigma.patch \
	file://enigma2_vuplus_vfd_mode.patch \
	file://enigma2_vuplus_pluginbrowser.patch \
	file://enigma2_vuplus_proc_oom_score_adj.patch \
        file://enigma2_vuplus_fix_standby_name.patch \
	file://enigma2_vuplus_disable_subtitle_sync_mode_bug.patch \
	file://spinner \
	file://number_key \
"

SRC_URI_append = " ${@base_contains('GST_VERSION', '1.0', '', 'file://enablesubtitleshack.patch', d)}"

SRC_URI_append = " ${@base_contains("VUPLUS_FEATURES", "vuwlan", "file://enigma2_vuplus_networksetup.patch", "", d)}"

LDFLAGS_prepend = "${@base_contains('GST_VERSION', '1.0', ' -lxml2 ', '', d)}"

SRC_URI_append = " file://enigma2_vuplus_inputhotplug.patch"

def change_po():
    import os
    try:
        os.system("find ./ -name \"*.po\" > ./po_list")
        os.system("find ./ -name \"*.pot\" >> ./po_list")
        po_list = []
        po_list = open('po_list','r+').readlines()
        for x in po_list:
            changeword(x)
        os.system('rm po_list')
    except:
        print 'word patch error '
        return

def changeword(file):
    fn = file[:-1]
    fnn = file[:-1]+'_n'
    cmd = "sed s/Dreambox/STB/g "+fn+" > "+fnn
    os.system(cmd)
    cmd1 = "mv "+fnn+" "+fn
    os.system(cmd1)

do_unpack_append(){
    change_po()
}

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/fonts ${datadir}/keymaps"
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools-brokensep pkgconfig pythonnative

do_configure_prepend() {
	git checkout ${BRANCH}
}

do_compile_prepend_vuplus() {
	install -m 0755 ${WORKDIR}/spinner/*.png ${S}/data/skin_default/spinner/
	install -m 0755 ${WORKDIR}/number_key/*.png ${S}/data/skin_default/buttons/
}

EXTRA_OECONF = " \
        --enable-dependency-tracking \
	${@base_contains("GST_VERSION", "1.0", "--with-gstversion=1.0", "", d)} \
	${@base_contains("VUPLUS_FEATURES", "display-text-vfd", "--with-display-text-vfd" , "", d)} \
	${@base_contains("VUPLUS_FEATURES", "display-graphic-vfd", "--with-display-graphic-vfd" , "", d)} \
	${@base_contains("VUPLUS_FEATURES", "right-half-vfd-skin", "--with-set-right-half-vfd-skin" , "", d)} \
	${@base_contains("VUPLUS_FEATURES", "enable-rc-kbd", "--with-remote-keyboard" , "", d)} \
	${@base_contains("VUPLUS_FEATURES", "uianimation", "--with-libvugles2" , "", d)} \
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
"

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
}

INSANE_SKIP_${PN} = "already-stripped"
INSANE_SKIP_enigma2-plugin-extensions-webbrowser = "build-deps"
INSANE_SKIP_enigma2-plugin-extensions-modem = "build-deps"



