import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;
import states.State;

public class Simulator implements Runnable {

	private String title;
	private int width;
	private int height;

	private Display display;

	private Thread thread;
	private boolean running = false;

	private Graphics g;
	private BufferStrategy bs;

	private State state;

	/**
	 * @param title
	 * @param width
	 * @param height
	 */

	public Simulator(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	private void init() {

		display = new Display(width, height, title);

		state = new State();

		state.initEntities();

	}

	public synchronized void start() {
		if (running)
			return;
		thread = new Thread(this, "Simaulator");
		thread.start();
		running = true;
	}

	private void update() {
		state.update();
	}

	private void render() {

		bs = display.getCanvas().getBufferStrategy();

		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();

		// Clearing the Window
		g.clearRect(0, 0, width, height);

		state.render(g);

		bs.show();
		g.dispose();

	}

	/**
	 * The Simulator Loop
	 */
	@Override
	public void run() {
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				delta--;
			}

		}

		stop();

	}

	private synchronized void stop() {
		if (!running)
			return;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
