import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
* MinusTime is a button which substracts 1 minute to the game timer.   
*
* @version 0.1
* @author Julien Hoeglund , Valentin Lefebure
*/
public class MinusTime implements ActionListener{
	private GameWindow w;
	private JLabel l;
	private int min;
	private int sec;

	public MinusTime(GameWindow window, JLabel label){
		l=label;
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if (w.getTime() > 60){
			w.setTime(w.getTime()- 60);
			min = w.getTime()/60;
			sec = w.getTime()%60;
		
			l.setText("Timer: "+Integer.toString(min) +" min."+Integer.toString(sec) +" sec." );
		}
		
	}
}