package game;

/*
CLASS: YourGameName
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

class UnicornGame extends Game {

  public UnicornGame() {
    super("YourGameName!",800,600);
    this.setFocusable(true);
	this.requestFocus();
	
  }
  
	public void paint(Graphics brush) {
    	brush.setColor(Color.black);
    	brush.fillRect(0,0,width,height);
    	
  }
  
	public static void main (String[] args) {
   		UnicornGame a = new UnicornGame();
		a.repaint();
  }
}