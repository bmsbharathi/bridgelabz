import java.util.*;
import java.lang.*;

class Binary
{
	public static void main(String args[]){

	Scanner read = new Scanner(System.in);
	int number = read.nextInt();
	String binValue;
	
	binValue = Utility.binaryConversion(number);
	System.out.println("Binary value of "+ number+ " is\t"+binValue);
	binarySplit(binValue);
	
	}
	static void binarySplit(String input)
	{
		String subString1,subString2,result;
		int number,sum=0,rem=0,flag1=0;

		subString1=input.substring(0,4);
		subString2=input.substring(4,8);
		result=subString2+subString1;
		System.out.println("After Nibble swapping\t" + result);
		number=Integer.parseInt(result);
		while(number>0)
		{
			
			rem=(number%10);
			sum=sum+(int)(rem*Math.pow(2,flag1++));
			number/=10;
				
		}

		System.out.println("The decimal value after nibble swapping\t"+ sum);

	}
}