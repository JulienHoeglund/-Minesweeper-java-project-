import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
* PlusTime adds 1 mine to the game.   
*
* @version 0.1
* @author Julien Hoeglund
*/
public class PlusMine implements ActionListener{
	private GameWindow w;
	private JLabel l;
	public PlusMine(GameWindow window, JLabel label){
		l=label;
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(w.getMines()<w.getX()*w.getY()){
			w.setMines(w.getMines()+1);
			l.setText("Mines: "+Integer.toString(w.getMines()));
		}
	}
}