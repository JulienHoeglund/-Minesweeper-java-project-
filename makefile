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
		GameButton.java \
		MinusHeight.java \
		MinusMine.java \
		MinusWidth.java \
		PlayGame.java \
		PlusHeight.java \
		PlusMine.java \
		PlusWidth.java \
		QuitGame.java \
		ResumeGame.java \
		SaveGame.java \
		QuitGame.java 

default: classes  

classes: $(CLASSES:.java=.class)

test:
	$(JVM) GameWindow
clean : 
	$(RM) *.class


