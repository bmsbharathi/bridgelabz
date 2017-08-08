import java.util.*;
class LeapYear
{
	public static void main(String args[])
	{
		int year;

		System.out.println("Enter a year");
		Scanner inp = new Scanner(System.in);
		year = inp.nextInt();

		if( year < 999)
		{
			System.out.println("Enter the year in yyyy format");
		}
		else{


			if(year % 400 == 0)
			{
				System.out.println(year+" is a Leap Year");
			}
			else if(year % 100 ==0)
			{
				System.out.println(year+" is a not a Leap Year");
			}
			else if(year % 4 ==0)
			{
				System.out.println(year+" is a Leap Year");
			}
			
			else
			{

				System.out.println(year+" is not a Leap Year");

			}
		}
	}
}
