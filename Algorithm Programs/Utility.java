import java.util.*;

public final class Utility
{
  private Utility()
  {
    //Constructor
  }

  public static void checkAnagram(String input1, String input2)
  {
    String s1,s2;
        char []temp = input1.toCharArray();
        char []temp2 = input2.toCharArray();

        //System.out.println(temp + "" + temp2);

        Arrays.sort(temp);
        Arrays.sort(temp2);

        //System.out.println(temp + "" + temp2);

        s1 = String.valueOf(temp);
        s2 = String.valueOf(temp2);

        if(s1.equals(s2))
        {
          System.out.println(input1+" and "+input2+" are Anagrams");
        }
        else
        {
          System.out.println(input1+" and "+input2+" are not Anagrams");
        }

    }

static String binaryConversion(int number){
    int num,sum=0,rem=0,k=0,i=0,count=0,additional,padding;
    String str;
    num = number;
    while(num>0)
    { 
      rem=num%2;
      sum=sum+(int)(rem*Math.pow(10,k++));
      num=num/2;
    }
    
    while(k>=Math.pow(2,i))
    {
      i++;  
      count++;
    }
 
    additional=(int)Math.pow(2,count);
 
    padding=additional-k;
    //System.out.println(padding +" " + " Zeroes are to be added");
    
    str=String.valueOf(sum);

    for(int j=0;j<padding;j++)
      str=0+str;

    //System.out.println(str);

    int val=Integer.parseInt(str);
    while(val>0)
    {
      int result=val%10000;
     // System.out.println("Splitting in 4 bits\t" + result);
      val=val/10000;
      //System.out.println("Splitting in 4's of bits" + val);
    }
    return str;

}
  public static void genPrime(int l,int r)
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

  public static void convertTemperature(String unit, float temperature)
  {
    float result;
    if(unit.equalsIgnoreCase("C"))
    {
      result = (temperature * 9)/5 + 32;
      System.out.println("Temperature in Fahrenheit: "+result);
    }
    else if(unit.equalsIgnoreCase("F"))
    {
      result = (float)((temperature - 32) * (5/9)) + 32;
      System.out.println("Temperature in Celsius: "+result);
    }
    else{
      System.out.println("Invalid Input");
    }
  }

  public static int[] bubbleSort(int []arr, int n)
  {

        for(int i=0;i<n-1;i++)
          {
            for(int j=0;j<(n-1);j++)
            {
              if(arr[j]>arr[j+1])
              {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
              }
            }
          }


          return arr;

  }

  public static int binarySearch(int []arr,int l, int r, int value)
  {

    if(l <= r)
    {
      int mid = l + (r-1)/2;

      if( arr[mid] == value)
      {
        return mid;
      }
      else if( arr[mid] > value)
      {
        return binarySearch(arr,l,mid-1,value);
      }
      else //if( arr[mid] < value)
      {
        return binarySearch(arr,mid+1,r,value);
      }
    }
    return -1;

  }

  public static String[] bubbleSort(String []arr,int l)
  {
    for(int i=0;i<l-1;i++)
    {
      for(int j=0;j<l-1;j++)
      {
        if(arr[j].compareTo(arr[j+1]) > 0)
        {
          String temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }

    /*System.out.println(" ");

              for(int i=0;i<l;i++)
                System.out.println(""+arr[i]);
                */
    return arr;
  }

  public static int[] InsertionSort(int []arr, int n)
  {
    int j=0,key;
        for(int i=1;i<n;i++)
          {
            j=i-1;
            key=arr[i];
            while(j>=0 && arr[j] > key )
            {
              arr[j+1] = arr[j];
              j=j-1;
            }
            arr[j+1] = key;
          }
/*
          System.out.println("");
          for(int i=0;i<n;i++)
            System.out.println(""+arr[i]);
*/
            return arr;
  }

  public static long[] InsertionSort(long []arr, int n)
  {
    int j=0; long key;
        for(int i=1;i<n;i++)
          {
            j=i-1;
            key=arr[i];
            while(j>=0 && arr[j] > key )
            {
              arr[j+1] = arr[j];
              j=j-1;
            }
            arr[j+1] = key;
          }
  /*
          System.out.println("");
          for(int i=0;i<n;i++)
            System.out.println(""+arr[i]);
  */
            return arr;
  }
  public static String[] InsertionSort(String []str, int n)
  {
    int j=0;
    String key;
        for(int i=1;i<n;i++)
          {
            j=i-1;
            key=str[i];
            while(j>=0 && str[j].compareTo(key) > 0 )
            {
              str[j+1] = str[j];
              j=j-1;
            }
            str[j+1] = key;
          }

  /*        System.out.println("");
          for(int i=0;i<n;i++)
            System.out.println(""+str[i]);
*/
  return str;
  }

  public static int binarySearch(String []str,int l, int r, String value)
  {
    //System.out.println(l+""+r);
    if(l <= r)
    {
      int mid = l + (r-1)/2;

      if( str[mid].equalsIgnoreCase(value) )
      {
        return mid;
      }
      else if( str[mid].compareTo(value) > 0)
      {
        return binarySearch(str,l,mid-1,value);
      }
      else //if( arr[mid] < value)
      {
        return binarySearch(str,mid+1,r,value);
      }
    }
    return -1;

  }

  public static void calculateMonthlyPayment(double principal, double year, double rate)
  {
    double monthly = 0,r,n;

    r = rate/(12*100);
    n = 12*year;

    monthly = ( principal * r )    / ( 1 - (Math.pow(r+1,-n)));

    System.out.println("Monthly Payment = "+ monthly);
  }


}
