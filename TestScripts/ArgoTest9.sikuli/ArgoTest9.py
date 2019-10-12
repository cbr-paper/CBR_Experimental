myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *

t = "asssd"

setPauseDelay(0.1,0.1)
#newDiagram()

initializeActivityDiagram()
addSwimlane(Pattern("1530638311835.png").targetOffset(-455,-190),"1530638371908.png")
addSwimlane(Pattern("1530638444124.png").targetOffset(-16,-124),"1530638475803.png")
nameSwimlane(Pattern("1530638475803.png").targetOffset(-72,-119),Pattern("1530638475803.png").targetOffset(-88,-135),"Cuarteles")
nameSwimlane(Pattern("1530638864426.png").targetOffset(72,-126),Pattern("1530638864426.png").targetOffset(72,-136),"Invierno")
addNewStartingPoint(Pattern("1530638938351.png").targetOffset(-145,-100))
addState(Pattern("1530639043889.png").targetOffset(17,-101),"1530639091026.png","Copenhagen")
addConnection(Pattern("1530639148201.png").targetOffset(-45,-1),"1530639154499.png","1530639159675.png","1530639297015.png")
editConnectionName(Pattern("1530639323443.png").targetOffset(-40,2),"1530639342714.png","cow","1530639366700.png")
increaseSwimlaneHeigth(Pattern("1530639411802.png").targetOffset(153,143),100)
addNewJunction(Pattern("1530639464790.png").targetOffset(39,-33))
addConnection("1530639512399.png","1530639523122.png","1530639552923.png","1530639582484.png")
editConnectionName(Pattern("1530639649742.png").targetOffset(-16,20),Pattern("1530639649742.png").targetOffset(1,1),"chicken","1530639693053.png")
addNewFork(Pattern("1530639728211.png").targetOffset(-137,15))
addConnection("1530639761973.png","1530639768611.png","1530639774988.png","1530639803666.png")
addNewEndingPoint(Pattern("1530639839036.png").targetOffset(-124,20))
addNewEndingPoint(Pattern("1530639872651.png").targetOffset(50,5))
addConnection("1530639900810.png","1530639909034.png",Pattern("1530639920396.png").targetOffset(83,41),"1530639961820.png")
increaseSwimlaneWidth(Pattern("1530640007653.png").targetOffset(154,137),100)
addConnection("1530640280446.png","1530640290976.png",Pattern("1530640296702.png").targetOffset(-94,78),"1530640324927.png")
editConnectionName(Pattern("1530640389426.png").targetOffset(-15,-41),Pattern("1530640389426.png").targetOffset(2,-5),"snow","1530640431566.png")

newDiagram()

initializeActivityDiagram()
addSwimlane(Pattern("1530638311835.png").targetOffset(-455,-190),"1530638371908.png")
addSwimlane(Pattern("1530638444124.png").targetOffset(-16,-124),"1530638475803.png")
nameSwimlane(Pattern("1530638475803.png").targetOffset(-72,-119),Pattern("1530638475803.png").targetOffset(-88,-135),"Cuarteles")
nameSwimlane(Pattern("1530638864426.png").targetOffset(72,-126),Pattern("1530638864426.png").targetOffset(72,-136),"Invierno")
addNewStartingPoint(Pattern("1530638938351.png").targetOffset(-145,-100))
addState(Pattern("1530639043889.png").targetOffset(17,-101),"1530639091026.png","Copenhagen")
addConnection(Pattern("1530639148201.png").targetOffset(-45,-1),"1530639154499.png","1530639159675.png","1530639297015.png")
editConnectionName(Pattern("1530639323443.png").targetOffset(-40,2),"1530639342714.png","cow","1530639366700.png")
increaseSwimlaneHeigth(Pattern("1530639411802.png").targetOffset(153,143),100)
addNewJunction(Pattern("1530639464790.png").targetOffset(39,-33))
addConnection("1530639512399.png","1530639523122.png","1530639552923.png","1530639582484.png")
editConnectionName(Pattern("1530639649742.png").targetOffset(-16,20),Pattern("1530639649742.png").targetOffset(1,1),"chicken","1530639693053.png")
addNewFork(Pattern("1530639728211.png").targetOffset(-137,15))
addConnection("1530639761973.png","1530639768611.png","1530639774988.png","1530639803666.png")
addNewEndingPoint(Pattern("1530639839036.png").targetOffset(-124,20))
addNewEndingPoint(Pattern("1530639872651.png").targetOffset(50,5))
addConnection("1530639900810.png","1530639909034.png",Pattern("1530639920396.png").targetOffset(83,41),"1530639961820.png")
increaseSwimlaneWidth(Pattern("1530640007653.png").targetOffset(154,137),100)
addConnection("1530640280446.png","1530640290976.png",Pattern("1530640296702.png").targetOffset(-94,78),"1530640324927.png")
editConnectionName(Pattern("1530640389426.png").targetOffset(-15,-41),Pattern("1530640389426.png").targetOffset(2,-5),"snow","1530640431566.png")

closeArgo()