/**
* The Grid class draws and updates the game grid 
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
public class Grid{
	private Cell[] cells;

	public Grid(int sizeX, int sizeY){
		cells = new Cells[sizeX*sizeY];
	}
}