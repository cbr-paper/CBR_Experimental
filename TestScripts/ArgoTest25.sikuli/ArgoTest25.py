myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *
    
n = "asssd"

setPauseDelay(0.1,0.1)
#newDiagram()

initializeActivityDiagram()
addNewStartingPoint(Pattern("1532938303541.png").targetOffset(-142,-267))
addState("1532938361501.png","1532938454674.png","a")
addConnection("1532938507034.png","1532938514942.png","1532938521928.png","1532938540760.png")
addNewFork(Pattern("1532938572276.png").targetOffset(-123,-92))
addConnection("1532938652008.png","1532938687753.png","1532938727181.png","1532938750493.png")
modifyElementWidth(Pattern("1532938772907.png").targetOffset(37,15),200)
addState("1532938925611.png","1532939030099.png","n")
addCallState("1532939099650.png","m","1532939148779.png")
addConnection("1532939276141.png","1532939386956.png","1532939406374.png","1532939455452.png")
addConnection("1532939549486.png","1532939573011.png","1532939556743.png","1532939609957.png")
addNewJunction("1532939681233.png")
addConnection("1532940455217.png","1532940540040.png","1532940504636.png","1532940626431.png")
addFlowState("1532940685808.png","m","1532940778621.png")
addConnection("1532940822553.png","1532940846303.png","1532940852704.png","1532940975466.png")
addNewJoint("1532941057052.png")
addConnection("1532941095651.png","1532941111718.png","1532941132180.png","1532941181154.png")

newDiagram()

initializeActivityDiagram()
addNewStartingPoint(Pattern("1532938303541.png").targetOffset(-142,-267))
addState("1532938361501.png","1532938454674.png","a")
addConnection("1532938507034.png","1532938514942.png","1532938521928.png","1532938540760.png")
addNewFork(Pattern("1532938572276.png").targetOffset(-123,-92))
addConnection("1532938652008.png","1532938687753.png","1532938727181.png","1532938750493.png")
modifyElementWidth(Pattern("1532938772907.png").targetOffset(37,15),200)
addState("1532938925611.png","1532939030099.png","n")
addCallState("1532939099650.png","m","1532939148779.png")
addConnection("1532939276141.png","1532939386956.png","1532939406374.png","1532939455452.png")
addConnection("1532939549486.png","1532939573011.png","1532939556743.png","1532939609957.png")
addNewJunction("1532939681233.png")
addConnection("1532940455217.png","1532940540040.png","1532940504636.png","1532940626431.png")
addFlowState("1532940685808.png","m","1532940778621.png")
addConnection("1532940822553.png","1532940846303.png","1532940852704.png","1532940975466.png")
addNewJoint("1532941057052.png")
addConnection("1532941095651.png","1532941111718.png","1532941132180.png","1532941181154.png")
closeArgo()