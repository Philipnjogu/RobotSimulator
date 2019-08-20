package display;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private int width;
	private int height;
	private String title;
	
	/**
	 * @param width
	 * @param height
	 * @param title
	 */
	public Display(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		createDisplay();
		
	}
	
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
		
		frame.setVisible(true);
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the canvas
	 */
	public Canvas getCanvas() {
		return canvas;
	}
	
	
	
	
}
