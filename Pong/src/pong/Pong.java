package pong;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Pong extends Canvas implements Runnable{
	

	private static final long serialVersionUID = 1L;
	public static int WIDTH =240, HEIGHT = 120, SCALE = 3;
	
	public Pong() {
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
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
		
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
