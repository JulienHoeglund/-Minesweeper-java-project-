import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StoryListener implements ActionListener{
	private GameWindow w;
	public StoryListener(GameWindow window){
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		w.story();
	}
}