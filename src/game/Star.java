package game;

import java.awt.*;

import game.Point;

public class Star extends Element implements GameItem{
	private int scoreVal;
	private Pickupable pickup;
	
	public Star(Point position, Pickupable pickup, int score) {
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
	
	public void pickup() {
		this.pickup.pickup(scoreVal);
	} 
	
	public void paint(Graphics brush) {
		brush.setColor(Color.yellow);
		super.paint(brush);
	}
}
