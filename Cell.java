/**
* The Cell class holds information about a g cell : location, whether it 
* has a mine or the number of mines around it, its display state, etc  
*
* @version 0.1
* @author Julien Hoeglund
*/
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;

public class Cell extends GameButton{
	private int id;
	private boolean revealed;
	private boolean mined;
	private boolean exploded;
	private int neighbors;
	private int f; // flag : 0 null, 1 certain, 2 doubt
	private boolean dec;
	private boolean r;
	private Grid g;
	private boolean defeat;
	private BufferedImage img;
	private BufferedImage explosion;
	
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
		dec=false;
		r=false;
	}
	public void drawFlag(Graphics g2){
		switch(f){
			case 1: 
				g2.drawString("*",(this.getWidth()/2)-5,(this.getHeight()/2)+5);
				break;	
			case 2: 
				g2.drawString("?",(this.getWidth()/2)-5,(this.getHeight()/2)-5);
				break;	
		}
	}
	private BufferedImage loadImage(){
		URL imagePath = getClass().getResource("mine.png");
		BufferedImage result = null;
		try {
			result = ImageIO.read(imagePath);
		} catch (IOException e) {
			System.err.println("Error");
		}
		return result;
	}
	public void paintComponent(Graphics g1){
		Graphics g2 = g1.create();
		if(this.isOpaque()){	
			g2.setColor(new Color(0, 51, 102));
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
		}
		Font font = new Font("", Font.PLAIN, 30);
		g2.setColor(Color.GRAY);
		g2.setFont(font); 		
		if(!revealed){
			drawFlag(g2);	
		}
		if(revealed){
			g2.setColor(new Color(0, 77, 153));
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
			if(getFlag()==1 && !dec){
                dec=true;
                g.decFlagCount();
        		g.updateLabel();
            }
            if(!mined){
                if(!r){
                	r=true;
                	g.decCellsLeft();
                	if(g.getCellsLeft()==0 && g.getGameState()!=2)
                    	g.setEnd(true);
                }
                if(f==1 && g.getGameState()!=0){	
					g2.setColor(Color.DARK_GRAY);
					g2.drawString("...",this.getWidth()/2,(this.getHeight()/2)+20);
				}
            }
			if(neighbors!=0){
				String s = Integer.toString(neighbors);
				g2.setColor(Color.WHITE);
				FontMetrics m = g2.getFontMetrics(font);
				int x = (this.getWidth() - m.stringWidth(s))/2;
				int y = ((this.getHeight() - m.getHeight())/2)+20;
				g2.drawString(s,x,y);				
			}
			if(!mined && neighbors==0){
				g.revealNeighbors(id);
			}
			if(mined){
				img=loadImage();
				g2.setColor(Color.BLACK);
				g2.fillRect(0,0,this.getWidth(),this.getHeight());
				drawFlag(g2);
				if(exploded){
					g2.setColor(Color.RED);
					g2.fillRect(0,0,this.getWidth(),this.getHeight());
					g2.drawImage(img,0,0,getWidth(),getWidth(),null);
					g.setEnd(false);     //false=defeat
				}else if(f==1){
					g2.setColor(Color.GREEN);
					g2.drawImage(img,0,0,getWidth(),getHeight(),null);
					g2.setColor(Color.WHITE);
				}
				else{
					g2.drawImage(img,0,0,getWidth(),getHeight(),null);
				}
			}
		}
	}
	public void setMined(){
		mined=true;
	}
	public boolean isMined(){
		return mined;
	}
	public boolean getExploded(){
		return exploded;
	}
	public void setExploded(){
		exploded=true;
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
	public int getNeighbors(){
		return neighbors;
	}
	public int getFlag(){
		return f;
	}
	public void setFlag(int flag){
		f=flag;
	}
	public void setR(){
		r=true;
	}
	public void setDec(){
		dec=true;
	}
	public boolean getR(){
		return r;
	}
	public boolean getDec(){
		return dec;
	}
}