import java.io.*;
import java.util.*;

class Node
{
  Node link;
  int data;

  Node(int val)
  {
    data = val;
    link = null;
  }
}
class HashChaining
{
  Node []table;
  int size;

  HashChaining(int tablesize)
  {
    table = new Node[tablesize];
    size = 0;
  }

  void insert(int val)
  {
    size++;
    int pos = myhash(val);
    Node newPtr = new Node(val);

    if(table[pos]==null)
    {
      table[pos] = newPtr;
    }
    else
    {
      newPtr.link = table[pos];
      table[pos] = newPtr;
    }
  }
  void remove(int val)
  {
    int pos = myhash(val);
    Node start = table[pos];
    Node temp = start;

    if(start.data == val)
    {
      size--;
      table[pos] = start.link;
      return;
    }
    while( temp.link!=null && temp.data !=val)
    {
      temp = temp.link;
    }
    if(temp.link == null)
    {
      System.out.println("Element not found");
      return;
    }
    size--;
    if(temp.link.link == null)
    {
      temp.link = null;
      }
    temp.link = temp.link.link;
    table[pos] = start;
  }

  int myhash(Integer key)
  {
    int hashVal = key.hashCode();

    hashVal %= 11;

    if(hashVal < 0)
      hashVal += 11;

      return hashVal;
  }

  void displayTable()
  {
    System.out.print("\nHashTable:\n");
    for(int i=0;i<table.length;i++)
    {
      System.out.print("\nPosition "+i+":\t");
      Node temp = table[i];
      while( temp != null)
      {
        System.out.print(temp.data+" ");
        temp = temp.link;
      }
    }
  System.out.println("");
  }

  void updateFile(File file)
  {
    FileOutputStream fos = null;

    try{
      fos = new FileOutputStream(file);

    for(int i=0;i<table.length;i++)
    {

      Node temp = table[i];
      while( temp != null)
      {
        byte b[] = String.valueOf(temp.data).getBytes();
        fos.write(b);
        fos.write(' ');
        temp = temp.link;
      }

    }
      fos.close();
  }
  catch(IOException e)
  {
    System.out.println(e);
  }

  }
  int search(int key)
  {
    int flag =0;

    for(int i=0;i<table.length;i++)
    {
      Node temp = table[i];

      while( temp != null)
      {
        if(temp.data == key)
        {
          flag =1;
        }
        temp = temp.link;
      }


  }
  return flag;
  }
}
class HashingTest
{
  public static void main(String args[]) throws FileNotFoundException
  {
    File fileOne = new File("bharathi.txt");
    Scanner scan = new Scanner(fileOne);
    Scanner read = new Scanner(System.in);
    scan.useDelimiter(" ");
    int temp,i=0,flag;

    HashChaining HC = new HashChaining(11);

     try{
     while( scan.hasNext() )
     {
       temp = scan.nextInt();
       HC.insert(temp);
      }


     }
     catch(InputMismatchException d)
     {
       //System.out.println(d);
     }
     HC.displayTable();

     System.out.println("\nEnter the value to search");
     temp = read.nextInt();
     flag = HC.search(temp);

    if(flag == 0)
    {
      System.out.println("\n"+temp+" not found in file");
      System.out.println("Added to Hash table");
      HC.insert(temp);
      HC.displayTable();
    }
    else{
      System.out.println("\n"+temp+" found in file");
      System.out.println("Removed from Hash table");
      HC.remove(temp);
      HC.displayTable();

    }
    HC.updateFile(fileOne);
  }
}
