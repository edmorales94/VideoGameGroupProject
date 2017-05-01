package groupProject;

import java.awt.*;

public class Rect {
	double x;
	double y;
	int w;
	int h;
	int rectA;
	
	public Rect(int x,int y, int w, int h, int angle){//constructor must protect the code, what if it was negative??
		this.x = x;
		this.y = y;
	
		this.w = w;
		this.h = h;
		rectA = angle;
	}
	
	public boolean contains(int mx, int my){
		return ((mx < x+w) && (mx > x) && (my > y) && (my<y+h));
		
	}
	
	public boolean hasCollidedWith(Rect r){
		return ((r.x <= x+w) && (r.x+r.w >= x) && (r.y+r.h>= y) && (r.y<= y+h));
	}
	
	public void moveByrect(int dx, int dy){
		x += dx; 
		y += dy;
		
	}
	
	public void rotateLeftrect(int degrees){
		rectA -= degrees;
		if(rectA < 0) rectA += 360;
	}
	
	public void rotateRightrect(int degrees){
		rectA += degrees;
		if(rectA > 359) rectA -= 360;
	}
	
	public void moveForwardrect(int d){
		x +=  (d * Lookup.cos[rectA]); 
		y +=  (d * Lookup.sin[rectA]);
	}
	
	public void moveBackwardrect(int d){
		x -=  (d * Lookup.cos[rectA]); 
		y -=  (d * Lookup.sin[rectA]);
	}
	
	public void moveUpByrect(int dy){
	     y -= dy;
	}

	public void moveDownByrect(int dy){
	     y += dy;
	}

	public void moveLeftByrect(int dx){
		x -= dx;
	}

	public void moveRightByrect(int dx){
        x += dx;  
	}
	
	public void draw(Graphics g){
		g.setColor(Color.red);
		g.drawRect((int)x-Camera2d.x,(int)y-Camera2d.y,w,h);
	}
}
