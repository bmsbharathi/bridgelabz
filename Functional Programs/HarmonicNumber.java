import java.util.*;
import java.lang.String;
class HarmonicNumber
{
	public static void main(String args[])
	{
		int N;
		double value=0;
		System.out.println("Enter the value of N?");
		Scanner inp = new Scanner(System.in);
		N = inp.nextInt();
		if( N == 0)
		{
			System.out.println("N Should not be Zero");

		}
		else
		{
		for(int i=1; i <= N;i++)
		{
			value+=(double)1/i;
		}
		
		}
		System.out.println("The "+N+"th Harmonic Value is "+value);
	}

}
