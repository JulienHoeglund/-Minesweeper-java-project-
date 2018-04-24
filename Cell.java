/**
* The Cell class holds information about a grid cell : location, whether it 
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
	private int neighbors;
	private Graphics g;
	private boolean defeat;
	private boolean clicked;
	private Grid grid;
	private int id;
	private int flag; //0 null, 1 certain, 2 doubt
	private Image qmark;
	private Image star;

	public Cell(Grid gd, int i){
		super();
		revealed=false;
		mined = false;
		neighbors = 0;
		defeat = false;
		clicked=false;
		grid=gd;
		id=i;
		flag=0;
		qmark = Toolkit.getDefaultToolkit().getImage("img/questionmark.png");
		star = Toolkit.getDefaultToolkit().getImage("img/star.png");

	}
	public void paintComponent(Graphics g){
		Graphics g2 = g.create();
		if(this.isOpaque()){	
			g2.setColor(Color.GRAY);
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
		}
		Font font = new Font("TimesRoman", Font.PLAIN, 30);
		g2.setColor(Color.WHITE);
		g2.setFont(font); 		
		if(!revealed){
			switch(flag){
				case 1: //g2.drawImage(star,30,30,this);
						g2.drawString("*",30,30);
						break;	
				case 2: //g2.drawImage(qmark,30,30,this);
						g2.drawString("?",30,30);
						break;	
			}
		}
		if(revealed){
			g2.setColor(Color.WHITE);
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
			if(neighbors!=0){
				String s = Integer.toString(neighbors);
				g2.setColor(Color.BLACK);
				FontMetrics m = g2.getFontMetrics(font);
				int x = (this.getWidth() - m.stringWidth(s))/2;
				int y = (this.getHeight() - m.getHeight())/2;
				g2.drawString(s,x,y);				
			}
		}	
		if(revealed && neighbors==0 && !mined){
			grid.revealNeighbors(id);
		}
		if(revealed && mined){
			g2.setColor(Color.BLACK);
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
		}
	}
	public void setGraphics(Graphics graphics){
		g=graphics;
	}public boolean isMined(){
		return mined;
	}
	public void setRevealed(){
		revealed=true;
	}
	public void setClicked(){
		clicked=true;
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
	public boolean getGameState(){
		return defeat;
	}
	public void setDefeat(){
		defeat=true;
	}
	public int getFlag(){
		return flag;
	}
	public void setFlag(int f){
		flag=f;
	}
}