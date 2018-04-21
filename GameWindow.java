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
		this.setTitle("MindSweeper!");
		this.setPreferredSize(new Dimension(width,height));
		this.setMaximumSize(new Dimension(width,height));
		this.setLocation(xPos, yPos);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	int gridX=10, gridY=10,mines=40; 
    	grid=new Grid(gridX,gridY);
    	grid.generateMines(mines);
    	
    	JLabel timer = new JLabel("Timer : 30s");	
    	JLabel blank = new JLabel("Number of mines : " + mines);
    	MinePanel board = new MinePanel(new GridLayout(gridX,gridY),grid); 
    	MenuPanel menu = new MenuPanel(new GridLayout(0,1));

    	for(int i=0;i<gridY*gridX;i++){
    		Cell c = grid.getCell(i);
    		c.setPreferredSize(new Dimension(30,30));
    		c.addMouseListener(new CellListener(c,board));
    		board.add(c);			
    	}
    	
    	JButton ng = new JButton ("New Game ");
    	JButton rg = new JButton ("Resume Game ");
    	menu.add(ng);
    	menu.add(rg);

    	this.add(board,BorderLayout.CENTER);
    	this.add(menu,BorderLayout.EAST);
    	this.pack();
    	this.setVisible(true);
		}
}