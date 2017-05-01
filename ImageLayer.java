package groupProject;


import java.awt.*;

import javax.swing.ImageIcon;

public class ImageLayer{
   Image image;//image that'll be used as background and could add tile map if you want
   int x;//x-position for the image
   int y;//y-position for the image
   int totalx;
   int totaly;
   int A = 0;
   Rect CamBorder = new Rect(0,0, 1, 1, 0);
   /*
   double x_offsetMax = image.getHeight(this) + GameJPanel.frameWidth;
   double y_offsetMax = image.getWidth(this) + GameJpanel.frameHeight;
   double x_offsetMin = 0;
   double y_offsetMin = 0;
    //&& layer1.totalx >= x_offsetMax 
			   //&& layer1.totaly >= y_offsetMax) 
			  // && layer1.totalx <= 0 )
			   /*&& layer1.totaly <= 0 )
   */
   
//---------- constructor --------------------------------------------------------------------------------------------------------------------------------
   public ImageLayer(String filename, int x, int y){//z and w
	  //TookKit loads the image in another thread, so it takes longer to paint in the Game_loop 
      image = new ImageIcon(filename).getImage();//ImageIcon loads the image and waits for it to 
      											//finish loading before painting anything(pg. 36)
      this.x = x;//set the x-position
      this.y = y;//set the y-position
   }
   public void moveUpBy(int dy)
   {
      y -= dy;
   }

   public void moveDownBy(int dy)
   {
      y += dy;
   }

   public void moveLeftBy(int dx)
   {
      x -= dx;
   }

   public void moveRightBy(int dx)
   {
      x += dx;
   }
   /*
   public boolean hasCollidedWith(Rect r)
	{
		return ((r.x <= x+w) && (r.x+r.w >= x) && (r.y+r.h>= y) && (r.y<= y+h));
	}
//*/
   public double leftOrRight(int x, int y)//left or right of the enemy
   {
	   return (x- this.totalx) * Lookup.sin[A] - (y- this.totaly) * Lookup.cos[A];
   }
   public double distanceTo(int x, int y)
   {
	   return (x- this.totalx) * Lookup.cos[A] + (y- this.totaly) * Lookup.sin[A];
   }

//---------- draw method --------------------------------------------------------------------------------------------------------------------------------
   public void draw(Graphics g){
	   totalx = x - Camera2d.x;
	   totaly = y - Camera2d.y;
	   
	   g.drawImage(image, totalx, totaly, null);
	   g.setColor(Color.green);
	   g.drawRect((int)CamBorder.x-Camera2d.x,(int)CamBorder.y-Camera2d.y, CamBorder.w, CamBorder.h);
	   
	   /*
	   if(x > x_offsetMax)
	    {x = (int) x_offsetMax;
	    g.translate((int)x, 0);}
	   if (x < x_offsetMin)
	    {x = (int) x_offsetMin;
	    g.translate((int)x, 0);}
	   if (y > y_offsetMax)
	    {y = (int)y_offsetMax;
	    g.translate(0, (int)y);}
	   if (y < y_offsetMin)
	    {y = (int) y_offsetMin;
	    g.translate(0,(int) y);}
	   */
	 //* 
	   
 
	  
	   
   }
}