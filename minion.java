package groupProject;

public class minion extends player 
{
	public minion(double x, double y,int w, int h, int angle)
	{
		super((int)x,(int)y,w,h,angle);
	}
	public void track(PolygonModel2d p)
	   {
	       if(leftOrRight((int)p.x, (int)p.y) > 0)  { rotateLeftby(2); this.rotateLeftrect(2);}
	       if(leftOrRight((int)p.x, (int)p.y) < 0)  { rotateRightby(2); this.rotateRightrect(2);}
	   }


	   public void chase(PolygonModel2d p)
	   {
	       track(p);

	       if(distanceTo((int)p.x, (int)p.y) > 100)   {moveForwardby(2); this.moveForwardrect(2);}
	   }
	public double leftOrRight(int x, int y)//left or right of the enemy
	{
		return (x- this.x) * Lookup.sin[A] - (y- this.y) * Lookup.cos[A];
	}
	public double distanceTo(int x, int y)
	{
		return (x- this.x) * Lookup.cos[A] + (y- this.y) * Lookup.sin[A];
	}
	
}