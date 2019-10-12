myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *

t = "asssd"

setPauseDelay(0.1,0.1)

#newDiagram()
initializeActivityDiagram()
addNewStartingPoint(Pattern("1530716097588.png").targetOffset(-387,-178))
addState("1530716143486.png","1530716191556.png","state")
addConnection("1530716254292.png","1530716260738.png","1530716278502.png","1530716300980.png")
addNewJunction("1530716382790.png")
addConnection("1530716408876.png","1530716417383.png","1530716424622.png","1530716449763.png")
addNewEndingPoint("1530716462924.png")
addConnection("1530716489849.png","1530716497286.png","1530716504566.png","1530716550416.png")
addNewFork(Pattern("1530716614181.png").targetOffset(-62,-4))
addConnection("1530716674088.png","1530716679983.png","1530716686497.png","1530716717072.png")
addCallState(Pattern("1530716747439.png").targetOffset(-108,6),"a","1530716786184.png")
addState("1530716813296.png","1530716833299.png","b")
addConnection("1530716851603.png","1530716863958.png",Pattern("1530716871471.png").targetOffset(-97,14),"1530716939871.png")
addConnection("1530721265718.png","1530721284584.png","1530721290862.png","1530721314904.png")
addNewJoint(Pattern("1530721344637.png").targetOffset(-111,17))
addConnection("1530722683871.png",Pattern("1530722713585.png").targetOffset(56,-27),Pattern("1530722817239.png").targetOffset(-68,1),"1530722849302.png")
addConnection("1530721479747.png","1530721643342.png",Pattern("1530721489916.png").targetOffset(-58,-1),"1530721709974.png")
addState(Pattern("1530721738403.png").targetOffset(-112,-1),"1530721789611.png","s")
addConnection(Pattern("1530723005883.png").targetOffset(-49,-22),"1530723041086.png",Pattern("1530723081447.png").targetOffset(-165,-50),"1530723496948.png")
addNewEndingPoint(Pattern("1530723151142.png").targetOffset(46,11))
addConnection("1530722107561.png","1530722113693.png","1530722119959.png","1530722136498.png")
modifyElementWidth(Pattern("1530722300209.png").targetOffset(29,-5),100)

newDiagram()

initializeActivityDiagram()

addNewStartingPoint(Pattern("1530716097588.png").targetOffset(-387,-178))
addState("1530716143486.png","1530716191556.png","state")
addConnection("1530716254292.png","1530716260738.png","1530716278502.png","1530716300980.png")
addNewJunction("1530716382790.png")
addConnection("1530716408876.png","1530716417383.png","1530716424622.png","1530716449763.png")
addNewEndingPoint("1530716462924.png")
addConnection("1530716489849.png","1530716497286.png","1530716504566.png","1530716550416.png")
addNewFork(Pattern("1530716614181.png").targetOffset(-62,-4))
addConnection("1530716674088.png","1530716679983.png","1530716686497.png","1530716717072.png")
addCallState(Pattern("1530716747439.png").targetOffset(-108,6),"a","1530716786184.png")
addState("1530716813296.png","1530716833299.png","b")
addConnection("1530716851603.png","1530716863958.png",Pattern("1530716871471.png").targetOffset(-97,14),"1530716939871.png")
addConnection("1530721265718.png","1530721284584.png","1530721290862.png","1530721314904.png")
addNewJoint(Pattern("1530721344637.png").targetOffset(-111,17))
addConnection("1530722683871.png",Pattern("1530722713585.png").targetOffset(56,-27),Pattern("1530722817239.png").targetOffset(-68,1),"1530722849302.png")
addConnection("1530721479747.png","1530721643342.png",Pattern("1530721489916.png").targetOffset(-58,-1),"1530721709974.png")
addState(Pattern("1530721738403.png").targetOffset(-112,-1),"1530721789611.png","s")
addConnection(Pattern("1530723005883.png").targetOffset(-49,-22),"1530723041086.png",Pattern("1530723081447.png").targetOffset(-165,-50),"1530723496948.png")
addNewEndingPoint(Pattern("1530723151142.png").targetOffset(46,11))
addConnection("1530722107561.png","1530722113693.png","1530722119959.png","1530722136498.png")
modifyElementWidth(Pattern("1530722300209.png").targetOffset(29,-5),100)


closeArgo()