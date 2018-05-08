/**
* MinusMine is a button which decrements the number of mines   
*
* @version 0.1
* @author Julien Hoeglund
*/
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MinusMine implements ActionListener{
	private GameWindow w;
	private JLabel l;

	public MinusMine(GameWindow window, JLabel label){
		l=label;
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(w.getMines()>0){
			w.setMines(w.getMines()-1);
			l.setText("Mines: "+Integer.toString(w.getMines()));
		}
	}
}