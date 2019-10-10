library(matrixStats)
library(psych)
hard_to_measure_start = 0
hard_to_measure_end = 2000000
instantaneous_start = 2000000
instantaneous_end = 200000000
immediate_start = 200000000
immediate_end = 1000000000
continuous_start = 1000000000
continuous_end = 5000000000
captive_start = 5000000000

getActionsPositionsByType <-
  function(srt_no_mon_01,
           srt_no_mon_02,
           srt_no_mon_03) {
    srtMean = rowMeans(cbind(
      srt_no_mon_01,
      srt_no_mon_02,
      srt_no_mon_03
    ))
    
    hard_to_measure_indexes = which(srtMean > hard_to_measure_start &
                                      srtMean <= hard_to_measure_end)
    instantaneous_indexes = which(srtMean > instantaneous_start &
                                    srtMean <= instantaneous_end)
    immediate_indexes = which(srtMean > immediate_start &
                                srtMean <= immediate_end)
    continuous_indexes = which(srtMean > continuous_start &
                                 srtMean <= continuous_end)
    captive_indexes = which(srtMean > captive_start)
    
    
    
    return(data.frame(
      action_type = c(
        "hard to measure",
        "instantaneous",
        "immediate",
        "continuous",
        "captive"
      ),
      positions = I(
        list(
          hard_to_measure_indexes,
          instantaneous_indexes,
          immediate_indexes,
          continuous_indexes,
          captive_indexes
        )
      )
    ))
  }

getAverageSrtOfExecutions <-
  function(execution_01,
           execution_02,
           execution_03) {

  bindExecutions <- cbind(
      execution_01,
      execution_02,
      execution_03
    )
    # print(bindExecutions)
    srtMean = rowMeans(bindExecutions,na.rm = TRUE)
     #srtMean = rowMedians(bindExecutions,na.rm = TRUE)
     #srtMean = apply(X = cbind(execution_01, execution_02, execution_03), MARGIN = 1,
               #      function(x) geometric.mean(x, na.rm = TRUE))
     
     
     
    return(srtMean)
  }

compareSrt <- function(dataset1, dataset2, positionOfActionType) {
  overheadValues = c(length(positionOfActionType))
  
  for (i in 1:length(positionOfActionType)) {
    overheadValues[i] = round(((dataset2[positionOfActionType[i]] - dataset1[positionOfActionType[i]]) /
                                 dataset1[positionOfActionType[i]]) * 100, 2)
  }
  
  return(overheadValues)
}

overhead <- function(value1, value2){
  return(round(((value2-value1)/value1) *100,2))
}

sampleCBR <- function(x, y, p) {
  random <- runif(1, min = 0, max = 1)
  
  if (random < p) {
    x <- y
  } else{
    x <- x
  }
}

returnSRTTimes <- function(dataset, indexesActionsByType, actionType) {
  positionOfActionType = unlist(indexesActionsByType$positions[indexesActionsByType$action_type == actionType])
  
  overheadValues = c(length(positionOfActionType))
  
  for (i in 1:length(positionOfActionType)) {
    overheadValues[i] = dataset[positionOfActionType[i]]
  }
  return(overheadValues)
}
