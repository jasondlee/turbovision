#!/bin/bash

JAVA_INCLUDE=-"I$JAVA_HOME/include -I$JAVA_HOME/include/linux"
OUTDIR=src/generated/java/com/steeplesoft/turbovision/internal


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
    rm -rf src/generated/java
    mkdir -p $OUTDIR
    
    # -Wall
    swig -v $DEBUG -v -fvirtual\
        -small\
        -c++ \
        -java \
        -outdir $OUTDIR  \
        -package com.steeplesoft.turbovision.internal \
        -I../library/include -I$JAVA_HOME/include \
        -I$JAVA_HOME/include/linux \
        tvision.i
    if [ $? != 0 ] ; then
        echo "SWIG failed"
        exit -1
    fi
    g++ -DUses_TApplication -DUses_TWindow -c -fPIC $JAVA_INCLUDE -I../library/include -I/include/boost-0  \
            -L../library/makes -lrhtv tvision_wrap.cxx  && \
    g++ -shared   tvision_wrap.o    -o libtvision.so -L../library/makes -lrhtv
    if [ $? != 0 ] ; then
        echo "gcc failed"
        exit -1
    fi
fi

if [ "$MAVEN" == "true" ] ; then
    mvn clean install
fi
