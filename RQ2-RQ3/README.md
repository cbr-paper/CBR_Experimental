##Instructions for precision and recall replication

Import eclipseProject as a Maven to Project in Eclipse

#RQ2 - Precision results

1. modify in config.properties (src/main/resources) the number of iterations to run the algorithm, default is 1, in the paper we used 1;5;10;15;20 runs.
2. launch the main class PrecisionRQ2 and the results will be obtained in the file precision.csv

#RQ3 - Recall results

1. modify in config.properties (src/main/resources) the number of iterations to run the algorithm, default is 1, in the paper we used 1;5;10;15;20 runs.
2. launch the main class RecallCBRRQ3 and the results will be obtained in the file recall.csv for CBR
3. launch the main class RecallSamplingRQ3 and the results will be obtained in the file recall_sampling.csv for sampling techniques
4. run recallResults.R to process the results

