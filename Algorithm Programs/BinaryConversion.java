import java.util.*;
import java.io.*;
import java.lang.*;

class ToBinary
{
	public static void main (String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a decimal number");
		int n=sc.nextInt();
		binarycon(n);
	}

	static String binarycon(int number){
		int temp,num,sum=0,rem=0,i=0,count=0,digits=0,k=0,add;
		
		String str,result;
		
		while(number>0)
		{	
			rem = number%2;
			sum = sum+(int)(rem*Math.pow(10,k++));
			number = number/2;
		}
		//System.out.println(sum);
		

		
		while(k>=Math.pow(2,i))
		{
			i++;	
			count++;
		}

		
		add=(int)Math.pow(2,count);
		digits = add-k;
		System.out.println(add+"\t"+k);
		System.out.println(digits +" " + "Zeroes are to be added");
		
		str=String.valueOf(sum);

		for(int j=0;j<digits;j++)
			str=0+str;
		
		
		num=Integer.parseInt(str);
		
		while(num>0)
		{
			
			temp=num%10000;
			System.out.println("Splitting in 4's of bits " + temp);
			num=num/10000;
		}
		return str;

	}
} 