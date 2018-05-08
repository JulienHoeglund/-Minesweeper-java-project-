/**
* GameButton is a class used to make beautiful custom buttons  
*
* @version 0.1
* @author Julien Hoeglund
*/
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class GameButton extends JButton{
	public GameButton(){
		this.setFocusable(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setBackground(new Color(0, 51, 102));
		this.setOpaque(true);
	}
	public GameButton(String s){
		super(s);
		this.setFocusable(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(true);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.WHITE);
	}
	public GameButton(String s, int x){
		super(s);
		this.setFocusable(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setForeground(Color.WHITE);
	}
	
}
