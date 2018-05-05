/**
* The GameWindow class draws and updates the game window 
*
* @version 0.1
* @author Julien Hoeglund
*/
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.URL;
import java.awt.image.BufferedImage;


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
        GameWindow window=new GameWindow(1116,954,0,0);
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
        title.setMaximumSize(new Dimension(200,100));
        title.setFont(new Font("TimesRoman",Font.PLAIN,40));
    	title.setForeground(Color.BLACK);
        menu();
        X=5;
        Y=5;
        mines=10;
     }
    public void configButton(GameButton b){
    	b.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    	b.setMaximumSize(new Dimension(300,25)); 
    }
    public void story(){
        getContentPane().removeAll();
        getContentPane().repaint();
        BackgroundPanel bp = new BackgroundPanel(this,2);
        bp.setLayout(new BoxLayout(bp, BoxLayout.Y_AXIS));
        bp.add(title);   
        this.add(bp);
        GameButton mg = new GameButton("Menu");
        MenuGame mgl = new MenuGame(this);
        mg.addActionListener(mgl);
        mg.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        configButton(mg);        
        bp.add(Box.createRigidArea(new Dimension(30,500)));
        bp.add(mg);
        this.pack();
    }
    public void menu(){
        getContentPane().removeAll();
        getContentPane().repaint();
        BackgroundPanel bp = new BackgroundPanel(this,1);
        bp.setLayout(new BoxLayout(bp, BoxLayout.Y_AXIS));
        this.add(bp);
        bp.add(title);
        bp.add(Box.createRigidArea(new Dimension(30,30)));
        
        GameButton ng = new GameButton("New Game");
        NewGame ngl = new NewGame(this);
        ng.addActionListener(ngl);
        configButton(ng);
        Boolean r=false;
        try{
            FileInputStream file = new FileInputStream("save.mns");
            DataInputStream flux = new DataInputStream(file);  
            ResumeGame rgl= new ResumeGame(this,grid,flux);
            GameButton rg = new GameButton("Resume");
            rg.addActionListener(rgl);
            configButton(rg);
            bp.add(rg);
            bp.add(Box.createRigidArea(new Dimension(30,30)));    
            bp.add(ng);
            bp.add(Box.createRigidArea(new Dimension(30,30)));    
            r=true;
        }catch(FileNotFoundException fnfe){
        }
        
        GameButton story = new GameButton("Story");
        story.setForeground(Color.WHITE);
        story.addActionListener(new StoryListener(this));
        GameButton qg = new GameButton("Quit");
        QuitGame qgl = new QuitGame(this,grid);
        qg.addActionListener(qgl);
        
        configButton(story);
        configButton(qg);
        
        bp.add(story);
        if(!r){
            bp.add(Box.createRigidArea(new Dimension(30,30)));    
            bp.add(ng);
        }
        bp.add(Box.createRigidArea(new Dimension(30,30)));    
        bp.add(qg);    
        bp.add(Box.createRigidArea(new Dimension(30,30)));
        
        this.pack();
    }
    public void config(){
        getContentPane().removeAll();
        getContentPane().repaint();
        
        BackgroundPanel bp = new BackgroundPanel(this,1);
        bp.setLayout(new BoxLayout(bp, BoxLayout.Y_AXIS));
        this.add(bp);
        
        bp.add(title);
        
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
        
        lwidth.setForeground(Color.WHITE);
        lheight.setForeground(Color.WHITE);
        lmines.setForeground(Color.WHITE);
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
    	
        bp.add(lwidth);        
        bp.add(pW);    
        bp.add(mW);    
        bp.add(Box.createRigidArea(new Dimension(30,30)));
        bp.add(lheight);    
        bp.add(pH);
        bp.add(mH);    
        bp.add(Box.createRigidArea(new Dimension(30,30)));
        bp.add(lmines);    
        bp.add(pM);    
        bp.add(mM);    
        bp.add(Box.createRigidArea(new Dimension(30,30)));
        bp.add(pg);
        bp.add(Box.createRigidArea(new Dimension(30,30)));
        bp.add(mg);    
        bp.add(Box.createRigidArea(new Dimension(30,30)));
        bp.add(qg);    
        
        this.pack();
    }
	public void runGame(boolean resumed){	
    	getContentPane().removeAll();
		getContentPane().repaint();

        BackgroundPanel bp = new BackgroundPanel(this,0);
        this.add(bp);
        
    	count = new JLabel(" Mines: " +Integer.toString(mines));
        count.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        count.setForeground(Color.WHITE);
        
        if(!resumed){
            grid=new Grid(X,Y,mines,count);
            grid.generate();
        }
        JPanel board = new JPanel(new GridLayout(X,Y)); 
        board.setPreferredSize(new Dimension(750,750));
        board.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
        board.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        MenuPanel menu = new MenuPanel(grid);
        menu.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        menu.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        menu.setPreferredSize(new Dimension(110,750));
        grid.setMenu(menu);
        
        for(int i=0;i<X*Y;i++){
    		Cell c = grid.getCell(i);
            c.setMaximumSize(new Dimension(50,50));
    		c.setMinimumSize(new Dimension(50,50));
    		c.addMouseListener(new CellListener(c,board,grid));
    		board.add(c);			
    	}
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                save();
            }
        });
        GameButton ng = new GameButton ("New Game",1);
        NewGame ngl = new NewGame(this);
    	ng.addActionListener(ngl);
    	
        GameButton sg = new GameButton("Save",1);
        sg.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
                save();
            }
        });
        
    	GameButton qg = new GameButton("Quit",1);
        QuitGame qgl = new QuitGame(this,grid);
        qg.addActionListener(qgl);
        
        GameButton mg = new GameButton("Menu",1);
        MenuGame mgl = new MenuGame(this);
        mg.addActionListener(mgl);
        
        ng.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    	ng.setMaximumSize(new Dimension(400,80)); 
        
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
        menu.add(Box.createRigidArea(new Dimension(30,30)));

        bp.add(Box.createRigidArea(new Dimension(500,85)));
        bp.add(board);
        bp.add(menu);
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
    public void save(){
        File fl = new File("save.mns");
        fl.delete();
        try{
            FileOutputStream file = new FileOutputStream("save.mns");
            DataOutputStream f = new DataOutputStream(file);  
            Cell[] cells = grid.getCells();
            f.writeInt(grid.getX());
            f.writeInt(grid.getY());
            f.writeInt(grid.getMines());           
            for(int i=0;i<cells.length;i++){
                f.writeInt(i);
                f.writeBoolean(cells[i].getRevealState());
                f.writeBoolean(cells[i].isMined());
                f.writeBoolean(cells[i].getExploded());
                f.writeInt(cells[i].getNeighbors());
                f.writeInt(cells[i].getFlag());
                f.writeBoolean(cells[i].getR());
                f.writeBoolean(cells[i].getDec());
            }
            f.close();
        }catch(IOException ioe){
            System.err.println("Error: could not save");
        }
    }
}