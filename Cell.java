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

	public Cell(boolean mine, int n){
		revealed=false;
		mined = mine;
		neighbours = n;
		doubt = false ;
		certainty = false;			
	}
	public void paintComponent(Graphics g){
		Graphics g2 = g.create();
		if(this.isOpaque()){	
			g2.setColor(this.getBackground());
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
		}
			this.setForeground(Color.RED);
			if(this.isMined()){
				g2.fillRect(0,0,this.getWidth(),this.getHeight());
				System.out.println("Mined!");
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
}