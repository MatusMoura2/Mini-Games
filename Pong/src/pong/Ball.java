package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

	public double x, y;
	private int width;
	private int height;

	public double directionY, directionX;
	public double speed = 1;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 3;
		this.height = 3;

		this.directionX = new Random().nextGaussian();
		this.directionY = new Random().nextGaussian();
	}

	public void spin() {

		if (x + (directionX * speed) + width >= Pong.WIDTH) {
			directionX *= -1;
		} else if (x + (directionX * speed) < 0) {
			directionX *= -1;
		}

		if (y >= Pong.HEIGHT) {// Inimigo ganha

		} else if (y < 0) {// Jogador ganha

		}

		Rectangle rectangleBounds = new Rectangle((int) (x + (directionX * speed)), (int) (y + (directionY * speed)),
				width, height);

		Rectangle rectangleBoundsPlayer = new Rectangle(Pong.player.x, Pong.player.y, Pong.player.width,
				Pong.player.height);
		Rectangle rectangleBoundsEnemy = new Rectangle((int) Pong.enemy.x, (int) Pong.enemy.y, Pong.enemy.width,
				Pong.enemy.height);

		if (rectangleBounds.intersects(rectangleBoundsPlayer)) {
			directionY *= -1;
			
		}else if(rectangleBounds.intersects(rectangleBoundsEnemy)) {
			directionY *=-1;
		}

		y += directionY * speed;
		x += directionX * speed;
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, 3, 3);
	}
}
