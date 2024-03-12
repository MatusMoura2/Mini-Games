package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	public boolean right, left;

	public int x, y, width, height;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 10;
	}

	public void spin() {
		if (right) {
			x++;
		} else if (left) {
			x--;
		}

		if (x + width > Pong.WIDTH) {
			x = Pong.WIDTH - width;
		} else if (x < 0) {
			x = 0;
		}

	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 40, 10);
	}
}
