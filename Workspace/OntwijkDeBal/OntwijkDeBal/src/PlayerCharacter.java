
public class PlayerCharacter extends GameObject {

	//Fields
	private int lives;
	private int score;
	
	
	//Constructor
	public PlayerCharacter(int xPos,int yPos,int moveSpeed, int lives) {
		super(xPos, yPos, moveSpeed);
		this.lives=lives;
	}
	
	
	//Methods
	public void hit() {
		lives = lives-1;
		
	}
	
	public boolean hasDied() {
		if (lives<=0) {
			return true;
		}
		return false;
	}
	
	public int getScore() {
		return score;
	}
}
