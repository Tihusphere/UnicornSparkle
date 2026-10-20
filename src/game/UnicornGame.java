package game;

/**
CLASS: UnicornGame
DESCRIPTION: Extending Game, UnicornGame is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class UnicornGame extends Game implements KeyListener{

	private Scorekeeper score;
	private Unicorn unicorn;
	private Star star;
	private ThunderCloud cloud;
	
	private Random rand;
	private long frameCount;
	private ArrayList<Element> objects;
	private int hits;
	
	/**
	 * Constructor for UnicornGame.
	 * 
	 * Initializes scorekeeper object, creates the one unicorn for the game (controlled by player).
	 * Instantiates random object, and integers frameCount and hits to be used within the paint() method.
	 * frameCount dictates when elements should spawn into the GUI frame.
	 * hits counts how many thunderclouds have been hit, which determines when the game is over.
	 * The arrayList of objects is used to centralize moving the elements and checking for collisions.
	 * 
	 */
	public UnicornGame() {
		super("Unicorn Game!",800,600);
		this.setFocusable(true);
		this.requestFocus();

		score = new Scorekeeper();
		unicorn = new Unicorn(new Point(720, 230));
		rand = new Random();
		frameCount = 0;
		hits = 0;
		
		objects = new ArrayList<Element>();
		
		this.addKeyListener(this);
	
	}
  
	/**
	 * INNER CLASS: Scorekeeper
	 * DESCRIPTION: Stores and maintains score for the game. Also evaluates when the game is over.
	 */
	public class Scorekeeper {
		private int score;
	 
		/**
		 * Constructor for Scorekepper. Assigns initial score to 0.
		 */
	 	public Scorekeeper() {
	 		score = 0;		 	
	 	} 
	 	
	 	/**
	 	 * Gets the score. Used at the end of the game to display final score.
	 	 * @return current score.
	 	 */
		public int getScore() {
	 		return score;
	 	}
		 
		/**
		 * Updates the score. 
		 * Use with the pickup() method in functional interface Pickupable() as described
		 * in lambda function implementation.
		 * 
		 * @param num 	value that is added to current score (the value from the Star or ThunderCloud element)
		 */
		public void updateScore(int num) {
	 		score += num;
	 	}
		 
		/**
		 * Checks if the game is over. Game ends when 3 thunderclouds have been hit.
		 * 
		 * @return boolean value (true if game is over, false if not).
		 */
		public boolean isGameOver() {
	 		if (hits >= 3) {
	 			return true;
	 		}
		 	return false; 
		}
	}
  
	/**
	 * Core funcitonality that runs the game. 
	 * First, sets the board to a black screen with predefined width and height.
	 * 
	 * Then, checks if the game is over by calling Scorekeepers' isGameOver() method. If the game is over, 
	 * displays a game over message, final score, and instructions to replay the game in the GUI.
	 * 
	 * If the game isn't over, a unicorn remains painted on the screen. Every few frames, a cloud and a star spawn into 
	 * the game screen at a randomly generated y coordinate along a predefined column at the leftmost side of the screen.
	 * Every frame, each star and cloud present moves eastward (right) towards the Unicorn. The player must use the up 
	 * and down arrows to avoid the clouds and catch the stars. When it collides into either, that element disappears. 
	 * The arraylist of elements aids with the collision checking, and an element is removed from both the game GUI and 
	 * the arrayList upon collision.
	 * 
	 * The game ends once the Unicorn collides into 3 clouds.
	 * 
	 */
  	public void paint(Graphics brush) {
    	brush.setColor(Color.black);
    	brush.fillRect(0,0,width,height);
    	
    	if (score.isGameOver()) {
    		brush.setColor(Color.RED);
    		brush.drawString("Game Over!", 300, 300);
    		brush.drawString("Your Score: " + score.getScore(), 400, 300);
    		brush.drawString("Close the window and rerun the program to play again!", 220, 320);
    	}
    	
    	else {
    		unicorn.paint(brush);
        	
        	for (int index = 0; index < objects.size(); index++) {
           		Element element = objects.get(index);
           		element.paint(brush);
           		element.move(1, 0, 0);
           		
           		if (element.checkCollision(unicorn)) {
           			if (element.getClass().equals(star.getClass())) {
           				((Star)element).pickup();
           				objects.remove(element);
           			}
           			else if (element.getClass().equals(cloud.getClass())) {
           				((ThunderCloud)element).pickup();
           				objects.remove(element);
           				hits++;
           			}
           		}
           	}
        	
        	if (frameCount % 300 == 0) {
        		star = new Star(new Point(90, rand.nextInt(10, 520)), 5, (scoreVal) -> score.updateScore(scoreVal));
            	objects.add(star);
              	cloud = new ThunderCloud(new Point(10, rand.nextInt(10, 520)), 10, (scoreVal) -> score.updateScore(scoreVal));
              	objects.add(cloud);
        	}
           	
           	frameCount = frameCount + 1L;
    	}
  
  	}
  
	public static void main (String[] args) {
   		UnicornGame a = new UnicornGame();
		a.repaint();
  }

	/**
	 * keyTyped method from the KeyListener class --> it's here, but not implemented and not needed.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * Moves the Unicorn depending on which key is being pressed. Up arrow triggers upwards movement, while Down arrow
	 * triggers downwards movement. 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == e.VK_UP) {
			unicorn.move(5);
		}
		else if (e.getKeyCode() == e.VK_DOWN){
			unicorn.move(-5);
		}
		
	}

	/**
	 * When either arrow key is released, the unicorn remains at rest.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		unicorn.move(0);
		
	}
}