/**
* MinePanel is a class used to manage the different game views  
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel{
	private boolean end;
	private boolean victory;
	private Grid grid;
	public MenuPanel(GridLayout layout, Grid g){
		super(layout);
		grid=g;
	}public MenuPanel(){
		super();
	}
	@Override
	public void paintComponent(Graphics g){
		Graphics g2 = g.create();
		Font font = new Font("TimesRoman", Font.PLAIN, 20);
		g2.setFont(font); 		
		if(this.isOpaque()){	
			g2.setColor(this.getBackground());
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
		}
		if(end){
			g2.setColor(Color.RED);
			if(victory){
				g2.drawString("Victory !",(this.getWidth()/2)-40,this.getWidth()/2);
			}
			else{

				g2.drawString("Defeat !",(this.getWidth()/2)-40,this.getWidth()/2);
			}
		}
	}
	public void setEnd(boolean v){
		end=true;
		victory=v;
	}
}