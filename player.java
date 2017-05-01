package groupProject;

import java.awt.*;

public class player extends PolygonModel2d{
	
	boolean punch = false;//signal to punch
	int punchDuration = 0;//value that will signal the time for an arm to punch
	
//--------- constructor ----------------------------------------------------------------------------------------------------------------------
	public player(double x, double y, int angle){
		super(x,y,angle);//set the location and angle for the player
	}
	
//---------- x_Data --------------------------------------------------------------------------------------------------------------------------
	public int [][] x_data(){
		int [][] struct_x = //a 2D array containing all of the x values of the player
			{
				{20,-20,-20,20},//x positions for the body
				{10,-10,-10,10},//x positions for the left arm
				{10,-10,-10,10},//x positions for right arm
				{30,20,20,30}//x positions for the foot
			};
		return struct_x;
	}
	
//---------- y_data --------------------------------------------------------------------------------------------------------------------------
	public int [][] y_data(){
		int [][] struct_y =//a 2D array containing all of the y values of the player
			{
				{30,30,-30,-30},//y positions for the body
				{-30,-30,-40,-40},//y positions for the left arm
				{30,30,40,40},//y positions for the right arm
				{-20,-20,-10,-10}//y positions for the foot 
			};
		return struct_y;
	}
	
//---------- punch with left arm -------------------------------------------------------------------------------------------------------------
	public void punchWithLeftArm(){
		struct_x[1][0] = 50;//upper right corner of left arm rectangle is extending
		struct_x[1][3] = 50;//lower right corner of left arm rectangle is extending 		
	}
	
//---------- punch with right arm ------------------------------------------------------------------------------------------------------------
	public void punchWithRightArm(){
		struct_x[2][0] = 50;//upper right corner of right arm rectangle is extending
		struct_x[2][3] = 50;//lower right corner of right arm rectangle is extending
		
		struct_x[1][0] = 10;//upper right corner of left arm rectangle is back to original position
		struct_x[1][3] = 10;//lower right corner of left arm rectangle is back to original position
	}

//---------- throw punches -------------------------------------------------------------------------------------------------------------------
	public void throwPunches(){
		punch = true;
		punchDuration++;
		punchWithLeftArm();
		if(punchDuration % 6 == 0){
			punchWithRightArm();
		}
	}
// -------- respond to input -----------------------------------------------------------------------------------------------------------------
	public void respondToInput(boolean[] inputIs){
		if(inputIs[GameJPanel.UP])  moveForwardby(5);
		if(inputIs[GameJPanel.DN])  moveBackwardby(3);
		if(inputIs[GameJPanel.LT])  rotateLeftby(3);
		if(inputIs[GameJPanel.RT])  rotateRightby(3);
		if(inputIs[GameJPanel._A])  throwPunches();punch = false;
	}
	
//---------- draw ----------------------------------------------------------------------------------------------------------------------------
	public void draw(Graphics g){
		super.draw(g);//draw method from PolygonModel
		g.setColor(Color.blue);
		g.drawOval((int)x-15,(int)y-15, 30, 30);//outline of the head
		g.fillOval((int)x-15,(int)y-15, 30, 30);//fill head
		
		if(moving == true){//if moving from PolygonModel
			for(int i = 0;i < 4;i++){
				struct_y[3][i] = struct_y[3][i]*-1;//this changes the foot's y position
				moving = false;
			}
		}
				
		if(!punch){
			struct_x[1][0] = 10;//upper right corner of left arm rectangle is back to original position
			struct_x[1][3] = 10;//lower right corner of left arm rectangle is back to original position
			
			struct_x[2][0] = 10;//upper right corner of right arm rectangle is back to original position
			struct_x[2][3] = 10;//lower right corner of left arm rectangle is back to original position
		}
	}
}
