#!/bin/bash

export LD_LIBRARY_PATH=`pwd`:`pwd`/../library/makes
mvn install
java -Djava.library.path=$LD_LIBRARY_PATH -cp target/tvsample-1.0-SNAPSHOT.jar runme
reset
stty sane
