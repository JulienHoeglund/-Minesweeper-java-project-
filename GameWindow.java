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
    private int X;
    private int Y;
    private int mines;
    public GameWindow(int w, int h, int x, int y){
		this.setTitle("(Play with) Minerves");
		this.setPreferredSize(new Dimension(w,h));
		this.setLocation(x, y);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        end=false;
        menu();
        X=4;
        Y=4;
        mines=0;
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
    public void config(){
        getContentPane().removeAll();
        getContentPane().repaint();

        JPanel menu = new JPanel();
        
        JLabel lwidth = new JLabel("Width: 4"); 
        JButton mW = new JButton("-");
        mW.addActionListener(new MinusWidth(this,lwidth));
        JButton pW = new JButton("+");
        pW.addActionListener(new PlusWidth(this,lwidth));
                
        JLabel lheight = new JLabel("Height: 4"); 
        JButton mH = new JButton("-");
        mH.addActionListener(new MinusHeight(this,lheight));
        JButton pH = new JButton("+");
        pH.addActionListener(new PlusHeight(this,lheight));

        
        JLabel lmines = new JLabel("Mines");
        JButton mM = new JButton("-");
        mM.addActionListener(new MinusMine(this,lmines));
        
        JButton pM = new JButton("+");
        pM.addActionListener(new PlusMine(this,lmines));

        JButton pg = new JButton ("Play Game ");
        
        PlayGameButton pgl = new PlayGameButton(this);
        pg.addActionListener(pgl);
        
        menu.add(lwidth);        
        menu.add(mW);    
        menu.add(pW);    
        menu.add(lheight);    
        menu.add(mH);    
        menu.add(pH);
        menu.add(lmines);    
        menu.add(mM);    
        menu.add(pM);    
        menu.add(pg);    
        
        this.add(menu,BorderLayout.CENTER);
        this.pack();
    }
	public void runGame(){	
    	getContentPane().removeAll();
		getContentPane().repaint();
    	this.setLayout(new BorderLayout());
    	
        JLabel count = new JLabel(" Mines: " +Integer.toString(mines));
        
        grid=new Grid(X,Y,mines,count);
        
        MinePanel board = new MinePanel(new GridLayout(X,Y),grid); 
        MenuPanel menu = new MenuPanel(new GridLayout(0,1),grid);
    	grid.setMenu(menu);
        grid.generate();
        
        for(int i=0;i<X*Y;i++){
    		Cell c = grid.getCell(i);
    		c.setPreferredSize(new Dimension(30,30));
    		c.addMouseListener(new CellListener(c,board,grid));
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
    public void setX(int x){
        X=x;
    }
    public void setY(int y){
        Y=y;
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public int getMines(){
        return mines;
    }
    public void setMines(int m){
        mines=m;
    }    
}