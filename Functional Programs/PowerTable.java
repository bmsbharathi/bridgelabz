import java.lang.Math;
class PowerTable
{
	public static void main(String args[])
	{
		int power;

		System.out.println("Enter a number less than 31");
		power = Integer.parseInt(args[0]);

		if( power > 31)
		{
			System.out.println("Enter number less than 31");
		}
		else{

			for(int i = 0; i <= power; i++)
			{
				System.out.println("2 power "+ i +" is "+ (int)Math.pow(2,i));

			}
		}
	}
}