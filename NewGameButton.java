import java.awt.event.*;

public class NewGameButton implements ActionListener{
	private GameWindow w;
	public NewGameButton(GameWindow window){
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		w.runGame();
	}
}