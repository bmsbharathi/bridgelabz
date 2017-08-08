import java.io.*;
import java.util.*;
import java.lang.*;

class Notes
{
  int noOfNotes=0;
  public static void main(String args[])
  {
    int amount;
    Scanner read = new Scanner(System.in);
    System.out.println("Enter the Amount");
    amount = read.nextInt();

    Notes obj = new Notes();
    obj.findChange(amount);
  }

  void findChange(int amount)
  {
    int balance;
    balance=amount;

    if(amount>=1000)
    {
      noOfNotes = 0;
      balance = amount%1000;
      int thousand = amount/1000;
      amount=balance;
      System.out.println("\nNo of Thousands "+thousand);
      if(amount>0)
      {
        noOfNotes+=thousand;
        findChange(amount);
      }
    }
    else if(balance>=500)
    {
      balance = amount%500;
      int fhundred = amount/500;

      amount=balance;
      System.out.println("No of five hundreds "+fhundred);
      if(amount>0)
      {
        noOfNotes+=fhundred;
        findChange(amount);
      }
    }
    else if(balance>=100)
    {
      balance = amount%100;
      int hundred = amount/100;

      amount=balance;
      System.out.println("No of hundreds "+hundred);
      if(amount>0)
      {
        noOfNotes+=hundred;
        findChange(amount);
      }
    }
    else if(balance>=50)
    {
      balance = amount%50;
      int fifty = amount/50;
      noOfNotes+=fifty;
      amount=balance;
      System.out.println("No of Fifty "+fifty);
      if(amount>0)
      {
        noOfNotes+=fifty;
        findChange(amount);
      }
    }
    else if(balance>=10)
    {
      balance = amount%10;
      int ten = amount/10;

      amount=balance;
      System.out.println("No of Tens "+ten);
      if(amount>0)
      {
        noOfNotes+=ten;
        findChange(amount);
      }
    }
    else if(balance>=5)
    {
      balance = amount%5;
      int five = amount/5;

      amount=balance;
      System.out.println("No of fives "+five);
      if(amount>0)
      {
        noOfNotes+=five;
        findChange(amount);
      }
    }
    else if(balance>=2)
    {
      balance = amount%2;
      int two = amount/2;
      noOfNotes+=two;
      amount=balance;
      System.out.println("No of Twos "+two);
      if(amount>0)
      {
        noOfNotes+=two;
        findChange(amount);
      }

    }
    else
    {
      balance = amount%1;
      int one = amount/1;

      amount=balance;
      System.out.println("No of ones "+one);
      if(amount>0)
      {
        noOfNotes+=one;
        findChange(amount);
      }
    }


    if(amount==0)
      {
        System.out.println("\nTotal no of Notes "+noOfNotes);
      }

  }
}
