package groupProject;
import java.awt.Graphics;

public abstract class PolygonModel2d{
		
		double x;
		double y;
		int A;
		//int z;
		int [][] struct_x = x_data();// contains all Xs of each polygon
		int [][] struct_y = y_data();// contains all Ys of each polygon
		boolean moving = false;
		
//---------- constructor -----------------------------------------------------------------------------------------------------------------------------------------------
		public PolygonModel2d(double x, double y, int angle){
			this.x = x;
			this.y = y;	
			A = angle;//changed so it can be remember from the beginning
		}
		
//---------- abstract methods ------------------------------------------------------------------------------------------------------------------------------------------
		public abstract int[][] x_data();//method to get all Xs of a polygon
		public abstract int[][] y_data();//method to get all Xs of a polygon
		//public abstract Color[] getColors();
		
//---------- draw method -----------------------------------------------------------------------------------------------------------------------------------------------
		public void draw(Graphics g){
			int[] xpoints = new int[4];//the shapes are just rectangles/squares so we need 4 Xs
			int[] ypoints = new int[4];//and 4 Ys to create the rectangles/squares
			
			double cosA =  Lookup.cos[A];// the value to get X to rotate
			double sinA =  Lookup.sin[A];// the value to get Y to rotate
						
			for(int poly = 0; poly < struct_x.length; poly++){// go through each of the 4 rectangles
				for(int vertex = 0; vertex< struct_x[poly].length; vertex++){//go through each vertex of each rectangle 
					//set the x and y of those vertices to the correct coordinates based on the angle
					xpoints[vertex] = (int) (struct_x[poly][vertex]* cosA - struct_y[poly][vertex]* sinA + x);
					ypoints[vertex] = (int) (struct_x[poly][vertex]* sinA + struct_y[poly][vertex]* cosA + y);
				}
				g.drawPolygon(xpoints, ypoints, struct_x[poly].length);//draw each rectangle of the body
			}
		}
		
//---------- rotate to the left ----------------------------------------------------------------------------------------------------------------------------------------
		public void rotateLeftby(int degrees){
			A -= degrees;
			if(A < 0) A += 360;
		}
//---------- rotate to the right ---------------------------------------------------------------------------------------------------------------------------------------
		public void rotateRightby(int degrees){
			A += degrees;
			if(A > 359) A -= 360;
		}
//---------- move forward ----------------------------------------------------------------------------------------------------------------------------------------------
		public void moveForwardby(int d){
			x +=  d * Lookup.cos[A]; 
			y +=  d * Lookup.sin[A];
			moving = true;
		}
//--------- move backward ----------------------------------------------------------------------------------------------------------------------------------------------
		public void moveBackwardby(int d){
			x -=  d * Lookup.cos[A]; 
			y -=  d * Lookup.sin[A];
			moving = true;
		}
}

