package groupProject;

public class Camera2d{
   static int x;//position to place the camera
   static int y;//height to place the camera
   static int Angle = 0;//angle it'll be facing
   static boolean CAMmoving = false;//is the camera moving?
   
/**************************************************************************************************************************************************************************************
* This function is used to move the camera's coordinates by a certain amount
* @param dx
* @param dy
*/
   public static void moveBy(int dx, int dy){
		x += dx; 
		y += dy;
	}
   
/**************************************************************************************************************************************************************************************
* This function is used to move the character up by decreasing the y-coordinate
* @param dy
*/
   public static void moveUpBy(int dy){
      y -= dy;
      CAMmoving = true;
   }

/**************************************************************************************************************************************************************************************
* This function is used to move the character down by increasing the y-coordinate
* @param dy
*/
   public static void moveDownBy(int dy){
      y += dy;
      CAMmoving = true;
   }

/**************************************************************************************************************************************************************************************
* This function is used to move the character to the left by decreasing the x-coordinate
* @param dx
*/
   public static void moveLeftBy(int dx){
      x -= dx;
      CAMmoving = true;
   }

/**************************************************************************************************************************************************************************************
* This function is used to move the character to the right by increasing the x-coordinate
* @param dy
*/
   public static void moveRightBy(int dx){
      x += dx;
      CAMmoving = true;
   }
   
/**************************************************************************************************************************************************************************************
* This function is used to move the character forward according to the angle and distance desired
* @param distance  
*/
   public static void moveForwardBy(int dist){
	   x += dist * Lookup.cos[Angle];
	   y += dist * Lookup.sin[Angle];
	   CAMmoving = true;
   }
   
/**************************************************************************************************************************************************************************************
* This function is used to move the character backward according to the angle and distance desired
*/
   public static void moveBackwardBy(int dist){
	   x -= dist * Lookup.cos[Angle];
	   y -= dist * Lookup.sin[Angle];
	   CAMmoving = true;
   }
   
/**************************************************************************************************************************************************************************************
* This function is used to rotate the character to the left by a certain amount of degrees
* @param degrees  
*/
   public static void rotateLeftby(int degrees){
		Angle -= degrees;
		if(Angle < 0) Angle += 360;
	}
   
/**************************************************************************************************************************************************************************************
* This function is used to rotate the character to the right by a certain amount of degrees
* @param degrees  
*/
	public static void rotateRightby(int degrees){
		Angle += degrees;
		if(Angle > 359) Angle -= 360;
	}
}
