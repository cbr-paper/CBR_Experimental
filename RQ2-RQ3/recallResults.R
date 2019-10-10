recall = read.csv("eclipseProject/recall.csv", dec = ".", sep = ";", header = F)
recall_sampling = read.csv("eclipseProject/recall_sampling.csv", dec = ".", sep = ";", header = F)

#add header
colnames(recall) <- c('probability', 'RB', 'RE')
recall[is.na(recall)] <- 0

colnames(recall_sampling) <- c('technique', 'recall')
recall_sampling[is.na(recall_sampling)] <- 0

aggregated_cbr <- aggregate(. ~ probability, recall, mean)
aggregated_sampling <- aggregate(. ~ technique, recall_sampling, mean)