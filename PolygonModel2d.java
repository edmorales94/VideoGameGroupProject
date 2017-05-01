package groupProject;

import java.awt.*;
import java.awt.Graphics;

public abstract class PolygonModel2d extends Rect
{
		
		double x;
		double y;
		int w;
		int h;
		int A;
		//int z;
		int [][] struct_x = x_data();
		int [][] struct_y = y_data();
		boolean moving = false;
		double totalx;
		double totaly;
		
	
		
		
		
		public PolygonModel2d(double x, double y,int w, int h, int angle)
		{
			super((int)x-30,(int)y-40,w, h,angle);
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			A = angle;//changed so it can be remember from the beginning
		}
		public abstract int[][] x_data();
		public abstract int[][] y_data();
		//public abstract Color[] getColors();
		
		public void draw(Graphics g){
			//g.translate((int)this.x-Camera2d.x,(int)this.y-Camera2d.y);
			totalx = x - Camera2d.x;
			totaly = y - Camera2d.y;
			   
			int[] xpoints = new int[4];
			int[] ypoints = new int[4];
			double cosA =  Lookup.cos[A];
			double sinA =  Lookup.sin[A];
			g.setColor(Color.red);
			//g.translate((int)x-Camera2d.x, (int)y - Camera2d.y);
			super.draw(g);
			//g.translate((int)x-Camera2d.x, (int)y - Camera2d.y);
			
			for(int poly = 0; poly < struct_x.length; poly++)
			{
			
				for(int vertex = 0; vertex< struct_x[poly].length; vertex++)
				{
					xpoints[vertex] = (int) (struct_x[poly][vertex]* cosA - struct_y[poly][vertex]* sinA + x-Camera2d.x);
					ypoints[vertex] = (int) (struct_x[poly][vertex]* sinA + struct_y[poly][vertex]* cosA + y-Camera2d.y);
				}
				g.drawPolygon(xpoints, ypoints, struct_x[poly].length);
				//g.translate((int)this.x-Camera2d.x,(int)this.y-Camera2d.y);
				g.setColor(Color.GRAY);
				g.fillPolygon(xpoints, ypoints, struct_x[poly].length);
				//g.translate((int)this.x-Camera2d.x,(int)this.y-Camera2d.y);
			}
			//g.translate((int)this.x-Camera2d.x,(int)this.y-Camera2d.y);
			//refreshPoly(this);
			
			
	
		}
		//*
		public void moveBy(int dx, int dy)
		{
			x += dx; 
			y += dy;
			
		}
		//*/
		public void rotateLeftby(int degrees)
		{
			A -= degrees;
			if(A < 0) A += 360;
			//moving = true;
		}
		public void rotateRightby(int degrees)
		{
			A += degrees;
			if(A > 359) A -= 360;
			//moving = true;
		}
		public void moveForwardby(int d)
		{
			x +=  (d * Lookup.cos[A]);
			y +=  (d * Lookup.sin[A]);
			moving = true;
		}
		public void moveBackwardby(int d)
		{
			x -=  d * Lookup.cos[A]; 
			y -=  d * Lookup.sin[A];
			moving = true;
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
	
}

