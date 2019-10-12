myScriptPath = "../"

addImportPath(myScriptPath)

from argouml import *

n = "asssd"

setPauseDelay(0.1,0.1)

#newDiagram()
initializeActivityDiagram()

addSwimlane(Pattern("1530775641328.png").targetOffset(-454,-189),"1530775675491.png")
addSwimlane("1530775686290.png","1530775701691.png")
addSwimlane("1530775717517.png","1530775759714.png")
addSwimlane(Pattern("1530775771592.png").targetOffset(137,-124),"1530775802078.png")
addNewStartingPoint(Pattern("1530779700094.png").targetOffset(-273,-88))
addState(Pattern("1530779750503.png").targetOffset(33,-23),"1530779782023.png","a")
addConnection("1530782589366.png","1530782621811.png","1530782628004.png","1530782685821.png")   
addNewFork(Pattern("1530782726285.png").targetOffset(28,-24))
makeForkVertical(Pattern("1530782819781.png").targetOffset(63,-3),100)
addConnection("1530782932600.png","1530782946675.png","1530782952204.png","1530807194967.png")
addFlowState("1530807303622.png","b","1530807394322.png")
addConnection("1530807423862.png","1530807432590.png","1530808228323.png","1530808266337.png")
addState("1530808385241.png","1530808422898.png","c")
addConnection("1530808439573.png","1530808453059.png","1530808457884.png","1530808557315.png")
addNewEndingPoint("1530808601109.png")
addConnection("1530808704393.png","1530808745845.png","1530808751966.png","1530808771551.png")
increaseSwimlaneHeigth(Pattern("1530808811213.png").targetOffset(126,64),90)
addNewStartingPoint(Pattern("1530809822587.png").targetOffset(-54,14))
addNewJunction(Pattern("1530809887950.png").targetOffset(-39,-48))
addConnection("1530809990411.png","1530810005881.png","1530810037603.png","1530810088349.png")
addConnection("1530810158875.png","1530810203842.png","1530810211520.png","1530810287634.png")

newDiagram()
initializeActivityDiagram()

addSwimlane(Pattern("1530775641328.png").targetOffset(-454,-189),"1530775675491.png")
addSwimlane("1530775686290.png","1530775701691.png")
addSwimlane("1530775717517.png","1530775759714.png")
addSwimlane(Pattern("1530775771592.png").targetOffset(137,-124),"1530775802078.png")
addNewStartingPoint(Pattern("1530779700094.png").targetOffset(-273,-88))
addState(Pattern("1530779750503.png").targetOffset(33,-23),"1530779782023.png","a")
addConnection("1530782589366.png","1530782621811.png","1530782628004.png","1530782685821.png")   
addNewFork(Pattern("1530782726285.png").targetOffset(28,-24))
makeForkVertical(Pattern("1530782819781.png").targetOffset(63,-3),100)
addConnection("1530782932600.png","1530782946675.png","1530782952204.png","1530807194967.png")
addFlowState("1530807303622.png","b","1530807394322.png")
addConnection("1530807423862.png","1530807432590.png","1530808228323.png","1530808266337.png")
addState("1530808385241.png","1530808422898.png","c")
addConnection("1530808439573.png","1530808453059.png","1530808457884.png","1530808557315.png")
addNewEndingPoint("1530808601109.png")
addConnection("1530808704393.png","1530808745845.png","1530808751966.png","1530808771551.png")
increaseSwimlaneHeigth(Pattern("1530808811213.png").targetOffset(126,64),90)
addNewStartingPoint(Pattern("1530809822587.png").targetOffset(-54,14))
addNewJunction(Pattern("1530809887950.png").targetOffset(-39,-48))
addConnection("1530809990411.png","1530810005881.png","1530810037603.png","1530810088349.png")
addConnection("1530810158875.png","1530810203842.png","1530810211520.png","1530810287634.png")

closeArgo()