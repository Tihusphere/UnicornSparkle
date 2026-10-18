package game;
import java.awt.*;
import game.Point;

public class Unicorn extends Element{
	private UnicornState state;
	private static Animation[] animations;
	
	public class Animation {
		private int degreeOfRotation;
		private Point[] shape;
		
		public Animation(int degree, Point[] shape) {
			this.degreeOfRotation = degree;
			this.shape = shape;
		}
		
	}
	
	{ //animation states init
		Point[] upShape = {new Point(2,0), new Point(2,7), new Point(0,7), new Point(0,9), new Point(1,9), new Point(1,10), new Point(0,12), new Point(2,10), new Point(4,10), new Point(4,7), new Point(5,7), new Point(8,10), new Point(10,10), new Point(10,7), new Point(7,5), new Point(8,5), new Point(8,0), new Point(6,0), new Point(6,2), new Point(5,2), new Point(5,0), new Point(4,0), new Point(4,2), new Point(3,2), new Point(3,0)};
		animations[0] = new Unicorn.Animation(0, upShape);
		
		Point[] centerShape = {new Point(0,0)};
		animations[0] = new Unicorn.Animation(0, centerShape);
		
		Point[] downShape = {new Point(0,0)};
		animations[0] = new Unicorn.Animation(0, downShape);
	}
	
	public Unicorn(Point position) {
		super(animations[UnicornState.CENTER.ordinal()].shape, position, 
				animations[UnicornState.CENTER.ordinal()].degreeOfRotation);
		state = UnicornState.CENTER;
	}
	
	
	public void paint(Graphics brush) {
		super.paint(brush);
	}
	
	public void move(int movement) {
		
		if (movement > 0) {
			changeState(UnicornState.UP);
		} else if (movement < 0) {
			changeState(UnicornState.DOWN);
		} else {
			changeState(UnicornState.CENTER);
		}
		
		super.move(0, movement, 0);
	}
	
	private void changeState(UnicornState state) {
		this.state = state;
		super.shape = animations[state.ordinal()].shape;
		super.rotate(animations[state.ordinal()].degreeOfRotation);
	}
}
