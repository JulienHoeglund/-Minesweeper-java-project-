/**
* The Grid class draws and updates the game grid 
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
import java.util.Random;
import javax.swing.*;
import java.awt.*;
public class Grid{
	private Cell[] cells;
	public Grid(int sizeX, int sizeY){
		cells = new Cell[sizeX*sizeY];
	}
	public void generate(int mines){
		Random rand = new Random();
		for(int i = 0; i < mines ; i++){
			int x = rand.nextInt((cells.length)+1);
			cells[x].setMined();
		}
	}
	public Cell[] getGrid(){
		return cells;
	}
}