import java.util.*;
import java.util.Random;
import java.lang.*;
class CouponGeneration
{
	public static void main(String args[])
	{
		System.out.println("Enter the number of coupons to be generated");
		Scanner inp = new Scanner(System.in);
		int n=inp.nextInt();

		CouponGeneration.generate(n);
	}
	static void generate(int n){
		int arr[] = new int[n];
		int i,j,temp,count=0;
		Random r1 = new Random();
		for(i=0;i<n;i++)
		{
				temp = r1.nextInt(123432);
				count++;
				arr[i]=temp;
				
				for(j=0;j<i;j++)
				{
					if(arr[i]==arr[j])
					{
						i--;
						count++;
						break;	
					}
				}

				
			}
			for(j=0;j<n;j++)
				System.out.println(arr[j]);			
		
			System.out.println("No of genrations:"+count);
	}

		
		
}