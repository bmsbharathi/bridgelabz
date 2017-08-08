import java.util.*;
class CoinToss
{
	public static void main(String args[])
	{
		int noOfFlips,heads=0;
		System.out.println("Hello! Enter the number of tosses");
		Scanner inp = new Scanner(System.in);
		noOfFlips = inp.nextInt();
		double tailsPercent,headsPercent=0;
		for(int i=0; i < noOfFlips; i++)
		{
			double rand=Math.random();
		//System.out.println("Random:"+rand);
			System.out.println("\nTrial "+(i+1)+": ");
			if( rand > 0.5)
			{
				System.out.println("Heads");
				heads++;
			}
			else
			{
				System.out.println("Tails");		}
		}
		headsPercent = ((float)heads/(float)noOfFlips)*100;
		tailsPercent = (100-headsPercent);
		//System.out.println("Head: "+heads+" No of flips:"+noOfFlips+" HeadsPercent"+headsPercent);
		
		System.out.println("\nPercentage of Heads:"+headsPercent);

		System.out.println("Percentage of Tails:"+tailsPercent);
	}

}
