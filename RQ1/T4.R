options(scipen = 999)

########### SRT associated to the actions recorded during the executions "NO MONITORING" ###########

srt_no_mon_T4_01 = read.csv("data/srt/nomonitor/Test4/01/system_response_time.csv", dec = ".", sep = "#", header = T)
srt_no_mon_T4_02 = read.csv("data/srt/nomonitor/Test4/02/system_response_time.csv", dec = ".", sep = "#", header = T)
srt_no_mon_T4_03 = read.csv("data/srt/nomonitor/Test4/03/system_response_time.csv", dec = ".", sep = "#", header = T)

########## CBR MONITOR

srt_cbr_mon_T4_01 = read.csv("data/srt/cbrmonitor/Test4/01/system_response_time.csv", dec = ".", sep = "#", header = T)
srt_cbr_mon_T4_02 = read.csv("data/srt/cbrmonitor/Test4/02/system_response_time.csv", dec = ".", sep = "#", header = T)
srt_cbr_mon_T4_03 = read.csv("data/srt/cbrmonitor/Test4/03/system_response_time.csv", dec = ".", sep = "#", header = T)

srt_cbr1_mon_T4_01 = cbind(srt_cbr_mon_T4_01)
srt_cbr1_mon_T4_02 = cbind(srt_cbr_mon_T4_02)
srt_cbr1_mon_T4_03 = cbind(srt_cbr_mon_T4_03)

srt_cbr1_mon_T4_01[, "srt"] <- mapply(sampleCBR, x = srt_no_mon_T4_01[,"srt"], y = srt_cbr1_mon_T4_01[,"srt"], p=cbr1Probability)
srt_cbr1_mon_T4_02[, "srt"] <- mapply(sampleCBR, x = srt_no_mon_T4_02[,"srt"], y = srt_cbr1_mon_T4_02[,"srt"], p=cbr1Probability)
srt_cbr1_mon_T4_03[, "srt"] <- mapply(sampleCBR, x = srt_no_mon_T4_03[,"srt"], y = srt_cbr1_mon_T4_03[,"srt"], p=cbr1Probability)

###### SAMPLER

srt_sampler1_mon_T4_01 = read.csv("data/srt/sampler1monitor/Test4/01/system_response_time.csv", dec = ".", sep = "#", header = T)
srt_sampler1_mon_T4_02 = read.csv("data/srt/sampler1monitor/Test4/02/system_response_time.csv", dec = ".", sep = "#", header = T)
srt_sampler1_mon_T4_03 = read.csv("data/srt/sampler1monitor/Test4/03/system_response_time.csv", dec = ".", sep = "#", header = T)

##### SAMPLER 2

srt_sampler2_mon_T4_01 = read.csv("data/srt/sampler2monitor/Test4/01/system_response_time.csv", dec = ".", sep = "#", header = T)
srt_sampler2_mon_T4_02 = read.csv("data/srt/sampler2monitor/Test4/02/system_response_time.csv", dec = ".", sep = "#", header = T)
srt_sampler2_mon_T4_03 = read.csv("data/srt/sampler2monitor/Test4/03/system_response_time.csv", dec = ".", sep = "#", header = T)

indexesActionsByType_T4 = getActionsPositionsByType(srt_no_mon_T4_01$srt, srt_no_mon_T4_02$srt, srt_no_mon_T4_03$srt)

srtNoMonAverage_T4 = getAverageSrtOfExecutions(srt_no_mon_T4_01$srt, srt_no_mon_T4_02$srt, srt_no_mon_T4_03$srt)

srtCBR1Average_T4 = getAverageSrtOfExecutions(srt_cbr1_mon_T4_01$srt, srt_cbr1_mon_T4_02$srt, srt_cbr1_mon_T4_03$srt)

srtSampler1Average_T4 = getAverageSrtOfExecutions(srt_sampler1_mon_T4_01$srt,srt_sampler1_mon_T4_02$srt,srt_sampler1_mon_T4_03$srt)
srtSampler2Average_T4 = getAverageSrtOfExecutions(srt_sampler2_mon_T4_01$srt,srt_sampler2_mon_T4_02$srt,srt_sampler2_mon_T4_03$srt)

# Instantaneous actions SRT Comparison

instantaneousNoMonCBR1MonSrtComparison_T4 = 
  compareSrt(srtNoMonAverage_T4, srtCBR1Average_T4, 
             unlist(indexesActionsByType_T4$positions[indexesActionsByType_T4$action_type == "instantaneous"]))

cat("instantaneousNoMonCBR1MonSrtComparison_T4:", round(mean(instantaneousNoMonCBR1MonSrtComparison_T4),2),"\n")

instantaneousNoMonSampler1MonSrtComparison_T4 = 
  compareSrt(srtNoMonAverage_T4, srtSampler1Average_T4, 
             unlist(indexesActionsByType_T4$positions[indexesActionsByType_T4$action_type == "instantaneous"]))
cat("instantaneousNoMonSampler1MonSrtComparison_T4:", round(mean(instantaneousNoMonSampler1MonSrtComparison_T4),2),"\n")

instantaneousNoMonSampler2MonSrtComparison_T4 = 
  compareSrt(srtNoMonAverage_T4, srtSampler2Average_T4, 
             unlist(indexesActionsByType_T4$positions[indexesActionsByType_T4$action_type == "instantaneous"]))
cat("instantaneousNoMonSampler2MonSrtComparison_T4:", round(mean(instantaneousNoMonSampler2MonSrtComparison_T4),2),"\n")


# immediate actions SRT Comparison

immediateNoMonCBR1MonSrtComparison_T4 = 
  compareSrt(srtNoMonAverage_T4, srtCBR1Average_T4, 
             unlist(indexesActionsByType_T4$positions[indexesActionsByType_T4$action_type == "immediate"]))
cat("immediateNoMonCBR1MonSrtComparison_T4:", round(mean(immediateNoMonCBR1MonSrtComparison_T4),2),"\n")

immediateNoMonSampler1MonSrtComparison_T4 = 
  compareSrt(srtNoMonAverage_T4, srtSampler1Average_T4, 
             unlist(indexesActionsByType_T4$positions[indexesActionsByType_T4$action_type == "immediate"]))
cat("immediateNoMonSampler1MonSrtComparison_T4:", round(mean(immediateNoMonSampler1MonSrtComparison_T4),2),"\n")

immediateNoMonSampler2MonSrtComparison_T4 = 
  compareSrt(srtNoMonAverage_T4, srtSampler2Average_T4, 
             unlist(indexesActionsByType_T4$positions[indexesActionsByType_T4$action_type == "immediate"]))
cat("immediateNoMonSampler2MonSrtComparison_T4:", round(mean(immediateNoMonSampler2MonSrtComparison_T4),2),"\n")

# continuous actions SRT Comparison


continuousNoMonCBR1MonSrtComparison_T4 = 
  compareSrt(srtNoMonAverage_T4, srtCBR1Average_T4, 
             unlist(indexesActionsByType_T4$positions[indexesActionsByType_T4$action_type == "continuous"]))
cat("continuousNoMonCBR1MonSrtComparison_T4:", round(mean(continuousNoMonCBR1MonSrtComparison_T4),2),"\n")

continuousNoMonSampler1MonSrtComparison_T4 = 
  compareSrt(srtNoMonAverage_T4, srtSampler1Average_T4, 
             unlist(indexesActionsByType_T4$positions[indexesActionsByType_T4$action_type == "continuous"]))
cat("continuousNoMonSampler1MonSrtComparison_T4:", round(mean(continuousNoMonSampler1MonSrtComparison_T4),2),"\n")

continuousNoMonSampler2MonSrtComparison_T4 = 
  compareSrt(srtNoMonAverage_T4, srtSampler2Average_T4, 
             unlist(indexesActionsByType_T4$positions[indexesActionsByType_T4$action_type == "continuous"]))
cat("continuousNoMonSampler2MonSrtComparison_T4:", round(mean(continuousNoMonSampler2MonSrtComparison_T4),2),"\n")


