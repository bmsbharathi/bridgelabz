import java.util.*;
import java.lang.*;
class CouponGeneration
{
	public static void main(String args[])
	{
		System.out.println("Enter the number of coupons to be generated");
		Scanner inp = new Scanner(System.in);
		int n=inp.nextInt();

		Coupon.generate(n);
	}

	static void generate(int n)
	{	int arr = new int[n];
		for(i=0;i<n;i++)
		{
			Random r = new Random();
			int temp=r.nextInt(123456);
			if(i==0)
			{
				arr[i] = temp;
			}
			if(i>1){
				for(j=0;j<=i;j++)
				{
					if(a[i]==temp)
					{
						temp=r.nextInt(121231);
						a[j]=temp;
					}
					else
					{
						a[j]=temp;

					}
				}
					}


		}
	}

}

	