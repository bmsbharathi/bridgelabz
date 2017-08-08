import java.util.*;

class InsertionSort
{
  public static void main(String args[])
  {
    int n,l;
    Scanner read = new Scanner(System.in);
    System.out.println("Enter the number of elements");


    n = read.nextInt();
    int []arr = new int[n];

    for(int i=0;i<n;i++)
      arr[i]=read.nextInt();

    InsertionSort i = new InsertionSort();
    i.InsertionSort(arr,n);
  int len;
  System.out.println("Enter the no of Strings");
  len = read.nextInt();

  String []str = new String[len];

  System.out.println("Enter the Strings");
  for(int k=0;k < len; k++)
    str[k] = read.next();

  i.InsertionSort(str,len);

  }
  void InsertionSort(int []arr, int n)
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

          System.out.println("");
          for(int i=0;i<n;i++)
            System.out.println(""+arr[i]);

  }
  void InsertionSort(String []str, int n)
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

          System.out.println("");
          for(int i=0;i<n;i++)
            System.out.println(""+str[i]);

  }

}
