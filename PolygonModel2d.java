package groupProject;

import java.awt.*;
import java.awt.Graphics;

public abstract class PolygonModel2d extends Rect{
	
	double x;
	double y;
	int w;
	int h;
	int A;
	//int z;
	int [][] struct_x = x_data();
	int [][] struct_y = y_data();
	boolean moving = false;
	boolean front = false;
	boolean back = false;
		
//---------- constructor --------------------------------------------------------------------------------------------------------------------------------------------------------------
	public PolygonModel2d(double x, double y,int w, int h, int angle){
		super((int)x-30,(int)y-40,w, h,angle);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		A = angle;//angle need it to handle character's rotation
	}
	
//---------- methods to get all of the x-coordinates and y-coordinates that compose the character -------------------------------------------------------------------------------------
	public abstract int[][] x_data();
	public abstract int[][] y_data();
		
/**************************************************************************************************************************************************************************************
 * Draw method that handles the movement/rotation of the character. This methods also 
 * adjusts the coordinates according to the camera */
	public void draw(Graphics g){
				   
		int[] xpoints = new int[4];//array to place the x-coordinates of each polygon composing the head individually
		int[] ypoints = new int[4];//array to place the y-coordinates of each polygon composing the head individually
		
		double cosA =  Lookup.cos[A];//will help to set the correct x-value for the polygon
		double sinA =  Lookup.sin[A];//will help to set the correct y-value for the polygon
		g.setColor(Color.red);
		super.draw(g);//calling the draw method from Rect.java to draw rectangle around the whole character
					
		for(int poly = 0; poly < struct_x.length; poly++){//go through all elements inside the array
			for(int vertex = 0; vertex< struct_x[poly].length; vertex++){//go through each elements of this current element in the main array
				xpoints[vertex] = (int) (struct_x[poly][vertex]* cosA - struct_y[poly][vertex]* sinA + x-Camera2d.x);
				ypoints[vertex] = (int) (struct_x[poly][vertex]* sinA + struct_y[poly][vertex]* cosA + y-Camera2d.y);
			}
			g.setColor(Color.GRAY);
			g.fillPolygon(xpoints, ypoints, struct_x[poly].length);//draw the character's body part
		}
	}
		
/**************************************************************************************************************************************************************************************
 * This function is used to move the character's coordinates by a certain amount
 * @param dx
 * @param dy */
	public void moveBy(int dx, int dy){
		x += dx; 
		y += dy;	
	}
		
/**************************************************************************************************************************************************************************************
* This function is used to rotate the character to the left by a certain amount of degrees
* @param degrees  
*/
	public void rotateLeftby(int degrees){
		A -= degrees;
		if(A < 0) A += 360;
	}
	
/**************************************************************************************************************************************************************************************
* This function is used to rotate the character to the right by a certain amount of degrees
* @param degrees  
*/
	public void rotateRightby(int degrees){
		A += degrees;
		if(A > 359) A -= 360;
	}
	
/**************************************************************************************************************************************************************************************
* This function is used to move the character forward according to the angle and distance desired
* @param distance  
*/
	public void moveForwardby(int d){
		x +=  (d * Lookup.cos[A]);
		y +=  (d * Lookup.sin[A]);
		moving = true;
		front = true;
	}
	
/**************************************************************************************************************************************************************************************
* This function is used to move the character backward according to the angle and distance desired
*/
	public void moveBackwardby(int d){
		x -=  d * Lookup.cos[A]; 
		y -=  d * Lookup.sin[A];
		moving = true;
		back = true;
	}
	
/**************************************************************************************************************************************************************************************
 * This function is used to move the character up by decreasing the y-coordinate
 * @param dy
 */
	public void moveUpBy(int dy){
		y -= dy;
	}

/**************************************************************************************************************************************************************************************
* This function is used to move the character down by increasing the y-coordinate
* @param dy
*/
	public void moveDownBy(int dy){
		y += dy;      
	}

/**************************************************************************************************************************************************************************************
* This function is used to move the character to the left by decreasing the x-coordinate
* @param dx
*/
	public void moveLeftBy(int dx){
		x -= dx;     
	}

/**************************************************************************************************************************************************************************************
 * This function is used to move the character to the right by increasing the x-coordinate
 * @param dy
*/
	public void moveRightBy(int dx){
		x += dx;     
	}
}

