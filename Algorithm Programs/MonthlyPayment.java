import java.util.*;
import java.io.*;

class MonthlyPayment
{
  public static void main(String args[])
  {
    double principal, year, rate;

    principal = Double.parseDouble(args[0]);
    year = Double.parseDouble(args[1]);
    rate = Double.parseDouble(args[2]);

    MonthlyPayment mp = new MonthlyPayment();
    mp.calculateMonthlyPayment(principal,year,rate);

  }
  void calculateMonthlyPayment(double principal, double year, double rate)
  {
    double monthly = 0,r,n;

    r = rate/(12*100);
    n = 12*year;

    monthly = ( principal * r )    / ( 1 - (Math.pow(r+1,-n)));

    System.out.println("Monthly Payment = "+ monthly);
  }
}
