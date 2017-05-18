

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {

	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	private Rectangle screenRect;

	private Player player;
	private SafeSquare safe1;
	private SafeSquare safe2;
	private Level level;
	private ArrayList<Shape> obstacles;

	private ArrayList<Integer> keys;
	
	private ArrayList<PImage> assets;

	public DrawingSurface() {
		super();
		assets = new ArrayList<PImage>();
		keys = new ArrayList<Integer>();
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		
		safe1 = new SafeSquare(true,true);
		safe2 = new SafeSquare(false,false);
		
		//once more levels are made, input random integer
		level = new Level(1);
		obstacles = level.getLevels();
		
		
		
	}


	public void spawnNewPlayer() {
		player = new Player(assets.get(0), DRAWING_WIDTH/2-Player.PLAYER_WIDTH/2,50);
	}
	
	public void runMe() {
		runSketch();
	}

	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		//size(0,0,PApplet.P3D);
		assets.add(loadImage("Capture.PNG"));
		
		spawnNewPlayer();
	}

	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() {

		// drawing stuff

		background(200,200,200);   

		pushMatrix();

		float ratioX = (float)width/DRAWING_WIDTH;
		float ratioY = (float)height/DRAWING_HEIGHT;

		scale(ratioX, ratioY);

		fill(0);
		for (Shape s : obstacles) {
			if (s instanceof Rectangle) {
				Rectangle r = (Rectangle)s;
				rect(r.x,r.y,r.width,r.height);
			}
		}

		fill(250,250,0);
		
		rect(safe1.getX(), safe1.getY(), SafeSquare.SAFESQUARE_WIDTH, SafeSquare.SAFESQUARE_HEIGHT);
		rect(safe2.getX(), safe2.getY(), SafeSquare.SAFESQUARE_WIDTH, SafeSquare.SAFESQUARE_HEIGHT);
		
		player.draw(this);

		popMatrix();


		// modifying stuff

		if (isPressed(KeyEvent.VK_LEFT))
			player.walk(-1);
		if (isPressed(KeyEvent.VK_RIGHT))
			player.walk(1);
		if (isPressed(KeyEvent.VK_UP))
		{
			player.jump();
			player.wallJump();
		}
		if (isPressed(KeyEvent.VK_DOWN))
		{
			//crouching (why is this hard for me)
		}
			

		player.act(obstacles);

		if (!screenRect.intersects(player))
			spawnNewPlayer();
		
		//CODE TO RANDOMIZE LEVEL
		
		
		if(//(safe1.getSafe()).intersects(player)*/)
		{
			if(!safe1.getIsStart())
			{
				level = new Level((int)(Math.random()*3)); 
				obstacles = level.getLevels();
				safe1.swap();
				safe2.swap();
			}
			
		}
		
		if(//(safe2.getSafe()).intersects(player)*/)
		{
			if(!safe2.getIsStart())
			{
				level = new Level((int)(Math.random()*3)); 
				obstacles = level.getLevels();
				safe1.swap();
				safe2.swap();
			}
		}
		
		
		
	}


	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}


}

