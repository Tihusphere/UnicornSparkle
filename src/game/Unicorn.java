package game;

public class Unicorn extends Element{
	private UnicornState state;
	private Animation[] animations;
	
	public Unicorn(Point[] points, Point position, double rotation) {
		super(points, position, rotation);
		state = UnicornState.CENTER;
		animations = new Animation[5];
	}
	//initialization blocks for objects of animation class
		
	public class Animation {
		public int degreeOfRotation;
		public Point[] shape;
		
		public Animation() {
			
		}
		
	}
	{ //initialize types of animations
		
	}			

	{
			
	}
		
	{
			
	}
	
	
	public void paint() {
		
	}
	
	public void move(int movement) {
		
	}
	
	public void changeState(UnicornState state) {
		
	}
}
