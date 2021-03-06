import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
* CellListener receives and processes mouse inputs on a Cell. It processes flags depending of the click and current old flag. 
*
* @version 0.1
* @author Julien Hoeglund
*/

public class CellListener implements MouseListener{
    private Cell c;
    private JPanel p;
    private Grid g;
    public CellListener(Cell cell, JPanel panel,Grid grid){
      c=cell;
      p=panel;
      g=grid;
    } 
    public void mouseClicked(MouseEvent e){    	
        if(e.getButton()==MouseEvent.BUTTON1 && !c.getRevealState() && c.getFlag()!=1  && g.getGameState()==0){
            c.setRevealed();
            if(c.isMined()){
    			g.setEnd(false); //false = defeat
                c.setRevealed();
                c.setExploded();
                //stopTimer();
            }
            c.repaint(); 
        }
        else if(e.getButton()==MouseEvent.BUTTON3 && !c.getRevealState()){
            int f = c.getFlag();
    		if(f==0){
                if(g.getFlagCount()<g.getMines()){
                    f++;
                    g.incFlagCount();
                }
                else{
                    f=2;
                    c.setFlag(2);
                }
            }   
            else if(f==2){
                f=0;
            }
            else if(f==1){
                f++;
                g.decFlagCount();  
            }
            c.setFlag(f);
            c.repaint();
            g.updateLabel(); 
    	}
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