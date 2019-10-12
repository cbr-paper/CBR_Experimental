myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *

tx = "asssd"

setPauseDelay(0.1,0.1)

#newDiagram()

initializeActivityDiagram()
addStartingPoint(Pattern("1530526695841.png").targetOffset(-431,-178),"1530526731686.png")
addState(Pattern("1530526787375.png").targetOffset(-342,-180),"1530526841465.png","Withdraw")
addConnection("1530526858891.png","1530526866778.png","1530526872501.png","1530526891505.png")
addCallState(Pattern("1530526929563.png").targetOffset(-41,-88),"Check balance","1530526966992.png")
addConnection("1530531210352.png","1530531225539.png","1530531235100.png","1530531297818.png")
addJunction(Pattern("1530531337924.png").targetOffset(-16,1),"1530531363294.png")
addConnection("1530531377535.png","1530531383891.png","1530531388436.png","1530531407482.png")
addFlowState(Pattern("1530531963309.png").targetOffset(48,38),"Print EXP","1530532006286.png")
addConnection("1530532034444.png","1530532041015.png","1530532045370.png","1530532092665.png")
addEndingPoint(Pattern("1530532119991.png").targetOffset(42,17),"1530532155248.png")
addConnection("1530532168377.png","1530532175313.png","1530532181000.png","1530532202060.png")
addState(Pattern("1530532242517.png").targetOffset(-39,11),"1530532421280.png","Print amount")
addConnection("1530532439426.png","1530532449945.png","1530532454446.png","1530532482886.png")
addFork("1530532524400.png","1530532537382.png")
addEndingPoint("1530532555663.png","1530532571830.png")
addCallState(Pattern("1530532603128.png").targetOffset(-150,3),"Ready","1530532634290.png")
addConnection("1530532675500.png","1530532652038.png","1530532657297.png","1530532696189.png")
addConnection("1530532712322.png","1530532722323.png","1530532727238.png","1530532745340.png")
addConnection("1530532762486.png","1530532779620.png","1530532784896.png","1530532804360.png")
addText("1530532848133.png","1530532969715.png","Check update")
addText(Pattern("1530532901337.png").targetOffset(40,4),"1530533001008.png","Money out")
addText("1530532926583.png","1530533020483.png","End")

newDiagram()

initializeActivityDiagram()
addStartingPoint(Pattern("1530526695841.png").targetOffset(-431,-178),"1530526731686.png")
addState(Pattern("1530526787375.png").targetOffset(-342,-180),"1530526841465.png","Withdraw")
addConnection("1530526858891.png","1530526866778.png","1530526872501.png","1530526891505.png")
addCallState(Pattern("1530526929563.png").targetOffset(-41,-88),"Check balance","1530526966992.png")
addConnection("1530531210352.png","1530531225539.png","1530531235100.png","1530531297818.png")
addJunction(Pattern("1530531337924.png").targetOffset(-16,1),"1530531363294.png")
addConnection("1530531377535.png","1530531383891.png","1530531388436.png","1530531407482.png")
addFlowState(Pattern("1530531963309.png").targetOffset(48,38),"Print EXP","1530532006286.png")
addConnection("1530532034444.png","1530532041015.png","1530532045370.png","1530532092665.png")
addEndingPoint(Pattern("1530532119991.png").targetOffset(42,17),"1530532155248.png")
addConnection("1530532168377.png","1530532175313.png","1530532181000.png","1530532202060.png")
addState(Pattern("1530532242517.png").targetOffset(-39,11),"1530532421280.png","Print amount")
addConnection("1530532439426.png","1530532449945.png","1530532454446.png","1530532482886.png")
addFork("1530532524400.png","1530532537382.png")
addEndingPoint("1530532555663.png","1530532571830.png")
addCallState(Pattern("1530532603128.png").targetOffset(-150,3),"Ready","1530532634290.png")
addConnection("1530532675500.png","1530532652038.png","1530532657297.png","1530532696189.png")
addConnection("1530532712322.png","1530532722323.png","1530532727238.png","1530532745340.png")
addConnection("1530532762486.png","1530532779620.png","1530532784896.png","1530532804360.png")
addText("1530532848133.png","1530532969715.png","Check update")
addText(Pattern("1530532901337.png").targetOffset(40,4),"1530533001008.png","Money out")
addText("1530532926583.png","1530533020483.png","End")
closeArgo()






