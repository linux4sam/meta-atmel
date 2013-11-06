# Bootstrap image
require recipes-images/angstrom/console-base-image.bb

export IMAGE_BASENAME = "bootstrap-image"

IMAGE_INSTALL += " \
	setup-bootstrap \
	"
