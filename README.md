# Similarity Detection - Data Mining Project

Similarity analysis methods may be used to detect cheating in exams. Attached is data set for
answers of a question. Among a number of exam takers, there are a few students who cheat.
Using at least 2 similarity analysis techniques identify students that cheat.

## Usage
After you obtain the jar the usage is as follows:
````bash
Usage: java -jar similarity.jar [-d] [-t <cheat_threshold>]

    -d  Detailed printout. To print each distance found
    
    -t  Cheat Threashold. If two answers has distince lower than threashold than it is a cheat.
        Default Value: 0.4

````

