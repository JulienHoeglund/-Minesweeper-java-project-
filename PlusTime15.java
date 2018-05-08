/**
* PlusTime15 is a button which adds 15 seconds to the game timer   
*
* @version 0.1
* @author Julien Hoeglund , Valentin Lefebure
*/
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PlusTime15 implements ActionListener{
	private GameWindow w;
	private JLabel l;
	private int min;
	private int sec;

	public PlusTime15(GameWindow window, JLabel label){
		l=label;
		w=window;
		w.setTime(0);
	}
	@Override
	public void actionPerformed(ActionEvent e){
			w.setTime(w.getTime()+15);
			min = w.getTime()/60;
			sec = w.getTime()%60;
			l.setText("Timer: "+Integer.toString(min) +" min."+Integer.toString(sec) +" sec." );
	}
}