package org.jcurvefever.input;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class KeyInput extends KeyAdapter {
	public static final int 			KEY_LEFT 	= KeyEvent.VK_LEFT;
	public static final int 			KEY_UP 		= KeyEvent.VK_UP;
	public static final int 			KEY_DOWN 	= KeyEvent.VK_DOWN;
	public static final int 			KEY_RIGHT 	= KeyEvent.VK_RIGHT;
	
	private boolean 					inputBlocked;
	
	private HashMap<Integer, Boolean> 	currentInput;
	
	public KeyInput(Component component) {
		currentInput = new HashMap<>();
		
		component.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		if(this.inputBlocked) {
			return;
		}
		switch(event.getKeyCode()) {
		case KEY_LEFT:
		case KEY_UP:
		case KEY_DOWN:
		case KEY_RIGHT:
			JOptionPane.showMessageDialog(null, "MOVE");
			clearMoveInput();
			break;
		default:
			
		}
		
		currentInput.put(event.getKeyCode(), true);
	}
	
	public void blockInput() {
		this.inputBlocked = true;
	}
	
	public void unblockInput() {
		this.inputBlocked = false;
	}
	
	public boolean isInputBlocked() {
		return this.inputBlocked;
	}
	
	@Override
	public void keyReleased(KeyEvent event) {
		currentInput.put(event.getKeyCode(), false);
	}
	
	public boolean isKeyPressed(int keyCode) {
		Boolean state = currentInput.get(keyCode);
		return state != null && state;
	}
	
	private void clearMoveInput() {
		currentInput.put(KEY_LEFT	, false);
		currentInput.put(KEY_UP		, false);
		currentInput.put(KEY_DOWN	, false);
		currentInput.put(KEY_RIGHT	, false);
	}
	
	

}
