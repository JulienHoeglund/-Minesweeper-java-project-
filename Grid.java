/**
* The Grid class draws and updates the game grid holding cells
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/

import java.util.Random;
import java.lang.Exception.*;
import javax.swing.*;
import java.awt.*;

public class Grid{
	private Cell[] cells;
	private int X;
	private int Y;
	private int index;
	private int mines;
	private int flagCount;
	private JLabel l;
	public Grid(int sizeX, int sizeY, int m, JLabel label){
		X=sizeX;
		Y=sizeY;
		cells=new Cell[X*Y];
		for (int i=0;i<cells.length;i++)
			cells[i]=new Cell(this,i);
		mines=m;
		flagCount=0;
		l=label;
	}
	public void save(){
		
	}
	public void generate(){
		//Mine generation
		Random rand=new Random();
		for (int i=0;i<mines;i++){
			int x=rand.nextInt(cells.length);
			cells[x].setMined();
		}
		//Number of neighbor mines 
		int n,p;		
		try{
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
		}catch(ArrayIndexOutOfBoundsException e){
			System.err.println("Error : " + e.getMessage());
			System.err.println("index :" + index);		
		}
	}
	public Cell getCell(int index){
		return cells[index];
	}
	public void revealAll(){
		for (int i=0;i<cells.length;i++){
			cells[i].setRevealed();
		}	
	}
	public void revealNeighbors(int i){
		int p=i-X;
		if((i+1)%X!=0){
			if(p+1>0){
				if(!cells[p+1].getRevealState()){
					cells[p+1].setRevealed();
					cells[p+1].repaint();
				}
			}	
			if(p>=0){
				if(!cells[p].getRevealState()){
					cells[p].setRevealed();
					cells[p].repaint();
				}
			}
			if(i%X!=0){
				if((p-1)>=0){
					if(!cells[p-1].getRevealState()){	
						cells[p-1].setRevealed();
						cells[p-1].repaint();
					}
				}
			}
		}	
		if((i+1)%X!=0){
			if((i+1)<cells.length){
				if(!cells[i+1].getRevealState()){
					cells[i+1].setRevealed();
					cells[i+1].repaint();
				}
			}
		}
		if(i%X!=0){
			if((i-1)>=0){
				if(!cells[i-1].getRevealState()){
				//if(cells[i-1].isMined()){
					cells[i-1].setRevealed();
					cells[i-1].repaint();
				}				
			}
		}	
		p=i+X;
		if((i+1)%X!=0){
			if(p+1<cells.length){
				if(!cells[p+1].getRevealState()){
					cells[p+1].setRevealed();
					cells[p+1].repaint();
				}
			}
		}
		if(p<cells.length){
			if(!cells[p].getRevealState()){
				cells[p].setRevealed();
				cells[p].repaint();
			}
		}
		if(i%X!=0){
			if((p-1)<cells.length){
				if(!cells[p-1].getRevealState()){
					cells[p-1].setRevealed();
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
    	l.setText(Integer.toString(getMines()-getFlagCount())+" mines");
    }
}