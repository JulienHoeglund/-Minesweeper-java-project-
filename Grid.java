/**
* The Grid class draws and updates the game grid holding cells
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/

import java.util.Random;

public class Grid{
	private Cell[] cells;
	public Grid(int sizeX, int sizeY){
		cells=new Cell[sizeX*sizeY];
		for (int i=0;i<cells.length;i++)
			cells[i]=new Cell(false,0);
	}
	public void generate(int mines){
		Random rand=new Random();
		rand.nextInt(1);
		for (int i=0;i<mines;i++){
			int x=rand.nextInt(cells.length+1);
			cells[i].setMined();
		}
	}
	public Cell getCell(int index){
		return cell[index];
	}
}