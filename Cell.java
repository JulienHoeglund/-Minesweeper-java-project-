	/**
* The Cell class holds information about a g cell : location, whether it 
* has a mine or the number of mines around it, its display state, etc  
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
import javax.swing.*;
import java.awt.*;

public class Cell extends JButton{
	private boolean revealed;
	private boolean mined;
	private boolean exploded;
	private int neighbors;
	private Graphics gs;
	private boolean defeat;
	private Grid g;
	private int id;
	private int f; // flag : 0 null, 1 certain, 2 doubt
	private Image q;
	private Image s;
	private boolean dec;
	private boolean r;
	private MenuPanel m;
	public Cell(Grid gd, int i){
		super();
		revealed=false;
		mined = false;
		neighbors = 0;
		defeat = false;
		exploded=false;
		g=gd;
		id=i;
		f=0;
		q = Toolkit.getDefaultToolkit().getImage("img/questionmark.png");
		s = Toolkit.getDefaultToolkit().getImage("img/star.png");
		dec=false;
		r=false;
	}
	public void drawFlag(Graphics g2){
		switch(f){
			case 1: //g2.drawImage(star,30,30,this);
				g2.drawString("*",30,30);
				break;	
			case 2: //g2.drawImage(qmark,30,30,this);
				g2.drawString("?",30,30);
				break;	
		}
	}
	public void paintComponent(Graphics g1){
		Graphics g2 = g1.create();
		if(this.isOpaque()){	
			g2.setColor(Color.GRAY);
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
		}
		Font font = new Font("TimesRoman", Font.PLAIN, 30);
		g2.setColor(Color.WHITE);
		g2.setFont(font); 		
		if(!revealed){
			drawFlag(g2);	
		}
		if(revealed){
			g2.setColor(Color.WHITE);
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
			if(getFlag()==1 && !dec){
                dec=true;
                g.decFlagCount();
        		g.updateLabel();
            }
            if(!mined && !r){
                r=true;
                g.decCellsLeft();
                System.out.println(g.getCellsLeft());
                if(g.getCellsLeft()==0 && g.getGameState()!=2)
                    g.setEnd(true);
                if(f==1 && g.getGameState()!=0){	
					g2.setColor(Color.RED);
					g2.drawString("...",30,30);
				}
            }
			if(neighbors!=0){
				String s = Integer.toString(neighbors);
				g2.setColor(Color.BLACK);
				FontMetrics m = g2.getFontMetrics(font);
				int x = (this.getWidth() - m.stringWidth(s))/2;
				int y = ((this.getHeight() - m.getHeight())/2)+15;
				g2.drawString(s,x,y);				
			}
			if(!mined && neighbors==0){
				g.revealNeighbors(id);
			}
			if(mined){
				g2.setColor(Color.BLACK);
				g2.fillRect(0,0,this.getWidth(),this.getHeight());
				drawFlag(g2);
				if(exploded){
					g2.setColor(Color.RED);
					g2.fillRect(0,0,this.getWidth(),this.getHeight());
				    g.setEnd(false);     //false=defeat
					System.out.println(id+": "+"b");
				}
				if(f==0){
					g2.setColor(Color.RED);
					g2.drawString("!",30,30);
				}
			}
		}
	}
	public void setGraphics(Graphics graphics){
		gs=graphics;
	}public boolean isMined(){
		return mined;
	}
	public void setRevealed(boolean x){
		revealed=true;
		if(x)
			exploded=x;
	}
	public void setNeighbors(int n){
		neighbors=n;
	}
	public boolean getRevealState(){
		return revealed; 
	}
	public void setMined(){
		mined=true;
	}
	public int getNeighbors(){
		return neighbors;
	}
	public int getFlag(){
		return f;
	}
	public void setFlag(int flag){
		f=flag;
	}
}