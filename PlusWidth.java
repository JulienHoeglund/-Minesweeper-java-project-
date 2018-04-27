import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PlusWidth implements ActionListener{
	private GameWindow w;
	private JLabel l;

	public PlusWidth(GameWindow window, JLabel label){
		l=label;
		w=window;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(w.getX()<30){
			w.setX(w.getX()+1);
			l.setText("Width: "+Integer.toString(w.getX()));
		}
	}
}