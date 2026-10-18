package game;

public class ThunderCloud extends Element implements Pickupable{
	private int scoreVal;
	private Pickupable pickup;
	
	public ThunderCloud(Point[] points, Point position, double rotation, 
			Pickupable pickup, int score) {
		super(points, position, rotation);
		this.scoreVal = score;
		this.pickup = pickup;
	}
	
	public void pickup() {
		
		this.pickup.pickup();
	} 
}
