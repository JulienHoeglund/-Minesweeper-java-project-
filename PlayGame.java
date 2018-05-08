import java.awt.event.*;
/**
* The PlayGame class receives and processes mouse inputs 
*
* @version 0.1
* @author Julien Hoeglund
*/
public class PlayGame implements ActionListener{
	private GameWindow w;
	public PlayGame(GameWindow window){
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(w.getTime()>0){
		w.runGame(false);				
		}
	}
}