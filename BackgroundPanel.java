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
    private int story;
    public BackgroundPanel(GameWindow window, int s){
        try{
        	img = ImageIO.read(new File("minerva_background.png"));
    	}catch(IOException e){
    		System.err.println("FIle not found"+e);
    	}
    	w=window;
    	story=s;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    	g.drawImage(img, 0, 0,w.getWidth(),w.getHeight(), null);
    	Font font = new Font("Times New Roman", Font.ITALIC, 18);
    	g.setFont(font);
    	g.setColor(Color.BLACK);
    	if(story==1){
    		g.drawString("Minerva headed for battle. She had put her mighty helmet on, ", 550, 700);
    		g.drawString("had taken her greatest spear and was about to descend", 550, 730);
    		g.drawString("among Men.", 550, 760);
    		g.drawString("Only you, legendary legionary whose renown has spread in all", 550, 790);
    		g.drawString("of the Roman Empire, can stop the wrath of Minerva.", 560, 820);
    	}
    	if(story==2){
    		g.setColor(new Color(0,0,0,75));
    		font = new Font("Times New Roman", Font.ITALIC, 18);
    		int x=400;
    		g.fillRect(x-10,108,1116,400);
    		g.setColor(Color.LIGHT_GRAY);
    		g.drawString("\"Are the odds good ?\" asked the legionary to the Oracle.", x, 130);
    		g.drawString("She turned her hooded face and set her old, maliceful eyes upon him.", x, 160);
    		g.drawString("\"The last three sacrifices' guts were black. A bull and two horses.\"", x, 190);
    		g.drawString("The thought made the man shudder.", x, 220);
    		g.drawString("\"Then she's coming...\"", x, 250);
    		g.drawString("\"The war will be terrible for you, legionary. Many losses.\"", x, 280);
    		g.drawString("He paused, thinking about his reasons for a moment.", x, 310);
    		g.drawString("\"It will be worth the fight. Reason must prevail. Men will learn to live without", x, 340);
    		g.drawString("the reassuring presence of their gods.\"", x, 370);
    		g.drawString("The Oracle turned away to feel the fire in the hearth made of cold marble.", x, 400);
    		g.drawString("\"Men will have to learn to live without your presence.", x, 430);
    		g.drawString("She will surely have prepared her deadly game for you...\"", x, 460);
    		g.drawString("\"I shall fight the odds. I shall fight with the power of my mind.\"", x, 490);
    	}
    }
}