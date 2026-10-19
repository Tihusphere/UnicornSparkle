package game;

import java.awt.*;

public class ThunderCloud extends Element implements GameItem{
	private int scoreVal;
	private Pickupable pickup;
	
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
	
	public void pickup() {
		this.pickup.pickup(scoreVal);
	} 
	
	public void paint(Graphics brush) {
		brush.setColor(Color.gray);
		super.paint(brush);
	}
}
