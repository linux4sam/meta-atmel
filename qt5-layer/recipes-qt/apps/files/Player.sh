#!/bin/sh

if [ -e /dev/fb1 ]
then
	sleep 2
	dd if=/dev/zero of=/dev/fb0

	cd "$(dirname "$0")"
	./player -platform linuxfb:fb=/dev/fb1 -plugin tslib:/dev/input/event1 -plugin evdevkeyboard:/dev/input/event0 $1

	dd if=/dev/zero of=/dev/fb1
else
	# find screen geometry
	resolution=`/usr/sbin/fbset | sed -n -e "s/^mode \"\([^-]*\).*/\1/p"`
	V_WIDTH=`echo $resolution | cut -f1 -d 'x'`
	V_HEIGHT=`echo $resolution | cut -f2 -d 'x'`
	#echo "w=${V_WIDTH}, h=${V_HEIGHT}"

	# Hack to prevent the pipeline from being stuck and launch weston & Qtdemo again.
	(sleep 142 && killall -9 gst-launch-1.0 > /dev/null 2>&1 && /etc/init.d/weston start > /dev/null 2>&1 && sleep 1 &&  /etc/init.d/qtdemo start > /dev/null 2>&1)&

	if [ -d /proc/asound/card0 ]
	then
	
		/usr/bin/gst-launch-1.0 uridecodebin uri=file:///opt/VideoPlayer/media/Microchip-masters.mp4 expose-all-streams=false name=srcVideo caps="video/x-h264\;audio/x-raw" srcVideo. ! h264parse ! queue ! g1h264dec ! video/x-raw,width=${V_WIDTH},height=${V_HEIGHT} ! drmsink max-lateness=-1 async=false enable-last-sample=false srcVideo. ! queue ! audioconvert ! audio/x-raw,format=S16LE ! alsasink async=false enable-last-sample=false

	else
	
		/usr/bin/gst-launch-1.0 uridecodebin uri=file:///opt/VideoPlayer/media/Microchip-masters.mp4 expose-all-streams=false name=srcVideo caps="video/x-h264" srcVideo. ! h264parse ! queue ! g1h264dec ! video/x-raw,width=${V_WIDTH},height=${V_HEIGHT} ! drmsink max-lateness=-1 async=false enable-last-sample=false

	fi

fi
