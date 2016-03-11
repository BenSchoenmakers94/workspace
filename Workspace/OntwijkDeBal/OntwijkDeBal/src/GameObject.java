
public class GameObject {

	//Fields
	protected int xPos;
	protected int yPos;
	protected double moveSpeed;
	
	//Constructor
	public GameObject(int xPos,int yPos,double moveSpeed) {
		this.xPos=xPos;
		this.yPos=yPos;
		this.moveSpeed=moveSpeed;
	}
	
	//Methods
	public int getxPos() {
		return xPos;
	}
	
	public int getyPos() {
		return yPos;
	}
}
