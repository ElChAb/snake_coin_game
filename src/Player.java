
public class Player {

	Game game;
	boolean loose = false;
	
	public Player(Game game) {		
		this.game = game;
	}
	
	public void addLen() {
		if(game.snake.CoinCollision()) {		
			game.snake.snakLen ++ ;
			game.coin.coordinate();
			 if(game.barrier.coinBarCollision()) {
					game.coin.coordinate();
			 }
		}
	}
	
	public void loose() {
		if(game.snake.xs[0] > 630 
				|| game.snake.xs[0] < 10 
				|| game.snake.ys[0] < 10 
				|| game.snake.ys[0] > 600
				|| game.barrier.barCollision()) {
			loose = true;	
		}		
	}
	
	

}
