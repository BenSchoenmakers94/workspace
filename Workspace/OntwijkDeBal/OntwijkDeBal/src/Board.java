import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Board {

	// Fields
	private ArrayList<Ball> balls;
	private PlayerCharacter player;

	private boolean playerCreated;
	private boolean firstBall;
	private boolean gameFinished;

	private JFrame gameBoard;
	private PlayerView userView;
	private int panelHeight;
	private int panelWidth;

	private final String DEFAULT_FRAMETITLE = "Ontwijk de bal!";
	private final int DEFAULT_MOVESPEED = 10;
	private final int DEFAULT_LIVES = 1;
	private final int DEFAULT_PANELHEIGHT = 400;
	private final int DEFAULT_PANELWIDTH = 400;
	private final int DEFAULT_FPS = 60;
	private final int MAX_BALLS=15;

	// Constructor
	public Board() {
		balls = new ArrayList<Ball>();
		playerCreated = false;
		firstBall = true;
		gameFinished = false;
		panelHeight = DEFAULT_PANELHEIGHT;
		panelWidth = DEFAULT_PANELWIDTH;
		prepareGame();
	}

	// Methods
	public void create() {

		gameBoard = new JFrame();
		gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameBoard.setTitle(DEFAULT_FRAMETITLE);

		userView = new PlayerView(this);
		userView.setPreferredSize(new Dimension(panelWidth, panelHeight));
		gameBoard.setContentPane(userView);
		gameBoard.setResizable(false);
		gameBoard.pack();
		gameBoard.setLocationRelativeTo(null);
		gameBoard.setVisible(true);

	}

	private void prepareGame() {
		// TODO: Creates a player object---Creates the firstball
		player = new PlayerCharacter((panelWidth / 2), (panelHeight / 2),
				DEFAULT_MOVESPEED, DEFAULT_LIVES);
		balls.add(new Ball((panelWidth / 2), ((panelHeight / 2) + 50),
				DEFAULT_MOVESPEED));
	}

	public void addBall(Ball bouncedBall) {
		// TODO: Checks if the given ball has its .split value on false.
		// Yes: adds a new ball to the arraylist and changes values in the given
		// ball
		// No: Does nothing.

		if (!bouncedBall.isHasSplit()) {
			if (bouncedBall.getNrOfBounces() == bouncedBall.getMaxBounces()) {
				balls.add(new Ball(bouncedBall.xPos, bouncedBall.yPos,
						DEFAULT_MOVESPEED));
				bouncedBall.split();

			}

		}
	}

	public ArrayList<Ball> getBalls() {
		return balls;
	}

	public PlayerCharacter getPlayer() {
		return player;
	}

	private void moveMyBalls() {
		// TODO: Move balls in the arraylist corresponding to their speed
		for (int i = 0; i < balls.size(); i++) {
			if (!balls.get(i).hasDirection()) {
				balls.get(i).moveRandomDirection();
			} else {
				balls.get(i).xPos = balls.get(i).xPos
						+ balls.get(i).getxSpeed();
				balls.get(i).yPos = balls.get(i).yPos
						+ balls.get(i).getySpeed();

				isBallBouncing(balls.get(i));	
				
				if (balls.size()<MAX_BALLS) {
					addBall(balls.get(i));
					
				}
				

			}
			

			// addBall(ball);
			// Move ball along x-axis
			/*
			 * if (ball.getMoveRight()) { ball.xPos =
			 * ball.xPos+ball.getxSpeed(); } else { ball.xPos =
			 * ball.xPos-ball.getxSpeed(); }
			 * 
			 * //Move ball along y-axis if (ball.getMoveDown()) { ball.yPos =
			 * ball.yPos+ball.getySpeed(); } else { ball.yPos =
			 * ball.yPos-ball.getySpeed(); }
			 */

		}
		// addBall(ball);
		System.out.println(balls.size());
	}
	

	private void isBallBouncing(Ball ball) {
		
		if (ball.getxPos() >= (DEFAULT_PANELWIDTH - 20)) {
			ball.setMoveRight(false);
			ball.bounce();
		}
		if (ball.getxPos() <= 20) {
			ball.setMoveRight(true);
			ball.bounce();
		}
		if (ball.getyPos() >= (DEFAULT_PANELHEIGHT - 20)) {
			ball.setMoveDown(false);
			ball.bounce();
		}
		if (ball.getyPos() <= 20) {
			ball.setMoveDown(true);
			ball.bounce();
		}
		
	}

	public void run() {
		while (!gameFinished) {
			try {
				
				moveMyBalls();
				userView.repaint();
				Thread.sleep(1000 / DEFAULT_FPS);

				// Check if game has ended
				if (player.hasDied()) {
					gameFinished = true;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// TODO: a loop that keeps the game running, ends when player 'dies'.

	}
}
