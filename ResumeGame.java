import java.awt.event.*;
import java.io.*;
/**
* ResumeGame reads the state of the last game from a file and loads it in a new Grid object.
*
* @version 0.1
* @author Julien Hoeglund
*/
public class ResumeGame implements ActionListener{
	private GameWindow w;
	private Grid g;
	private DataInputStream f;
	public ResumeGame(GameWindow window,Grid grid,DataInputStream flux){
		w=window;
		g=grid;
		f=flux;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		w.stopTimer();
		int X,Y;
		int id;
		boolean revealState;
		boolean mined;
		int neighbors;
		boolean exploded; 
		int flag;
		boolean r;
		boolean dec;
		int time;
		try{
			X=f.readInt();
			Y=f.readInt();
			int mines=f.readInt();
			g=new Grid(X,Y,mines,w.getCount());
			while(f.available()>0){
				id=f.readInt();
				revealState=f.readBoolean();
				mined=f.readBoolean();
				exploded = f.readBoolean();
				neighbors=f.readInt();
				flag=f.readInt();
				r=f.readBoolean();
				dec=f.readBoolean();
				time=f.readInt();
				g.loadCell(id,revealState,mined,exploded,neighbors,flag,r,dec);
				w.setX(X);
				w.setY(Y);
				w.setGrid(g);
				if(exploded){
					g.setGameState(2);
				}
				w.setTime(time);
			}
			f.close();
		}catch(IOException ex){
			System.err.println("IO Error");
		}
		w.runGame(true);
	}
}