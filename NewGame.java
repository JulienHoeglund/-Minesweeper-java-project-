/**
* NewGameButton launches the configuration of a new game   
*
* @version 0.1
* @author Julien Hoeglund
*/
import java.awt.event.*;

public class NewGame implements ActionListener{
	private GameWindow w;
	public NewGame(GameWindow window){
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		w.config();
	}
}