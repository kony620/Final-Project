import java.awt.Rectangle;
import java.awt.Shape;

public class Spike extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
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