package org.jcurvefever.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Screen extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int width, height;
	
	public Screen(int w, int h) {
		width	= w;
		height 	= h;
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		
		requestFocus();
	}
	
	public void render() {
		Graphics2D g2d = (Graphics2D) getGraphics();
		// Background
		g2d.setColor(new Color(0x1C1C1C));
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(new Color(0x000000));
		g2d.fillRect(width / 4, 0, width / 4 * 3, height);
		g2d.setColor(new Color(0xFFFFFF));
		for (int i = 0; i < 3; i++) {
			g2d.drawRect(width / 4 + i, 0 + i, width / 4 * 3 - (i * 2) - 1, height - (i * 2) - 1);
		}
	}
	
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
}
