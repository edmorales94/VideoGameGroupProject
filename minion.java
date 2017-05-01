package groupProject;

public class minion extends player{
	
//---------- constructor ------------------------------------------------------------------------------------------------------------------------------------------------------------
	public minion(double x, double y,int w, int h, int angle){
		super((int)x,(int)y,w,h,angle);//constructor from Player.java
	}
	
/************************************************************************************************************************************************************************************
 * This method determines whether the hero is to the right or left of this enemy
 * @param x
 * @param y
 * @return
 */
	public double leftOrRight(int x, int y){//left or right of the enemy
		return (x- this.x) * Lookup.sin[A] - (y- this.y) * Lookup.cos[A];
	}

/************************************************************************************************************************************************************************************
 * This method will keep checking how far the hero is from this enemy
 * @param x
 * @param y
 * @return
 */
	public double distanceTo(int x, int y){
		return (x- this.x) * Lookup.cos[A] + (y- this.y) * Lookup.sin[A];
	}
	
/************************************************************************************************************************************************************************************
 * Method used to track the movements from the hero/player
 * @param p
 */
	public void track(PolygonModel2d p){
		if(leftOrRight((int)p.x, (int)p.y) > 0)  { rotateLeftby(2); this.rotateLeftrect(2);}
		if(leftOrRight((int)p.x, (int)p.y) < 0)  { rotateRightby(2); this.rotateRightrect(2);}	
	}

/************************************************************************************************************************************************************************************
 * Method used to follow the hero depending on how far he is from this enemy
 * @param p
 */
	public void chase(PolygonModel2d p){
		track(p);
		if(distanceTo((int)p.x, (int)p.y) > 100){
			moveForwardby(2); 
			this.moveForwardrect(2);
			}
	   }
}