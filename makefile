JC=javac
JVM=java

.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java
	
CLASSES= \
		GameWindow.java \
		GameWindowTimer.java \
		Cell.java \
		CellListener.java \
		StoryListener.java \
		Grid.java \
		MenuPanel.java \
		GameButton.java \
		MinusHeight.java \
		MinusMine.java \
		MinusWidth.java \
		MinusTime.java \
		PlusTime15.java \
		MinusTime15.java \
		PlayGame.java \
		PlusHeight.java \
		PlusMine.java \
		Plus10Mine.java \
		Minus10Mine.java \
		PlusWidth.java \
		PlusTime.java \
		QuitGame.java \
		NewGame.java \
		ResumeGame.java \
		BackgroundPanel.java \
		QuitGame.java
		
default: classes  

classes: $(CLASSES:.java=.class)

test:
	$(JVM) GameWindow
clean : 
	$(RM) *.class
	$(RM) save.mns

