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
import java.util.Random;

class UnicornGame extends Game {

	private Scorekeeper score;
	private Unicorn unicorn;
	private Star star;
	private ThunderCloud cloud;
	
	private Random rand;
	private long frameCount;
	private ArrayList<Element> objects;
	private int hits;
	
	public UnicornGame() {
		super("Unicorn Game!",800,600);
		this.setFocusable(true);
		this.requestFocus();
	
		score = new Scorekeeper();
		unicorn = new Unicorn(new Point(720, 230));
		rand = new Random();
		frameCount = 0;
		hits = 0;

	//every frame, has to check if the unicorn bumped into a thundercloud or a star
	//if collision occured, then edit the score
	//once there have been 3 collisions, then the game should be over.
	//then clear the board and draw the string "game over. Final Score: <display score>"
	
	
		objects = new ArrayList<Element>();
	
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
	 		if (hits >= 3) {
	 			return true;
	 		}
		 	return false; 
		}
	}
  
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
        	
        	if (frameCount % 50 ==0) {
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
}