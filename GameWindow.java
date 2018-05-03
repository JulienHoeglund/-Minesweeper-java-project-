/**
* The GameWindow class draws and updates the game window 
*
* @version 0.1
* @author Julien Hoeglund
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GameWindow extends JFrame{
	private int height,width,xPos,yPos;
	private Grid grid;
	private boolean end;
    private int X;
    private int Y;
    private int mines;
    private JLabel count;
    public static void main(String[] args){
        GameWindow window=new GameWindow(1000,1000,0,0);
    } 
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
        mines=1;
    }
    public void menu(){
        JPanel menu = new JPanel();
        count = new JLabel(" Mines: " +Integer.toString(mines));
        try{
            FileInputStream file = new FileInputStream("save.mns");
            DataInputStream flux = new DataInputStream(file);  
            ResumeGame rgl= new ResumeGame(this,grid,flux);
            GameButton rg = new GameButton("Resume");
            rg.addActionListener(rgl);
            menu.add(rg);    
        }catch(FileNotFoundException fnfe){
        }
        GameButton ng = new GameButton ("New Game ");
        NewGame ngl = new NewGame(this);
        ng.addActionListener(ngl);
        GameButton qg = new GameButton("Quit");
        QuitGame qgl = new QuitGame(this,grid);
        qg.addActionListener(qgl);
        
        menu.add(ng);    
        menu.add(qg);    
        this.add(menu,BorderLayout.CENTER);
        this.pack();
    }
    public void config(){
        getContentPane().removeAll();
        getContentPane().repaint();

        JPanel menu = new JPanel();
        
        JLabel lwidth = new JLabel("Width: "+X); 
        GameButton mW = new GameButton("-");
        mW.addActionListener(new MinusWidth(this,lwidth));
        GameButton pW = new GameButton("+");
        pW.addActionListener(new PlusWidth(this,lwidth));
                
        JLabel lheight = new JLabel("Height: "+Y); 
        GameButton mH = new GameButton("-");
        mH.addActionListener(new MinusHeight(this,lheight));
        GameButton pH = new GameButton("+");
        pH.addActionListener(new PlusHeight(this,lheight));

        
        JLabel lmines = new JLabel("Mines: "+mines);
        GameButton mM = new GameButton("-");
        mM.addActionListener(new MinusMine(this,lmines));
        
        GameButton pM = new GameButton("+");
        pM.addActionListener(new PlusMine(this,lmines));

        GameButton pg = new GameButton ("Play Game ");
        
        PlayGame pgl = new PlayGame(this);
        pg.addActionListener(pgl);
        
        GameButton qg = new GameButton("Quit");
        QuitGame qgl = new QuitGame(this,grid);
        qg.addActionListener(qgl);
        
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
        menu.add(qg);    
        
        this.add(menu,BorderLayout.CENTER);
        this.pack();
    }
	public void runGame(boolean resumed){	
    	getContentPane().removeAll();
		getContentPane().repaint();
    	this.setLayout(new BorderLayout());
    	
        count = new JLabel(" Mines: " +Integer.toString(mines));
        if(!resumed){
            grid=new Grid(X,Y,mines,count);
            grid.generate();
        }
        JPanel board = new JPanel(new GridLayout(X,Y)); 
        MenuPanel menu = new MenuPanel(new GridLayout(0,1),grid);
    	grid.setMenu(menu);
        
        for(int i=0;i<X*Y;i++){
    		Cell c = grid.getCell(i);
    		c.setPreferredSize(new Dimension(30,30));
    		c.addMouseListener(new CellListener(c,board,grid));
    		board.add(c);			
    	}

    	GameButton ng = new GameButton ("New Game ");
    	NewGame ngl = new NewGame(this);
    	ng.addActionListener(ngl);
    	
        GameButton sqg = new GameButton("Save and quit  ");
        SaveQuitGame sqgl = new SaveQuitGame(this,grid);
        sqg.addActionListener(sqgl);
        
        menu.add(count);
        menu.add(ng);
    	menu.add(sqg);

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
    public JLabel getCount(){
        return count;
    }    
    public void setGrid(Grid g){
        grid=g;
    }
}