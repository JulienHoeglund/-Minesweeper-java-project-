/**
* The Cell class holds information about a grid cell : location, whether it 
* has a mine or the number of mines around it, its display state, etc  
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
import javax.swing.*;
import java.awt.*;

public class Cell extends JButton{
	private boolean revealed;
	private boolean mined;
	private boolean doubt;
	private boolean certainty;
	private int neighbors;
	private Graphics g;
	private boolean defeat;
	private boolean clicked;
	private Grid grid;
	private int id;

	public Cell(Grid gd, int i){
		revealed=false;
		mined = false;
		neighbors = 0;
		doubt = false ;
		certainty = false;			
		defeat = false;
		clicked=false;
		grid=gd;
		id=i;
	}
	public void paintComponent(Graphics g){
		Graphics g2 = g.create();
		if(this.isOpaque()){	
			g2.setColor(Color.GRAY);
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
		}
		if(revealed){
			g2.setColor(Color.WHITE);
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
			if(neighbors!=0){
				String s = Integer.toString(neighbors);
				g2.setColor(Color.BLACK);
				Font font = new Font("TimesRoman", Font.PLAIN, 30);
				g2.setFont(font); 
				FontMetrics m = g2.getFontMetrics(font);
				int x = (this.getWidth() - m.stringWidth(s))/2;
				int y = (this.getHeight() - m.getHeight())/2;
				g2.drawString(s,x,y);				
			}
		}	
		if(revealed && neighbors==0 && !mined){
			grid.revealNeighbors(id);
		}
		if(revealed && mined){
			g2.setColor(Color.BLACK);
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
		}
	}
	public void setGraphics(Graphics graphics){
		g=graphics;
	}public boolean isMined(){
		return mined;
	}
	public void setRevealed(){
		revealed=true;
	}
	public void setClicked(){
		clicked=true;
	}
	public void setNeighbors(int n){
		neighbors=n;
	}
	public boolean getRevealState(){
		return revealed; 
	}
	public void setMined(){
		mined=true;
	}
	public int getNeighbors(){
		return neighbors;
	}
	public void setUserDoubt()
	{
		doubt = true;
	}
	public void setUserCertainty()
	{	
		certainty = true;
	}
	public void setDoubtLess()
	{
		doubt = false;
		certainty = false;		
	}
	public boolean getGameState(){
		return defeat;
	}
	public void setDefeat(){
		defeat=true;
	}
}