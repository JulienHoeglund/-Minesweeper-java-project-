JC=javac
JVM=java

.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java
	
CLASSES= \
		GameWindow.java \
		Cell.java \
		CellListener.java \
		Grid.java \
		MenuPanel.java \
		MinePanel.java \
		MinusHeight.java \
		MinusMine.java \
		MinusWidth.java \
		PlayGameButton.java \
		PlusHeight.java \
		PlusMine.java \
		PlusWidth.java \
		QuitGameButton.java \
		ResumeGameButton.java \
		SaveQuitGameButton.java

default: classes  

classes: $(CLASSES:.java=.class)

test:
	$(JVM) GameWindow
clean : 
	$(RM) *.class


