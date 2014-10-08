package org.jcurvefever.ui;

import javax.swing.JFrame;

import org.jcurvefever.controllor.GameFlow;
import org.jcurvefever.graphics.Screen;

public class GameFrame extends JFrame {
	
	private static final long serialVersionUID = 2350830544775088845L;

	public GameFrame(Screen screen) {
		setTitle(GameFlow.TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(screen);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
