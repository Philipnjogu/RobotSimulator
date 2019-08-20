package states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

import controls.RobotControl;
import entities.Bar;
import entities.Block;
import entities.Robot;

public class State {

	public static final int TOTAL_HEIGHT = 14;
	public static final int TOTAL_WIDTH = 13;

	private Robot robot;

	private Stack<Bar> bars;
	private Stack<Block> blocks;

	private RobotControl controller;

	public State() {
		robot = new Robot(2, 1, 0);
		bars = new Stack<Bar>();
		blocks = new Stack<Block>();

		controller = new RobotControl(robot);

	}

	public void initEntities(int barHeights[], int blockHeights[], int required[], boolean ordered) {
		createBlocksAndBars(barHeights, blockHeights);
	}

	public void initEntities(int barHeights[]) {
		int blockHeights[] = { 2, 2, 2, 2 };

		createBlocksAndBars(barHeights, blockHeights);

	}

	public void initEntities() {

		int barHeights[] = { 4, 4, 4, 4, 4, 4 };
		int blockHeights[] = { 2, 2, 2, 2 };

		createBlocksAndBars(barHeights, blockHeights);

	}

	private void createBlocksAndBars(int barHeights[], int blockHeights[]) {
		int x = 3;

		for (int n : barHeights) {
			x++;
			bars.push(new Bar(x, (TOTAL_HEIGHT - n), n, Color.black));
		}

		x = 11;

		int totalHeight = 0;

		for (int n : blockHeights) {
			totalHeight += n;
			blocks.push(new Block(x, (TOTAL_HEIGHT - totalHeight), n, Color.blue));
		}

	}

	public void update() {
		for (Bar bar : bars)
			bar.update();

		for (Block block : blocks)
			block.update();

		robot.update();
	}

	public void render(Graphics g) {
		for (Bar bar : bars)
			bar.render(g);

		for (Block block : blocks)
			block.render(g);

		robot.render(g);
	}

}
