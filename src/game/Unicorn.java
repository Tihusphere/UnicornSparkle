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
		Point[] upShape = {new Point(0,0)};
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
		super.move(0, movement, 0);
	}
	
	public void changeState(UnicornState state) {
		this.state = state;
		super.shape = animations[state.ordinal()].shape;
		super.rotate(animations[state.ordinal()].degreeOfRotation);
	}
}
