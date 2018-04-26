/**
* The CellListener class receives and processes mouse inputs 
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class CellListener implements MouseListener{
    private Cell c;
    private MinePanel p;
    private MenuPanel m;
    private Grid g;
    public CellListener(Cell cell, MinePanel panel, MenuPanel menu,Grid grid){
    		c=cell;
    		p=panel;
    		m=menu;
            g=grid;
    } 
    public void mouseClicked(MouseEvent e){    	
    	if(e.getButton()==MouseEvent.BUTTON1){
    		c.setRevealed();
    		c.repaint(); 
            if(c.isMined()){
    				p.setEnd(false); //false = defeat
    				p.repaint();
    				m.setEnd(false);
    				m.repaint();
    		}
    	}
    	else if(e.getButton()==MouseEvent.BUTTON3 && !c.getRevealState()){
    		int f = c.getFlag();
    		if(f==2){
    			f++;
                c.setFlag(0);
                System.out.println("a");     			
    		}
    		else{
    		    f++;
    		    c.setFlag(f);
                System.out.println("b");
            }
            if(f==1){
                g.incFlagCount();  
                System.out.println("c");
            }
            if(f==2){
                g.decFlagCount();  
                System.out.println("d");
            }
            c.repaint();
    	}
        g.updateLabel();
    }
	public void mouseEntered(MouseEvent e){       
	}
	public void mouseExited(MouseEvent e){
	}
	public void mousePressed(MouseEvent e){        
	}
	public void mouseReleased(MouseEvent e){
	}

}