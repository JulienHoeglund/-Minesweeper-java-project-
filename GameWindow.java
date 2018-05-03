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
    private JLabel title;
    public static void main(String[] args){
        GameWindow window=new GameWindow(1000,1000,0,0);
    } 
    public GameWindow(int w, int h, int x, int y){
		String t = new String("Minerves");
		this.setTitle(t);
		this.setPreferredSize(new Dimension(w,h));
		this.setLocation(x, y);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        end=false;
        title = new JLabel(t);
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        title.setMaximumSize(new Dimension(100,100));
        title.setFont(new Font("",Font.PLAIN,20));
    	menu();
        X=4;
        Y=4;
        mines=1;
     }
    public void configButton(GameButton b){
    	b.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    	b.setMaximumSize(new Dimension(300,25)); 
    }
    public void menu(){
        getContentPane().removeAll();
        getContentPane().repaint();
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(30,30)));
        try{
            FileInputStream file = new FileInputStream("save.mns");
            DataInputStream flux = new DataInputStream(file);  
            ResumeGame rgl= new ResumeGame(this,grid,flux);
            GameButton rg = new GameButton("Resume");
            rg.addActionListener(rgl);
            configButton(rg);
            this.add(rg);
            this.add(Box.createRigidArea(new Dimension(30,30)));    
        }catch(FileNotFoundException fnfe){
        }
        GameButton ng = new GameButton ("New Game ");
        NewGame ngl = new NewGame(this);
        ng.addActionListener(ngl);
        GameButton qg = new GameButton("Quit");
        QuitGame qgl = new QuitGame(this,grid);
        qg.addActionListener(qgl);
        ng.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        qg.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        configButton(ng);
        configButton(qg);
        
        this.add(ng);
        this.add(Box.createRigidArea(new Dimension(30,30)));    
        this.add(qg);    
        this.add(Box.createRigidArea(new Dimension(30,30)));
        this.pack();
    }
    public void config(){
        getContentPane().removeAll();
        getContentPane().repaint();
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.add(title);
        
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
        lmines.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        GameButton mM = new GameButton("-");
        mM.addActionListener(new MinusMine(this,lmines));
        
        GameButton pM = new GameButton("+");
        pM.addActionListener(new PlusMine(this,lmines));

        GameButton pg = new GameButton ("Create");
        
        PlayGame pgl = new PlayGame(this);
        pg.addActionListener(pgl);
        
        GameButton qg = new GameButton("Quit");
        QuitGame qgl = new QuitGame(this,grid);
        qg.addActionListener(qgl);

        GameButton mg = new GameButton("Menu");
        MenuGame mgl = new MenuGame(this);
        mg.addActionListener(mgl);
        
        lwidth.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        mW.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        pW.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        lheight.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        mH.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        pH.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        lmines.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        pM.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        mM.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        pg.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        mg.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        qg.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    	
        this.add(lwidth);        
        this.add(pW);    
        this.add(mW);    
        this.add(Box.createRigidArea(new Dimension(30,30)));
        this.add(lheight);    
        this.add(pH);
        this.add(mH);    
        this.add(Box.createRigidArea(new Dimension(30,30)));
        this.add(lmines);    
        this.add(pM);    
        this.add(mM);    
        this.add(Box.createRigidArea(new Dimension(30,30)));
        this.add(pg);
        this.add(Box.createRigidArea(new Dimension(30,30)));
        this.add(mg);    
        this.add(Box.createRigidArea(new Dimension(30,30)));
        this.add(qg);    
        
        this.pack();
    }
	public void runGame(boolean resumed){	
    	getContentPane().removeAll();
		getContentPane().repaint();
    	this.setLayout(new BorderLayout());
    	count = new JLabel(" Mines: " +Integer.toString(mines));
        count.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        count.setForeground(Color.WHITE);
        
        if(!resumed){
            grid=new Grid(X,Y,mines,count);
            grid.generate();
        }
        JPanel board = new JPanel(new GridLayout(X,Y)); 
        MenuPanel menu = new MenuPanel(grid);
    	grid.setMenu(menu);
        
        for(int i=0;i<X*Y;i++){
    		Cell c = grid.getCell(i);
    		c.setPreferredSize(new Dimension(30,30));
    		c.addMouseListener(new CellListener(c,board,grid));
    		board.add(c);			
    	}

    	GameButton ng = new GameButton ("New Game",1);
    	NewGame ngl = new NewGame(this);
    	ng.addActionListener(ngl);
    	
        GameButton sg = new GameButton("Save",1);
        SaveGame sgl = new SaveGame(this,grid);
        sg.addActionListener(sgl);
        
    	GameButton qg = new GameButton("Quit",1);
        QuitGame qgl = new QuitGame(this,grid);
        qg.addActionListener(qgl);
        
        GameButton mg = new GameButton("Menu",1);
        MenuGame mgl = new MenuGame(this);
        mg.addActionListener(mgl);
        
        ng.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    	ng.setMaximumSize(new Dimension(300,40)); 
        
        sg.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    	sg.setMaximumSize(new Dimension(300,40)); 
    	
    	qg.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    	qg.setMaximumSize(new Dimension(300,40)); 
    	
    	mg.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    	mg.setMaximumSize(new Dimension(300,40)); 
    	
        menu.add(Box.createRigidArea(new Dimension(30,100)));
        menu.add(count);
        menu.add(Box.createRigidArea(new Dimension(30,100)));
        menu.add(ng);
        menu.add(Box.createRigidArea(new Dimension(30,100)));
    	menu.add(mg);
        menu.add(Box.createRigidArea(new Dimension(30,100)));
    	menu.add(sg);
    	menu.add(Box.createRigidArea(new Dimension(30,100)));
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
    public JLabel getCount(){
        return count;
    }    
    public void setGrid(Grid g){
        grid=g;
    }
}