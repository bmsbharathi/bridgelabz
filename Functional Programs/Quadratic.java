import java.io.*;
import java.util.*;
class Quadratic
{
	public static void main(String args[])
	{
		
		double delta,root1,root2,a,b,c;

		System.out.println("Quadratic Equation ax^2 + bx + c =0, Enter a, b, c ");
		Scanner inp = new Scanner(System.in);
		a = inp.nextDouble();
		b = inp.nextDouble();
		c = inp.nextDouble();

		delta = Math.pow(b,2)-4*a*c;
		//System.out.println(delta);
		
		root1 = (-b + Math.sqrt(Math.abs(delta)))/(2*a);
		root2 = (-b - Math.sqrt(Math.abs(delta)))/(2*a);

		System.out.println("\nRoot1: "+root1+"\nRoot2: "+root2);

	}

}