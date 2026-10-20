package game;

import java.awt.*;
/**
 * INTERFACE: GameItem
 * DESCRIPTION: Provides two methods that will be common among all 3 items drawn in the game (ThunderCloud, Star, Unicorn)
 * USAGE: Methods are overridden by implementing classes (Star and ThunderCloud)
 */
public interface GameItem {
	/**
	 * Provides specific paint method for an element so brush can be assigned to a different color.
	 * @param brush 	Graphics object used to call methods to draw the element  
	 */
	public void paint(Graphics brush);
	/**
	 * Provides actions upon 'picking up' (colliding with) an element. 
	 */
	public void pickup();
}
