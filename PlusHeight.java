import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PlusHeight implements ActionListener{
	private GameWindow w;
	private JLabel l;

	public PlusHeight(GameWindow window, JLabel label){
		l=label;
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(w.getY()<30){
			w.setY(w.getY()+1);
			l.setText("Height: "+Integer.toString(w.getY()));
		}
	}
}