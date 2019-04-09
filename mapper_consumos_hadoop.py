#!/usr/bin/python

import sys
fxMap = []

# input comes from STDIN (standard input)
for line in sys.stdin:
    line = line.strip()
    line = line.split(";")
    if line[2]=="Potencia":
                 fxMap.append(tuple([line[0], int(line[4])]))

        
# Show the returned values
for i in sorted(fxMap):
    print ("%-20s - %d" % (i[0], i[1]))