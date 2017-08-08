import java.util.*;
import java.lang.*;
class PrimeGeneration
{
  public static void main(String args[])
  {
    int min,max;
    System.out.println("Enter the Min and Max range");

    Scanner s = new Scanner(System.in);
    min=s.nextInt();
    max=s.nextInt();

    PrimeGeneration pg = new PrimeGeneration();
    pg.genPrime(min,max);

  }
  void genPrime(int l,int r)
  {
    int flag=0,i,j;

    System.out.println("Prime Numbers Between "+l+" and "+r+":");
    for(i=l;i<=r;i++)
    {
      for(j=2;j < i; j++)
      {
        flag=0;
        if( i % j == 0 )
          {
            flag=1;
            break;
          }
      }
      if(flag ==0 )
        {
          if(i==0 || i==1)
          {

          }
          else{
            System.out.println(i+"\t");
        }
    }

    }


  }
}
