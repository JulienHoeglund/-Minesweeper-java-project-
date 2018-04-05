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
		this.height=h;
		this.width=w;
		this.xPos=x;
		this.yPos=y;
		this.setSize(width,height);	
		this.setPreferredSize(new Dimension(width,height));
		this.setMinimumSize(new Dimension(width,height));
		this.setLocation(xPos, yPos);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int gridX=3, gridY=3; 
		grid=new Grid(gridX,gridY);
		//grid.generate(2);
		GridLayout layout=new GridLayout();
		
		JPanel panel=new JPanel(layout);
		
		for(int i=0;i<gridX*gridY;i++){
			
			grid.getCell(i).add(listener);
		}
				
		// TEST AVEC 1 CELL

		Cell testCell=new Cell(true,0);  
		CellListener listener=new CellListener();
		
		testCell.addMouseListener(listener);
		
		panel.add(testCell);
		this.add(panel);

		this.setVisible(true);
	}

}