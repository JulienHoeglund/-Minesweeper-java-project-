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
    public CellListener(Cell cell){
    		c=cell;
    }
    public void mouseClicked(MouseEvent e){
    		c.setRevealed();
			c.repaint();
			//System.out.println(c.getRevealState());
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