myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *

t = "asssd"

setPauseDelay(0.1,0.1)

#newDiagram()

initializeActivityDiagram()

addSwimlane(Pattern("1530692186542.png").targetOffset(-454,-187),"1530692218433.png")
increaseSwimlaneWidth(Pattern("1530692238805.png").targetOffset(60,140),300)
addNewStartingPoint(Pattern("1530692283644.png").targetOffset(-210,-97))
addState(Pattern("1530692358995.png").targetOffset(-122,-34),"1530692394228.png","s")
addConnection("1530692440930.png","1530692453545.png","1530692459570.png","1530692485028.png")
addFlowState(Pattern("1530692517590.png").targetOffset(-145,-13),"flow","1530692564713.png")
addFlowState(Pattern("1530692688264.png").targetOffset(-94,40),"state","1530692722781.png")
addConnection(Pattern("1530692804458.png").targetOffset(-9,-64),"1530692841034.png","1530692847600.png","1530692877934.png")
addConnection("1530693010621.png","1530693020464.png","1530693025999.png","1530693042576.png")
addNewJunction(Pattern("1530693059471.png").targetOffset(12,-49))
addConnection("1530693209743.png","1530693219422.png","1530693237651.png","1530693287075.png")
addState(Pattern("1530693327344.png").targetOffset(-63,-33),"1530693363961.png","e")
addConnection("1530693499307.png","1530693507163.png","1530693517081.png","1530693574601.png")
addNewEndingPoint("1530693595954.png")
addConnection("1530693706161.png","1530693726343.png","1530693734487.png","1530693767109.png")
addConnection("1530693785188.png","1530693796115.png","1530693802991.png","1530693820839.png")
nameSwimlane(Pattern("1530693839266.png").targetOffset(-7,-129),Pattern("1530693839266.png").targetOffset(-20,-144),"qwerty")
editConnectionName(Pattern("1530693986200.png").targetOffset(-1,-26),"1530694000443.png","asd","1530694034106.png")
increaseSwimlaneHeigth(Pattern("1530694074325.png").targetOffset(228,145),80)
addComment(Pattern("1530694216868.png").targetOffset(-9,51),"1530694233248.png","asd")
addText("1530694374225.png","1530694392587.png","comm")

newDiagram()

initializeActivityDiagram()

addSwimlane(Pattern("1530692186542.png").targetOffset(-454,-187),"1530692218433.png")
increaseSwimlaneWidth(Pattern("1530692238805.png").targetOffset(60,140),300)
addNewStartingPoint(Pattern("1530692283644.png").targetOffset(-210,-97))
addState(Pattern("1530692358995.png").targetOffset(-122,-34),"1530692394228.png","s")
addConnection("1530692440930.png","1530692453545.png","1530692459570.png","1530692485028.png")
addFlowState(Pattern("1530692517590.png").targetOffset(-145,-13),"flow","1530692564713.png")
addFlowState(Pattern("1530692688264.png").targetOffset(-94,40),"state","1530692722781.png")
addConnection(Pattern("1530692804458.png").targetOffset(-9,-64),"1530692841034.png","1530692847600.png","1530692877934.png")
addConnection("1530693010621.png","1530693020464.png","1530693025999.png","1530693042576.png")
addNewJunction(Pattern("1530693059471.png").targetOffset(12,-49))
addConnection("1530693209743.png","1530693219422.png","1530693237651.png","1530693287075.png")
addState(Pattern("1530693327344.png").targetOffset(-63,-33),"1530693363961.png","e")
addConnection("1530693499307.png","1530693507163.png","1530693517081.png","1530693574601.png")
addNewEndingPoint("1530693595954.png")
addConnection("1530693706161.png","1530693726343.png","1530693734487.png","1530693767109.png")
addConnection("1530693785188.png","1530693796115.png","1530693802991.png","1530693820839.png")
nameSwimlane(Pattern("1530693839266.png").targetOffset(-7,-129),Pattern("1530693839266.png").targetOffset(-20,-144),"qwerty")
editConnectionName(Pattern("1530693986200.png").targetOffset(-1,-26),"1530694000443.png","asd","1530694034106.png")
increaseSwimlaneHeigth(Pattern("1530694074325.png").targetOffset(228,145),80)
addComment(Pattern("1530694216868.png").targetOffset(-9,51),"1530694233248.png","asd")
addText("1530694374225.png","1530694392587.png","comm")

closeArgo()