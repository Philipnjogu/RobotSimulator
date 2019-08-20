package entities;

import java.awt.Color;
import java.awt.Graphics;

import states.State;

public class Robot extends Entity {
	
	enum Direction{To, From};

	public static final int X_POS = 1, Y_POS = 13;
	private int height;
	private int width;
	private int depth;

	/**
	 * @param height
	 * @param width
	 * @param depth
	 */
	public Robot(int height, int width, int depth) {
		super(X_POS, Y_POS);
		this.height = FACTOR * height;
		//this.height = FACTOR * 12;
		this.width = FACTOR * width;
		//this.width =  FACTOR * 8;
		
		this.depth = FACTOR * depth;
	}

	/**
	 * Increases the height of the vertical anchor arm by 1 unit
	 */
	public void up() {
		height++;
		y--;
	}

	/**
	 * Decreases the height of the vertical anchor arm by 1 unit
	 */
	public void down() {
		y++;
		height--;
	}

	/**
	 * Increases the horizontal arm by 1 unit
	 */
	public void extend() {
		width++;
	}

	/**
	 * Decreases the horizontal arm by 1 unit
	 */
	public void contract() {
		width--;
	}

	/**
	 * Decrease the height of the picking arm by one unit
	 */
	public void raise() {
		depth--;
	}

	/**
	 * Increases the height of the picking arm by 1 unit
	 */

	public void lower() {
		depth++;
	}

	/**
	 * Picks a block from the top of a stack of blocks
	 */
	public void pick() {

	}

	/**
	 * Drops a block to the top of a stack of blocks
	 */

	public void drop() {

	}

	/**
	 * 
	 * @param factor Increases the speed
	 * 
	 * @return void
	 */
	public void speedUp(int factor) {

	}

	/**
	 * 
	 * @param factor Decreases the speed
	 * 
	 * @return void
	 */
	public void slowDown(int factor) {

	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {

		//Height
		g.setColor(Color.magenta);
		g.drawRect(FACTOR, (State.TOTAL_HEIGHT * FACTOR - height), breadth, height);
		
		//WIDTH
		g.setColor(Color.red);
		g.drawRect(2 * FACTOR, (State.TOTAL_HEIGHT * FACTOR - height), width, FACTOR);
		
		//HEIGHT
		g.setColor(Color.green);
		g.drawRect(FACTOR + width, (State.TOTAL_HEIGHT * FACTOR - height + FACTOR), breadth, depth);
	}

}
