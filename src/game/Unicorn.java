package game;

public class Unicorn extends Element{
	private UnicornState state;
	private Animation[] animations;
	
	public Unicorn(Point[] points, Point position, double rotation) {
		super(points, position, rotation);
		state = UnicornState.CENTER;
		animations = new Animation[5];
	}
	
	public class Animation {
		public int degreeOfRotation;
		public Point[] shape;
		
		public Animation() {
			
		}
	}
	
	public void paint() {
		
	}
	
	public void move(int movement) {
		
	}
	
	public void changeState(UnicornState state) {
		
	}
}
