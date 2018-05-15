import java.awt.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Rectangle;
	/**
	* This class represents a subclass of Vehicle. A truck has different width, height and speed properties from other vehicles.
	
	* @author James Young
	*/
public class Truck extends Vehicle
{
	private static final int TRUCK_WIDTH = 180;
	private static final int TRUCK_HEIGHT = 90;
	private static final int TRUCK_TIRE_SIZE = 20;
	
	public Truck()
	{
		super(0, 0, DEFAULT_COLOR, TRUCK_WIDTH, TRUCK_HEIGHT);
	}
	public Truck(int x, int y, Color c)
	{
		super(x, y, c, TRUCK_WIDTH, TRUCK_HEIGHT);
	}
	
	/*
	* Draws a truck
	*@author modified from C. Horstmann's Big java section 3.8
	*@param g2 Graphics2D needed to draw the truck
	*/
	@Override
	public void draw(Graphics2D g2)
	{
		Rectangle frontBody = new Rectangle(getX(), getY() + 30, 50, 40);
		Rectangle body = new Rectangle(getX() + 50, getY(), 130, 70);
		Rectangle size = new Rectangle(getX(), getY(), TRUCK_WIDTH, TRUCK_HEIGHT);
		Ellipse2D.Double frontTire1 = new Ellipse2D.Double(getX(), getY() + 70, TRUCK_TIRE_SIZE, TRUCK_TIRE_SIZE);
		Ellipse2D.Double frontTire2 = new Ellipse2D.Double(getX() + 30, getY() + 70, TRUCK_TIRE_SIZE, TRUCK_TIRE_SIZE);
		Ellipse2D.Double midTire1 = new Ellipse2D.Double(getX() + 70, getY() + 70, TRUCK_TIRE_SIZE, TRUCK_TIRE_SIZE);
		Ellipse2D.Double midTire2 = new Ellipse2D.Double(getX() + 90, getY() + 70, TRUCK_TIRE_SIZE, TRUCK_TIRE_SIZE);
		Ellipse2D.Double rearTire1 = new Ellipse2D.Double(getX() + 130, getY() + 70, TRUCK_TIRE_SIZE, TRUCK_TIRE_SIZE);
		Ellipse2D.Double rearTire2 = new Ellipse2D.Double(getX() + 150, getY() + 70, TRUCK_TIRE_SIZE, TRUCK_TIRE_SIZE);
		
		g2.setColor(getColor());
		g2.draw(body);
		g2.draw(frontTire1);
		g2.draw(frontTire2);
		g2.draw(midTire1);
		g2.draw(midTire2);
		g2.draw(rearTire1);
		g2.draw(rearTire2);
		g2.draw(frontBody); 
		g2.draw(size);
		g2.fill(frontTire1);
		g2.fill(frontTire2);
		g2.fill(midTire1);
		g2.fill(midTire2);
		g2.fill(rearTire1);
		g2.fill(rearTire2);
		g2.fill(body);
		g2.fill(frontBody);
	}
}