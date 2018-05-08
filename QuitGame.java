import java.awt.event.*;
/**
* QuitGame ends the application (without saving anything)    
*
* @version 0.1
* @author Julien Hoeglund
*/
public class QuitGame implements ActionListener{
	private GameWindow w;
	public QuitGame(GameWindow window){
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		w.stopTimer();
		w.dispose();
	}
}