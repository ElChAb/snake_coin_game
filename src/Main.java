import javax.swing.JFrame;

public class Main extends JFrame{

	public Main() {
		
		setSize(700,700);
		setTitle("Snake And Coin");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Game game = new Game();		
		add(game);
		addKeyListener(game);		
		
		setVisible(true);
		
	}

	public static void main(String[] args) {

		new Main();

	}

}
