import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Snake implements KeyListener{

	protected BufferedImage bodyImg, faceImg;
	protected int xa = 45, ya = 45 ;
	Game game;	
	boolean down = false,
			left = false,
			right = true,
			up = false;
	int[] xs = new int[700];
	int[] ys = new int[700];
	boolean loose = false;	
	int snakLen = 2;	
	int tmpY, tmpX, tmp;

	
	public void paint(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g ;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

	
		if(right) {	
			tmpY = ys[0];
			tmpX = xs[0];
			xs[0] += xa;		
				
			g2.drawImage(faceImg, xs[0], ys[0], null);			
			
			for(int i = 1 ; i < snakLen ; i++) {
				if(xs[0] == xs[i] && ys[0] == ys[i]) {
					 loose = true;
				}
				
				tmp = tmpY;
				tmpY = ys[i];
				ys[i] = tmp;
				
				tmp = tmpX;
				tmpX = xs[i];
				xs[i] = tmp;
				
				g2.drawImage(bodyImg, xs[i], ys[i], null);
			
			}
			
		}
		
		if(left) {
			tmpY = ys[0];
			tmpX = xs[0];
			xs[0] -= xa;		
					
			g2.drawImage(faceImg, xs[0], ys[0], null);			
			
			for(int i = 1 ; i < snakLen ; i++) {
				if(xs[0] == xs[i] && ys[0] == ys[i]) {
					 loose = true;
				}
				tmp = tmpY;
				tmpY = ys[i];
				ys[i] = tmp;
				
				tmp = tmpX;
				tmpX = xs[i];
				xs[i] = tmp;
				
				g2.drawImage(bodyImg, xs[i], ys[i], null);
			
			}	
		}
		
	    if(down) {
			
			tmpY = ys[0];
			tmpX = xs[0];
			ys[0] += xa;		
			
			
			g2.drawImage(faceImg, xs[0], ys[0], null);			
			
			for(int i = 1 ; i < snakLen ; i++) {
				if(xs[0] == xs[i] && ys[0] == ys[i]) {
					 loose = true;
				}
				tmp = tmpY;
				tmpY = ys[i];
				ys[i] = tmp;
				
				tmp = tmpX;
				tmpX = xs[i];
				xs[i] = tmp;
				
				g2.drawImage(bodyImg, xs[i], ys[i], null);
			
			}	
			
		}
				
	    else if(up) {
			
			tmpY = ys[0];
			tmpX = xs[0];
			ys[0] -= xa;		
					
			g2.drawImage(faceImg, xs[0], ys[0], null);			
			
			for(int i = 1 ; i < snakLen ; i++) {
				if(xs[0] == xs[i] && ys[0] == ys[i]) {
					 loose = true;
				}
				tmp = tmpY;
				tmpY = ys[i];
				ys[i] = tmp;
				
				tmp = tmpX;
				tmpX = xs[i];
				xs[i] = tmp;
				
				g2.drawImage(bodyImg, xs[i], ys[i], null);
			
			}
	
		
		}
		
	}


	public Rectangle headBound() {	
		return new Rectangle(xs[0], ys[0], faceImg.getWidth(), faceImg.getHeight());	
	}
	
	
	public boolean CoinCollision() {
		return  game.coin.coinBound().intersects(headBound());	
	}
	

	
	public Snake(Game game) {

		this.game = game;
		
		xs[0] = 50;
		ys[0] = 50;
		
		try {
			
			bodyImg = ImageIO.read(new File("circle.png"));
			faceImg = ImageIO.read(new File("emoji.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_DOWN && !up) {		
			down = true;
			right = false;
			left = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP && !down) {
			up = true;
			right = false;
			left = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT && !right) {
			left = true;
			up = false;
			down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && !left) {
			right = true;
			up = false;
			down = false;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
