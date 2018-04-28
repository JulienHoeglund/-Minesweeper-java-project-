import java.awt.event.*;

public class PlayGameButton implements ActionListener{
	private GameWindow w;
	public PlayGameButton(GameWindow window){
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		w.runGame(false);
	}
}