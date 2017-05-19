#!/bin/bash

JAVA_INCLUDE=-"I$JAVA_HOME/include -I$JAVA_HOME/include/linux"
OUTDIR=src/generated/java/com/steeplesoft/turbovision/internal

rm -rf src/generated/java
mkdir -p $OUTDIR

set -x
#function hi() {
swig -v \
    -debug-classes \
    -c++ \
    -java \
    -outdir $OUTDIR  \
    -package com.steeplesoft.turbovision.internal \
    -I../library/include -I$JAVA_HOME/include \
    -I$JAVA_HOME/include/linux \
    tvision.i
#}
g++ -DUses_TApplication -c -fPIC $JAVA_INCLUDE -I../library/include -I/include/boost-0  -L../library/makes -lrhtv tvision_wrap.cxx  -I"/opt/jdk-1.8/include" -I"/opt/jdk-1.8/include/linux"
g++ -shared  -L../library/makes -lrhtv tvision_wrap.o    -o libtvision.so
#-I/include/boost-0 $JAVA_INCLUDE   

#g++ -Wall -Wno-sign-compare -Wpointer-arith \
#	-Wformat-security -Wswitch-enum \
#	-Wunused-parameter -Wstrict-aliasing -Wcast-align \
#	-Wmissing-field-initializers \
#	-I/opt/jdk-1.8/include -I/opt/jdk-1.8/include/linux \
#	-I../library/include \
#	-g -O2 -export-dynamic tvision_wrap.cxx \
#	-L../library/makes \
#	-lrhtv
