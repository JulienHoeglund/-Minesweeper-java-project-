import java.awt.event.*;
import java.io.*;
public class ResumeGameButton implements ActionListener{
	private GameWindow w;
	private Grid g;
	private DataInputStream f;
	public ResumeGameButton(GameWindow window,Grid grid,DataInputStream flux){
		w=window;
		g=grid;
		f=flux;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		//LOAD
		int id;
		boolean revealState;
		boolean mined;
		int neighbors;
		int flag;
		boolean r;
		boolean dec;

		try{
			int X=f.readInt();
			int Y=f.readInt();
			int mines=f.readInt();
			g=new Grid(X,Y,mines,w.getCount());
			while(f.available()>0){
				id=f.readInt();
				revealState=f.readBoolean();
				mined=f.readBoolean();
				neighbors=f.readInt();
				flag=f.readInt();
				r=f.readBoolean();
				dec=f.readBoolean();
				g.loadCell(id,revealState,mined,neighbors,flag,r,dec);
			}
			f.close();
		}catch(IOException ex){
			System.err.println("IO Error");
		}
		w.setGrid(g);
		w.runGame(true);
	}
	/*
	


	*/
}