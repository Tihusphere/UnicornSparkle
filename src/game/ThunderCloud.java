package game;

public class ThunderCloud extends Element implements Pickupable{
	private int scoreVal;
	
	public ThunderCloud(Point[] points, Point position, double rotation) {
		super(points, position, rotation);
		scoreVal = 0;
	}
	
	public void pickup() {
		
	} 
}
