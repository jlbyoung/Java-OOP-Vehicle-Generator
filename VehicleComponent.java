import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	/**
	* This class draws vehicles based on random x and y coordinates(negative coordinate system)
	* and random colors.
	* @author James Young
	*/
	/**
* A <code>VehicleComponent</code> class has collection of vehicles
* <p>
* CPSC 1181 Assignment 6
* </p>
* @author James Young
* @version Mar 01, 2017
* @studentid 100273383
* @course CPSC 1181-001
* @instructor Gladys Monagan
*/
public class VehicleComponent extends JComponent implements ActionListener
{
	private int numberOfVehicles;
	private ArrayList<Vehicle> listOfVehicles;
	public int MAX_ATTEMPTS = 25;
	public static Integer boundsWidth;
	public static Integer boundsHeight;
	Random random = new Random();
	Timer t = new Timer(10, this);
	
	/**
	*Initializes values for number of vehicles
	*@param n the number of vehicles given by user
	*/
	
	public VehicleComponent(int n)
	{
		numberOfVehicles = n;
		listOfVehicles = new ArrayList<Vehicle>();
	}
	
	/**
	*draws the vehicles according to the number of vehicles specified by user. Draws a vehicle only if the total area of window is greater than the combined area of vehicles
	*If there is overlap between the vehicles, the vehicle that is overlapping will be given random coordinates for a maximum attempt of 25.
	*If there is no overlap, the program will begin to draw the vehicle.
	*@param g Graphics needed to draw shapes
	*/
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		int attempts = 0;
		int totalArea = boundsWidth * boundsHeight;
		int v1Area = 0;
		for(Vehicle v1 : listOfVehicles)
		{
			//The area of a given vehicle
			v1Area = v1.getHeight() * v1.getWidth();
			do
			{
				//Checks to see if vehicle overlaps or not
				if(checkOverlap(v1))
				{
					//If the vehicle overlaps, then it is given random coordinates.
					if(v1.getOverlap())
					{
						randomizePosition(v1, boundsWidth, boundsHeight);
					}
				}
				attempts++;
			} while(attempts < MAX_ATTEMPTS);
			//If the cumulative area of all vehicles are less than the total frame area, then the program is free to continue drawing vehicles
			if(v1Area < totalArea)
			{
				if(!v1.getOverlap());
				{
					v1.draw(g2);
				}
			}
			//Each vehicle's area is added onto the next, giving a cumulative value
			v1Area += v1Area;
		}
		t.start();
	}
	
	/**
	* Initializes the listOfVehicles given equal probablity to different kinds of vehicles, gives random positions and color to each vehicle too.
	* @param h the frame's height minus margin(-200)
	* @param w the frame's width minus margin(-200)
	*/
	public void initVehicles(int w, int h)
	{
		for(int i = 0; i < numberOfVehicles; i++)
		{
			int choose = random.nextInt(3);
			if(choose == 0)
			{
				listOfVehicles.add(new Car());
			}
			else if (choose == 1)
			{
				listOfVehicles.add(new Bicycle());
			}
			else
			{
				listOfVehicles.add(new Truck());
			}
		}
		for(Vehicle v1 : listOfVehicles)
		{
			randomizePosition(v1, w, h);
			v1.setColor(new Color((int)(Math.random() * 0x1000000)));
		}
	}
	/**
	*Gives random coordinates to vehicle
	*@param v The vehicle to be given random coordinates
	*@param w the frame's width
	*@param h the frame's height
	*/
	
	public void randomizePosition(Vehicle v, int w, int h)
	{
		v.setPosition(random.nextInt(w), random.nextInt(h));
	}
	/**
	*Sets the bounds of the window being resized
	*@param w the frame's width
	*@param h the frame's height
	*/
	
	public static void setBounds(int w, int h)
	{
		boundsWidth = w;
		boundsHeight = h;
	}
	/**
	*checks and sets the vehicle's overlapFlag if they are overlapping. Sets the overlapFlag to false if not overlapping, otherwise always returns true
	*@param v1 the vehicle being checked for overlap
	*@return true if overlap
	*/
	public boolean checkOverlap(Vehicle v1)
	{
		//Second independent arrayList to check if each vehicle in listOfVehicles intersects or not
		ArrayList<Vehicle> otherList = new ArrayList<Vehicle>(listOfVehicles);
		//Creating rectangles to use intersect method to determine if a vehicle is overlapping or not
		Rectangle v1Rec = new Rectangle(v1.getX(), v1.getY(), v1.getWidth(), v1.getHeight());
		for(int i = 0; i < otherList.size(); i++)
		{
			Vehicle v2 = otherList.get(i);
			if(!(v1.equals(v2)))
				{
				Rectangle v2Rec = new Rectangle(v2.getX(), v2.getY(), v2.getWidth(), v2.getHeight());
				if(!v1Rec.intersects(v2Rec))
				{
					v1.setOverlap(false);
				}
				else
				{
					v1.setOverlap(true);
					return true;
				}
			}
		}
		return true;
	}
	
		/**
	*Handles event of moving the vehicles. The X and Y coordinates are changed according to the constant velocity of 6.
	*@param e Event being fired
	*/
	public void actionPerformed(ActionEvent e)
	{
		for(Vehicle v1 : listOfVehicles)
		{
			int v = 6;
			if(v1.getX() < 0 || v1.getX() >= boundsWidth)
			{
				v = -v;
			}
			if(v1.getY() <= 0 || v1.getY() >= boundsHeight)
			{
				v = -v;
			}
			v1.setPosition(v1.getX() + v, v1.getY() + v);
			repaint();
		}
	}
}