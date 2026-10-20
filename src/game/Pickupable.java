package game;
/**
 * INTERFACE: Pickupable
 * DESCRIPTION: Functional interface that provides pickup() method. 
 * USAGE: Implemented by the UnicornGame (class that provides 'main functioning' to display elements into the Swing GUI)
 * 			via lambda function
 */
@FunctionalInterface
public interface Pickupable {
	/**
	 * Method instantiated with the lambda function that updates the score in the ScoreKeeper inner class of UnicornGame
	 * @param score
	 */
	public void pickup(int score);
}
