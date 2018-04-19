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
	private boolean victory;
	private boolean defeat;

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
		int gridX=10, gridY=10; 
		grid=new Grid(gridX,gridY);
		grid.generateMines(40);
		JLabel timer = new JLabel("Timer : 30s");	
		JLabel blank = new JLabel("Number of mines : 12");
		JPanel panel=new JPanel(new GridLayout(gridX,gridY)); 
		for(int i=0;i<gridY*gridX;i++){
			Cell c = grid.getCell(i);
			c.setPreferredSize(new Dimension(30,30));
			c.addMouseListener(new CellListener(c,this));
			panel.add(c);			
		}
		
		this.add(timer,BorderLayout.WEST);
		this.add(panel,BorderLayout.CENTER);
		this.add(blank,BorderLayout.EAST);
		this.pack();
		this.setVisible(true);
		
		for(int i=0;i<gridY*gridX;i++){
			Cell c = grid.getCell(i);
			if(c.getVictoryState()){
				getContentPane().removeAll();
				revalidate();
				repaint();
			}
		}
	}
}