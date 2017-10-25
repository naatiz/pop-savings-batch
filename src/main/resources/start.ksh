#!/bin/ksh

APPNAME="AEM Scoping Tool"
APPCODE=aemscope
APPBASE=/home/sangupta
APPPID=$APPBASE/runs/$APPCODE.pid
APPJAR=$APPBASE/aem-scope.jar
APPOPTS="-XX:-LoopUnswitching -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled"

case $1 in
    start)
        echo "Starting $APPNAME server ..."
        if [ ! -f $APPPID ]; then
            nohup java $APPOPTS -jar $APPJAR /home/admin/$APPCODE 2>> /dev/null >> /dev/null &
            echo $! > $APPPID
            echo "$APPNAME started!"
        else
            echo "$APPNAME is already running ..."
        fi
    ;;

    stop)
        if [ -f $APPPID ]; then
            PID=$(cat $APPPID);
            echo "Stopping $APPNAME..."
            kill $PID;
            echo "$APPNAME stopped!"
            rm $APPPID
        else
            echo "$APPNAME is not running ..."
        fi
    ;;

    *)
        echo "Choose an option start/stop for the service"
    ;;
esac