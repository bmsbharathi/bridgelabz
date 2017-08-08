import java.io.*;
import java.util.*;
class StringPermutaions
{
	public static void main(String args[])
	{
		String input;
		int length;

		System.out.println("Enter a String");
		Scanner inp = new Scanner(System.in);
		input = inp.next();

		length = input.length();
		//		System.out.println(length+""+input);
		StringPermutaions s = new StringPermutaions();
		s.permute(input,0,length-1);

	}

void permute(String str,int l,int r)
{
	if(l == r)
		System.out.println(str);
	else
	{
		for(int i=l; i<=r; i++)
		{
			str = swap(str,l,i);
			permute(str,l+1,r);
			str = swap(str,l,i);

		}
	}

}
String swap(String str, int i,int j)
{
	char temp;
	char []arr = str.toCharArray();
	temp = arr[i];
	arr[i]=arr[j];
	arr[j]=temp;

	return String.valueOf(arr);

}
}
