myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *
    
n = "asssd"

setPauseDelay(0.1,0.1)

#newDiagram()
initializeActivityDiagram()

addSwimlane(Pattern("1530953862848.png").targetOffset(-462,-207),"1530953947595.png")
addSwimlane(Pattern("1530953962362.png").targetOffset(12,-131),"1530953993026.png")
addSwimlane(Pattern("1530953993026.png").targetOffset(-95,-95),"1530954081755.png")
addSwimlane(Pattern("1530954081755.png").targetOffset(39,-134),"1530954124177.png")
addSwimlane(Pattern("1530954124177.png").targetOffset(205,-111),"1530954162368.png")
increaseSwimlaneHeigth(Pattern("1530954162368.png").targetOffset(389,140),100)
addNewStartingPoint(Pattern("1530955088172.png").targetOffset(-360,-144))
addState(Pattern("1530955142434.png").targetOffset(-80,-21),"1530955190059.png","a")
addNewFork(Pattern("1530955247126.png").targetOffset(90,-2))
makeForkVertical(Pattern("1530955287176.png").targetOffset(64,-4),90)
addFlowState("1530955409073.png","b","1530955435786.png")
addCallState("1530955482975.png","c","1530955537503.png")
addConnection("1530955553772.png","1530955560993.png","1530955565900.png","1530955591034.png")
addConnection("1530955601699.png","1530955608446.png","1530955613273.png","1530955665632.png")
addConnection(Pattern("1530955678659.png").targetOffset(-4,19),Pattern("1530955685837.png").targetOffset(-6,1),"1530955690089.png","1530955749908.png")
addConnection("1530955765835.png","1530955772261.png","1530955777390.png","1530955800426.png")
addState(Pattern("1530955833686.png").targetOffset(-54,2),"1530955880250.png","d")
editConnectionName(Pattern("1530955911563.png").targetOffset(-2,-11),"1530955927038.png","e","1530955951519.png")
addConnection("1530956174610.png","1530956180830.png","1530956186571.png","1530956208774.png")
addNewEndingPoint("1530956268255.png")
addConnection("1530956324314.png","1530956331638.png","1530956336689.png","1530956398475.png")

newDiagram()
initializeActivityDiagram()

addSwimlane(Pattern("1530953862848.png").targetOffset(-462,-207),"1530953947595.png")
addSwimlane(Pattern("1530953962362.png").targetOffset(12,-131),"1530953993026.png")
addSwimlane(Pattern("1530953993026.png").targetOffset(-95,-95),"1530954081755.png")
addSwimlane(Pattern("1530954081755.png").targetOffset(39,-134),"1530954124177.png")
addSwimlane(Pattern("1530954124177.png").targetOffset(205,-111),"1530954162368.png")
increaseSwimlaneHeigth(Pattern("1530954162368.png").targetOffset(389,140),100)
addNewStartingPoint(Pattern("1530955088172.png").targetOffset(-360,-144))
addState(Pattern("1530955142434.png").targetOffset(-80,-21),"1530955190059.png","a")
addNewFork(Pattern("1530955247126.png").targetOffset(90,-2))
makeForkVertical(Pattern("1530955287176.png").targetOffset(64,-4),90)
addFlowState("1530955409073.png","b","1530955435786.png")
addCallState("1530955482975.png","c","1530955537503.png")
addConnection("1530955553772.png","1530955560993.png","1530955565900.png","1530955591034.png")
addConnection("1530955601699.png","1530955608446.png","1530955613273.png","1530955665632.png")
addConnection(Pattern("1530955678659.png").targetOffset(-4,19),Pattern("1530955685837.png").targetOffset(-6,1),"1530955690089.png","1530955749908.png")
addConnection("1530955765835.png","1530955772261.png","1530955777390.png","1530955800426.png")
addState(Pattern("1530955833686.png").targetOffset(-54,2),"1530955880250.png","d")
editConnectionName(Pattern("1530955911563.png").targetOffset(-2,-11),"1530955927038.png","e","1530955951519.png")
addConnection("1530956174610.png","1530956180830.png","1530956186571.png","1530956208774.png")
addNewEndingPoint("1530956268255.png")
addConnection("1530956324314.png","1530956331638.png","1530956336689.png","1530956398475.png")


closeArgo()