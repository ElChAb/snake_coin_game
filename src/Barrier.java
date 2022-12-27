import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Barrier {
	
	BufferedImage barrier;
	int x, y;
	Random random = new Random();
	Game game;
	
	public Barrier(Game game) {
		this.game = game;
		
		randomCoordinate();
		
		try {
			barrier = ImageIO.read(new File("jesus.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void randomCoordinate() {
		
		x = random.nextInt(600)+20;
		y = random.nextInt(600)+20;
		
	}

	public void paint(Graphics g) {		
		g.drawImage(barrier, x, y, null);
	}
		
	public Rectangle barrierBound() {
		return new Rectangle(x , y, barrier.getWidth(), barrier.getHeight());	
	}
	
	public boolean barCollision() {		
		return game.snake.headBound().intersects(barrierBound());	
	}
	
	public boolean coinBarCollision() {
		return game.coin.coinBound().intersects(barrierBound());	
	}
	

}
