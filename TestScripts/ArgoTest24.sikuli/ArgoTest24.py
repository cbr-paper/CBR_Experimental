myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *
    
n = "asssd"

setPauseDelay(0.1,0.1)
#newDiagram()

initializeActivityDiagram()

addSwimlane(Pattern("1532936277921.png").targetOffset(-416,-203),"1532936329149.png")
addState(Pattern("1532936355857.png").targetOffset(-68,-1),"1532936382461.png","a")
addNewStartingPoint("1532936401843.png")
addConnection("1532936439607.png","1532936452769.png","1532936445168.png","1532936476438.png")
addSwimlane("1532936496534.png","1532936512493.png")
addNewJunction("1532936650815.png")
addConnection("1532936752352.png","1532936764546.png","1532936769923.png","1532936795834.png")
increaseSwimlaneWidth(Pattern("1532936828910.png").targetOffset(72,147),100)
increaseSwimlaneWidth(Pattern("1532936865698.png").targetOffset(18,137),100)
addNewJoint("1532936914602.png")
addConnection("1532936942727.png","1532936951097.png","1532936957352.png","1532936999322.png")
addConnection("1532937011734.png","1532937023042.png","1532937028723.png","1532937047635.png")
increaseSwimlaneHeigth(Pattern("1532937237991.png").targetOffset(213,145),100)
addFlowState("1532937318747.png","a","1532937334764.png")
addConnection("1532937363521.png","1532937373241.png","1532937378286.png","1532937412664.png")
addConnection("1532937464571.png","1532937473816.png","1532937480220.png","1532937499447.png")
addNewEndingPoint("1532937516675.png")
addConnection("1532937541460.png","1532937548997.png","1532937661192.png","1532937682470.png")

newDiagram()

initializeActivityDiagram()

addSwimlane(Pattern("1532936277921.png").targetOffset(-416,-203),"1532936329149.png")
addState(Pattern("1532936355857.png").targetOffset(-68,-1),"1532936382461.png","a")
addNewStartingPoint("1532936401843.png")
addConnection("1532936439607.png","1532936452769.png","1532936445168.png","1532936476438.png")
addSwimlane("1532936496534.png","1532936512493.png")
addNewJunction("1532936650815.png")
addConnection("1532936752352.png","1532936764546.png","1532936769923.png","1532936795834.png")
increaseSwimlaneWidth(Pattern("1532936828910.png").targetOffset(72,147),100)
increaseSwimlaneWidth(Pattern("1532936865698.png").targetOffset(18,137),100)
addNewJoint("1532936914602.png")
addConnection("1532936942727.png","1532936951097.png","1532936957352.png","1532936999322.png")
addConnection("1532937011734.png","1532937023042.png","1532937028723.png","1532937047635.png")
increaseSwimlaneHeigth(Pattern("1532937237991.png").targetOffset(213,145),100)
addFlowState("1532937318747.png","a","1532937334764.png")
addConnection("1532937363521.png","1532937373241.png","1532937378286.png","1532937412664.png")
addConnection("1532937464571.png","1532937473816.png","1532937480220.png","1532937499447.png")
addNewEndingPoint("1532937516675.png")
addConnection("1532937541460.png","1532937548997.png","1532937661192.png","1532937682470.png")
closeArgo()