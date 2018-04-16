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
		exit = false;
	}
	public void prep(){
		//getParameters();	
	}
	public boolean input(){
		return false;
	}
	public void update(){
		//if(window.isVisible())
	}
	public void end(){
		
	}
	public void run(){
		prep();
		window = new GameWindow(1000,1000,500,0);
		while(!exit){
			exit=input();
			update();
		}
		end();
	}
}