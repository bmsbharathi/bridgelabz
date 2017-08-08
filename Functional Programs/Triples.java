import java.util.*;

class Triples
{
	public static void main(String args[]){
		int N,i,j,k, flag =0;

		Scanner inp = new Scanner(System.in);

		System.out.println("Enter the number of Inputs");
		N = inp.nextInt();

		int []arr = new int[N];

		System.out.println("Enter numbers");
		for( i=0;i<N;i++)
		{
			arr[i] = inp.nextInt();
		}

		
		for(i=0;i<N;i++)
		{
			for(j=i+1;j<N;j++)
			{
				if(arr[j-1]>arr[j])
					{
					int temp= arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					}
			}

		}

/*

		for( i=0;i<N;i++)
		{
			System.out.println(""+arr[i]);
		}

*/
		for(i=0;i<N-2;i++)
			{
				if(i==0 || arr[i]>arr[i-1])
				{
				j=i+1;
				k=N-1;
		
				while(j<k)
				{
					
					if(arr[i]+arr[j]+arr[k] == 0)
					{
						System.out.println("Distinct Triples:"+arr[i]+" "+arr[j]+" "+arr[k]);
						j++;
						k--;
						flag++;
					
					while(j<k && arr[j]==arr[j-1])
                        j++;
                    
                    while(j<k && arr[k]==arr[k+1])
                        k--;
                    
					}



					else if(arr[i]+arr[j]+arr[k]<0)
						j++;
					
					else			/*(arr[i]+arr[j]+arr[k]>0)*/
						k--;

					
				}
			}
		}

		if(flag == 0)
			System.out.println("No Triples found");
	}

}




/*import java.util.*;

class Triples
{
	public static void main(String args[]){
		int N,i,j,k;

		Scanner inp = new Scanner(System.in);

		System.out.println("Enter the number of Inputs");
		N = inp.nextInt();

		int []arr = new int[N];

		System.out.println("Enter numbers");
		for( i=0;i<N;i++)
		{
			arr[i] = inp.nextInt();
		}

		for(i=0;i<N;i++)
			{
				for(j=i+1;j<N;j++)
					{
						for(k=j+1;k<N;k++)
						{
							if(arr[i]+arr[j]+arr[k] == 0)
							{
								System.out.println("Distincts:"+arr[i]+" "+arr[j]+" "+arr[k]);
							}
						}
				}
		}


/*
		for( i=0;i<N;i++)
		{
			System.out.println(""+arr[i]);
		}*/

