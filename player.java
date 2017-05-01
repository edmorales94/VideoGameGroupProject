package groupProject;

import java.awt.*;

public class player extends PolygonModel2d {
	
	boolean punch = false;
	
//---------- Constructor --------------------------------------------------------------------------------------------------------------------------------------------------------
	public player(double x, double y, int w, int h, int angle){
		super(x,y,w,h,angle);
	}
	
/********************************************************************************************************************************************************************************
 * Method used to handle all of the character's reaction according to the key pressed by player
 * @param inputIs
 */
	public void respondToInput(boolean[] inputIs){
		if(inputIs[GameJPanel.UP]) {moveForwardby(3);this.moveForwardrect(3);}
	    if(inputIs[GameJPanel.DN]) {moveBackwardby(3);this.moveBackwardrect(3);}
	    if(inputIs[GameJPanel.LT]) {rotateLeftby(3); this.rotateLeftrect(3);}
	    if(inputIs[GameJPanel.RT]) {rotateRightby(3);this.rotateRightrect(3);}
	    boolean x = false;
	    if(x==false && inputIs[GameJPanel._A])  this.punchWithLeftArm(); x=true;
	      
	    if(x==true && inputIs[GameJPanel._A])  this.punchWithRightArm(); x=false;
	        
	      //should add punchWithRightArm() after simultaneously button "A" press
	  }
	
/********************************************************************************************************************************************************************************
 * Array used to collect all of the x-coordinates that compose the character 
 */
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
	
/********************************************************************************************************************************************************************************
 * Array used to collect all of the y-coordinates that compose the character 
 */
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
	
/********************************************************************************************************************************************************************************
 * This method changes the coordinates of the left arm 
 */
	public void punchWithLeftArm(){
		struct_x[1][0] = 50;
		struct_x[1][3] = 50;
	}

/********************************************************************************************************************************************************************************
* This method changes the coordinates of the right arm 
*/
	public void punchWithRightArm(){
		struct_x[2][0] = 50;
		struct_x[2][3] = 50;
	}
	
/********************************************************************************************************************************************************************************
* Method that return an array containing 4 different colors 
*/
	 public Color[] getColors(){
	      Color[] c ={new Color(150, 200, 150),Color.black,Color.black,Color.green};

	      return c;
	   }
	
/********************************************************************************************************************************************************************************
* This method changes the coordinates of the left arm 
*/
	public void draw(Graphics g){
		super.draw(g);
		g.setColor(Color.blue);
		g.fillOval((int)x-15-Camera2d.x,(int)y-15-Camera2d.y, 30, 30);
			
		if(this.moving == true){
			for(int i = 0;i < 4;i++){
				struct_y[3][i] = struct_y[3][i]*-1;//this changes the foot's y position
				this.moving = false;
			}
		}
		
		if(!punch){// conditions to set the arms back to their default position
			struct_x[1][0] = 10;//left arm
			struct_x[1][3] = 10;
			
			struct_x[2][0] = 10;//right arm
			struct_x[2][3] = 10;
		}	
	}
}
