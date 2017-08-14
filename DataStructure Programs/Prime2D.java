import java.util.*;
class primeCalculate{

	int[][] brr=new int[100][100];
	int[] arr=new int[1000];
	int k=0,l=0,m=0,i,start;

	void primeCalc(int a,int b)
	{

		for(i=a;i<b;i++)
		{
			int flag=0;

			if(i==0 || i==1)
			{
				flag=1;
			}

			for(int j=2;j<i;j++)
			{
				if(i%j==0 || i==0 || i==1)
				{
					flag=1;
					break;
				}
			}

			if(flag==0)
			{
				arr[m]=i;
				m++;

			}


		int z=0;
		for(l=0;l<10;l++)
		{


			for(k=0;k<25;k++)
			{
				if(arr[z]==checkInterval(200,300) || arr[z]==checkInterval(300,400) || arr[z]==checkInterval(400,500) || arr[z]==checkInterval(500,600) || 		arr[z]==checkInterval(600,700) || arr[z]==checkInterval(700,800) || arr[z]==checkInterval(800,900) || arr[z]==checkInterval(900,1000) )

				{
					k=0;l++;
				}

				brr[k][l]=arr[z];
				z++;


			}
		}




		}



	}
	int checkInterval(int a,int b)
	{
		for(int i=a;i<b;i++)
		{
			int flag=0;
			if(i==0 || i==1)
			{
				flag=1;
			}

			for(int j=2;j<i;j++)
			{
				if(i%j==0 || i==0 || i==1)
				{
					flag=1;
					break;
				}
			}

			if(flag==0)
			{

				start=i;
				break;

			}

		}
		return start;
	}


	void print()
	{
		int z=0;
		for(k=0;k<25;k++)

		{


			for(l=0;l<10;l++)
			{

				if(brr[k][l]==0)
				{
				break;
				}
				System.out.print(brr[k][l]+"\t");

			}
			System.out.println();
		}
	}
}




class Prime2D{
	public static void main(String...args)
	{
  	primeCalculate p=new primeCalculate();
  	Scanner sc=new Scanner(System.in);
  	int a=0,b=1000;

    System.out.println("\nPrime numbers:\n");
  	p.primeCalc(a,b);
  	p.print();




	}
}
