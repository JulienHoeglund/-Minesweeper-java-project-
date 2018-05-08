import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
* Minus10Mine is a button which decrements the number of mines by 10.   
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
public class Minus10Mine implements ActionListener{
	private GameWindow w;
	private JLabel l;

	public Minus10Mine(GameWindow window, JLabel label){
		l=label;
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(w.getMines()>=10){
			w.setMines(w.getMines()-10);
			l.setText("Mines: "+Integer.toString(w.getMines()));
		}
	}
}