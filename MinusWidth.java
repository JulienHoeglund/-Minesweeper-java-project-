/**
* MinusWidth is a button which decrements the number of cell columns    
*
* @version 0.1
* @author Julien Hoeglund
*/
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MinusWidth implements ActionListener{
	private GameWindow w;
	private JLabel l;

	public MinusWidth(GameWindow window, JLabel label){
		l=label;
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(w.getX()>4){
			w.setX(w.getX()-1);
			l.setText("Width: "+Integer.toString(w.getX()));
		}
	}
}