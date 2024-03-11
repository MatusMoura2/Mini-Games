package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public void spin() {
		
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(100, 120-10, 40, 10);
	}
}
