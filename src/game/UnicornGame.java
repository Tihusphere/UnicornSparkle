package game;

/*
CLASS: UnicornGame
DESCRIPTION: Extending Game, UnicornGame is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class UnicornGame extends Game {

	private Scorekeeper score;
	private Unicorn unicorn;
	private ArrayList<Pickupable> objects;
	
			
  public UnicornGame() {
    super("Unicorn Game!",800,600);
    this.setFocusable(true);
	this.requestFocus();
	
	score = new Scorekeeper();
	unicorn = new Unicorn(new Point(400, 300));
	//what needs to happen here:
	//needs to crate multiple objects of thunderCloud and Star classes (every few seconds we have more objects added to the arrayList of pickupable objects
	//every frame, has to check if the unicorn bumped into a thundercloud or a star
	//if collision occured, then edit the score
	//once there have been 3 collisions, then the game should be over.
	//then clear the board and draw the string "game over. Final Score: <display score>"
	
	
	objects = new ArrayList<Pickupable>();
	
  }
  
  public class Scorekeeper {
	 private int score;
	 
	 public Scorekeeper() {
		 score = 0;
	 }
	 
	 public int getScore() {
		 return score;
	 }
	 
	 public void updateScore(int num) {
		 score += num;
	 }
	 
	 public boolean isGameOver() {
		 return false; /* placeholder value until we implement this method */
	 }
  }
  
  	public void paint(Graphics brush) {
    	brush.setColor(Color.black);
    	brush.fillRect(0,0,width,height);
    	unicorn.paint(brush);
    	
  	}
  
	public static void main (String[] args) {
   		UnicornGame a = new UnicornGame();
		a.repaint();
  }
}