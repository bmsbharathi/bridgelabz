import java.util.*;

class BubbleSort
{
  public static void main(String args[])
  {
    int n,l;
    Scanner read = new Scanner(System.in);
    BubbleSort b = new BubbleSort();

    /*
    System.out.println("Enter the number of elements");

    n = read.nextInt();
    int []arr = new int[n];

    for(int i=0;i<n;i++)
      arr[i]=read.nextInt();

    //b.bubbleSort(arr,n);

    System.out.println("---------------");
*/
    System.out.println("Enter the no of Strings");
    l = read.nextInt();

    String []a = new String[l];

    for(int i=0;i<l;i++)
      a[i] = read.next();

      b.bubbleSort(a,l);


  }
  void bubbleSort(int []arr, int n)
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

          for(int i=0;i<n;i++)
          System.out.println(""+arr[i]);

  }
  void bubbleSort(String []arr,int l)
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
    System.out.println(" ");

              for(int i=0;i<l;i++)
                System.out.println(""+arr[i]);

  }
}
