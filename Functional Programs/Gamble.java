import java.util.*;
import java.lang.Math;
class Gamble
{
	public static void main(String args[]){
	
	int i=0,stake,goal,noOfTrails,win=0,loss=0; 
	System.out.println("Enter the Stake, Goal and no of Trails");
	Scanner inp= new Scanner(System.in);
	stake = inp.nextInt();
	goal = inp.nextInt();
	noOfTrails = inp.nextInt();

	for(i = 0;i < noOfTrails; i++)
	{
		if(stake == goal)
		{
			System.out.println("Goal reached in "+i+" trails");
			break;
		}
		if(stake == 0)
			{
			System.out.println("Broke!! out of stake");
			break;	
		}
		System.out.println("\nTrail:"+(i+1));
		if(Math.random() > 0.5)
		{
			win++;
			System.out.println("Win");
			stake++;
		}
		else
		{
			stake--;
			System.out.println("Loss");
		}
		
		
	}
	float winPercent,lossPercent, averageWin, averageLoss;
	winPercent = ((float)win/i)*100;
	averageWin=(float)win/i;
	averageLoss=(float)(i-win)/i;
	loss=(i-win);
	lossPercent = (float)(i-win)/i*100;
	
	System.out.println("\nWin % " +winPercent+"\nAverage Wins:"+averageWin+"\nAverage Loss: "+averageLoss+"\nLoss Percentage:"+lossPercent);


	}
}