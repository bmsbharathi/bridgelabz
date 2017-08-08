import java.io.*;
import java.util.*;

class UtilTest
{
  public static void main(String args[])
  {
    char command;

    //ArrayList<Long> timings = new ArrayList<Long>();
    TreeMap <Long, String> timings = new TreeMap<Long, String>();

    int lenInt, lenString;
    Scanner read = new Scanner(System.in);


    System.out.println("Enter the no of elements in the Integer array");
    lenInt = read.nextInt();
    int []arr = new int[lenInt];

    System.out.println("Enter the elements of Integer array");
    for(int i=0;i<lenInt;i++)
      arr[i] = read.nextInt();

    System.out.println("Enter the no of elements in the String array");
    lenString = read.nextInt();
    String []str = new String[lenString];

    System.out.println("Enter the elements of String array");

    for(int i=0;i<lenString;i++)
      str[i] = read.next();

      int count=0;
    do {

        long start,end;

          System.out.println("\nEnter your choice\n 1.BubbleSort (int) 2.BubbleSort (String) 3.InsertionSort (int) 4.InsertionSort (String) 5.Binary Search (int) 6.Binary Search (String) Q.Quit");
          command = read.next().charAt(0);

      switch(command)
      {
        case 'Q':
        System.out.println("\nThank You");
        break;
        case 'q':
        System.out.println("\nThank You");
        break;
        case '1':

        start = System.nanoTime();
        arr = Utility.bubbleSort(arr,lenInt);
        System.out.println("Sorted array: \n");
        end = System.nanoTime();

        for(int i = 0;i<lenInt;i++)
          System.out.println(arr[i]);

        System.out.println("\nElapsed Time "+(double)(end-start)/1000000+" NanoSeconds");

        timings.put((end-start),"BubbleSort (Int)");
        //timings.add(end-start);
        count++;

        break;

        case '2':

          start = System.nanoTime();
          str = Utility.bubbleSort(str,lenString);
          System.out.println("Sorted array :\n");
          end = System.nanoTime();

          for(int i = 0;i<lenString;i++)
            System.out.println(str[i]);

          System.out.println("\nElapsed Time "+(double)(end-start)/1000000+" Milli Seconds\n");

          timings.put((end-start),"BubbleSort (String)");
                  count++;

          break;

        case '3':

        start = System.nanoTime();
        arr = Utility.InsertionSort(arr,lenInt);
        System.out.println("Sorted array :\n");
        end = System.nanoTime();

        for(int i = 0;i<lenInt;i++)
          System.out.println(arr[i]);

        System.out.println("\nElapsed Time "+(double)(end-start)/1000000+" Milli Seconds\n");

        timings.put((end-start),"InsertionSort (Int)");
        count++;

        break;
        case '4':

          start = System.nanoTime();
          str = Utility.InsertionSort(str,lenString);
          System.out.println("Sorted array :\n");
          end = System.nanoTime();

          for(int i = 0;i<lenString;i++)
            System.out.println(str[i]);

          System.out.println("\nElapsed Time "+(double)(end-start)/1000000+" Milli Seconds\n");

          timings.put((end-start),"InsertionSort (String)");
          count++;

        break;

        case '5':
        System.out.println("\nEnter the element to be searched ");
        int Key = read.nextInt();

        start = System.nanoTime();
        arr = Utility.InsertionSort(arr,lenInt);
        int result = Utility.binarySearch(arr,0,lenInt,Key);

        if(result == -1)
          System.out.println("\n"+Key + " not found in the array");
        else
          System.out.println("\n"+Key + " found in the array at position"+(result+1));

        end = System.nanoTime();
        System.out.println("\nElapsed Time "+(double)(end-start)/1000000+" Milli Seconds\n");

        timings.put((end-start),"BinarySearch (Int)");
        count++;

        break;

        case '6':

        System.out.println("\nEnter the String to be searched ");
        String value = read.next();

        start = System.nanoTime();
        str = Utility.InsertionSort(str,lenString);
        result = Utility.binarySearch(str,0,lenString,value);

        if(result == -1)
          System.out.println("\n"+value + " not found in the array");
        else
          System.out.println("\n"+value+ " found in the array at position "+(result+1));

        end = System.nanoTime();

        System.out.println("\nElapsed Time "+(double)(end-start)/1000000+" Milli Seconds\n");

        timings.put((end-start),"BinarySearch (String)");
        count++;

        break;

        default:
          System.out.println("\nInvalid Input");


      }



    } while(command !='q');

    System.out.println("\nOrder of elapsed timing in Nano Seconds"+":");

    NavigableMap nmap=timings.descendingMap();

    Set set = nmap.entrySet();

    Iterator it = set.iterator();

      while(it.hasNext()) {
      Map.Entry me = (Map.Entry)it.next();
      System.out.print(me.getValue()+"\t");
      System.out.print(me.getKey()+"\n");


}

/*
    int siz = timings.size();
    int i=0;

    long ar[]= new long[siz];



    while(itr.hasNext()){

      ar[i] = (long)itr.next();
      i++;
  }

  ar = Utility.InsertionSort(ar,siz);

  for(i = 0;i<siz;i++)
    System.out.print(ar[i]+"\t");
*/


  }
}
