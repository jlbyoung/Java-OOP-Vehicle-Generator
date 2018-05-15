import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.*;
 /**
  * This class represents a vehicle. A vehicle has a position corresponding
  * to the upper left hand corner of the enclosing rectangle, it has a width
  * and a height, and it has a color. The width and the height are of the 
  * enclosing rectangle (bounding box) anchored by its upper left hand 
  * corner.
  * @author A Student
  */
public abstract class Vehicle
{
	/*
	* The default value for the width and height of the vehicle's enclosing square.
	*/
	public static final int DEFAULT_VEHICLE_SIDE = 200;

	/*
	* The default color of the vehicle.
	*/
	public static final Color DEFAULT_COLOR = Color.RED;
	
	/*
	* The X and Y coordinate of the vehicle (negative coordinate system)
	*/ 
	private int xLeft;
	private int yTop;
	
	/*
	* The width and height of the vehicle 
	*/ 
	private int width;
	private int height;
	/*
	* The random color of the vehicle
	*/ 
	private Color color;
	
	/*
	* To determine if a particular vehicle is overlapping with another, True if it is, false if not overlapping.
	*/
	private boolean overlapFlag;
	/**
	* Sets the vehicle's bounding rectangle's sides to the
	* <code><a href="Vehicle.html#DEFAULT_VEHICLE_SIDE">DEFAULT_VEHICLE_SIDE</a></code>,
	* the vehicles'color to 
	* <code><a href="Vehicle.html#DEFAULT_COLOR">DEFAULT_COLOR</a></code>,
	* and the upper left hand corner of the bounding rectangle to the origin.
	*/
	public Vehicle()
	{
		xLeft = 0;
		yTop = 0;
		color = DEFAULT_COLOR;
		width = DEFAULT_VEHICLE_SIDE;
		height = DEFAULT_VEHICLE_SIDE;
	}
	/**
	* Sets the vehicle's bounding rectangle to be of dimensions w x h with
	* (x,y) as upper left hand corner and the vehicle's colour to c. 
	* @param x the x-coordinate of the enclosing rectangle's upper left hand corner
	* @param y the y-coordinate of the enclosing rectangle's upper left hand corner 
	* @param c the colour of the vehicle
	* @param w the width of the enclosing rectangle
	* @param h the height of the enclosing rectangle
	*/
	public Vehicle(int x, int y, Color c, int w, int h)
	{
		xLeft = x;
		yTop = y;
		color = c;
		width = w;
		height = h;
	}
	
	/**
	* Draws the vehicle onto the graphics context using the 
	* previously set colour and position of the enclosing rectangle.
	* @param g2 the graphics context
	*/
	public abstract void draw(Graphics2D g2);
	
	/**
	* Sets the position of the vehicle by setting the upper left hand corner 
	* of the bounding box of the vehicle to be the point (x,y).
	* @param x the x-coordinate of the enclosing rectangle's upper left hand corner
	* @param y the y-coordinate of the enclosing rectangle's upper left hand corner 
	*/
	public void setPosition(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	/**
	* Sets the colour of the vehicle.
	* @param c a specified Color
	*/
	public void setColor(Color c)
	{
		color = c;
	}
	
	/**
	* @return the colour of the vehicle.
	*/
	public Color getColor()
	{
		return color;
	}
	
	/**
	* @return the top left X coordinate of the vehicle.
	*/
	
	public int getX()
	{
		return xLeft;
	}
	
	/**
	* @return the top left Y coordinate of the vehicle.
	*/
	
	public int getY()
	{
		return yTop;
	}
	/**
	* @return the width of the vehicle.
	*/
	
	public int getWidth()
	{
		return width;
	}
	/**
	* @return the height of the vehicle.
	*/
	
	public int getHeight()
	{
		return height;
	}
	
	/**
	* @return whether or not the vehicle is overlapping with another vehicle, true if it is, false if not overlapping
	*/
	
	public boolean getOverlap()
	{
		return overlapFlag;
	}
	
	/**
	* Sets the overlapFlag to true if overlaps with another vehicle, and false if not
	* @param a boolean value, true if overlaps, false if not
	* @return whether or not the vehicle is overlapping with another vehicle, true if it is, false if not overlapping
	*/
	public void setOverlap(boolean o)
	{
		overlapFlag = o;
	}
	
	/**
	* @return the string consisting of the upper left hand corner of the 
	* enclosing rectangle, its color, and the dimensions of the enclosing rectangle
	*/
	@Override
	public String toString()
	{
		String string = "";
		string = "coordinates :(" + xLeft + ", " + yTop + ")" + ", color : " + color + ", width : " + width + ", height : " + height;
		return string;
	}
	
	/**
	* Determines if two vehicles are equal.
	* @return true if obj is equal to this object based on the vehicle's
	* position (the position is defined by the upper left hand corner of the 
	* enclosing rectangle), by the dimensions of the enclosing rectangle, 
	* and by the vehicle's color
	*/
	@Override 
	public boolean equals(Object obj)
	{
		if(obj instanceof Vehicle)
		{
			Vehicle v = (Vehicle)obj;
			if(v.getX() == this.getX() && v.getY() == this.getY() && v.getWidth() == this.getWidth() && v.getHeight() == this.getHeight() && v.getColor() == this.getColor())
			{
				return true;
			}
		}
		return false;
	}
}