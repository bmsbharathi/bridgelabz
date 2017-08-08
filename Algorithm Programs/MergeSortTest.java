import java.io.*;
import java.util.*;

class MergeSortTest
{
  public static void main(String args[])
  {
    Scanner read = new Scanner(System.in);
    int len,i;

    System.out.println("Enter the number of Strings");
    len = read.nextInt();

    String arr[] = new String[len];

    System.out.println("Enter the String values");

    for(i=0;i<len;i++)
      arr[i] = read.next();


      MergeSortTest mst = new MergeSortTest();

      mergeSort(arr,0,len-1);

      System.out.println("\n");

      for(i=0;i<len;i++)
        System.out.println(arr[i]);



  }

  static void mergeSort(String arr[],int l,int r){

    if( l < r )
    {
      int m = (r+l)/2;

      mergeSort(arr,l,m);
      mergeSort(arr,m+1,r);

      merge(arr,l,m,r);
    }


  }

  static void merge(String arr[],int l,int m,int r)
  {
    int i,j,k,n1,n2;


    n1 = m-l+1;
    n2 = r-m;

    String []L = new String[n1];
    String []R = new String[n2];


      for(i=0;i<n1;i++)
        L[i] = arr[l+i];

      for(j=0;j<n2;j++)
        R[j] = arr[m+1+j];

    i=0;j=0;k=l;

    while(i < n1 && j < n2)
    {
        if( L[i].compareTo(R[i]) < 0 )
        {
          arr[k] = L[i];
          i++;
        }
        else
        {
          arr[k] = R[j];
          j++;
        }
        k++;
      }
        while(i < n1)
        {
          arr[k] = L[i];
          i++;
          k++;
        }
        while(j < n2)
        {
          arr[k] = R[j];
          j++;
          k++;

        }

    }
  }
