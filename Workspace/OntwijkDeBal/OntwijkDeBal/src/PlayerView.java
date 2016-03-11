import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class PlayerView extends JPanel {

	// Balls are circles
	// Player is a rectangle
	private static final long serialVersionUID = 7L;

	// Fields
	private Board gameBoard;
	private ArrayList<Ball> balls;
	private PlayerCharacter player;
	

	// Constructor
	public PlayerView(Board gameBoard) {
		this.gameBoard = gameBoard;
		balls = gameBoard.getBalls();
		player = gameBoard.getPlayer();
		
	}

	// Methods
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//paintMyPlayer(g);
		paintMyBalls(g);
	}

	private void paintMyBalls(Graphics g) {
		for (Ball ball : balls) {
			
			if (ball.isHasSplit() && ball.getColor()==Color.RED) {
				ball.setColor(randomColor());
			}
			g.setColor(ball.getColor());
			int x = ball.getxPos() - (ball.getRadius() / 2);
			int y = ball.getyPos() - (ball.getRadius() / 2);
			
			g.fillOval(x, y, ball.getRadius(), ball.getRadius());
			
		}

	}
	
	private Color randomColor() {
		Random random = new Random();
		float r = random.nextFloat();
		float g = random.nextFloat();
		float b = random.nextFloat();
		
		Color randomColor = new Color(r, g, b);
		return randomColor;
		
		
	}

	private void paintMyPlayer(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(player.getxPos(), player.getyPos(), 15, 15);
	}
}
