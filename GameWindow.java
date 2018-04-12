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
		grid.generate(2);
		
		GridLayout layout=new GridLayout();
		JPanel panel=new JPanel(layout);
		
		CellListener listener=new CellListener();
		Cell c; 
		for(int i=0;i<gridX*gridY;i++){
			c = grid.getCell(i);
			//c.setGraphics(this.getGraphics);
			c.addMouseListener(new CellListener(getCell(i)));
			panel.add(grid.getCell(i));
		}
		this.add(panel,BorderLayout.CENTER);
		this.setVisible(true);
	}

}