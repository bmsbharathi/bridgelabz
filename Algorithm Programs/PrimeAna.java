import java.util.*;
import java.lang.*;
import java.io.*;

class PrimeAna
{
  public static void main(String args[])
  {

    int min,max;
    System.out.println("Enter the Min and Max range");

    Scanner s = new Scanner(System.in);
    min=s.nextInt();
    max=s.nextInt();

    PrimeAna pa = new PrimeAna();
    pa.genPrime(min,max);

  }

  void genPrime(int l,int r)
  {
    int flag=0,i=0,j=0,k=0;

    System.out.print("Prime Numbers Between "+l+" and "+r+":\n");
    int arr[] = new int[r-l];


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
          if(i!=0 || i!=1)
          {
            

            System.out.print(i+" ");
            

            arr[k] = i;
            checkPalindrome(i);
            System.out.println("");
            k++;
          }
        }

    }
  
  checkAnagram(arr,k);

  }

void checkAnagram(int arr[],int len)
{
  String str,str1;
  int brr[] = new int[len],flag = 0;
  for(int i=0;i<len;i++)
    {
      str = String.valueOf(arr[i]);
      char c[] = str.toCharArray();
      Arrays.sort(c);
      str1 = String.valueOf(c);
      int val = Integer.parseInt(str1);
      brr[i] = val;

    }
    System.out.println("\nThe Anagrams are");
  for(int i=0;i<len;i++)
  {
    for(int j=i+1;j<len;j++)
    {
      if(brr[i]==brr[j])
      {
        System.out.println(arr[i]+"---"+arr[j]);
        flag = 1;
      }
    }
  }
  if(flag==0)
  {
    System.out.println(" None");
  }
}


void checkPalindrome(int num){

  int i,j,sum=0,rev=0,temp,rem=0;
  temp=num;

  
  if(num>9)
  {
    while(temp>0)
    {
      rem=temp%10;
      rev = rev*10+rem;
      temp=temp/10;
    }
  
    if(rev == num)
    {
      System.out.print(" is a palindrome");
    }
  }
  

  }



  static int reverseNumber(int number)
  {
    int sum=0,rem=0,rev=0;
    while(number>0)
    {
      rem=number%10;
      rev = rev*10+number;
      number=number/10;
    }
    
    return rev; 
  
  }
}
