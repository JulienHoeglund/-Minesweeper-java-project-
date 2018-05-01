/**
* MinePanel is a class used to manage the different game views  
*
* @version 0.1
* @author Julien Hoeglund
*/
import javax.swing.*;
import java.awt.*;

public class MinePanel extends JPanel{
	private boolean end;
	private boolean victory;
	private Grid grid;
	public MinePanel(GridLayout layout, Grid g){
		super(layout);
		grid=g;
	}
	@Override
	public void paintComponent(Graphics g){
		Graphics g2 = g.create();
		if(this.isOpaque()){	
			g2.setColor(this.getBackground());
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
		}
		if(end){
			g2.setColor(Color.RED);
			if(victory){
				g2.drawString("Victory !",490,50);
			}
			else{
				g2.drawString("Defeat !",490,50);
			}
			grid.revealAll();
		}
	}
	public void setEnd(boolean v){
		end=true;
		victory=v;
	}
}