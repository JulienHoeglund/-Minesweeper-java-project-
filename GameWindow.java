import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame
{
	private int height,width,xPos,yPos;
	private Grid grid;

	public GameWindow(int w, int h, int x, int y)
	{
		this.fenetre = new JFrame();
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
		grid.generate();

	}

}