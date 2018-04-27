import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MinusHeight implements ActionListener{
	private GameWindow w;
	private JLabel l;

	public MinusHeight(GameWindow window, JLabel label){
		l=label;
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(w.getY()>4){
			w.setY(w.getY()-1);
			l.setText("Height: "+Integer.toString(w.getY()));
		}
	}
}