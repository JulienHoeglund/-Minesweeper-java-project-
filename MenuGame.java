import java.awt.event.*;
/**
* MenuGame is a listener that launches the configuration of a new game. 
*
* @version 0.1
* @author Julien Hoeglund
*/
public class MenuGame implements ActionListener{
	private GameWindow w;
	public MenuGame(GameWindow window){
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		w.menu();
		w.stopTimer();
	}
}