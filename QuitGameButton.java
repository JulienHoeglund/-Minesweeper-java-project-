/**
* QuitGameButton is a button displayed in the menus to end the application (without saving anything)    
*
* @version 0.1
* @author Julien Hoeglund
*/

import java.awt.event.*;

public class QuitGameButton implements ActionListener{
	private GameWindow w;
	private Grid g;
	public QuitGameButton(GameWindow window,Grid grid){
		w=window;
		g=grid;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		w.dispose();
	}
}