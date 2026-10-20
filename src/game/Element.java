package game;
import game.Polygon;
import java.awt.*;
import game.Point;
/**
 * CLASS: Element
 * DESCRIPTION: 
 */
public class Element extends Polygon {
	
	/**
	 * Constructor for Element class
	 * 
	 * @param points	set of points that defines the outline of an element
	 * @param position	starting position of the elemenet in the swing GUI interface
	 * @param rotation	degree that the element will be rotated from it's original position (typically 0 is passed) 
	 */
	public Element(Point[] points, Point position, double rotation) {
		super(points, position, rotation);
	}
	
	/**
	 * Turns all points in an element into a format that allows the polygon function 'draw' to work.
	 * 
	 * @return ret	the two-dimensional array of all points in the element.
	 */
	private int[][] getXYPoints() {
		Point[] points = super.getPoints();
		int[][] ret = new int[2][points.length];
		
		for(int i = 0; i < points.length; i++) {
			ret[0][i] = (int) points[i].x;
			ret[1][i] = (int) points[i].y;
		}
		
		return ret;
	}
	
	/**
	 * Paints the element onto the game GUI by allowing the Graphics brush to paint the outline created by the array of points
	 * 	predefined within this class.
	 * 
	 * @param brush
	 */
	public void paint(Graphics brush) {
		int[][] pointsXY = getXYPoints();
		brush.drawPolygon(pointsXY[0], pointsXY[1], pointsXY[0].length);
	}
	
	/**
	 * Moves the element in a certain x and y direction, as well as rotates the element a certain degrees
	 * 
	 * @param x int value for left/right movement
	 * @param y int value for up/down movement
	 * @param r double value for degree of rotation
	 */
	public void move(int x, int y, int r) {
		position.x += x;
		position.y += y;
		super.rotate(r);
	}
	
	/**
	 * Checks if two elements have touched. Loops through all points in the second element and checks if it touches
	 * 	any of the first element's points.
	 * In this case, the elements that move horizontally (thundercloud and star) call the method, 
	 * 	and pass Unicorn as the parameter.
	 * 
	 * @param e	this is the element that is being checked against the element calling the method. 
	 * @return boolean (true if collision occurred, false if not)
	 */
	public boolean checkCollision(Element e) {
		for (Point p : e.getPoints()) {
			if (super.contains(p)) {
				return true;
			}
		}
		return false;
	}
}
