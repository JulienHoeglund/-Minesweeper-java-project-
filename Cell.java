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
	private boolean mined;
	private boolean doubt;
	private boolean certainty;
	private int neighbours;

	public Cell(boolean mine, int n){
		boolean isMined = mine;
		int neighbours = n;
		boolean doubt = false ;
		boolean certainty = false;			
	}
	public boolean isMined(){
		return mined;
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