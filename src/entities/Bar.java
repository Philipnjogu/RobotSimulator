package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Bar extends Entity {

	private int height;
	private Color color;

	/**
	 * @param x
	 * @param y
	 * @param width  of the entity
	 * @param height of the entity
	 */
	public Bar(int x, int y, int height, Color color) {
		super(x, y);
		this.height = FACTOR * height;
		this.color = color;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, breadth, height);
	}

}
