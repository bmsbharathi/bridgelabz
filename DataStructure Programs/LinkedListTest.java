import java.util.Scanner;
import java.io.*;
import java.util.*;

class Node

{

    protected String data;

    protected Node link;

    public Node()

    {

        link = null;

        data = "";

    }


    public Node(String val,Node n)

    {

        data = val;

        link = n;

    }



    public void setLink(Node n)

    {

        link = n;

    }


    public void setData(String val)

    {

        data = val;

    }



    public Node getLink()

    {

        return link;

    }



    public String getData()

    {

        return data;

    }

}


class LinkedListTest

{

    protected Node start;

    protected Node end ;

    public int size ;


    public LinkedListTest()

    {

        start = null;

        end = null;

        size = 0;

    }

  
    public void insertAtEnd(String val)

    {

        Node nptr = new Node(val,null);

        size++ ;

        if(start == null)

        {

            start = nptr;

            end = start;

        }

        else

        {

            end.setLink(nptr);

            end = nptr;

        }

    }


    public void deleteValue(String key)

    {
      Node temp = start, prev = null;


        if (temp != null && temp.data.equals(key))
        {
            start = temp.getLink(); // Changed head
            return;
        }


        while (temp != null && !temp.data.equals(key))
        {
            prev = temp;
            temp = temp.getLink();
        }


        if (temp == null)
          return;


        prev.setLink(temp.getLink());

        }



    public void display()

    {

        System.out.print("\nLinked List = ");

        if (size == 0)

        {

            System.out.print("empty\n");

            return;

        }

        if (start.getLink() == null)

        {

            System.out.println(start.getData() );

            return;

        }

        Node ptr = start;

        System.out.print(start.getData()+ "->");

        ptr = start.getLink();

        while (ptr.getLink() != null)

        {

            System.out.print(ptr.getData()+ "->");

            ptr = ptr.getLink();

        }

        System.out.print(ptr.getData()+ "\n");

    }

    public void updateFile(File file1) throws IOException
    {
      FileOutputStream fos = new FileOutputStream(file1);
      Node temp=start;

      while(temp!=null)
      {
      byte b[] = temp.getData().getBytes();

      temp = temp.getLink();

      fos.write(b);
      fos.write(' ');
      }

      fos.close();
    }

    public int searchList(String key)
    {
      int flag = 0;
      Node temp = start;

      while(temp  != null)
      {
        if(temp.getData().equals(key))
        {
          flag =1;
        }
        temp = temp.getLink();
      }
      return flag;
    }

}


class SinglyLinkedList

{

    public static void main(String[] args) throws IOException

    {

        Scanner scan = new Scanner(System.in);
        String input,key;
        int size;
        LinkedListTest list = new LinkedListTest();
        ArrayList<String> arr = new ArrayList<String>();
        System.out.println("Enter the file name to write");
        input = scan.next();

        File fileName = new File(input);
        FileOutputStream fos = new FileOutputStream(fileName);

        System.out.println("\nEnter the Data to write");
        input = scan.next();

        byte b[] = input.getBytes();

        fos.write(b);
        fos.close();

        Scanner read = new Scanner(fileName);

        read.useDelimiter(",");

        while(read.hasNext())
        {
          String data = read.next();
          list.insertAtEnd(data);
        }
        list.display();

        System.out.println("\nEnter the string to search");
        key = scan.next();
        int flag = list.searchList(key);
        if(flag==1)
        {
          list.deleteValue(key);
          System.out.println("\n"+key+" found in file\nHence deleted from file");
          list.display();
        }
        else
        {
          list.insertAtEnd(key);
          System.out.println("\n"+key+" not found in file\nHence added to file");
          list.display();
        }
        list.updateFile(fileName);


    }

}
