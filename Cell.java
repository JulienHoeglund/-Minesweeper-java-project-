/**
* The Cell class holds information about a grid cell :  location, whether it 
* has a mine or the number of mines around it, its display state, etc  
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
import javax.swing.*;
import java.awt.*;

public class Cell extends JComponent{
	private boolean mined;
	private boolean doubt;
	private boolean certainty;
	private int neighbours;

	public Cell(boolean mine, int n){
		boolean isMined = mine;
		int neighbours = n;
		int doubt = 0;			
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
	public void userDoubt()
	{
		doubt = true;
	}
	public void userCertainty()
	{	
		certainty = true;
	}
}