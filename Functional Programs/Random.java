import java.io.*;
import java.util.*;
import java.lang.*;
class Randomm
{
  public static void main(String args[])
  {
    int number;

    System.out.println("Enter the Number of coupons needed");
    Scanner inp = new Scanner(System.in);
    number = inp.nextInt();

    Random rand = new Random();
    number = rand.nextInt(15000);
    System.out.println(number);
  }
}
