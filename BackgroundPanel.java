/**
* The GameWindow class draws and updates the game window 
*
* @version 0.1
* @author Julien Hoeglund
*/
import javax.swing.*; 
import java.io.*; 
import java.awt.*; 
import java.awt.image.*; 	
import javax.imageio.*; 

public class BackgroundPanel extends JPanel{
    BufferedImage img;
    GameWindow w;
    public BackgroundPanel(GameWindow window){
        try{
        	img = ImageIO.read(new File("minerva_background.png"));
    	}catch(IOException e){
    		System.err.println("FIle not found"+e);
    	}
    	w=window;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    	g.drawImage(img, 0, 0,w.getWidth(),w.getHeight(), null);
    }
}