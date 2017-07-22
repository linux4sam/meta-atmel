#!/bin/sh
# Killall weston will kill all the child process including QT Application and this script file
# executing Player.sh in background to play video file.

(sh /opt/VideoPlayer/Player.sh > /opt/1.txt 2>&1)&

killall -v -9 weston > /dev/null 2>&1

