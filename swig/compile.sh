#!/bin/bash

swig -c++ -java -I../library/include tvision.i
g++ -DUses_TApplication -c -fpic -I../library/include -I/include/boost-0  -L../library/makes -lrhtv tvision_wrap.cxx  -I"/opt/jdk-1.8/include" -I"/opt/jdk-1.8/include/linux"
g++ -shared  -I/include/boost-0   -L../library/makes -lrhtv tvision_wrap.o    -o libtvision.so

#g++ -Wall -Wno-sign-compare -Wpointer-arith \
#	-Wformat-security -Wswitch-enum \
#	-Wunused-parameter -Wstrict-aliasing -Wcast-align \
#	-Wmissing-field-initializers \
#	-I/opt/jdk-1.8/include -I/opt/jdk-1.8/include/linux \
#	-I../library/include \
#	-g -O2 -export-dynamic tvision_wrap.cxx \
#	-L../library/makes \
#	-lrhtv
