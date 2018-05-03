/**
* The SaveQuitGameButton class writes the state of the current game to a file
*
* @version 0.1
* @author Julien Hoeglund
*/
import java.awt.event.*;
import java.io.*;
public class SaveGame implements ActionListener{
	private GameWindow w;
	private Grid g;
	public SaveGame(GameWindow window,Grid grid){
		w=window;
		g=grid;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		File fl = new File("save.mns");
		fl.delete();
		try{
			FileOutputStream file = new FileOutputStream("save.mns");
			DataOutputStream f = new DataOutputStream(file);  
			Cell[] cells = g.getCells();
			f.writeInt(g.getX());
			f.writeInt(g.getY());
			f.writeInt(g.getMines());			
			for(int i=0;i<cells.length;i++){
				f.writeInt(i);
				f.writeBoolean(cells[i].getRevealState());
				f.writeBoolean(cells[i].isMined());
				f.writeBoolean(cells[i].getExploded());
				f.writeInt(cells[i].getNeighbors());
				f.writeInt(cells[i].getFlag());
				f.writeBoolean(cells[i].getR());
				f.writeBoolean(cells[i].getDec());
			}
			f.close();
		}catch(IOException ioe){
			System.err.println("Error: could not save");
		}
	}
}