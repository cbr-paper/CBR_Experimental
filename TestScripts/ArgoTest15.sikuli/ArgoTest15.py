myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *
    
n = "asssd"

setPauseDelay(0.1,0.1)
#newDiagram()
initializeActivityDiagram()

addSwimlane(Pattern("1530879298464.png").targetOffset(-459,-198),"1530879340307.png")
addSwimlane("1530879366147.png","1530879456795.png")
addSwimlane("1530879469913.png","1530879490006.png")
addNewStartingPoint(Pattern("1530879508422.png").targetOffset(-232,-111))
addState("1530879640060.png","1530879662054.png","a")
addConnection("1530879676499.png","1530879692497.png","1530879697718.png","1530879716893.png")
addNewFork("1530879804875.png")
addConnection("1530879826924.png","1530879835666.png","1530879840358.png","1530879862250.png")
addState("1530879877449.png","1530879905811.png","a")
addConnection("1530879919706.png","1530879940900.png","1530879950958.png","1530879976979.png")
addState(Pattern("1530880383364.png").targetOffset(-65,-32),"1530880537698.png","b")
addConnection("1530880586043.png","1530880600367.png","1530880605872.png","1530880625626.png")
addNewJoint("1530880839304.png")
addConnection("1530881020062.png","1530881030266.png","1530881037455.png","1530881057957.png")
addState("1530881223871.png","1530881262476.png","a")
addConnection("1530881304262.png","1530881313257.png","1530881318958.png","1530881377920.png")
addConnection("1530881402891.png","1530881411115.png","1530881415805.png","1530881446376.png")
addState(Pattern("1530881585995.png").targetOffset(-20,-4),"1530881717536.png","n")
addConnection("1530881844103.png","1530881994382.png","1530881999291.png","1530882016721.png")
addNewEndingPoint("1530882037207.png")
addConnection("1530882068925.png","1530882077188.png","1530882081274.png","1530882112568.png")
newDiagram()
initializeActivityDiagram()

addSwimlane(Pattern("1530879298464.png").targetOffset(-459,-198),"1530879340307.png")
addSwimlane("1530879366147.png","1530879456795.png")
addSwimlane("1530879469913.png","1530879490006.png")
addNewStartingPoint(Pattern("1530879508422.png").targetOffset(-232,-111))
addState("1530879640060.png","1530879662054.png","a")
addConnection("1530879676499.png","1530879692497.png","1530879697718.png","1530879716893.png")
addNewFork("1530879804875.png")
addConnection("1530879826924.png","1530879835666.png","1530879840358.png","1530879862250.png")
addState("1530879877449.png","1530879905811.png","a")
addConnection("1530879919706.png","1530879940900.png","1530879950958.png","1530879976979.png")
addState(Pattern("1530880383364.png").targetOffset(-65,-32),"1530880537698.png","b")
addConnection("1530880586043.png","1530880600367.png","1530880605872.png","1530880625626.png")
addNewJoint("1530880839304.png")
addConnection("1530881020062.png","1530881030266.png","1530881037455.png","1530881057957.png")
addState("1530881223871.png","1530881262476.png","a")
addConnection("1530881304262.png","1530881313257.png","1530881318958.png","1530881377920.png")
addConnection("1530881402891.png","1530881411115.png","1530881415805.png","1530881446376.png")
addState(Pattern("1530881585995.png").targetOffset(-20,-4),"1530881717536.png","n")
addConnection("1530881844103.png","1530881994382.png","1530881999291.png","1530882016721.png")
addNewEndingPoint("1530882037207.png")
addConnection("1530882068925.png","1530882077188.png","1530882081274.png","1530882112568.png")

closeArgo()