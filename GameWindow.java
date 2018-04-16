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
		grid.generateMines(2);
		
		GridLayout layout=new GridLayout();
		JPanel panel=new JPanel(layout);
		this.setLayout(new FlowLayout());
		for(int i=0;i<gridX*gridY;i++){
			Cell c = grid.getCell(i);
			c.setPreferredSize(new Dimension(50,50));
			c.addMouseListener(new CellListener(c));
			panel.add(c);
			System.out.println(c.isMined());
		}
		this.add(panel);
		this.setVisible(true);
	}

}