import java.util.*;
import java.lang.*;
import java.io.*;

class GuessNumber
{ 
  public static void main(String args[])
  {
    int high,result,n;
    
    n = Integer.parseInt(args[0]);

    high=(int)Math.pow(2,n)-1;

    System.out.println("Think of a number between 0 and "+high);
    
    result=guessNumber(0,high);

    System.out.println(result + " " + "is the number");

  }


  static int guessNumber(int low,int high)
  {
    Scanner read=new Scanner(System.in);
    
    if((high-low)==1)
      return low;

    int mid=(low+high)/2;
    
    System.out.println("Is it less than" + " " + mid );
    String option=read.next();
    
    if(option.equalsIgnoreCase("yes"))
    {
      return guessNumber(low,mid);
    }
    else
    {
      return guessNumber(mid+1,high);
    }
  }
}
