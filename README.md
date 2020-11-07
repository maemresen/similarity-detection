# Similarity Detection - Data Mining Project

Similarity analysis methods may be used to detect cheating in exams. Attached is data set for
answers of a question. Among a number of exam takers, there are a few students who cheat.
Using at least 2 similarity analysis techniques identify students that cheat. Please turn in your
code and a 1 page report of your findings. In your report please include; brief explanation of
the algorithms, detected student ids, match rates and comparison of algorithms with respect to
execution time and match performance for various cases.

## Usage
After you obtain the jar the usage is as follows:
````bash
Usage: java -jar similarity.jar [-d] [-t <cheat_threshold>]

    -d  Detailed printout. To print each distance found
    
    -t  Cheat Threashold. If two answers has distince lower than threashold than it is a cheat.
        Default Value: 0.4

````

