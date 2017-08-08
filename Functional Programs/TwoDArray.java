import java.io.*;
import java.util.*;
class TwoDArray
{
	public static void main(String args[])
	{
		int m,n;
		
		Scanner inp = new Scanner(System.in);

		System.out.println("Enter the No of Rows and Columns");
		m=inp.nextInt();
		n=inp.nextInt();

		int intarr[][] = new int[m][n];

		Generic obj = new Generic();
		
		PrintWriter pw = new PrintWriter(System.out);

		pw.print("HELLO WORLD");

		obj.arrayPrint(intarr,m,n);

	}
}

class Generic{

	void  arrayPrint(int [][]intarr,int m,int n)
		{
		
		System.out.println("Enter the 2D Integer Array ");
		Scanner inp = new Scanner(System.in);

		PrintWriter writer = new PrintWriter(System.out);

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				{
					intarr[i][j] = inp.nextInt();
				}
		}

		System.out.println("\n");
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				writer.print(""+intarr[i][j]+"\t");
			}
			writer.print("\n");
		}
		writer.flush();
		writer.close();

	}

}
