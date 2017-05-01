package groupProject;
import java.awt.*;

public class Game_loop extends GameJPanel{
	private static final long serialVersionUID = 1L;
//---------- instance objects --------------------------------------------------------------------------------------------------------------------------------------
	ImageLayer layer1 = new ImageLayer("bkg.png", 0, 0);
	player hero = new player(100, 100, 0);
	minion badguy  = new minion(200,200,0);
	
//---------- constructor -------------------------------------------------------------------------------------------------------------------------------------------
	public void startTheGame(){
		startGame();//call the method that starts the game in GameJPanel
	}
	
//---------- respond to input --------------------------------------------------------------------------------------------------------------------------------------
	public void respondToInput(){
       hero.respondToInput(input);
	   if(input[GameJPanel.UP])  Camera2d.moveUpBy(1);
	   if(input[GameJPanel.DN])  Camera2d.moveDownBy(1);
	   if(input[GameJPanel.LT])  Camera2d.moveLeftBy(1);
	//   if(input[GameJPanel.RT])  Camera2d.moveRightBy(1);
   }

//---------- moveGameObjects ---------------------------------------------------------------------------------------------------------------------------------------
   public void moveGameObjects(){
      badguy.chase(hero);
   }

//---------- handle collisions -------------------------------------------------------------------------------------------------------------------------------------
   public void handleCollisions(){
   }

//---------- draw the instances ------------------------------------------------------------------------------------------------------------------------------------
   @Override
   public void paint(Graphics g){
	   super.paintComponent(g);//prints the panel where every component will be placed
	   layer1.draw(g);//draw image background
	   hero.draw(g);//draw hero
	   badguy.draw(g);//draw bad guy
   }
   
//---------- main method -------------------------------------------------------------------------------------------------------------------------------------------
   public static void main(String[] args){
	   Game_loop game = new Game_loop();//create a Game_loop object
	   game.startGame();//that will start the thread for the game
   }	
}
