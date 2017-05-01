package groupProject;

import java.awt.*;
public class player extends PolygonModel2d {
	
	boolean punch = false;
	//int omgX = 0-Camera2d.x;
	//int omgY = 0-Camera2d.y;
	
	public player(double x, double y, int w, int h, int angle){
		super(x,y,w,h,angle);
	}
	public void respondToInput(boolean[] inputIs)
	  {
	      if(inputIs[GameJPanel.UP]) {moveForwardby(3);this.moveForwardrect(3);}
	      if(inputIs[GameJPanel.DN]) {moveBackwardby(3);this.moveBackwardrect(3);}
	      if(inputIs[GameJPanel.LT]) {rotateLeftby(3); this.rotateLeftrect(3);}
	      if(inputIs[GameJPanel.RT]) {rotateRightby(3);this.rotateRightrect(3);}
	      boolean x = false;
	      if(x==false && inputIs[GameApplet._A])  this.punchWithLeftArm(); x=true;
	      
	      if(x==true && inputIs[GameApplet._A])  this.punchWithRightArm(); x=false;
	        
	      //should add punchWithRightArm() after simultaneously button "A" press
	  }
	
	public int [][] x_data(){
		int [][] struct_x = 
			{
				{20,-20,-20,20},//x positions for the body 
				{10,-10,-10,10},//x positions for the left arm
				{10,-10,-10,10},//x positions for right arm
				{30,20,20,30}//x positions for the foot
				//Struct_var[polygon][[vertex]
			};
		return struct_x;
	}
	
	public int [][] y_data(){
		int [][] struct_y =
			{
				{30,30,-30,-30},//y positions for the body
				{-30,-30,-40,-40},//y positions for the left arm
				{30,30,40,40},//y positions for the right arm
				{-20,-20,-10,-10}//y positions for the foot 
			};
		return struct_y;
	}
	
	public void punchWithLeftArm(){
		struct_x[1][0] = 50;
		struct_x[1][3] = 50;
		
		//struct_x[2][0] = 10;
		//struct_x[2][3] = 10;
	}
	
	public void punchWithRightArm(){
		struct_x[2][0] = 50;
		struct_x[2][3] = 50;
		
		//struct_x[1][0] = 10;
		//struct_x[1][3] = 10;
		
	}
	
	 public Color[] getColors()
	   {
	      Color[] c =
	      {
	         new Color(150, 200, 150),
	         Color.black,
	         Color.black,
	         Color.green
	      };

	      return c;
	   }
	 public void getdirection(){}//maybe
	
	public void draw(Graphics g){
		/*
		for(int j=0;j<struct_x.length; j++)
		{
			struct_x[0][j] = struct_x[0][j]*-Camera2d.x;
			struct_x[1][j] = struct_x[1][j]*-Camera2d.x;
			struct_x[2][j] = struct_x[2][j]*-Camera2d.x;
			struct_x[3][j] = struct_x[3][j]*-Camera2d.x;
		}
		for(int k=0;k<struct_y.length; k++)
		{
			struct_x[0][k] = struct_x[0][k]*-Camera2d.y;
			struct_x[1][k] = struct_x[1][k]*-Camera2d.y;
			struct_x[2][k] = struct_x[2][k]*-Camera2d.y;
			struct_x[3][k] = struct_x[3][k]*-Camera2d.y;
		}*/
		
		super.draw(g);
		//moves head g.translate((int)x-Camera2d.x,(int)y - Camera2d.y);
		
		g.setColor(Color.blue);
		g.drawOval((int)x-15-Camera2d.x,(int)y-15-Camera2d.y, 30, 30);
		g.fillOval((int)x-15-Camera2d.x,(int)y-15-Camera2d.y, 30, 30);
	
		
		if(this.moving == true){
			for(int i = 0;i < 4;i++)
			{
				/*
				for(int j =0; j<4; j++)
				{
					struct_y[3][j] = struct_y[3][j]*-1;//
					this.moving = false;
					
				}//*/
				//*
				struct_y[3][i] = struct_y[3][i]*-1;//this changes the foot's y position
				this.moving = false;
				//*/
			}
		}
		
		if(!punch){
			struct_x[1][0] = 10;
			struct_x[1][3] = 10;
			
			struct_x[2][0] = 10;
			struct_x[2][3] = 10;
		}
		
	}
}
