/**
* The Grid class draws and updates the game grid holding cells
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/

import java.util.Random;
import java.lang.Exception.*;

public class Grid{
	private Cell[] cells;
	private int X;
	private int Y;
	private int index;
	public Grid(int sizeX, int sizeY){
		X=sizeX;
		Y=sizeY;
		cells=new Cell[X*Y];
		for (int i=0;i<cells.length;i++)
			cells[i]=new Cell();
	}
	public void generate(int mines){
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
							System.out.println(i +"a0");	
						}
					}	
				}	
				if(p>=0){
					if(cells[p].isMined()){
						n++;
						System.out.println(i +"a1");	
					}
					if(i%X!=0){
						if((p-1)>=0){
							if(cells[p-1].isMined()){
								n++;
								System.out.println(i +"a2");	
							}
						}
					}
				}	
				if((i+1)%X!=0){
					if((i+1)<cells.length){
						if(cells[i+1].isMined()){
							n++;
							System.out.println(i+"b0");					
						}
					}
				}
				if(i%X!=0){
					if((i-1)>=0){
						if(cells[i-1].isMined()){
							n++;
							System.out.println(i+"b1");					
						}				
					}
				}	
				p=i+X;
				if((i+1)%X!=0){
					if(p+1<cells.length){
						if(cells[p+1].isMined()){
							n++;
							System.out.println(i+"c0");		
						}
					}
				}
				if(p<cells.length){
					if(cells[p].isMined()){
						n++;
						System.out.println(i+"c1");	
					}
				}
				if(i%X!=0){
					if((p-1)<cells.length){
						if(cells[p-1].isMined()){
							n++;
							System.out.println(i+"c2"+i%X);	
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
}