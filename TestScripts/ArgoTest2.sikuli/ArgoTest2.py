myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *

txt = "asd"

#newDiagram()

initializeActivityDiagram()

addSwimlane(Pattern("1530440293731.png").targetOffset(-425,-176),"1530440340708.png")
addStartingPoint(Pattern("1530440392024.png").targetOffset(-25,-98),"1530440433158.png")
addState(Pattern("1530440478271.png").targetOffset(-58,-42),"1530440533474.png","Placer order")
addConnection("1530440551281.png","1530440562469.png","1530440571048.png","1530440593607.png")
nameSwimlane(Pattern("1530440662967.png").targetOffset(-12,-123),Pattern("1530440690915.png").targetOffset(-2,-134),"Customer")
addSwimlane(Pattern("1530440819990.png").targetOffset(15,-129),"1530440856110.png")
addState(Pattern("1530440890588.png").targetOffset(-51,-40),"1530440949401.png","Pack items")
addConnection("1530440971010.png","1530440984973.png","1530440991309.png","1530441017172.png")
addState(Pattern("1530441042111.png").targetOffset(-58,39),"1530441113218.png","Arrange shipm")
addConnection("1530441140291.png","1530441179198.png","1530441148668.png","1530441205163.png")
addEndingPoint(Pattern("1530441245470.png").targetOffset(-30,101),"1530441281228.png")
addConnection("1530441308788.png","1530441321357.png","1530441328501.png","1530441352442.png")
nameSwimlane(Pattern("1530441381600.png").targetOffset(-10,-124),Pattern("1530441381600.png").targetOffset(-12,-139),"Seller")

newDiagram()

initializeActivityDiagram()

addSwimlane(Pattern("1530440293731.png").targetOffset(-425,-176),"1530440340708.png")
addStartingPoint(Pattern("1530440392024.png").targetOffset(-25,-98),"1530440433158.png")
addState(Pattern("1530440478271.png").targetOffset(-58,-42),"1530440533474.png","Placer order")
addConnection("1530440551281.png","1530440562469.png","1530440571048.png","1530440593607.png")
nameSwimlane(Pattern("1530440662967.png").targetOffset(-12,-123),Pattern("1530440690915.png").targetOffset(-2,-134),"Customer")
addSwimlane(Pattern("1530440819990.png").targetOffset(15,-129),"1530440856110.png")
addState(Pattern("1530440890588.png").targetOffset(-51,-40),"1530440949401.png","Pack items")
addConnection("1530440971010.png","1530440984973.png","1530440991309.png","1530441017172.png")
addState(Pattern("1530441042111.png").targetOffset(-58,39),"1530441113218.png","Arrange shipm")
addConnection("1530441140291.png","1530441179198.png","1530441148668.png","1530441205163.png")
addEndingPoint(Pattern("1530441245470.png").targetOffset(-30,101),"1530441281228.png")
addConnection("1530441308788.png","1530441321357.png","1530441328501.png","1530441352442.png")
nameSwimlane(Pattern("1530441381600.png").targetOffset(-10,-124),Pattern("1530441381600.png").targetOffset(-12,-139),"Seller")

closeArgo()
