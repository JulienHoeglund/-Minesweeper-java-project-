/**
* The GameWindow class draws and updates the game window 
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame
{
	private int height,width,xPos,yPos;
	private Grid grid;

	public GameWindow(int w, int h, int x, int y)
	{
		this.height = h;
		this.width = w;
		this.xPos = x;
		this.yPos = y;
		this.setSize(width,height);	
		this.setPreferredSize(new Dimension(width,height));
		this.setMinimumSize(new Dimension(width,height));
		//this.setMaximumSize(new Dimension(width,height));	

		this.setLocation(xPos, yPos);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		grid=new Grid(20,20);
		grid.generate(10);

		GridLayout layout = new GridLayout(5,5);
		
		JPanel panel = new JPanel();

		/*for(Cell cell : grid.getGrid()){
		}
		*/
		Cell testCell= new Cell(true,0); // test d'affichage 1 cell 
		CellListener listener = new CellListener();
		testCell.add(listener);

		this.setVisible(true);
	}

}