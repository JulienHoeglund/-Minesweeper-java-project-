/**
* The Game class is the base class managing inputs, graphics and game rules
*
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
public class Game{
	private GameWindow window;

	public Game(){
	}
	public void run(){
		window = new GameWindow(1000,1000,500,0);
	}
}