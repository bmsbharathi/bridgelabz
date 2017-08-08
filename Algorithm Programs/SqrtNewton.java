import java.io.*;
import java.lang.*;
import java.util.*;

class SqrtNewton
{
  public static void main(String args[])
  {
    double c;
    Scanner read = new Scanner(System.in);

    System.out.println("Enter a non-negative number");
    c = read.nextDouble();

    calcSqrt(c);

  }

  static void calcSqrt(double c)
  {

    double t=c, epsilon = Math.exp(-15);
    
    while(Math.abs(t - (c/t)) > (epsilon * t))
        {
            t = (c/(2 * t)) + (t/2);
        }
       
    System.out.println("The Square Root of "+c +"is "+t);

  }
}
