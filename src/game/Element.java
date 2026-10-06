package game;
import game.Polygon;
import java.awt.*;
import game.Point;

public class Element extends Polygon {
	
	public Element(Point[] points, Point position, double rotation) {
		super(points, position, rotation);
	}
	
	private int[][] getXYPoints() {
		Point[] points = super.getPoints();
		int[][] ret = new int[2][points.length];
		
		for(int i = 0; i < points.length; i++) {
			ret[0][i] = (int) points[i].x;
			ret[1][i] = (int) points[i].y;
		}
		
		return ret;
	}
	
	public void paint(Graphics brush) {
		int[][] pointsXY = getXYPoints();
		brush.drawPolygon(pointsXY[0], pointsXY[1], pointsXY[0].length);
	}
	
	public void move(int x, int y) {
		position.x += x;
		position.y += y;
	}
}
