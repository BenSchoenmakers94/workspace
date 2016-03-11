import java.awt.Color;
import java.util.Random;

public class Ball extends GameObject {

	// Fields
	private int nrOfBounces;
	private int maxBounces;
	private Color color;

	private double maxMoveSpeed;
	private double direction;
	private int xSpeed;
	private int ySpeed;
	private boolean hasDirection;
	private boolean moveRight;
	private boolean moveDown;

	private boolean hasSplit;

	private int radius;

	private final int DEFAULT_MAXBOUNCES = 5;
	private final int DEFAULT_RADIUS = 40;
	private final Color DEFAULT_COLOR = Color.RED;

	// Constructor
	public Ball(int xPos, int yPos, double moveSpeed) {
		super(xPos, yPos, moveSpeed);
		maxBounces = DEFAULT_MAXBOUNCES;
		nrOfBounces=0;
		radius = DEFAULT_RADIUS;
		color = DEFAULT_COLOR;
		hasSplit=false;
		

	}

	public Ball(int xPos, int yPos, double moveSpeed, int maxBounces) {
		super(xPos, yPos, moveSpeed);
		this.maxBounces = maxBounces;
		nrOfBounces=0;
		radius = DEFAULT_RADIUS;
		color = DEFAULT_COLOR;
		hasSplit=false;
		
	}

	// Methods
	public int getRadius() {
		return radius;
	}

	public boolean isHasSplit() {
		return hasSplit;
	}

	public void setHasSplit(boolean hasSplit) {
		this.hasSplit = hasSplit;
	}

	public int getNrOfBounces() {
		return nrOfBounces;
	}

	public void setMaxMoveSpeed(int maxMoveSpeed) {
		this.maxMoveSpeed = maxMoveSpeed;
	}

	public boolean hasDirection() {
		return hasDirection;
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public boolean getMoveRight() {
		return moveRight;
	}

	public boolean getMoveDown() {
		return moveDown;
	}

	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}

	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}
	public int getMaxBounces() {
		return maxBounces;
	}

	public void bounce() {
		nrOfBounces++;
		if (nrOfBounces < maxBounces) {
			accelerate();

		}
		
		move();
	}

	private void accelerate() {
		if (this.maxMoveSpeed > this.moveSpeed) {
			this.moveSpeed = this.moveSpeed + (this.moveSpeed / 4);
		}
	}

	public void split() {
		hasSplit = true;
	}

	private void move() {
		
		xSpeed = (int) (moveSpeed * Math.cos(direction));
		ySpeed = (int) (moveSpeed * Math.sin(direction));
		
		//If ball is moving right, make sure xSpeed is positive
		if (getMoveRight()) {
			if (getxSpeed()<0) {
				
				xSpeed=xSpeed-(2*xSpeed);
			}
		} else {
			if (getxSpeed()>0) {
				
				xSpeed=xSpeed-(2*xSpeed);
			}
		}
		
		//if ball is moving down, make sure ySpeed is positive
		if (moveDown) {
			if (getySpeed()<0) {
				ySpeed=ySpeed-(2*ySpeed);
				
			}
		} else {
			if (getySpeed()>0) {
				ySpeed=ySpeed-(2*ySpeed);
				
			}
		}
	}

	public void moveRandomDirection() {

		direction = Math.random() * 2.0 * Math.PI;

		xSpeed = (int) (moveSpeed * Math.cos(direction));
		ySpeed = (int) (moveSpeed * Math.sin(direction));
		hasDirection = true;

		/*
		 * if (moveRight) { do { direction=Math.random()*2.0*Math.PI; xSpeed=
		 * (int) (moveSpeed*Math.cos(direction)); } while (xSpeed>=1); } else {
		 * do { direction=Math.random()*2.0*Math.PI; xSpeed= (int)
		 * (moveSpeed*Math.cos(direction)); } while (xSpeed<1); }
		 * 
		 * if (moveDown) { do { direction=Math.random()*2.0*Math.PI; ySpeed=
		 * (int) (moveSpeed*Math.sin(direction)); } while (ySpeed>=1); } else {
		 * do { direction=Math.random()*2.0*Math.PI; ySpeed= (int)
		 * (moveSpeed*Math.sin(direction)); } while (ySpeed<1); }
		 */

	}

}
