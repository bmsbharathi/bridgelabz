import java.io.*;
import java.util.*;

class Node{

  char data;
  Node link;

  Node()
  {
    data = ' ';
    link = null;
  }
  Node(char c, Node l)
  {
    data = c;
    link = l;
  }
  void setLink(Node l)
  {
    link = l;
  }
  void setData(char val)
  {
    data = val;
  }
  Node getLink()
  {
    return link;
  }
  char getData()
  {
    return data;
  }

}
class DequeTest
{
  int size;
  Node rear,front;

  DequeTest()
  {
    size = 0;
    front = null;
    rear = null;
  }

  boolean isEmpty()
  {
    return (size == 0);
  }

  void insertAtFront(char val)
  {
    Node newPtr = new Node(val,null);
    size++;

    if( front == null)
    {
      front = newPtr;
      rear = front;
    }
    else
    {
      newPtr.setLink(front);
      front = newPtr;
    }

  }

  void insertAtRear(char val)
  {
    Node newPtr = new Node(val,null);
    size++;

    if(rear == null)
    {
      rear = newPtr;
      front = newPtr;
    }
    else
    {
      rear.setLink(newPtr);
      rear = newPtr;
    }
  }

  char removeAtFront()
  {
    if(isEmpty())
    {
      System.out.println("Empty Deque");
      throw new NoSuchElementException("");
    }
    Node temp = front;
    front = front.getLink();
    char data1 = temp.getData();
    if(front == null)
    {
      rear = null;
    }
    size--;

    return data1;
  }

  char removeAtRear()
  {
    if(isEmpty())
    {
      System.out.println("Empty Deque");
      throw new NoSuchElementException("");
    }

    char data1 = rear.getData();
    Node temp,temp1;

    temp1 = temp = front;

    while(temp!=rear)
    {
      temp1 = temp;
      temp = temp.getLink();
    }
    rear = temp1;

    rear.setLink(null);

    size--;
    return data1;
  }

  void display()
  {
    if(isEmpty())
    {
      System.out.println("Empty Deque");
      return ;
    }
    Node temp = front;

    while( temp!= null )
    {
      System.out.print(temp.getData()+"\t");
      temp = temp.getLink();
    }
    System.out.println();
  }

}
class DequeDemo
{
  public static void main(String args[])
  {
    DequeTest DQ = new DequeTest();
    Scanner scan = new Scanner(System.in);
    String word,revv;

    System.out.println("Enter a word");
    word = scan.next();

    char wordChar[] = word.toCharArray();

    for(int i=0;i<word.length();i++)
      DQ.insertAtRear(wordChar[i]);

    System.out.println("");
  //  DQ.display();


    int flag = 0;
    int mid = (DQ.size-1)/2;

    for(int i=0;i<mid;i++)
    {
      if(DQ.front.getData() == DQ.rear.getData())
      {
        DQ.removeAtRear();
        DQ.removeAtFront();
        flag++;
      }

    }
    
    //DQ.display();
    if( flag == mid )
    {
      System.out.println("It is a palindrome");
    }
    else
    {
      System.out.println("It is not a palindrome");
    }


  }

}
