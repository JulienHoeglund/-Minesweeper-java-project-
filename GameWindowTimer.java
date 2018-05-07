/*
The GameWindowTimer allows us to set an end to the game when the timer ( which has been previously set by the player ) hits 0
* @version 0.1
* @author Julien Hoeglund, Valentin Lefebure
*/
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class GameWindowTimer extends TimerTask {
	private GameWindow gW;
	private JLabel remain;
	private Grid grid;

	public GameWindowTimer(GameWindow w , JLabel lb, Grid g){	
		gW = w;
		remain = lb;
		grid=g;
	}
	private int setTimer(){
		gW.setTime(gW.getTime()-1);
		int t = gW.getTime();
		return t;
	}
	@Override
	public void run(){
		if (gW.getTime()%60 < 10 ){
			remain.setText("Timer: 0"+Integer.toString(gW.getTime()/60)+":0"+Integer.toString(gW.getTime()%60));
		}
		else{
			remain.setText("Timer: "+Integer.toString(gW.getTime()/60)+":"+Integer.toString(gW.getTime()%60));
		}
		this.setTimer();
		if (gW.getTime()==-1)
		{
			gW.setEnd();
			gW.setTime(0);
			gW.stopTimer();			
		}
		if(grid.getGameState()==2){
			gW.stopTimer();
		}
	}
}