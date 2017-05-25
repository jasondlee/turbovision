#!/bin/bash

export LD_LIBRARY_PATH=`pwd`:`pwd`/../library/makes

./compile.sh

mvn clean install && \
        read -p "Hit enter... " && \
	java -Djava.library.path=$LD_LIBRARY_PATH -cp target/tvsample-1.0-SNAPSHOT.jar com.steeplesoft.turbovision.TurboVisionDemo 2> error.log && \
	reset ; stty sane
