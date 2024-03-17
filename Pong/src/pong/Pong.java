package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Pong extends Canvas implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	public static int WIDTH = 140, HEIGHT = 120, SCALE = 3;

	public BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	public static Player player;
	public static Enemy enemy;
	public static Ball ball;

	public Pong() {
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		this.addKeyListener(this);

		player = new Player(100, HEIGHT - 5);
		enemy = new Enemy(100, 0);
		ball = new Ball(100, HEIGHT / 2 - 1);
	}

	public static void main(String[] args) {

		Pong pong = new Pong();

		JFrame jFrame = new JFrame("Pong");

		jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.add(pong);
		jFrame.pack();
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);

		new Thread(pong).start();

	}

	public void spin() {
		player.spin();
		enemy.spin();
		ball.spin();

	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = layer.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		player.render(g);

		enemy.render(g);
		
		ball.render(g);

		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);

		bs.show();

	}

	@Override
	public void run() {

		while (true) {
			spin();
			render();
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}

	}

}
