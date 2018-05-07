/*
	Plus10Mine is a class which adds 10 mines to the total of mines on the grid
*/

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Plus10Mine implements ActionListener{
	private GameWindow w;
	private JLabel l;

	public Plus10Mine(GameWindow window, JLabel label){
		l=label;
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(w.getMines()<w.getX()*w.getY()){
			w.setMines(w.getMines()+10);
			l.setText("Mines: "+Integer.toString(w.getMines()));
		}
	}
}