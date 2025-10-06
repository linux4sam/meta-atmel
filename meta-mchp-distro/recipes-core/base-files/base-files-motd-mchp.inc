do_install:append() {
    if [ -n "${MCHP_RELEASE_VERSION}" ] && [ -n "${MCHP_RELEASE_URL}" ]; then
        echo "This is version ${MCHP_RELEASE_VERSION} of the meta-mchp release." > ${D}${sysconfdir}/motd
        echo "" >> ${D}${sysconfdir}/motd
        echo "Updated images and documentation are available at:" >> ${D}${sysconfdir}/motd
        echo "        ${MCHP_RELEASE_URL}" >> ${D}${sysconfdir}/motd
    fi
}
