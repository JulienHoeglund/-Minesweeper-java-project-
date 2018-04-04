/**
* The Game class is the base class managing inputs, graphics and game rules
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
public class Game{
	private boolean exit; 
	private GameWindow window;

	public Game(){
		exit = 0;
		grid = new Grid();
	}
	public void prep(){
		getParameters();
		grid.create();	
	}
	public bool input(){
		 
		return false;
	}
	public void update(){
		if(window.isVisible())
	}
	public void end(){
		
	}
	public void run(){
		prep();
		window = new GameWindow(500,500,0,0);
		while(!exit){
			exit=input();
			update();
		}
		end();
	}
}