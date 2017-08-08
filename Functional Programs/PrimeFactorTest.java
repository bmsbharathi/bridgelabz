import java.util.*;
import java.lang.String;
class PrimeFactorTest
{
	public static void main(String args[])
	{
		//String name,template;
		System.out.println("Hello! Enter the number to Factorize");
		Scanner inp = new Scanner(System.in);
		int flag=0,number = inp.nextInt();

		for(int i=1;i<=number;i++)
		{
			if(number % i == 0)
			{
				flag=0;//System.out.println("Factor");
				for(int j=2;j<i;j++)
				{
					if(i%j==0)
					{
						flag=1;
						break;
					}
				
			}
			if(flag==0)
				{
					System.out.println(i+" is a prime factor");
					
				}
				
			}	
		}
	
}
}
