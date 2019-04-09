#!/usr/bin/python

# The reducer

from operator import itemgetter
import sys

import collections

current_key = None
current_count = 0
key = None
keysList=list()

# Import the mapped FX data data
for line in sys.stdin:

    # parse the input we got from mapper.py
    key, count = line.split('- ', 1)
    key = key.strip()
    keysList.append(key)
    try:
        count = int(count)
    except ValueError:
        continue

    if current_key == key:
        current_count += count
    else:
        if current_key:
            counterKeyList= collections.Counter(keysList)
            print ('%s\t%s\t%s' % (current_key,current_count, current_count/counterKeyList[current_key]))            
        current_count = count
        current_key = key



counterKeyList= collections.Counter(keysList)
# do not forget to output the last word if needed!
if current_key == key:
    print ('%s\t%s\t%s' % (current_key, current_count, current_count/counterKeyList[current_key]))
    
    
    
#cojo todas las keys
#me quedo con las distintas y las meto en una lista
#con esas voy iterando por el csv y cogiendo las filas con esa key potencia y sumando
