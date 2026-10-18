package game;
import java.awt.*;
import game.Point;

public class Unicorn extends Element{
	private UnicornState state;
	private Animation[] animations;
	
	public class Animation {
		private int degreeOfRotation;
		private Point[] shape;
		private static int mod = 8;
		
		public Animation(int degree, int[][] shapePts) {
			this.degreeOfRotation = degree;
			Point[] shape = new Point[shapePts.length];
			for (int i = 0; i < shapePts.length; i++) {
				shape[i] = new Point(shapePts[i][0]*mod, shapePts[i][1]*mod);
			}
			this.shape = shape;
		}
	}
	
	{ //animation states init
		animations = new Animation[3];
		
		int[][] upShape = {{0,0}};
		animations[0] = new Unicorn.Animation(0, upShape);
		
		int[][] centerShape = {{0,0},{1,2},{1,3},{0,3},{0,5},{2,5},{2,12},{3,12},{3,10},{4,10},{4,12},{5,12},{5,10},{6,10},{6,12},{8,12},{8,7},{7,7},{9,5},{9,3},{7,3},{4,6},{4,2},{2,2}};
		animations[1] = new Unicorn.Animation(0, centerShape);
		
		int[][] downShape = {{0,0}};
		animations[2] = new Unicorn.Animation(0, downShape);
	}
	
	public Unicorn(Point position) {
		super(new Point[]{new Point(0,0), new Point(0,1)}, position, 0);
		state = UnicornState.CENTER;
		changeState(state);
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
