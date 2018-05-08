import java.awt.event.*;

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