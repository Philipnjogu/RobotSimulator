package entities;

import java.awt.Graphics;

public abstract class Entity {
	public static final int BREADTH = 1;
	public static final int FACTOR = 40;
	protected int x;
	protected int y;
	protected int breadth;

	/**
	 * @param x position of the entity on the game board
	 * @param y position of the entity on the game board
	 */

	public Entity(int x, int y) {
		this.x = FACTOR * x;
		this.y = FACTOR * y;

		breadth = FACTOR * BREADTH;
	}

	public abstract void move();

	public abstract void update();

	public abstract void render(Graphics g);

}
