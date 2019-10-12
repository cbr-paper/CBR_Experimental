myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *

tx = "asssd"

setPauseDelay(0.1,0.1)

#newDiagram()

initializeActivityDiagram()
addSwimlane(Pattern("1530533519147.png").targetOffset(-450,-190),"1530533557071.png")
increaseSwimlaneWidth("1530533632828.png",200)
addStartingPoint(Pattern("1530533816554.png").targetOffset(-162,-100),"1530533845704.png")
addState(Pattern("1530533885202.png").targetOffset(-61,-90),"1530534008349.png","Receive")
addJunction(Pattern("1530534030673.png").targetOffset(-28,-13),"1530534070744.png")
addCallState(Pattern("1530534098362.png").targetOffset(-52,65),"Fill order","1530534134138.png")
addSwimlane(Pattern("1530534152993.png").targetOffset(0,-134),"1530534189096.png")
addState(Pattern("1530534189096.png").targetOffset(-36,-25),"1530534248055.png","Ship")
addFork(Pattern("1530534291448.png").targetOffset(-50,2),"1530534311248.png")
addConnection("1530534329035.png","1530534339486.png",Pattern("1530534351096.png").targetOffset(-7,-76),"1530534375734.png")
addConnection("1530534399021.png","1530534404771.png","1530534409801.png","1530534433031.png")
addConnection("1530601224613.png","1530601237810.png","1530601245211.png","1530601414953.png")
addConnection("1530601437474.png","1530601452244.png","1530601456935.png","1530601499976.png")
addConnection("1530601518391.png","1530601624551.png","1530601607891.png","1530601644630.png")
nameSwimlane(Pattern("1530601875750.png").targetOffset(0,-122),Pattern("1530601875750.png").targetOffset(-7,-129),"Seattle")
nameSwimlane(Pattern("1530601935269.png").targetOffset(1,-121),Pattern("1530601935269.png").targetOffset(-5,-134),"Reno")
increaseSwimlaneHeigth("1530602894834.png",100)
addEndingPoint(Pattern("1530602104380.png").targetOffset(-30,109),"1530602134653.png")
addEndingPoint(Pattern("1530602149188.png").targetOffset(-57,93),"1530602173756.png")
addConnection("1530602218192.png","1530602226585.png","1530602233616.png","1530602401837.png")
addConnection("1530602418936.png","1530602435991.png","1530602443618.png","1530602472878.png")

newDiagram()

initializeActivityDiagram()
addSwimlane(Pattern("1530533519147.png").targetOffset(-450,-190),"1530533557071.png")
increaseSwimlaneWidth("1530533632828.png",200)
addStartingPoint(Pattern("1530533816554.png").targetOffset(-162,-100),"1530533845704.png")
addState(Pattern("1530533885202.png").targetOffset(-61,-90),"1530534008349.png","Receive")
addJunction(Pattern("1530534030673.png").targetOffset(-28,-13),"1530534070744.png")
addCallState(Pattern("1530534098362.png").targetOffset(-52,65),"Fill order","1530534134138.png")
addSwimlane(Pattern("1530534152993.png").targetOffset(0,-134),"1530534189096.png")
addState(Pattern("1530534189096.png").targetOffset(-36,-25),"1530534248055.png","Ship")
addFork(Pattern("1530534291448.png").targetOffset(-50,2),"1530534311248.png")
addConnection("1530534329035.png","1530534339486.png",Pattern("1530534351096.png").targetOffset(-7,-76),"1530534375734.png")
addConnection("1530534399021.png","1530534404771.png","1530534409801.png","1530534433031.png")
addConnection("1530601224613.png","1530601237810.png","1530601245211.png","1530601414953.png")
addConnection("1530601437474.png","1530601452244.png","1530601456935.png","1530601499976.png")
addConnection("1530601518391.png","1530601624551.png","1530601607891.png","1530601644630.png")
nameSwimlane(Pattern("1530601875750.png").targetOffset(0,-122),Pattern("1530601875750.png").targetOffset(-7,-129),"Seattle")
nameSwimlane(Pattern("1530601935269.png").targetOffset(1,-121),Pattern("1530601935269.png").targetOffset(-5,-134),"Reno")
increaseSwimlaneHeigth("1530602894834.png",100)
addEndingPoint(Pattern("1530602104380.png").targetOffset(-30,109),"1530602134653.png")
addEndingPoint(Pattern("1530602149188.png").targetOffset(-57,93),"1530602173756.png")
addConnection("1530602218192.png","1530602226585.png","1530602233616.png","1530602401837.png")
addConnection("1530602418936.png","1530602435991.png","1530602443618.png","1530602472878.png")

closeArgo()