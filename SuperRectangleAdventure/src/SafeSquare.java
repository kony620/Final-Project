
import java.awt.Rectangle;
import java.awt.Shape;



public class SafeSquare {
	
	public static final int SAFESQUARE_HEIGHT = 100;
	public static final int SAFESQUARE_WIDTH = 50;
	
	
	private Shape safe;
	private int x;
	private int y;
	private boolean isStart;
	
	
	/**
	 *  Creates an instance of the SafeSquare object 
	 *  @param x determines what side of the screen the square is made on (true --> left, false --> right)
	 *  @param x determines if the safe square is the starting point or the ending point 
	 *  
	*/
	public SafeSquare(boolean q, boolean isStart)
	{
		this.isStart = isStart;
		
		if(q)
		{
			x = 0;
			y = 250;
			safe = (Shape) new Rectangle(x,y,SAFESQUARE_WIDTH,SAFESQUARE_HEIGHT);
		}
		else
		{
			x = 750;
			y = 250;
			safe = (Shape) new Rectangle(x,y,SAFESQUARE_WIDTH,SAFESQUARE_HEIGHT);
		}
	}
	
	public boolean getIsStart()
	{
		return isStart;
	}
	
	public Shape getSafe()
	{
		return safe;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	/**
	 *  Changed the field isStart to its opposite
	*/
	public void swap()
	{
		isStart = !isStart;
	}

}