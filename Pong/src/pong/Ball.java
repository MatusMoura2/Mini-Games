package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {

	public double x,y;
	private int width;
	private int height;
	
	public double directionY, directionX;
	public double speed = 2.5;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 3;
		this.height = 3;
		
		this.directionX = new Random().nextGaussian();
		this.directionY = new Random().nextGaussian();
	}
	
	public void spin() {
		y+=directionY*speed;
		x+=directionX*speed;

	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, 3, 3);
	}
}
