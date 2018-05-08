
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/*
*GameTimer allows the player to set an end to the game so it can be more challenging.
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
public class GameTimer extends TimerTask {	
	private GameWindow gW;
	private JLabel remain;

	public GameTimer(GameWindow w , JLabel lb){	
		gW = w; 
		remain = lb;
	}
	@Override
	public void run(){
		if (gW.getTime()%60 < 10 ){
			remain.setText("Timer: 0"+Integer.toString(gW.getTime()/60)+":0"+Integer.toString(gW.getTime()%60));
		}
		else{
			remain.setText("Timer: "+Integer.toString(gW.getTime()/60)+":"+Integer.toString(gW.getTime()%60));
		}
		int gameState=gW.getGameState();
		if(gameState==0 && gW.gameRunning()){
			int t = gW.getTime();
			gW.setTime(t-1);
			if(gW.getTime()==-1){
				gW.setEnd();
				gW.setTime(0);
				gW.stopTimer();
			}
		}
		if(!gW.gameRunning()){
			gW.stopTimer();
			cancel();
		}
	}
}