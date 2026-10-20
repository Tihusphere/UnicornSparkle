package game;

import java.awt.*;

/**
 * CLASS: ThunderCloud
 * DESCRIPTION: Thunderclouds are the 'obstacles' of the game. If a Unicorn collides into one, the score will decerase.
 * Too many hits and the game is over!
 */
public class ThunderCloud extends Element implements GameItem{
	private int scoreVal;
	private Pickupable pickup;
	
	/**
	 * ThunderCloud constructor. Defines Thundercloud's points and scales it up to the correct size.
	 * 
	 * @param position sets the position on the swing GUI board
	 * @param score	sets the value that the player's score is decremented by.
	 * @param pickup provides implementation for Pickupable functional interface's method, which updates the score.
	 */
	public ThunderCloud(Point position, int score, Pickupable pickup) {
		super(new Point[]{new Point(0,0)}, position, 0);
		this.scoreVal = score;
		this.pickup = pickup;
		
		int mod = 5;
		int[][] shapePts = {{5,0},{9,0},{10,1},{10,3},{12,3},{14,5},{14,7},
				{13,8},{1,8},{0,7},{0,4},{1,3},{4,3},{4,1}};
		Point[] shape = new Point[shapePts.length];
		for (int i = 0; i < shapePts.length; i++) {
			shape[i] = new Point(shapePts[i][0]*mod, shapePts[i][1]*mod);
		}
		super.shape = shape;
	}
	
	/**
	 * Calls pickup() method in Pickupable interface. Called upon collision with Unicorn, which updates the player's score.
	 * 	 
	 */
	public void pickup() {
		this.pickup.pickup(scoreVal);
	} 
	
	/**
	 * Paints the Thunder Cloud in the game with a gray outline.
	 */
	public void paint(Graphics brush) {
		brush.setColor(Color.gray);
		super.paint(brush);
	}
}
