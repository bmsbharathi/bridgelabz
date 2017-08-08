import java.util.*;
import java.io.*;

class BinarySearchh
{
  public static void main(String args[])
  {
    int len,value;
    System.out.println("Enter the no of elements");
    Scanner S = new Scanner(System.in);
    BinarySearchh bs = new BinarySearchh();


    len = S.nextInt();

    int []arr = new int[len];

    System.out.println("Enter the no of elements");

    for(int i=0;i<len;i++)
      arr[i] = S.nextInt();
    System.out.println("Enter the Element to be searched");
    value = S.nextInt();
    Arrays.sort(arr);

    System.out.println(" Element found at "+bs.binarySearch(arr,0,len-1,value)+" ");

  System.out.println("Enter the no of elements in the String array");

  len = S.nextInt();
  String search;
  String []str = new String[len];
  System.out.println("Enter the Strings");

  for(int s=0;s<len;s++)
    str[s] = S.next();

    System.out.println("Enter the element to be searched");
      search = S.next();



      //str = bs.bubbleSort(str,len);

  int result = bs.binarySearch(str,0,len, search);

  if(result == -1)
    System.out.println("Not found");
  else
    System.out.println("String found at "+(result+1));



  }


  int binarySearch(int []arr,int l, int r, int value)
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

  int binarySearch(String []str,int l, int r, String value)
  {

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



}
