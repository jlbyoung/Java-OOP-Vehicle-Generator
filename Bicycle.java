import java.awt.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Rectangle;
	/**
	* This class represents a subclass of Vehicle. A bicycle has different width, height and speed properties from other vehicles.
	
	* @author James Young
	*/
public class Bicycle extends Vehicle
{
	private static final int BIKE_WIDTH = 50;
	private static final int BIKE_HEIGHT = 35;
	private static final int BIKE_TIRE_SIZE = 15;
	
	public Bicycle()
	{
		super(0, 0, DEFAULT_COLOR, BIKE_WIDTH, BIKE_HEIGHT);
	}
	public Bicycle(int x, int y, Color c)
	{
		super(x, y, c, BIKE_WIDTH, BIKE_HEIGHT);
	}
	
	/*
	* Draws a bicycle
	*@author modified from C. Horstmann's Big java section 3.8
	*@param g2 Graphics2D needed to draw the bicycle
	*/
	@Override
	public void draw(Graphics2D g2)
	{
		//The left of the body
		Point2D.Double r1 = new Point2D.Double(getX(), getY()+ 20);
		//The right of the body
		Point2D.Double r2 = new Point2D.Double(getX() + 40, getY() + 20);
		//The handlebars
		Point2D.Double r3 = new Point2D.Double(getX() + 45, getY() + 5);
		Point2D.Double r4 = new Point2D.Double(getX() + 38, getY());
		Point2D.Double r5 = new Point2D.Double(getX() + 35, getY() + 5);
		
		//The entire body
		Line2D.Double body = new Line2D.Double(r1, r2);
		Line2D.Double handlebar1 = new Line2D.Double(r2, r3);
		Line2D.Double handlebar2 = new Line2D.Double(r3, r4);
		Line2D.Double handlebar3 = new Line2D.Double(r3, r5);
		Rectangle size = new Rectangle(getX(), getY(), BIKE_WIDTH, BIKE_HEIGHT);   
		Ellipse2D.Double rearTire = new Ellipse2D.Double(getX(), getY() + 20, BIKE_TIRE_SIZE, BIKE_TIRE_SIZE);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(getX() + 35, getY() + 20, BIKE_TIRE_SIZE, BIKE_TIRE_SIZE);
		
		
		g2.setColor(getColor());
		g2.draw(body);
		g2.draw(handlebar1);
		g2.draw(handlebar2);
		g2.draw(handlebar3);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(size);
		g2.fill(body);
		g2.fill(handlebar1);
		g2.fill(handlebar2);
		g2.fill(handlebar3);
		g2.fill(frontTire);
		g2.fill(rearTire);
	}
}