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
	}
	public GameButton(String s){
		super(s);
		this.setFocusable(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
	}
	public GameButton(String s, int x){
		super(s);
		this.setFocusable(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setForeground(Color.WHITE);
	}
	
}
