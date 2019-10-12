from sikuli import *

pause=1.2
delay=0.5

argoumlJar = "../../argouml.jar"

def openArgo():
    subprocess.call(['java', '-jar', argoumlJar])
    wait("1530806844807.png",FOREVER) 

def setPauseDelay(p,d):
    pause = p
    delay = d

def newDiagram():
    wait(pause)
    click(Pattern("1530279755476.png").targetOffset(-171,0))
    wait("1530279786720.png",FOREVER)
    wait(pause)
    click(Pattern("1530279786720.png").targetOffset(-19,37))

def slowType(text):
    wait(pause)
    for c in text:
        type(c)
        wait(delay)

def initializeActivityDiagram():
    wait(pause) 
    click(Pattern("1527588546941.png").targetOffset(5,6))
    wait("1527588598704.png",FOREVER)

def addSwimlane(destination,result):
    wait(pause)
    click("1527588618459.png")
    wait(pause)
    click(destination)
    wait(result,FOREVER)


def nameSwimlane(destination,title,titleText):
    wait(pause)
    click(destination)
    wait(pause)
    doubleClick(title)
    wait(pause)
    slowType(titleText + Key.ESC)


def addText(destination,result,tText):
    wait(pause)
    click("1530282158098.png")
    wait(pause)
    click(destination)
    wait(pause)
    slowType(tText + Key.ESC)
    wait(result,FOREVER)



def addState(destination,result,stateText):
    wait(pause)
    click("1527590659581.png")
    wait(pause)
    doubleClick(destination)
    wait(pause) 
    slowType(stateText + Key.ESC)
    wait(result,FOREVER)

    

# Add a starting point in the activity diagram

def addStartingPoint(destination,result):
    wait(pause)
    click("1527601255737.png")
    wait(pause)    
    doubleClick(destination)
    wait(result,FOREVER)

    
def addNewStartingPoint(destination):
    wait(pause)
    click("1527601255737.png")
    wait(pause)    
    doubleClick(destination)
    wait("1530633887493.png",FOREVER)


def addEndingPoint(destination,result):
    wait(pause) 
    click("1527602070053.png")
    wait(pause)
    click(destination)
    wait(result,FOREVER)
    
def addNewEndingPoint(destination):
    wait(pause) 
    click("1527602070053.png")
    wait(pause)
    click(destination)
    wait("1530633921523.png",FOREVER)


def addJunction(destination,result):
    wait(pause)
    click("1527601450476.png")
    wait(pause)
    doubleClick(destination)
    wait(result,FOREVER)

def addNewJunction(destination):
    wait(pause)
    click("1527601450476.png")
    wait(pause)
    doubleClick(destination)
    wait("1530633952146.png",FOREVER)
    
def addComment(destination,result,textComment):
    wait(pause) 
    click(destination)
    wait(pause)
    click("1527601789355.png")
    wait(result,FOREVER)
    wait(pause)
    doubleClick(result)
    wait(pause)
    slowType(textComment + Key.ESC)


def addConnection(origin,arrow,destination,result):
    wait(pause) 
    click(origin)
    wait(pause)
    drag(arrow)
    wait(pause)
    mouseMove(destination)
    wait(pause)
    dropAt(destination)
    wait(result,FOREVER)


def editConnectionName(connection,box,connectionText,result):
    wait(pause) 
    click(connection)
    wait(pause)
    doubleClick(box)
    wait(pause)
    slowType(connectionText + Key.ESC)
    wait(result,FOREVER) 
    
def addCallState(destination,callStateText,result):
    wait(pause)  
    click("1527606598296.png")
    wait(pause)
    doubleClick(destination)
    wait(pause)
    slowType(callStateText + Key.ESC)
    wait(result,FOREVER)
    
def addFlowState(destination,callFlowText,result):
    wait(pause)  
    click("1527606634937.png")
    wait(pause) 
    doubleClick(destination)
    wait(pause) 
    slowType(callFlowText + Key.ESC)
    wait(result,FOREVER)

    
def addFork(destination,result):
    wait(pause)  
    click("1527606644018.png")
    wait(pause) 
    click(destination)
    wait(pause)
    wait(result,FOREVER)


def addNewFork(destination):
    wait(pause)  
    click("1527606644018.png")
    wait(pause) 
    click(destination)
    wait(pause)
    wait("1530633990310.png",FOREVER)

    
def addJoint(destination,result):
    wait(pause)  
    click("1527606651285.png")
    wait(pause) 
    click(destination)
    wait(pause)
    wait(result,FOREVER)


def addNewJoint(destination):
    wait(pause)  
    click("1527606651285.png")
    wait(pause) 
    click(destination)
    wait(pause)
    wait("1530634020014.png",FOREVER)

def increaseSwimlaneHeigth(swimlane,destination):
    wait(pause)  
    click(swimlane)
    wait(pause)
    drag(swimlane)
    wait(pause)
    mLoc = Env.getMouseLocation().offset(0,destination) 
    mouseMove(mLoc)
    wait(pause)
    dropAt(mLoc)  
    wait(pause*2)

def increaseSwimlaneWidth(swimlane,destination):
    wait(pause)  
    click(swimlane)
    wait(pause)
    drag(swimlane)
    wait(pause)
    mLoc = Env.getMouseLocation().offset(destination,0) 
    mouseMove(mLoc)
    wait(pause)
    dropAt(mLoc)  
    wait(pause*2)

def makeForkVertical(fork,destination):
    wait(pause)
    click(fork)
    wait(pause)
    drag(fork)
    wait(pause)
    mLoc = Env.getMouseLocation().offset(-10,destination) 
    mouseMove(mLoc)
    wait(pause)
    dropAt(mLoc)
    wait(pause*2)

def modifyElementWidth(element,destination):
    wait(pause)  
    click(element)
    wait(pause)
    drag(element)
    wait(pause)
    mLoc = Env.getMouseLocation().offset(destination,0) 
    mouseMove(mLoc)
    wait(pause)
    dropAt(mLoc)  
    wait(pause*2)

def closeArgo():
    wait(pause) 
    click(Pattern("1530970314768.png").targetOffset(-95,-78))
    wait(pause)
    click(Pattern("1530970357273.png").targetOffset(2,41))
