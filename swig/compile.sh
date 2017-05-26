#!/bin/bash

JAVA_INCLUDE=-"I$JAVA_HOME/include -I$JAVA_HOME/include/linux"
OUTDIR=src/generated/java/com/steeplesoft/turbovision/internal

rm -rf src/generated/java
mkdir -p $OUTDIR

SWIG="false"
MAVEN="false"

while getopts sdm opt
do
    case "$opt" in
        s) SWIG="true" ;;
        d) DEBUG="-debug-classes" ;;
        m) MAVEN="true" ;;
    esac
done

if [ "$SWIG" == "true" ] ; then
    swig -v $DEBUG -Wall -fvirtual\
        -c++ \
        -java \
        -outdir $OUTDIR  \
        -package com.steeplesoft.turbovision.internal \
        -I../library/include -I$JAVA_HOME/include \
        -I$JAVA_HOME/include/linux \
        tvision.i
    g++ -DUses_TApplication -c -fPIC $JAVA_INCLUDE -I../library/include -I/include/boost-0  \
            -L../library/makes -lrhtv tvision_wrap.cxx  \
            -I"/opt/jdk-1.8/include" -I"/opt/jdk-1.8/include/linux" && \
        g++ -shared   tvision_wrap.o    -o libtvision.so -L../library/makes -lrhtv
fi

if [ "$MAVEN" == "true" ] ; then
    mvn clean install
fi