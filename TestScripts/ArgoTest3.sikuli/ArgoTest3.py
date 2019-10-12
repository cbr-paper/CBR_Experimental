myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *

txt = "asd"

setPauseDelay(0.1,0.1)

#newDiagram()

initializeActivityDiagram()

addSwimlane(Pattern("1530440293731.png").targetOffset(-425,-176),"1530440340708.png")
addStartingPoint(Pattern("1530440392024.png").targetOffset(-25,-98),"1530440433158.png")
addState(Pattern("1530440478271.png").targetOffset(-58,-42),"1530440533474.png","Placer order")
addConnection("1530440551281.png","1530440562469.png","1530440571048.png","1530440593607.png")
nameSwimlane(Pattern("1530440662967.png").targetOffset(-12,-123),Pattern("1530440690915.png").targetOffset(-2,-134),"Sales")
addFork(Pattern("1530454796033.png").targetOffset(-38,59),"1530454861579.png")
increaseSwimlaneHeigth(Pattern("1530454964564.png").targetOffset(81,141),50)
addState(Pattern("1530455234012.png").targetOffset(-56,91),"1530455295192.png","Process pay")
addConnection("1530455407054.png","1530455443668.png","1530455459465.png","1530455507259.png")
addConnection("1530455552011.png","1530455566606.png","1530455574534.png","1530455594318.png")
addSwimlane(Pattern("1530455697346.png").targetOffset(23,-159),"1530455759888.png")
addState(Pattern("1530455759888.png").targetOffset(20,41),"1530455931023.png","Fill order")
addConnection("1530456035244.png","1530456045641.png","1530456051794.png","1530456077360.png")
nameSwimlane(Pattern("1530456216604.png").targetOffset(75,-149),Pattern("1530456216604.png").targetOffset(72,-160),"Fullfilment")
addSwimlane(Pattern("1530456295906.png").targetOffset(98,-153),"1530456335658.png")
addJoint(Pattern("1530456335658.png").targetOffset(112,57),"1530456451142.png")
addEndingPoint(Pattern("1530456451142.png").targetOffset(135,130),"1530456532196.png")
addConnection(Pattern("1530456532196.png").targetOffset(4,51),"1530456699286.png","1530456705535.png","1530456727380.png")
addConnection("1530456760001.png","1530456768958.png","1530456774947.png","1530456793522.png")
nameSwimlane(Pattern("1530456852860.png").targetOffset(157,-144),Pattern("1530456852860.png").targetOffset(145,-156),"Warehouse")

newDiagram()
initializeActivityDiagram()

addSwimlane(Pattern("1530440293731.png").targetOffset(-425,-176),"1530440340708.png")
addStartingPoint(Pattern("1530440392024.png").targetOffset(-25,-98),"1530440433158.png")
addState(Pattern("1530440478271.png").targetOffset(-58,-42),"1530440533474.png","Placer order")
addConnection("1530440551281.png","1530440562469.png","1530440571048.png","1530440593607.png")
nameSwimlane(Pattern("1530440662967.png").targetOffset(-12,-123),Pattern("1530440690915.png").targetOffset(-2,-134),"Sales")
addFork(Pattern("1530454796033.png").targetOffset(-38,59),"1530454861579.png")
increaseSwimlaneHeigth(Pattern("1530454964564.png").targetOffset(81,141),50)
addState(Pattern("1530455234012.png").targetOffset(-56,91),"1530455295192.png","Process pay")
addConnection("1530455407054.png","1530455443668.png","1530455459465.png","1530455507259.png")
addConnection("1530455552011.png","1530455566606.png","1530455574534.png","1530455594318.png")
addSwimlane(Pattern("1530455697346.png").targetOffset(23,-159),"1530455759888.png")
addState(Pattern("1530455759888.png").targetOffset(20,41),"1530455931023.png","Fill order")
addConnection("1530456035244.png","1530456045641.png","1530456051794.png","1530456077360.png")
nameSwimlane(Pattern("1530456216604.png").targetOffset(75,-149),Pattern("1530456216604.png").targetOffset(72,-160),"Fullfilment")
addSwimlane(Pattern("1530456295906.png").targetOffset(98,-153),"1530456335658.png")
addJoint(Pattern("1530456335658.png").targetOffset(112,57),"1530456451142.png")
addEndingPoint(Pattern("1530456451142.png").targetOffset(135,130),"1530456532196.png")
addConnection(Pattern("1530456532196.png").targetOffset(4,51),"1530456699286.png","1530456705535.png","1530456727380.png")
addConnection("1530456760001.png","1530456768958.png","1530456774947.png","1530456793522.png")
nameSwimlane(Pattern("1530456852860.png").targetOffset(157,-144),Pattern("1530456852860.png").targetOffset(145,-156),"Warehouse")


closeArgo()