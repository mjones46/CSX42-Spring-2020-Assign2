# CSX42-Spring-2020-Assign2
## Name: Melissa Jones
-----------------------------------------------------------------------
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in numberPlay/src folder.
-----------------------------------------------------------------------
## Instruction to clean:
```commandline
ant -buildfile numberPlay/src/build.xml clean
```
Description: It cleans up all the .class files that were generated when you
compiled your code.
-----------------------------------------------------------------------
## Instruction to compile:
```commandline
ant -buildfile numberPlay/src/build.xml all
```
Description: Compiles your code and generates .class files inside the BUILD folder.
-----------------------------------------------------------------------
## Instruction to run:
#### Use the below command to run the program.
```commandline
ant run -buildfile numberPlay/src/build.xml \
-DinputNumStream="<input file path>" \
-DrunAvgWindowSize="<size of the window for running average calculations>" \
-DrunAvgOutFile="<output file path to which running averages are written>" \
-Dk="<max size of the list containing the top K numbers>" \
-DtopKNumOutFile="<path of output file to which the top K numbers are written>" \
-DnumPeaksOutFile="<path of output file to which the peaks in the number stream are written>"
```
-----------------------------------------------------------------------
## Description:
	This program takes a input file and extractes the integers or floats
	inside. These values are passed into at most three observers to calculate
	running average, top K, and peaks. When no more data is read from the
	file the output is generated in three files for each observer.
Using the following assumptions:
	1. If a number is inputted with a "." it is considered a float
	2. Only input with 0-9 and "." are valid no commas allowed
Sources:https://beginnersbook.com/2013/12/sort-arraylist-in-descending-order-in-java/
		https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
		https://www.geeksforgeeks.org/arraylist-of-arraylist-in-java/
		https://www.geeksforgeeks.org/enum-customized-value-java/
		https://www.geeksforgeeks.org/enum-in-java/
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------
"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [2/24/2020]
