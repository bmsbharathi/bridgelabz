import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;
class RandomCoupon
{
  public static void main(String args[])
  {
    int i,j,number,temp,count=0;

    System.out.println("Enter the Number of coupons needed");
    Scanner inp = new Scanner(System.in);
    number = inp.nextInt();
    System.out.println("\n");
    int []arr = new int[number];
    Random rand = new Random();

    for(i=0;i<number;i++)
    {
          temp = rand.nextInt(5);
          count++;
          arr[i]=temp;
          for(j=0;j<i;j++)
          {
            if(arr[i]==arr[j])
            {
              i--;
              break;
            }
          }

        }

  System.out.println("\n");
    for(j=0;j<number;j++)
      System.out.println(arr[j]);
    System.out.println("Number of times Random number generated:"+count);
  }
}
