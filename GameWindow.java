/**
* The GameWindow class draws and updates the game window 
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame{
	private int height,width,xPos,yPos;
	private Grid grid;
	private boolean end;
    public GameWindow(int w, int h, int x, int y){
		this.setTitle("Minesweeper");
		this.setPreferredSize(new Dimension(w,h));
		this.setLocation(x, y);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        end=false;
        menu();
    }
    public void menu(){
        JPanel menu = new JPanel();
        JButton rg = new JButton("Resume");
        JButton ng = new JButton ("New Game ");
        NewGameButton ngl = new NewGameButton(this);
        ng.addActionListener(ngl);
        JButton qg = new JButton("Quit");
        QuitGameButton qgl = new QuitGameButton(this,grid);
        qg.addActionListener(qgl);
        menu.add(rg);    
        menu.add(ng);    
        menu.add(qg);    
        this.add(menu,BorderLayout.CENTER);
        this.pack();
    }
	public void runGame(){	
    	getContentPane().removeAll();
		getContentPane().repaint();
    	this.setLayout(new BorderLayout());
    	
        int gridX=10, gridY=10,mines=10; 
    	JLabel count = new JLabel(Integer.toString(mines)+" mines");
        
        grid=new Grid(gridX,gridY,mines,count);
        grid.generate();
        
        MinePanel board = new MinePanel(new GridLayout(gridX,gridY),grid); 
        MenuPanel menu = new MenuPanel(new GridLayout(0,1),grid);
        
    	for(int i=0;i<gridY*gridX;i++){
    		Cell c = grid.getCell(i);
    		c.setPreferredSize(new Dimension(30,30));
    		c.addMouseListener(new CellListener(c,board,menu,grid));
    		board.add(c);			
    	}

    	JButton ng = new JButton ("New Game ");
    	NewGameButton ngl = new NewGameButton(this);
    	ng.addActionListener(ngl);
    	
        JButton qg = new JButton("Save and quit  ");
        QuitGameButton qgl = new QuitGameButton(this,grid);
        qg.addActionListener(qgl);
        
        menu.add(count);
        menu.add(ng);
    	menu.add(qg);

        this.add(board,BorderLayout.CENTER);
    	this.add(menu,BorderLayout.EAST);
    	this.pack();
    }
    public void setEnd(){
        end=true;
    } 
}