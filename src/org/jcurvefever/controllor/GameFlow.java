package org.jcurvefever.controllor;

import java.awt.Canvas;

import org.jcurvefever.graphics.Screen;
import org.jcurvefever.ui.GameFrame;

public class GameFlow extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final String 	TITLE 	= "JCurveFever";
	public static final int 	WIDTH 	= 800;
	public static final int 	HEIGHT 	= (int) (WIDTH * (1080 / 1920d));
	
	private Screen				screen;
	private GameFrame 			frame;
	
	private Thread				thread;
	private boolean				running;
	private int 				updates, frames;
	
	public GameFlow() {
		screen	= new Screen(WIDTH, HEIGHT);
		frame 	= new GameFrame(screen);
		
		start();
	}
	
	private synchronized void start() {
		running = true;
		thread 	= new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() {
		running = false;
		try {
			thread.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void update() {
		
	}
	
	private void render() {
		screen.render();
	}
	
	public void run() {
		long counter = System.currentTimeMillis();
		while (running) {
			update();
			render();
			updates++;
			frames++;
			
			if (System.currentTimeMillis() - 1000 >= counter) {
				System.out.println("Updates: " + updates + " | Frames: " + frames);
				counter = System.currentTimeMillis();
				frames 	= 0;
				updates = 0;
			}
			
			try {
				Thread.sleep(1000/60);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stop();
	}

}
