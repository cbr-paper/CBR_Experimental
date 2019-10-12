myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *

txt = "asd"

initializeActivityDiagram()

addStartingPoint(Pattern("1530437936136.png").targetOffset(-406,-158),"1530437979648.png")
addState(Pattern("1530438054206.png").targetOffset(-18,-31),"1530438135076.png","Call client")
addConnection("1530438198426.png","1530438218930.png",Pattern("1530438227615.png").similar(0.60),"1530438280058.png")
addState(Pattern("1530438347398.png").similar(0.62).targetOffset(121,-17),"1530438453625.png","Next client")
addConnection("1530438511609.png","1530438521509.png","1530438528646.png","1530438589189.png")
addJunction(Pattern("1530438671382.png").targetOffset(54,-3),"1530438702898.png")
addConnection(Pattern("1530438829819.png").similar(0.47),"1530438779593.png","1530438787802.png","1530438859710.png")
addState(Pattern("1530281182510.png").targetOffset(67,25),"1530281241257.png","Text number 1")
addEndingPoint(Pattern("1530281342599.png").targetOffset(-11,67),"1530281391283.png")
addConnection("1530281472099.png","1530281483446.png","1530281492757.png","1530281511959.png")
addConnection("1530281671762.png","1530281682944.png","1530281692434.png","1530281707079.png")
addConnection("1530282008123.png","1530282030339.png","1530282039780.png","1530282055684.png")
addText("1530282294918.png","1530282344609.png","Accept")
addText("1530282388994.png","1530282412185.png","Yes")
addText("1530282444891.png","1530282464706.png","No")

newDiagram()

initializeActivityDiagram()

addStartingPoint(Pattern("1530437936136.png").targetOffset(-406,-158),"1530437979648.png")
addState(Pattern("1530438054206.png").targetOffset(-18,-31),"1530438135076.png","Call client")
addConnection("1530438198426.png","1530438218930.png",Pattern("1530438227615.png").similar(0.60),"1530438280058.png")
addState(Pattern("1530438347398.png").similar(0.62).targetOffset(121,-17),"1530438453625.png","Next client")
addConnection("1530438511609.png","1530438521509.png","1530438528646.png","1530438589189.png")
addJunction(Pattern("1530438671382.png").targetOffset(54,-3),"1530438702898.png")
addConnection(Pattern("1530438829819.png").similar(0.47),"1530438779593.png","1530438787802.png","1530438859710.png")
addState(Pattern("1530281182510.png").targetOffset(67,25),"1530281241257.png","Text number 1")
addEndingPoint(Pattern("1530281342599.png").targetOffset(-11,67),"1530281391283.png")
addConnection("1530281472099.png","1530281483446.png","1530281492757.png","1530281511959.png")
addConnection("1530281671762.png","1530281682944.png","1530281692434.png","1530281707079.png")
addConnection("1530282008123.png","1530282030339.png","1530282039780.png","1530282055684.png")
addText("1530282294918.png","1530282344609.png","Accept")
addText("1530282388994.png","1530282412185.png","Yes")
addText("1530282444891.png","1530282464706.png","No")

closeArgo()