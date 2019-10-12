myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *

txt = "asssd"

setPauseDelay(0.1,0.1)

#newDiagram()

initializeActivityDiagram()
addStartingPoint(Pattern("1530457685895.png").targetOffset(-435,-173),"1530457733165.png")
addCallState(Pattern("1530457952973.png").targetOffset(-98,-75),"Fill order","1530458399661.png")
addConnection("1530458444352.png","1530458455439.png","1530458460214.png","1530458511993.png")
addFork(Pattern("1530458577642.png").targetOffset(-18,-80),"1530458672406.png")
makeForkVertical(Pattern("1530458920439.png").targetOffset(38,4),100)
addConnection("1530459165895.png","1530459175043.png","1530459181276.png","1530459243506.png")
addState(Pattern("1530459390580.png").targetOffset(100,-56),"1530459502434.png","Send invoice")
addFlowState(Pattern("1530459534094.png").targetOffset(66,-2),"Invoice","1530459611938.png")
addConnection("1530459629600.png","1530459639767.png",Pattern("1530459648784.png").targetOffset(8,-58),"1530459744675.png")
addConnection("1530459843504.png","1530459791959.png","1530459797034.png","1530459900717.png")
addJunction(Pattern("1530459980953.png").targetOffset(68,-23),"1530460038281.png")
addEndingPoint(Pattern("1530460078523.png").targetOffset(115,-38),"1530460122077.png")
addConnection("1530460150624.png","1530460162418.png","1530460171301.png","1530460209229.png")
addConnection("1530460229771.png","1530460238533.png","1530460243435.png","1530460282595.png")
addConnection("1530460331075.png","1530460339306.png","1530460344257.png","1530460363340.png")
addComment(Pattern("1530460514267.png").targetOffset(-190,-50),"1530460544507.png","A nice comment")

newDiagram()

initializeActivityDiagram()
addStartingPoint(Pattern("1530457685895.png").targetOffset(-435,-173),"1530457733165.png")
addCallState(Pattern("1530457952973.png").targetOffset(-98,-75),"Fill order","1530458399661.png")
addConnection("1530458444352.png","1530458455439.png","1530458460214.png","1530458511993.png")
addFork(Pattern("1530458577642.png").targetOffset(-18,-80),"1530458672406.png")
makeForkVertical(Pattern("1530458920439.png").targetOffset(38,4),100)
addConnection("1530459165895.png","1530459175043.png","1530459181276.png","1530459243506.png")
addState(Pattern("1530459390580.png").targetOffset(100,-56),"1530459502434.png","Send invoice")
addFlowState(Pattern("1530459534094.png").targetOffset(66,-2),"Invoice","1530459611938.png")
addConnection("1530459629600.png","1530459639767.png",Pattern("1530459648784.png").targetOffset(8,-58),"1530459744675.png")
addConnection("1530459843504.png","1530459791959.png","1530459797034.png","1530459900717.png")
addJunction(Pattern("1530459980953.png").targetOffset(68,-23),"1530460038281.png")
addEndingPoint(Pattern("1530460078523.png").targetOffset(115,-38),"1530460122077.png")
addConnection("1530460150624.png","1530460162418.png","1530460171301.png","1530460209229.png")
addConnection("1530460229771.png","1530460238533.png","1530460243435.png","1530460282595.png")
addConnection("1530460331075.png","1530460339306.png","1530460344257.png","1530460363340.png")
addComment(Pattern("1530460514267.png").targetOffset(-190,-50),"1530460544507.png","A nice comment")

closeArgo()

