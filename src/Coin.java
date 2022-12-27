import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Coin {

	BufferedImage coinImg;
	Game game;
	private int x,y;
	
	Random random = new Random();
	
	public void paint(Graphics g) {
	
		Graphics2D g2 = (Graphics2D) g ;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(game.barrier.coinBarCollision()) {
			coordinate();
		 }
		
		g2.drawImage(coinImg, x, y, null);
			
	}
	
	public Coin(Game game) {
		
		 this.game = game;
		 
		 coordinate();
		 
		 try {
			coinImg = ImageIO.read(new File("coin.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	public void coordinate() {
		
		x = random.nextInt(600) + 20;
		y = random.nextInt(600) + 20;

	}
	
	public Rectangle coinBound() {		
		return new Rectangle(x, y, coinImg.getWidth(), coinImg.getHeight());		
	}
	
	
	
}
