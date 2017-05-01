package groupProject;
import java.awt.*;

import javax.swing.ImageIcon;

public class ImageLayer{
   Image image;//image that'll be used as background
   double x;//x-position for the image
   double y;//y-position for the image
   
//---------- constructor --------------------------------------------------------------------------------------------------------------------------------
   public ImageLayer(String filename, double x, double y){
	  //TookKit loads the image in another thread, so it takes longer to paint in the Game_loop 
      image = new ImageIcon(filename).getImage();//ImageIcon loads the image and waits for it to 
      											//finish loading before painting anything(pg. 36)
      this.x = x;//set the x-position
      this.y = y;//set the y-position
   }

//---------- draw method --------------------------------------------------------------------------------------------------------------------------------
   public void draw(Graphics g){
       g.drawImage(image, (int)(x - Camera2d.x), (int)(y - Camera2d.y), null);
   }
}