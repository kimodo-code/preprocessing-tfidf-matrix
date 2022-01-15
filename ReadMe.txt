General notes:

Programme is written in Java and was created in Eclipse Version: 2018-09 (4.9.0) on a system running Windows 10.

Programme should be run in Windows.

Java files, class files and input/output files are in the one folder. The class files have been run successfully 
outside of Eclipse from command prompt.

The programme is compiled, the .class files have been included and only basic libraries were used 
so there should be no need for a JDK (although JRE is necessary). If, however, you want to change parts of the
code and re-run the programme then the java files would need to be re-compiled. In that case, here is the link
to a JDK: https://www.oracle.com/technetwork/java/javase/downloads/index.html

The input and output text files are in the same folder as the java files. All tasks are executed from a class
called "Driver" which contains the main method. This is in the folder along with the other files.

To use your own input files - put all your files in the folder as the code has been directed to search there
for files "./". For Task 2 and the output of Task 3 go to Driver class and type in the filename where it is
commented to do so. 

For Task 1, Task 4 and for the input of Task 3 you must go to the code in the task classes and enter the filename
on the line of code for file input and output. Exact details of where to go will be included under the individual
task headings in this ReadMe file.

A general assumption was made that the document titles would be specifically D1, D2, D3 and so on, and not anything
equivalent such as Document1, Document2, Document3 etc. This is very important for the operation of Task1 and Task2
as the splitting of the input text file relies on the document title having this format.

There is output to the console as well as to the output files. The print statements replicate to the console what 
should be the output to the output file. Several other print statements throughout
have been left commented out - if you wish to use them, remove the comment slashes. 

Task 1

If you want to change the input file name, it appears in one place, several lines down from the beginning of Task1
in the creation of the file object. To change the output file name, go to the very end of the code, to the line
just under the declaration of the outputFile method.

Issues with Task1 - Although the lines of document text output ok and in their correct order, they no longer
have their document identifier with them.


Task 2

Further details can be found in code comments but major bugs seem to have been avoided. A HashMap was used to create the inverted index.
Change the input/output filename in the Driver class.


Task 3

Input/output file is altered from Driver but input argument has been removed. An input object exists
in the code for Task3 - it's called output1 and it appears in two places just under the declaration
of the first method called goTask3 and half way down in that method.

Explanation of logic behind code:

The input given for Task 3 (as contained in the additional notes on the assignment) 

	D1	D2	D3
term1	1	1	2
term2	1	2	1
term3	2	4	1

was abandoned in favour of using the output from Task 1 - cleaned up documents on single lines without their document identifier.)

 document singl line document titl separ tab character
 space confus rest whitespac document tab easier
 carriag return languag line entity
 languag insist block text delin carriag return statement

This is why output_1 is used as the input file for Task 3. The reason for this is that although the matrix style input_s3
removes the need to calculate term occurences again, using the matrix style input would mean creating a double array [] []
with a mixture of type int and String which can't be done in java without first turning everything into objects, which would
be very difficult to deal with and also to print. If a double array was created with just int types then the information regarding which index position
belonged to which document title and term would be lost. If a double array of type String was created, then no calculations could be
performed.


The general outline taken for Task 3 was putting all the file input and output code in the class named Task3, and putting all the code
for calculating the TF IDF equations in a class named TF IDF Calc. Like the other tasks, Task 3 is run
under the main method in the class Driver.

There are problems with Task 3. Before discussing these, it should be noted what does work.

The file input code appears to be working correctly as there is a print to console statement in the file input code which outputs ok.
The file output code also appears to work correctly as there is dumb text which writes ok to the output_s3 file.

The plan was to take in the output from task 1 twice:

 document singl line document titl separ tab character
 space confus rest whitespac document tab easier
 carriag return languag line entity
 languag insist block text delin carriag return statement

The first time, to split on whitespace and store as a string called term.
The second time, to split off the documents every new line and store them in an array list called documents. 

Then the idea was to PASS THESE VARIABLES from the Task3 class to the calculation class and while there use a loop to go through the document array with
each term, count the occurrences, store them, get the TFIDF as per the equations, and then call everything from the printFile method back
in the Task3 class. 

The problem with this is that the scope of the variables was limited to the method they were in (readFile()) in Task3. 
Various approaches to solve this problem failed. 

Another issue is that the output would not have been in the form of a matrix, rather it would have been a single figure
produced from a method with the term, document and the overall size of the dataset as arguments. A possible solution would have been to use loops to iterate
through each term and to fill a double array.

Task 4

There is no specific method with input and output file as arguments. So to change the file name for the file input - input needs to be changed
in two places - in the getArrayA method and the getArrayB method in Task4. The methods are the first and second methods in 
Task4 and the file input line is the fifth line of code in each. The file output name is in the final method - 
printAnswer - which is a small method at the bottom of Task4.

The two methods - getArrayA and getArrayB retrieve the columns associated with D1 and D2 in the table and
the result is passed to the cosine similarity calculation method via the Driver class.

The search query is all terms entered. So, for example, if there are three words in the text input file, then the cosine similarity value
will be found for those three terms in document 1 and document 2. The result is not rounded. 

Task 5

Task 5 was not attempted. There are no task 5 files.

