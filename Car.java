import java.awt.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Rectangle;
	/**
	* This class represents a subclass of Vehicle. A car has different width, height and speed properties from other vehicles.
	
	* @author James Young
	*/
public class Car extends Vehicle
{
	private static final int CAR_WIDTH = 60;
	private static final int CAR_HEIGHT = 30;
	private static final int CAR_TIRE_SIZE = 10;
	
	public Car()
	{
		super(0, 0, DEFAULT_COLOR, CAR_WIDTH, CAR_HEIGHT);
	}
	public Car(int x, int y, Color c)
	{
		super(x, y, c, CAR_WIDTH, CAR_HEIGHT);
	}
	
	/*
	* Draws a car 
	*@author modified from C. Horstmann's Big java section 3.8
	*@param g2 Graphics2D needed to draw the shapes
	*/
	@Override
	public void draw(Graphics2D g2)
	{
		//The body of the car
		Rectangle body = new Rectangle(getX(), getY() + 10, 60, 10);
		//Enclosing rectangle
		Rectangle size = new Rectangle(getX(), getY(), CAR_WIDTH, CAR_HEIGHT);   
		//The tires of the car
		Ellipse2D.Double frontTire = new Ellipse2D.Double(getX() + 10, getY() + 20, CAR_TIRE_SIZE, CAR_TIRE_SIZE);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(getX() + 40, getY() + 20, CAR_TIRE_SIZE, CAR_TIRE_SIZE);
		
		//The top windows of the car
		int[] xPoints = { getX() + 10, getX() + 20, getX() + 40, getX() + 50 };
		int[] yPoints = { getY() + 10, getY(), getY(), getY() + 10 };
		int nPoints = 4;
		
		Polygon top = new Polygon(xPoints, yPoints, nPoints);
		
		g2.setColor(getColor());
		g2.draw(body);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(top); 
		g2.draw(size);
		g2.fill(body);
		g2.fill(frontTire);
		g2.fill(rearTire);
		g2.fill(top);
	}
}