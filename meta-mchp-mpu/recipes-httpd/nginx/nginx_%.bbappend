do_install:append() {
# Ensure the sites-available directory exists
install -d ${D}${sysconfdir}/nginx/sites-available

# Replace the content of the default_server.site with your custom configuration
cat > ${D}${sysconfdir}/nginx/sites-available/default_server <<EOF
# Default server configuration
server {
	listen 80 default_server;
	listen [::]:80 default_server;
	root /var/www/localhost/html/wireless_kit;
	index index.html index.htm;
	server_name _;
	# redirect server error pages to the static page /50x.html
	error_page 500 502 503 504 /50x.html;
	}
EOF
}
