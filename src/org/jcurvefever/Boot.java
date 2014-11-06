package org.jcurvefever;

import javax.swing.UIManager;

import org.jcurvefever.controllor.GameFlow;

public class Boot {

	public static void main(String[] args) throws Throwable {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		new GameFlow();
		
	}

}
