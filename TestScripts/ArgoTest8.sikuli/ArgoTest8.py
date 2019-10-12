myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *

t = "asssd"

setPauseDelay(0.1,0.1)

#newDiagram()

initializeActivityDiagram()
addSwimlane(Pattern("1530632060306.png").targetOffset(-437,-179),"1530632088136.png")
addSwimlane(Pattern("1530632103620.png").targetOffset(-4,-136),"1530632153093.png")
addSwimlane(Pattern("1530632172355.png").targetOffset(67,-119),"1530632211278.png")
increaseSwimlaneHeigth(Pattern("1530632248896.png").targetOffset(240,147),100)
addStartingPoint(Pattern("1530632425665.png").targetOffset(-222,-18),"1530632448480.png")
addState("1530632501447.png","1530632529071.png","state")
addConnection("1530632546987.png","1530632584308.png","1530632590811.png","1530634721999.png")
addFlowState(Pattern("1530632636449.png").targetOffset(98,-12),"flow","1530632721818.png")
addConnection("1530632749875.png","1530632764070.png","1530632768902.png","1530632810794.png")
addFork("1530632850305.png","1530632876446.png")
addConnection("1530632903805.png","1530632973493.png","1530633009422.png","1530633060490.png")
addCallState("1530633179822.png","CallState","1530633299586.png")

addConnection(Pattern("1530637380603.png").targetOffset(-33,7),"1530633343908.png","1530633350210.png","1530633369020.png")
addJunction(Pattern("1530637422115.png").targetOffset(131,126),"1530633733547.png")
addConnection("1530633817047.png","1530633780866.png","1530633786222.png","1530633833640.png")
addNewEndingPoint(Pattern("1530634084368.png").targetOffset(-217,47))
addConnection("1530634125449.png","1530634133785.png","1530634143929.png","1530634239543.png")
addState(Pattern("1530634294867.png").targetOffset(-140,-34),"1530634438480.png","state")
addConnection("1530634449212.png","1530634461541.png","1530634465908.png","1530634486930.png")
addConnection("1530634515498.png","1530634523802.png","1530634528449.png","1530634584913.png")

newDiagram()

initializeActivityDiagram()
addSwimlane(Pattern("1530632060306.png").targetOffset(-437,-179),"1530632088136.png")
addSwimlane(Pattern("1530632103620.png").targetOffset(-4,-136),"1530632153093.png")
addSwimlane(Pattern("1530632172355.png").targetOffset(67,-119),"1530632211278.png")
increaseSwimlaneHeigth(Pattern("1530632248896.png").targetOffset(240,147),100)
addStartingPoint(Pattern("1530632425665.png").targetOffset(-222,-18),"1530632448480.png")
addState("1530632501447.png","1530632529071.png","state")
addConnection("1530632546987.png","1530632584308.png","1530632590811.png","1530634721999.png")
addFlowState(Pattern("1530632636449.png").targetOffset(98,-12),"flow","1530632721818.png")
addConnection("1530632749875.png","1530632764070.png","1530632768902.png","1530632810794.png")
addFork("1530632850305.png","1530632876446.png")
addConnection("1530632903805.png","1530632973493.png","1530633009422.png","1530633060490.png")
addCallState("1530633179822.png","CallState","1530633299586.png")

addConnection(Pattern("1530637380603.png").targetOffset(-33,7),"1530633343908.png","1530633350210.png","1530633369020.png")
addJunction(Pattern("1530637422115.png").targetOffset(131,126),"1530633733547.png")
addConnection("1530633817047.png","1530633780866.png","1530633786222.png","1530633833640.png")
addNewEndingPoint(Pattern("1530634084368.png").targetOffset(-217,47))
addConnection("1530634125449.png","1530634133785.png","1530634143929.png","1530634239543.png")
addState(Pattern("1530634294867.png").targetOffset(-140,-34),"1530634438480.png","state")
addConnection("1530634449212.png","1530634461541.png","1530634465908.png","1530634486930.png")
addConnection("1530634515498.png","1530634523802.png","1530634528449.png","1530634584913.png")

closeArgo()