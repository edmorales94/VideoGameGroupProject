package groupProject;

import java.awt.*;

public class Game_loop extends GameJPanel{
	private static final long serialVersionUID = 1L;
	
//---------- instance objects --------------------------------------------------------------------------------------------------------------------------------------
	int Level = 1;//change to work on other levels
	ImageLayer layer1 = new ImageLayer("bkg1.png", -1, -1);
	ImageLayer layer2 = new ImageLayer("bkg2.png", -1, -1);
	ImageLayer layer3 = new ImageLayer("bkg3.png", -1, -1);
	ImageLayer layer4 = new ImageLayer("bkg4.png", -1, -1);
	ImageLayer layer5 = new ImageLayer("space.jpg", -2, -2);
	
	int x_CameraMax = 720;//1440/2; //+ //GameJPanel.frameWidth;// Since your moving the image layer in the negative
	int y_CameraMax = 450;//900/2; //+ //GameJPanel.frameHeight;//So adding the size of the camera, or the players view should
	int XoriginCam = 0-720;
	int YoriginCam = 0-450;
	//int CamScreen;
	int m = 480;
	int n = 180;
//------------CAMERA LIMIT--------------------------------------------------------------------------------------------------------------------------------------------
// Theses lines combine to create a box to detect if the layey1 left the box, then to return it to the box 
	Line leftDiagnol = new Line(0,0,1440,900);
	Line rightDiagnol = new Line(1440,0,0,900);
	Line LeftBorder = new Line(-479,-179,-479,0);
	Line RightBorder = new Line(1,-179,1,1);
	Line TopBorder = new Line(-479,-179,-1,-179);
	Line BottomBorder = new Line(-479,1,-1,1);
	Rect CameraLimit = new Rect(-479,-179, m, n, 0);
//------------Characters--------------------------------------------------------------------------------------------------------------------------------------------------
	player hero = new player(950, 850,60,80, 270);
	minion badguy  = new minion(720,450, 60, 80,0);
//------------LEVEL!----------------------------------------------------------------------------------------------------------	
	Line leftWALL = new Line(30,0,30,730);
	Line rightWALL = new Line(1870,0,1870,730);
	Line topWALL = new Line(30,60,1870,60);
	Rect b1WALL = new Rect(0,680,880,400,0);
	Rect b2WALL = new Rect(1050,675,260,400,0);
	Line b3WALL = new Line(1370,935,1870,935);
	Rect middlePillar1 = new Rect(210,240,50,440,0);
	Rect middlePillar2 = new Rect(525,242,50,240,0);
	Rect middlePillar4 = new Rect(1310,242,60,740,0);
	Rect middlePillar3 = new Rect(525,242,1180,60,0);
	Rect middlePillar5 = new Rect(1655,680,210,50,0);
	Rect Teleport1 = new Rect(1800,730,100,210,0);
//-----------Level2--------------------------------------------------------------------------------------------------------------
	Line rightwall = new Line(1800,0,1800,1080);
	Rect Topwall_1 = new Rect(0,0,670,200,0);
	Rect Topwall_2 = new Rect(650,220,430,110,0);
	Rect Topwall_3 = new Rect(1178,-1,660,180,0);
	Rect PillarA = new Rect(300,485,260,345,0);
	Rect PillarB = new Rect(1300,485,260,345,0);
	Rect middleWALL1 = new Rect(800,476,60,600,0);
	Rect middleWALL2 = new Rect(1040,330,60,502,0);
	Rect leftwallA = new Rect(0,0,60,740,0);
	Rect leftwallB = new Rect(0,945,60,150,0);
	Rect Teleport2 = new Rect(0,740,60,200,0);
	Line bottomwall = new Line(0,1080,1920,1080);
	Rect Topwall_4 = new Rect(675,40,500,30,0);
	Rect Teleport3 = new Rect(860,40,128,30,0);
//------------LEVEL3--------------------------------------------------------------------------------------------------------------
	Line Topwall = new Line(0,35,1920,35);
	Line RIGHTwall = new Line(1680,0,1680,1080);
	Line LEFTwall = new Line(0,40,0,240);
	Rect bookshelf = new Rect(160,35,530,100,0);
	Rect door = new Rect(0,230,160,35,0);
	Rect Teleport22 = new Rect(0,265,50,135,0);
	Rect plant = new Rect(0,400,100,100,0);
	Rect Col = new Rect(0,508,692,60,0);
	Rect Colleft = new Rect(625,310,65,260,0);
	Rect Desk = new Rect(1365,310,88,152,0);
	Rect desk = new Rect(140,635,97,230,0);
	Rect Coltop = new Rect(1120,135,555,50,0);
	Rect Coltopa = new Rect(1120,135,65,195,0);
	Rect ColbottomA = new Rect(1120,485,65,300,0);
	Rect Colbottom = new Rect(1120,685,555,105,0);
	Rect outerworldA = new Rect(985,780,600,300,0);
	Rect outerworldB = new Rect(710,780,120,300,0);
	Rect BHdesk = new Rect(0,570,66,145,0);
	Rect BHdeska = new Rect(0,825,66,250,0);
	Rect BHdeskb = new Rect(0,1019,750,61,0);
	Rect TelePort4 = new Rect(830,1000,155,100,0);
//------LEVEL-4-----------------------------------------------------------------------------------------------------------------------------------------------------
	Rect box1 = new Rect(1450,400,470,530,0);
	Rect Teleport5 = new Rect(0,0,195,170,0);
	Rect Teleport24 = new Rect(1870,930,100,150,0);
	Rect box2 = new Rect(1060,0,860,230,0);
	Rect box3 = new Rect(1055,400,205,350,0);
	Rect box4 = new Rect(0,925,1325,170,0);
	Rect box5 = new Rect(0,750,864,170,0);
	Rect box6 = new Rect(0,170,195,230,0);
	Rect box7 = new Rect(0,400,275,350,0);
	Rect box8 = new Rect(390,0,470,400,0);
	Rect box9 = new Rect(195,0,860,60,0);
	Rect box10 = new Rect(860,400,195,50,0);
	Rect box11 = new Rect(470,400,390,180,0);
	
//---------- constructor -------------------------------------------------------------------------------------------------------------------------------------------
	public void startTheGame(){	
		startGame();//call the method that starts the game in GameJPanel
	}
	
//---------- respond to input --------------------------------------------------------------------------------------------------------------------------------------
	public void respondToInput(){
       hero.respondToInput(input);
//--------CAMERA_START----------------------------------------------------------------------------------------------------------------------------------------------------
      
       if(Level==1){
//-----CAMERA-FOR-LEVEL-1-------------------------------------------------------------------------------------------------------------------------------------------------
    	   if(input[GameJPanel.UP]) //{Camera2d.moveUpBy(3);}if(input[GameJPanel.DN]) {Camera2d.moveDownBy(3);}if(input[GameJPanel.RT]) {Camera2d.moveRightBy(3);}if(input[GameJPanel.LT]) {Camera2d.moveLeftBy(3);}
       //*
       {
    		   if(LeftBorder.distanceTo((int)layer1.totalx,(int)layer1.totaly)>-1)	{Camera2d.moveLeftBy(0);}
    		   if(RightBorder.distanceTo((int)layer1.totalx,(int)layer1.totaly)<1)	{Camera2d.moveRightBy(0);}
    		   if(TopBorder.distanceTo((int)layer1.totalx,(int)layer1.totaly)>169)  {Camera2d.moveDownBy(0);}
    		   if(BottomBorder.distanceTo((int)layer1.totalx,(int)layer1.totaly)<-179){Camera2d.moveUpBy(0);}
       }
       //* CameraLimit is a rect create to take advantage of the contains() method inside rect to keep the imagelayer x and y inside that rect 
       if(CameraLimit.contains((int)layer1.totalx,(int)layer1.totaly))
       	{  //uses the angle of direction character is facing
    	   		if(input[GameJPanel.UP] && (hero.A < 90  || hero.A > 270))  {Camera2d.moveRightBy(2);}//super.update();} 
    	   		if(input[GameJPanel.UP] && (hero.A < 270 && hero.A > 90))   {Camera2d.moveLeftBy(2);}//super.update();}
    	   		if(input[GameJPanel.UP] && (hero.A > 180 && hero.A < 360)) {Camera2d.moveUpBy(2);}//super.update();}
    	   		if(input[GameJPanel.UP] && (hero.A < 180 && hero.A > 0)) {Camera2d.moveDownBy(2);}//super.update();}
       	}
     //*/
       }
       if(Level==2){
//-----CAMERA-FOR-LEVEL-2-----------------------------------------------------------------------------------------------------------------------------------------------------------
           if(input[GameJPanel.UP])// {Camera2d.moveUpBy(3);}if(input[GameJPanel.DN]) {Camera2d.moveDownBy(3);}if(input[GameJPanel.RT]) {Camera2d.moveRightBy(3);}if(input[GameJPanel.LT]) {Camera2d.moveLeftBy(3);}
           System.out.println(bottomwall.distanceTo((int)hero.x,(int)hero.y)+" oh");
           //*
           {
        	   if(LeftBorder.distanceTo((int)layer2.totalx,(int)layer2.totaly)>-1)	{Camera2d.moveLeftBy(2); }
        	   if(RightBorder.distanceTo((int)layer2.totalx,(int)layer2.totaly)<1)	{Camera2d.moveRightBy(2);}
        	   if(TopBorder.distanceTo((int)layer2.totalx,(int)layer2.totaly)>169)  {Camera2d.moveDownBy(2);}
        	   if(BottomBorder.distanceTo((int)layer2.totalx,(int)layer2.totaly)<-179){Camera2d.moveUpBy(2);}
           }
           //* CameraLimit is a rect create to take advantage of the contains() method inside rect to keep the imagelayer x and y inside that rect 
           if(CameraLimit.contains((int)layer2.totalx,(int)layer2.totaly))
           	{  //uses the angle of direction character is facing
        	   if(input[GameJPanel.UP] && (hero.A < 90  || hero.A > 270))  {Camera2d.moveRightBy(2);}//super.update();} 
        	   if(input[GameJPanel.UP] && (hero.A < 270 && hero.A > 90))   {Camera2d.moveLeftBy(2);}//super.update();}
        	   if(input[GameJPanel.UP] && (hero.A > 180 && hero.A < 360)) {Camera2d.moveUpBy(2);}//super.update();}
        	   if(input[GameJPanel.UP] && (hero.A < 180 && hero.A > 0)) {Camera2d.moveDownBy(2);}//super.update();}
           	}
         //*/
           }
       if(Level==3){
//-----CAMERA-FOR-LEVEL-3-------------------------------------------------------------------------------------------------------------------------------------------------------------
           if(input[GameJPanel.UP]) //{Camera2d.moveUpBy(3);}if(input[GameJPanel.DN]) {Camera2d.moveDownBy(3);}if(input[GameJPanel.RT]) {Camera2d.moveRightBy(3);}if(input[GameJPanel.LT]) {Camera2d.moveLeftBy(3);}
           //*
           {
        	   if(LeftBorder.distanceTo((int)layer3.totalx,(int)layer3.totaly)>-1)	{Camera2d.moveLeftBy(2);}
        	   if(RightBorder.distanceTo((int)layer3.totalx,(int)layer3.totaly)<1)	{Camera2d.moveRightBy(2);}
        	   if(TopBorder.distanceTo((int)layer3.totalx,(int)layer3.totaly)>169)  {Camera2d.moveDownBy(2);}
        	   if(BottomBorder.distanceTo((int)layer3.totalx,(int)layer3.totaly)<-179){Camera2d.moveUpBy(2);}
           }
           //* CameraLimit is a rect create to take advantage of the contains() method inside rect to keep the imagelayer x and y inside that rect 
           if(CameraLimit.contains((int)layer3.totalx,(int)layer3.totaly))
           	{  //uses the angle of direction character is facing
        	   if(input[GameJPanel.UP] && (hero.A < 90  || hero.A > 270))  {Camera2d.moveRightBy(2);}//super.update();} 
        	   if(input[GameJPanel.UP] && (hero.A < 270 && hero.A > 90))   {Camera2d.moveLeftBy(2);}//super.update();}
        	   if(input[GameJPanel.UP] && (hero.A > 180 && hero.A < 360)) {Camera2d.moveUpBy(2);}//super.update();}
        	   if(input[GameJPanel.UP] && (hero.A < 180 && hero.A > 0)) {Camera2d.moveDownBy(2);}//super.update();}
           	}
         //*/
           }
       if(Level==4){
//-----CAMERA-FOR-LEVEL-4----------------------------------------------------------------------------------------------------------------------------------------------------------------
           if(input[GameJPanel.UP]) //{Camera2d.moveUpBy(10);}if(input[GameJPanel.DN]) {Camera2d.moveDownBy(10);}if(input[GameJPanel.RT]) {Camera2d.moveRightBy(10);}if(input[GameJPanel.LT]) {Camera2d.moveLeftBy(10);}
           //*
           {
        	   if(LeftBorder.distanceTo((int)layer4.totalx,(int)layer4.totaly)>-1)	{Camera2d.moveLeftBy(2);}
        	   if(RightBorder.distanceTo((int)layer4.totalx,(int)layer4.totaly)<1)	{Camera2d.moveRightBy(2);}
        	   if(TopBorder.distanceTo((int)layer4.totalx,(int)layer4.totaly)>169)  {Camera2d.moveDownBy(2);}
        	   if(BottomBorder.distanceTo((int)layer4.totalx,(int)layer4.totaly)<-179){Camera2d.moveUpBy(2);}
           }
           //* CameraLimit is a rect create to take advantage of the contains() method inside rect to keep the imagelayer x and y inside that rect 
           if(CameraLimit.contains((int)layer1.totalx,(int)layer1.totaly))
           	{  //uses the angle of direction character is facing
        	   if(input[GameJPanel.UP] && (hero.A < 90  || hero.A > 270))  {Camera2d.moveRightBy(2);}//super.update();} 
        	   if(input[GameJPanel.UP] && (hero.A < 270 && hero.A > 90))   {Camera2d.moveLeftBy(2);}//super.update();}
        	   if(input[GameJPanel.UP] && (hero.A > 180 && hero.A < 360)) {Camera2d.moveUpBy(2);}//super.update();}
        	   if(input[GameJPanel.UP] && (hero.A < 180 && hero.A > 0)) {Camera2d.moveDownBy(2);}//super.update();}
           	}
         //*/
           }
  //------------CAMERA_END-------------------------------------------------------------------------------------------------------------------------------------------
	}

//---------- moveGameObjects ---------------------------------------------------------------------------------------------------------------------------------------
   public void moveGameObjects(){
      //badguy.chase(hero);
	   //layer1.FollowCharacter(hero);
      //box.x = player.x;
   }

//---------- HANDLING COLLISIONS-------------------------------------------------------------------------------------------------------------------------------------
   public void handleCollisions()
   {//}
	   /*
	   if (hero.hasCollidedWith(badguy))
	   {
		   hero.moveBackwardby(3);
		   hero.moveBackwardrect(3);
	   }
	   //*/
//-----LEVEL-1------------------------------------------------------------------------------------------------------------------------------------------------------
	   if(Level == 1)
	   {
//---------TELEPORT-TO-NEXT-LEVEL-2--------------------------------------------
		   if(Teleport1.contains((int)hero.x,(int)hero.y))
		   {
			   Level=2; 
			   hero.moveBy(-1700, 10); 
			   hero.moveByrect(-1700, 10);
			   Camera2d.moveBy(-450, -20);
		   												 }
//---------LINE-COLLISION--------------------------------------------------------
		   if(leftWALL.distanceTo((int)hero.x,(int)hero.y)>-32)
		   {
			   hero.moveRightBy(3); 
			   hero.moveRightByrect(3);
		   }
		   if(rightWALL.distanceTo((int)hero.x,(int)hero.y)<32)
		   {
			   hero.moveLeftBy(3);
			   hero.moveLeftByrect(3);
		   }
		   if(topWALL.distanceTo((int)hero.x,(int)hero.y)<35)
		   {
			   hero.moveDownBy(3); 
			   hero.moveDownByrect(3);
		   }
		   if(b3WALL.distanceTo((int)hero.x,(int)hero.y)>0)
		   {
			   hero.moveUpBy(3);
			   hero.moveUpByrect(3);
		   }
//---------RECTANGLE-COLLISION------------------------------------------------------------------------------
		   if(b1WALL.hasCollidedWith(hero)|b2WALL.hasCollidedWith(hero)
		     |middlePillar1.hasCollidedWith(hero)|middlePillar2.hasCollidedWith(hero)
		     |middlePillar3.hasCollidedWith(hero)|middlePillar4.hasCollidedWith(hero)
		     |middlePillar5.hasCollidedWith(hero))
		   {
			   {hero.moveBackwardby(3);
			   hero.moveBackwardrect(3);}
		   }
		
	   }
//-----LEVEL-2------------------------------------------------------------------------------------------------------------------------------------------------------
	   if(Level == 2)
	   {
//---------TELEPORT-BACK-TO-LEVEL-1-------------------------------------
		   if(Teleport2.contains((int)hero.x,(int)hero.y))
		   {
			   Level=1;
			   hero.moveBy(1700, 0);
			   hero.moveByrect(1700, 0);
			   Camera2d.moveBy(450, 0);
		   }
			  
//---------LINES-COLLISION-----------------------------------------------
		   if(rightwall.distanceTo((int)hero.x,(int)hero.y)<32)
		   	{
			   hero.moveLeftBy(3); 
			   hero.moveLeftByrect(3);
		    }
		   if(bottomwall.distanceTo((int)hero.x,(int)hero.y)>-45)
		    {
			   hero.moveUpBy(3); 
			   hero.moveUpByrect(3);
			}
//---------RECTANGLE-COLLISION-------------------------------------------
		   if(Topwall_1.hasCollidedWith(hero)|Topwall_2.hasCollidedWith(hero)
			 |Topwall_3.hasCollidedWith(hero)|PillarA.hasCollidedWith(hero)
			 |PillarB.hasCollidedWith(hero)|middleWALL1.hasCollidedWith(hero)
			 |middleWALL2.hasCollidedWith(hero)|leftwallA.hasCollidedWith(hero)
			 |leftwallB.hasCollidedWith(hero)|Topwall_4.hasCollidedWith(hero))
		   {
			   hero.moveBackwardby(3);
			   hero.moveBackwardrect(3);
		   }
//----------TELEPORT-TO-THE-NEXT-LEVEL-3
		    if(Teleport3.contains((int)hero.x,(int)hero.y))
		    {
		    	Level=3;hero.moveBy(-845, 260);
		    	hero.moveByrect(-845, 260);
		    	hero.A=0;hero.rectA=0;
		    	Camera2d.moveBy(-450, 0);
		    }
	   }
//-----LEVEL-3------------------------------------------------------------------------------------------------------------------------------------------------------
	   if(Level == 3)
	   {
//---------TELEPORT-BACK-TO-LEVEL-2-------------------------------------------
		   if(Teleport22.contains((int)hero.x,(int)hero.y))
		   {
			   Level=2;
			   hero.moveBy(850, -200);
			   hero.moveByrect(850, -200);
			   Camera2d.moveBy(150, 0);
			}
//---------LINE-COLLISION-------------------------------------------
		   //System.out.println(Topwall.distanceTo((int)hero.x,(int)hero.y));
		   if(Topwall.distanceTo((int)hero.x,(int)hero.y)<37)
		   {
			   hero.moveDownBy(3);
			   hero.moveDownByrect(3);
		   }
		   if(LEFTwall.distanceTo((int)hero.x,(int)hero.y)>-30)
		   {
			   hero.moveRightBy(3);
			   hero.moveRightByrect(3);
		   }
		   if(RIGHTwall.distanceTo((int)hero.x,(int)hero.y)<30)
		   {
			   hero.moveLeftBy(3);
			   hero.moveLeftByrect(3);
		   }
//---------RECTANGLE-COLLISION-------------------------------------------
		   if(bookshelf.hasCollidedWith(hero)|door.hasCollidedWith(hero)
			|plant.hasCollidedWith(hero)|Col.hasCollidedWith(hero)|Colleft.hasCollidedWith(hero)
			|Desk.hasCollidedWith(hero)|desk.hasCollidedWith(hero)
			|Coltop.hasCollidedWith(hero)|Coltopa.hasCollidedWith(hero)
			|ColbottomA.hasCollidedWith(hero)|Colbottom.hasCollidedWith(hero)
			|outerworldA.hasCollidedWith(hero)|outerworldB.hasCollidedWith(hero)
			|BHdesk.hasCollidedWith(hero)|BHdeska.hasCollidedWith(hero)
			|BHdeskb.hasCollidedWith(hero))
		   {
			   hero.moveBackwardby(3); hero.moveBackwardrect(3);
		   }
//---------TELEPORT-TO-NEXT-LEVEL 4------------------------------------
		   if(TelePort4.contains((int)hero.x,(int)hero.y))
		   {
			   Level=4;hero.moveBy(900, 0);
			   hero.moveByrect(900, 0);
			   hero.A=180;hero.rectA=180;
			   Camera2d.moveBy(0, -10);
		   }
	   }
//-----LEVEL-4------------------------------------------------------------------------------------------------------------------------------------------------------
	   if(Level == 4)
	   {
//---------TELEPORT-BACK2-LEVEL 3------------------------------------
		   if(Teleport24.contains((int)hero.x,(int)hero.y))
		   {
			   Level=3;
			   hero.moveBy(-1000, -100);
			   hero.moveByrect(-1000, -100);
			   hero.A=270;hero.rectA=270;
			   Camera2d.moveBy(-100, -100);
		   }
//---------RECTANGLE-COLLISION-------------------------------------------
		   if(box1.hasCollidedWith(hero)|box2.hasCollidedWith(hero)
			 |box3.hasCollidedWith(hero)|box4.hasCollidedWith(hero)
			 |box5.hasCollidedWith(hero)|box6.hasCollidedWith(hero)
			 |box7.hasCollidedWith(hero)|box8.hasCollidedWith(hero)
			 |box9.hasCollidedWith(hero)|box10.hasCollidedWith(hero)
			 |box11.hasCollidedWith(hero))
			 {
			   hero.moveBackwardby(3);hero.moveBackwardrect(3);
			 }
//---------TELEPORT-END-GAMEOVER------------------------------------		   
		   if(Teleport5.contains((int)hero.x,(int)hero.y))
		   {
			   Level=5;
		   }
	   }
	  
	   
   }//*/
   
//---------- draw the instances ------------------------------------------------------------------------------------------------------------------------------------
   public void draw(Graphics g){   
	super.paintComponent(g);//prints the panel where every component will be placed

//-----DRAW-LEVEL-1-----------------
 if(Level==1)
 	{
	 	layer1.draw(g);//draw image background
	 	hero.draw(g);//draw hero
	 	//badguy.draw(g);//draw bad guy
	 	LeftBorder.draw(g);
	 	TopBorder.draw(g);
	 	BottomBorder.draw(g);
	 	RightBorder.draw(g);
	 	leftWALL.draw(g);
	 	rightWALL.draw(g);
	 	topWALL.draw(g);
	 	b1WALL.draw(g);
	 	b2WALL.draw(g);
	 	b3WALL.draw(g);
	 	middlePillar1.draw(g);
	 	middlePillar2.draw(g);
	 	middlePillar3.draw(g);
	 	middlePillar4.draw(g);
	 	middlePillar5.draw(g);
	 	Teleport1.draw(g);
 	}
//-----DRAW-LEVEL-2-----------------
 if(Level == 2)
 {
	 layer2.draw(g);
	 hero.draw(g);
	 rightwall.draw(g);
	 leftwallA.draw(g);
	 leftwallB.draw(g);
	 Topwall_1.draw(g);
	 Topwall_2.draw(g);
	 Topwall_3.draw(g);
	 Topwall_4.draw(g);
	 PillarA.draw(g);
	 PillarB.draw(g);
	 middleWALL1.draw(g);
	 middleWALL2.draw(g);
	 bottomwall.draw(g);
	 Teleport2.draw(g);
	 Teleport3.draw(g);
 }
//-----DRAW-LEVEL-3-----------------
 if(Level == 3)
 {
	 layer3.draw(g);
	 hero.draw(g);
	 Topwall.draw(g);
	 bookshelf.draw(g);
	 RIGHTwall.draw(g);
	 LEFTwall.draw(g);
	 door.draw(g);
	 plant.draw(g);
	 Col.draw(g);
	 Colleft.draw(g);
	 Coltop.draw(g);
	 Coltopa.draw(g);
	 ColbottomA.draw(g);
	 Colbottom.draw(g);
	 Desk.draw(g);
	 desk.draw(g);
	 BHdesk.draw(g);
	 BHdeska.draw(g);
	 BHdeskb.draw(g);
	 outerworldA.draw(g);
	 outerworldB.draw(g);
	 TelePort4.draw(g);
	 Teleport22.draw(g);
 }
//-----DRAW-LEVEL-4-----------------
 if(Level == 4)
 {
	 layer5.draw(g);
	 layer4.draw(g);
	 hero.draw(g);
	 badguy.draw(g);
	 box1.draw(g);
	 box2.draw(g);
	 Teleport5.draw(g);
	 Teleport24.draw(g);
	 box3.draw(g);
	 box4.draw(g);
	 box5.draw(g);
	 box6.draw(g);
	 box7.draw(g);
	 box8.draw(g);
	 box9.draw(g);
	 box10.draw(g);
	 box11.draw(g);
 }
}
   
//---------- main method -------------------------------------------------------------------------------------------------------------------------------------------
   public static void main(String[] args){
	   Game_loop game = new Game_loop();//create a Game_loop object
	   game.startGame();//that will start the thread for the game
   }
}