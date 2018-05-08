/**
* MinePanel is a class used to manage the different game views  
*
* @version 0.1
* @author Julien Hoeglund
*/
import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel{
	private boolean end;
	private boolean victory;
	private Grid grid;
	private Image s;
	public MenuPanel(Grid g){
		super();
		this.setLayout(new BoxLayout((this), BoxLayout.Y_AXIS));
		grid=g;
	}
	@Override
	public void paintComponent(Graphics g){
		Graphics g2 = g.create();
		Font font = new Font("", Font.PLAIN, 20);
		g2.setFont(font); 		
		if(this.isOpaque()){	
			g2.setColor(Color.BLACK);
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
		}
		if(end){
			g2.setColor(Color.WHITE);
			if(victory){
				g2.drawString("Victory !",(this.getWidth()/2)-35,this.getWidth()/2);
				font = new Font("Herculanum", Font.ITALIC, 13);
				g2.setFont(font); 		
				g2.setColor(Color.RED);
				g2.drawString("You beat",this.getWidth()/2-25,(this.getWidth()/2+20));
				g2.drawString("Minerva",this.getWidth()/2-20,(this.getWidth()/2+33));
			}
			else{
				g2.drawString("Defeat !",(this.getWidth()/2)-35,this.getWidth()/2);
				font = new Font("Herculanum", Font.ITALIC, 13);
				g2.setFont(font); 		
				g2.setColor(Color.RED);
				g2.drawString("Minerva tricked",5,(this.getWidth()/2+20));
				g2.drawString("you",this.getWidth()/2-15,(this.getWidth()/2+33));
			}
		}
	}
	public void setEnd(boolean v){
		end=true;
		victory=v;
	}
}