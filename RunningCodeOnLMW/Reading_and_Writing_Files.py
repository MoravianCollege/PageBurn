# -*- coding: utf-8 -*-
"""
Created on Sun Feb  7 19:39:46 2016

@author: Nick
"""

def main():
    #Make sure you start the file path with /
    f = open("/docgraph/tutorial.txt",'r')
    print(f.read())
    f.close()
    write_to('testing.txt')

def write_to(filename):
    # the w+ indcates 	Opens a file for both writing and reading. 
    #Overwrites the existing file if the file exists. If the file does not exist,
    #creates a new file for reading and writing.
    f = open("/fhir/"+filename, 'w+')
    f.write("It\'s just a flesh wound!")
    f.close()
if __name__ == '__main__':
    main()