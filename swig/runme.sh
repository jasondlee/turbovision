#!/bin/bash

export LD_LIBRARY_PATH=`pwd`:`pwd`/../library/makes

./compile.sh -sm

if [ $? -eq 0 ] ; then
    java -Djava.library.path=$LD_LIBRARY_PATH -cp target/tvsample-1.0-SNAPSHOT.jar \
        com.steeplesoft.turbovision.TurboVisionDemo 2> error.log
    RC=$?
    reset ; stty sane
    if [ $RC != -1 ] ; then
        cat error.log
    fi
fi
