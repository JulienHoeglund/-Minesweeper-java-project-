/**
* PlayGameButton launches the configuration of a new game   
*
* @version 0.1
* @author Julien Hoeglund
*/
import java.awt.event.*;

public class NewGameButton implements ActionListener{
	private GameWindow w;
	public NewGameButton(GameWindow window){
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		w.config();
	}
}