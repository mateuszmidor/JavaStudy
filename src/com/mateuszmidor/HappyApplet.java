package com.mateuszmidor;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JApplet;

public class HappyApplet extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		drawBackground(g, Color.yellow);
		drawTextInTheMiddle(g, "Happy applet!");
	}

	private void drawTextInTheMiddle(Graphics g, String s) {
		Font f = g.getFont().deriveFont(20.0f);
		int x = centerLabelHorizontally(f, s, getWidth());
		int y = centerLabelVertically(f, s, getHeight());
		g.setColor(Color.black);
		g.setFont(f);
		g.drawString(s, x, y);
	}

	private int centerLabelVertically(Font f, String s, int height) {
		FontMetrics fm = getFontMetrics(f);
		return  (height + fm.getHeight()) / 2;
	}

	private int centerLabelHorizontally(Font f, String s, int width) {
		FontMetrics fm = getFontMetrics(f);
		
		return (width - fm.stringWidth(s)) / 2;
	}

	private void drawBackground(Graphics g, Color c) {
		g.setColor(c);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

}
