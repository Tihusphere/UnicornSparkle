package game;
import java.awt.*;
import game.Point;
/**
 * CLASS: Unicorn
 * DESCRIPTION: Creates a unicorn element. This is the element that the user controls with the keyboard inputs.
 * It also has different animations (different set of polygons) when it moves up or down. 
 * The UnicornState enum is used here to help with animations and movement. 
 */

public class Unicorn extends Element{
	private UnicornState state;
	private Animation[] animations;
	
	/**
	 * INNER CLASS: Animation
	 * DESCRIPTION: Provides details for different animations to be when the Unicorn moves up, down, and remains at rest.
	 * Creates different polygon elements in the initalization block and adds them to an array of animations, 
	 * all of which are scaled up by a value so the Unicorn is big enough on the screen. 
	 */
	public class Animation {
		private int degreeOfRotation;
		private Point[] shape;
		private static int mod = 8;
		
		/**
		 * Animation constructor
		 * @param degree the direction and amount of rotation the Unicorn rotates while moving up or down.
		 * @param shapePts 	array of points that outlines this animation
		 */
		public Animation(int degree, int[][] shapePts) {
			this.degreeOfRotation = degree;
			Point[] shape = new Point[shapePts.length];
			for (int i = 0; i < shapePts.length; i++) {
				shape[i] = new Point(shapePts[i][0]*mod, shapePts[i][1]*mod);
			}
			this.shape = shape;
		}
	}
	
	
	{ 
		animations = new Animation[3];
		
		int[][] upShape = {{0,0},{1,2},{1,3},{0,3},{0,5},{2,5},{2,11},{3,12},
				{4,12},{3,11},{3,10},{4,10},{4,11},{5,12},{6,12},{5,11},{5,10},
				{6,10},{7,12},{8,12},{8,7},{7,7},{7,6},{9,6},{10,5},{10,4},{6,4}
				,{4,6},{4,2},{2,2}};
		animations[0] = new Unicorn.Animation(15, upShape);
		
		int[][] centerShape = {{0,0},{1,2},{1,3},{0,3},{0,5},{2,5},{2,12},
				{3,12},{3,10},{4,10},{4,12},{5,12},{5,10},{6,10},{6,12},{8,12},
				{8,7},{7,7},{9,5},{9,3},{7,3},{4,6},{4,2},{2,2}};
		animations[1] = new Unicorn.Animation(0, centerShape);
		
		int[][] downShape = {{0,0},{1,2},{1,3},{0,3},{0,5},{2,5},{2,11},{3,12},
				{4,12},{3,11},{3,10},{4,10},{4,11},{5,12},{6,12},{5,11},{5,10},
				{6,10},{7,12},{8,12},{8,7},{7,7},{7,6},{9,6},{10,5},{10,4},{6,4}
				,{4,6},{4,2},{2,2}};
		animations[2] = new Unicorn.Animation(-15, downShape);
	}
	
	/**
	 * Constructor for Unicorn 
	 * Creates a Unicorn at a certain position on the board and sets it's state (center).
	 * 
	 * @param position
	 */
	public Unicorn(Point position) {
		super(new Point[]{new Point(0,0), new Point(0,1)}, position, 0);
		state = UnicornState.CENTER;
		changeState(state);
	}
	
	/**
	 * Paints the Unicorn into the game with a pink outline.
	 */
	public void paint(Graphics brush) {
		brush.setColor(Color.pink);
		super.paint(brush);
	}
	
	/**
	 * Moves the Unicorn up, down, or allows it to remain at rest.
	 * 	
	 * @param movement integer value that determines movement (positive -> upwards, negative --> downwards)
	 */
	public void move(int movement) {
		
		if (movement > 0) {
			changeState(UnicornState.UP);
		} else if (movement < 0) {
			changeState(UnicornState.DOWN);
		} else {
			changeState(UnicornState.CENTER);
		}
		
		super.move(0, -movement, 0);
	}
	
	/**
	 * Changes the 'state' of the Unicorn (the enum) which allows the animation to change as well.
	 *  
	 * @param state
	 */
	private void changeState(UnicornState state) {
		this.state = state;
		super.shape = animations[state.ordinal()].shape;
		super.rotate(animations[state.ordinal()].degreeOfRotation);
	}
}
