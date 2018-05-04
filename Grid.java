/**
* The Grid class draws and updates the game grid holding cells
*
* @version 0.1
* @author Julien Hoeglund
*/

import java.util.Random;
import java.lang.Exception.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Grid{
	private Cell[] cells;
	private int X;
	private int Y;
	private int index;
	private int cellsLeft;
	private int mines;
	private int gameState;
	private int flagCount;
	private JLabel l;
	private MenuPanel m;

	public Grid(int sizeX, int sizeY, int m, JLabel label){
		X=sizeX;
		Y=sizeY;
		cells=new Cell[X*Y];
		mines=m;
		flagCount=0;
		l=label;
		cellsLeft=cells.length-mines;
		gameState=0;
	}
	public void loadCell(int id,boolean revealState, boolean mined, boolean exploded, int neighbors,int flag, boolean r, boolean dec){
		Cell c=new Cell(this,id);
		if(mined)
			c.setMined();
		if(exploded)
			c.setExploded();
		if(revealState)
			c.setRevealed(false);
		c.setFlag(flag);
		c.setNeighbors(neighbors);
		c.setR();
		c.setDec();
		
		cells[id]=c;
	}
	public void setMenu(MenuPanel menu){
		m=menu;
	}
	public void setEnd(Boolean b){
		File fl = new File("save.mns");
		fl.delete();
		m.setEnd(b);
		m.repaint();
		if(!b){
			revealAll();
			gameState=2;
		}else{
			gameState=1;
		}
	}
	public Cell getCell(int index){
		return cells[index];
	}
	public Cell[] getCells(){
		return cells;
	}
	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}
	public void revealAll(){
		for (int i=0;i<cells.length;i++){
			if(!cells[i].getRevealState() && cells[i].isMined()){
				cells[i].setRevealed(false);
				cells[i].repaint();
			}
		}	
	}
	public void generate(){
		for (int i=0;i<cells.length;i++)
			cells[i]=new Cell(this,i);
		//Mine generation
		Random rand=new Random();
		int x;
		for (int i=0;i<mines;i++){
			do{
				x=rand.nextInt(cells.length);
			}while(cells[x].isMined());
			cells[x].setMined();
		}
		//Number of neighbor mines 
		int n,p;		
		for(int i=0;i<cells.length;i++){
			n=0;
			p=i-X;
			if((i+1)%X!=0){
				if(p+1>0){
					if(cells[p+1].isMined()){
						n++;
					}
				}	
			}	
			if(p>=0){
				if(cells[p].isMined()){
					n++;
				}
				if(i%X!=0){
					if((p-1)>=0){
						if(cells[p-1].isMined()){
							n++;
						}
					}
				}
			}	
			if((i+1)%X!=0){
				if((i+1)<cells.length){
					if(cells[i+1].isMined()){
						n++;
					}
				}
			}
			if(i%X!=0){
				if((i-1)>=0){
					if(cells[i-1].isMined()){
						n++;
					}				
				}
			}	
			p=i+X;
			if((i+1)%X!=0){
				if(p+1<cells.length){
					if(cells[p+1].isMined()){
						n++;
					}
				}
			}
			if(p<cells.length){
				if(cells[p].isMined()){
					n++;
				}
			}
			if(i%X!=0){
				if((p-1)<cells.length){
					if(cells[p-1].isMined()){
						n++;
					}
				}
			}
			cells[i].setNeighbors(n);
			index=i;
		}
	}
	public void revealNeighbors(int i){
		int p=i-X;
		if((i+1)%X!=0){ //do unless edge cell
			if(p+1>0){
				if(!cells[p+1].getRevealState()){
					cells[p+1].setRevealed(false);
					cells[p+1].repaint();
				}
			}	
		}	
		if(p>=0){
			if(!cells[p].getRevealState()){
				cells[p].setRevealed(false);
				cells[p].repaint();
			}
		}
		if(i%X!=0){
			if((p-1)>=0){
				if(!cells[p-1].getRevealState()){	
					cells[p-1].setRevealed(false);
					cells[p-1].repaint();
				}
			}
		}
		if((i+1)%X!=0){
			if((i+1)<cells.length){
				if(!cells[i+1].getRevealState()){
					cells[i+1].setRevealed(false);
					cells[i+1].repaint();
				}
			}
		}
		if(i%X!=0){
			if((i-1)>=0){
				if(!cells[i-1].getRevealState()){
				//if(cells[i-1].isMined()){
					cells[i-1].setRevealed(false);
					cells[i-1].repaint();
				}				
			}
		}	
		p=i+X;
		if((i+1)%X!=0){
			if(p+1<cells.length){
				if(!cells[p+1].getRevealState()){
					cells[p+1].setRevealed(false);
					cells[p+1].repaint();
				}
			}
		}
		if(p<cells.length){
			if(!cells[p].getRevealState()){
				cells[p].setRevealed(false);
				cells[p].repaint();
			}
		}
		if(i%X!=0){
			if((p-1)<cells.length){
				if(!cells[p-1].getRevealState()){
					cells[p-1].setRevealed(false);
					cells[p-1].repaint();
				}
			}
		}
	}
	public int getMines(){
		return mines; 
	}
	public void incFlagCount(){
        flagCount++;
    }
    public void decFlagCount(){
        flagCount--;
    }
    public int getFlagCount(){
        return flagCount;
    }
    public void updateLabel(){
    	l.setText(" Mines: " +Integer.toString(mines-getFlagCount()));
    }
    public int getCellsLeft(){
    	return cellsLeft;
    }
    public void decCellsLeft(){
    	cellsLeft--;
    }
    public int getGameState(){
		return gameState;
	}
	public void setDefeat(){
		gameState=2;
	}
}