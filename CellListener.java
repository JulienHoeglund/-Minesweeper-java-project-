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
    public CellListener(Cell cell, MinePanel panel){
    		c=cell;
    		p=panel;
    }
    public void mouseClicked(MouseEvent e){
    		c.setRevealed();
    		c.repaint();
    		if(c.isMined()){
    			p.setEnd(false); //set end with 'victory' set to false
    			p.repaint();
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