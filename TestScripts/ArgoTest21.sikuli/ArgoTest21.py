myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *
    
n = "asssd"
setPauseDelay(0.1,0.1)
#newDiagram()
initializeActivityDiagram()

addState(Pattern("1532696383916.png").similar(0.68).targetOffset(-478,-205),"1532696428133.png","a")
addSwimlane(Pattern("1532696638931.png").targetOffset(-198,-184),"1532696669780.png")
addState(Pattern("1532696704881.png").targetOffset(-69,-25),"1532696728088.png","b")
addNewJunction(Pattern("1532696796028.png").targetOffset(-30,-41))
addConnection("1532696842768.png","1532696851581.png","1532696856565.png","1532696948573.png")
addSwimlane("1532696990691.png","1532697007324.png")
nameSwimlane(Pattern("1532697044879.png").targetOffset(-5,-119),Pattern("1532697044879.png").targetOffset(-11,-131),"c")
addNewFork(Pattern("1532697136053.png").targetOffset(17,-91))
addNewJoint("1532697178503.png")
addConnection("1532697205173.png","1532697213768.png","1532697221340.png","1532697242562.png")
addConnection("1532697267282.png","1532697280750.png","1532697287803.png","1532697309439.png")
increaseSwimlaneHeigth(Pattern("1532697340964.png").targetOffset(155,142),100)
addNewEndingPoint("1532697400306.png")
addNewEndingPoint("1532697434316.png")
addSwimlane("1532697477455.png","1532697493546.png")
addState("1532697538858.png","1532697574030.png","ads")
addConnection("1532697661355.png","1532697671969.png","1532697677847.png","1532697734637.png")
addCallState("1532697771054.png","s","1532697869516.png")
addConnection("1532697905336.png","1532697925438.png","1532697937554.png","1532697968459.png")
modifyElementWidth(Pattern("1532698114644.png").targetOffset(230,196),200)
newDiagram()
initializeActivityDiagram()

addState(Pattern("1532696383916.png").similar(0.68).targetOffset(-478,-205),"1532696428133.png","a")
addSwimlane(Pattern("1532696638931.png").targetOffset(-198,-184),"1532696669780.png")
addState(Pattern("1532696704881.png").targetOffset(-69,-25),"1532696728088.png","b")
addNewJunction(Pattern("1532696796028.png").targetOffset(-30,-41))
addConnection("1532696842768.png","1532696851581.png","1532696856565.png","1532696948573.png")
addSwimlane("1532696990691.png","1532697007324.png")
nameSwimlane(Pattern("1532697044879.png").targetOffset(-5,-119),Pattern("1532697044879.png").targetOffset(-11,-131),"c")
addNewFork(Pattern("1532697136053.png").targetOffset(17,-91))
addNewJoint("1532697178503.png")
addConnection("1532697205173.png","1532697213768.png","1532697221340.png","1532697242562.png")
addConnection("1532697267282.png","1532697280750.png","1532697287803.png","1532697309439.png")
increaseSwimlaneHeigth(Pattern("1532697340964.png").targetOffset(155,142),100)
addNewEndingPoint("1532697400306.png")
addNewEndingPoint("1532697434316.png")
addSwimlane("1532697477455.png","1532697493546.png")
addState("1532697538858.png","1532697574030.png","ads")
addConnection("1532697661355.png","1532697671969.png","1532697677847.png","1532697734637.png")
addCallState("1532697771054.png","s","1532697869516.png")
addConnection("1532697905336.png","1532697925438.png","1532697937554.png","1532697968459.png")
modifyElementWidth(Pattern("1532698114644.png").targetOffset(230,196),200)



closeArgo()