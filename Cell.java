/**
* The Cell class holds information about a grid cell :  location, whether it 
* has a mine or the number of mines around it, its display state, etc  
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
import javax.swing.*;
import java.awt.*;

public class Cell extends AbstractButton{
	private boolean isMined;
	private int neighbours;

	public Cell(boolean mine, int n){
		boolean isMined = mine;
		int neighbours = n;			
	}
}