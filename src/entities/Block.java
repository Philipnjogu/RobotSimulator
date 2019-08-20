package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends Entity {

	private int height;
	private Color color;
	private boolean moving;

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */

	public Block(int x, int y, int height, Color color) {
		super(x, y);
		this.height = FACTOR * height;
		this.color = color;

		moving = false;
	}

	@Override
	public void move() {
		if (moving) {

		}
	}

	@Override
	public void update() {

		if (moving) {

		}

	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, breadth, height);

	}

}
