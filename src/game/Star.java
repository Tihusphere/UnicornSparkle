package game;
/**
 * CLASS: Star
 * DESCRIPTION: Creates a yellow star element that can hurl and spin towards the Unicorn. Multiple stars will be created 
 * during the game. Colliding with a star increases the player's score. 
 * USAGE: Star instances are created within the UnicornGame class.
 */
import java.awt.*;

import game.Point;

public class Star extends Element implements GameItem{
	private int scoreVal;
	private Pickupable pickup;
	
	/**
	 * Constructor for Star class. Assigns the set of points that outline a star and creates a Point[] array to store 
	 * aforementioned points. The mod integer scales all the points up to make the star a realistic size 
	 * relative to the Unicorn.
	 * 
	 * @param position	assigns initial position of the element on the game GUI
	 * @param score		assigns the value by which the player's score is increased by (upon the Unicorn's collision with the star).
	 * @param pickup	assigns implementation of pickup() method 
	 */
	public Star(Point position, int score, Pickupable pickup) {
		super(new Point[]{new Point(0,0)}, position, 0);
		this.scoreVal = score;
		this.pickup = pickup;
		
		int mod = 3;
		int[][] shapePts = {{7,0},{12,6},{16,6},{13,8},{16,16},{9,11},{0,16},{3,8},{0,6},{4,6}};
		Point[] shape = new Point[shapePts.length];
		for (int i = 0; i < shapePts.length; i++) {
			shape[i] = new Point(shapePts[i][0]*mod, shapePts[i][1]*mod);
		}
		super.shape = shape;
	}
	
	/**
	 * Calls the pickup() method from Pickupable class, which increases the player's score based on the Star's score value.
	 */
	public void pickup() {
		this.pickup.pickup(scoreVal);
	} 
	
	/**
	 * Paint method that allows a Star to appear on the swing GUI.
	 */
	public void paint(Graphics brush) {
		brush.setColor(Color.yellow);
		super.rotate(1);
		super.paint(brush);
	}
}
