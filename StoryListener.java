import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
* StoryListener is used to display the story.
*
* @version 0.1
* @author Julien Hoeglund
*/
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