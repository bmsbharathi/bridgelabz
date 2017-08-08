import java.util.*;
import java.lang.String;
class InputEx
{
	public static void main(String args[])
	{
		//String name,template;
		System.out.println("Hello! Whats Your Name?");
		Scanner inp = new Scanner(System.in);
		String name = inp.next();
		String template="Hello <<username>> How are you?";
		if( name.length() < 3)
		{
			System.out.println("Name should be a minimum of 3 characters");

		}
		else
		{
		
		String out=template.replace("<<username>>", name);
		System.out.println(out);
		}
	}

}
