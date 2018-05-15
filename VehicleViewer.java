/* * A <code>VehicleViewer</code> class gives graphical representation of Vehicles
 * * <p>
 * * CPSC 1181 Assignment 6
 * * </p>
 * * @author James Young
 * * @version Mar 01, 2017
 * * @studentid 100273383
 * * @course CPSC 1181-001
 * * @instructor Gladys Monagan
 * */
 */
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.*;
import java.awt.*;
public class VehicleViewer
{
	public static void main(String[] args)
	{
		int number = getNumberOfVehicles();
		
		JFrame fr = new JFrame();
		fr.setSize(800,800);
		fr.setTitle("Vehicles Viewer");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VehicleComponent vehicles = new VehicleComponent(number);
		vehicles.initVehicles(fr.getWidth() - 200, fr.getHeight()- 200);
		fr.add(vehicles);
		fr.setVisible(true);
		while(fr.isResizable())
		{
			vehicles.setBounds(fr.getWidth() - 200, fr.getHeight() - 200);
		}
	}
	
	/**getNumberOfVehicles() method
	*Asks the user to display a specified number of vehicles on the window. Pressing OK, Cancel or invalid number will result in error message.
	*@return The number of vehicles to be displayed
	*/
	
	public static int getNumberOfVehicles()
	{
		String input = JOptionPane.showInputDialog(null, "How many vehicles should be displayed?", "Number of Vehicles", JOptionPane.QUESTION_MESSAGE);
		//User presses cancel
		if(input == null)
		{
			JOptionPane.showMessageDialog(null, "You pressed cancel.", "Program message", JOptionPane.WARNING_MESSAGE);
		}
		//User presses OK without entering anything
		else if(input.equals(""))
		{
			JOptionPane.showMessageDialog(null, "You did not enter anything.", "Program message", JOptionPane.WARNING_MESSAGE);
		}
		
		else
		{
			//Checks if the number entered is a valid positive number
			boolean check = isNumeric(input);
			if(check == true)
			{
				int numberOfVehicles = Integer.parseInt(input);
				return numberOfVehicles;
			}
			//Any letters,  negative or decimal numbers will be rejected
			else
			{
				JOptionPane.showMessageDialog(null, "You have entered non-numeric data. Radius must be an integer number.", "Program error", JOptionPane.OK_OPTION);
			}
		}
		
		return 0;
	}
	
	/** isNumeric() method
	*Checks to see if input is numeric or not in string representation form.
	*@return true if string is full of numbers, false if not.
	*/
	
	public static boolean isNumeric(String radius)
	{
		for(int i = 0; i < radius.length(); i++)
		{
			if(radius.charAt(i) < '0' || radius.charAt(i) > '9')
			{
				return false;
			}
		}
		return true;
	}
}