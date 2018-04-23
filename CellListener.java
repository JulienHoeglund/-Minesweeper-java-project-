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
    public CellListener(Cell cell, MinePanel panel, MenuPanel menu){
    		c=cell;
    		p=panel;
    		m=menu;
    }
    public void mouseClicked(MouseEvent e){
    }
	public void mouseEntered(MouseEvent e){       
	}
	public void mouseExited(MouseEvent e){
	}
	public void mousePressed(MouseEvent e){        
			c.setRevealed();
    		c.setClicked();
    		c.repaint();
    		if(c.isMined()){
    			p.setEnd(false); //end with 'victory' set to false (defeat)
    			p.repaint();
    			m.setEnd(false);
    			m.repaint();
    		}
    }
	public void mouseReleased(MouseEvent e){
	}
}