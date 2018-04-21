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
	public Cell(){
		revealed=false;
		mined = false;
		neighbors = 0;
		doubt = false ;
		certainty = false;			
		defeat = false;
		clicked=false;
	}
	public void paintComponent(Graphics g){
		Graphics g2 = g.create();
		if(this.isOpaque()){	
			g2.setColor(this.getBackground());
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
		}
		if(clicked){
			g2.setColor(Color.BLACK);
			g2.drawString(Integer.toString(neighbors),15,15);				
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