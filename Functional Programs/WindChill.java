import java.io.*;
import java.util.*;
class WindChill
{
	public static void main(String args[])
	{
		double temp = Double.parseDouble(args[0]);
		double velocity = Double.parseDouble(args[1]);
		double w=0;

		if(temp > 50 || velocity>120 || velocity <3 )
		{
			System.out.println("Invalid Input!\n temperature should < 50 and Velocity between 3 and 120");
		}		
		else
		{
			w = 35.74 + 0.62151*temp + ( 0.4275 * temp - 35.75) * (Math.pow(velocity,0.16));
			System.out.println("WindChill:"+ w);
		}
		

	}


}