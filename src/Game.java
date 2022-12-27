import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable,KeyListener{

	protected BufferedImage mainBack, gameOver;
	Thread thread ;	
	protected Coin coin = new Coin(this);
	protected Snake snake = new Snake(this);
	protected Player player = new Player(this);
	protected Barrier barrier = new Barrier(this);	
	int x, y;
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g ;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.drawImage(mainBack, 0, 0, 700, 700, null);
		
		snake.paint(g2);
		coin.paint(g2);
		barrier.paint(g2);
		
		player.addLen();
		
		player.loose();
		
		if(player.loose || snake.loose) {
			g2.drawImage(gameOver, 200, 200, 300, 300, null);
			thread.stop();
		}
		
	}
	
	
	
	public Game() {
		
		try {
			
			mainBack = ImageIO.read(new File("forest.jpg"));
			gameOver = ImageIO.read(new File("game-over.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public Rectangle BackBound() {
		return new Rectangle(700, 700, mainBack.getWidth(), mainBack.getHeight());
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		snake.keyPressed(e);
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void run() {
		while(true) {
			
			repaint();
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public void addNotify() {		
		super.addNotify();	
		thread = new Thread(this);
		thread.start();
		
	}


}
