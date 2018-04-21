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
	private int neighbours;
	private Graphics g;
	private boolean defeat;
	public Cell(){
		revealed=false;
		mined = false;
		neighbours = 0;
		doubt = false ;
		certainty = false;			
		defeat = false;
	}
	public void paintComponent(Graphics g){
		Graphics g2 = g.create();
		if(this.isOpaque()){	
			g2.setColor(this.getBackground());
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
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
	public boolean getRevealState(){
		return revealed; 
	}
	public void setMined(){
		mined=true;
	}
	public int getNeighbours(){
		return neighbours;
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