/**
* The Game class is the base class managing inputs, graphics and game rules
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
public class Game{
	private boolean exit; 
	private Grid grid;

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
		
	}
	public void end(){
		
	}
	public void run(){
		prep();
		while(!exit){
			exit=input();
			update();
		}
		end();
	}
}