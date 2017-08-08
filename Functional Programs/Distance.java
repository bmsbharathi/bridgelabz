import java.util.*;
import java.lang.*;
class Distance 
{
	public static void main(String args[])
	{
		double x,y;
		double eucliDist;
		x=Double.parseDouble(args[0]);
		y=Double.parseDouble(args[1]);

		eucliDist = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));

		System.out.print(eucliDist+"\n");
	}
}