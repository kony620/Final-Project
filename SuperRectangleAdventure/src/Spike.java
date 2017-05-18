import java.awt.Rectangle;
import java.awt.Shape;

/**
 *Sends the player back to the safe square they started at
*/
public class Spike extends Rectangle{

	private static final long serialVersionUID = 1L;
	
	/**
	 *  Creates an instance of the Spike object 
	 *  @param x x coordinate
	 *  @param y y coordinate
	 *  
	*/
	public Spike(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 15;
		this.height = 15;
	}
	
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
}
