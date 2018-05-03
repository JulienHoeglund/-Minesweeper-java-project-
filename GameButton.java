/**
* GameButton is a class used to make beautiful custom buttons  
*
* @version 0.1
* @author Julien Hoeglund
*/
import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton{
	public GameButton(){
		super();
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
	}public GameButton(String s){
		super(s);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
	}
	
}
