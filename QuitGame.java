/**
* QuitGameButton is a button displayed in the menus to end the application (without saving anything)    
*
* @version 0.1
* @author Julien Hoeglund
*/

import java.awt.event.*;

public class QuitGame implements ActionListener{
	private GameWindow w;
	public QuitGame(GameWindow window){
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		w.dispose();
		w.stopTimer();
	}
}