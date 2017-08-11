import java.io.*;
import java.util.*;

interface Stack
{
  char pop();
  char peak();
  void push(char g);
  boolean isEmpty();
  int size();

}

class StackTest implements Stack
{
  Node head;
  int size;
  class Node
  {
    char data;
    Node link=null;
  }

  StackTest()
  {
      size = 0;
      head = null;
  }

  public char pop()
  {
    if(isEmpty())
    {
      System.out.println("Empty stack");
      return ' ';
      }
    else
    {
      char val = head.data;
      head = head.link;
      size--;
      return val;
    }
  }

  public void push(char value)
  {
    Node temp = head;
    head = new Node();
    head.data = value;
    head.link = temp;
    size++;
  }

  public char peak()
  {
    if(isEmpty())
    {
      System.out.println("Empty stack");
      return '0';
    }
    else{
      return head.data;
    }
  }

  public boolean isEmpty()
  {
    return (size == 0);
  }

  public int size()
  {
    return size;
  }

}

class StackTestDemo
{
  public static void main(String args[])
  {
    Scanner scan = new Scanner(System.in);
    StackTest s = new StackTest();
    String expression;
    int size;

    System.out.println("Enter the Arithmetic expression");
    expression = scan.next();

    char []exp = expression.toCharArray();
    size = expression.length();

    for(int i=0;i<size;i++)
    {
      if(exp[i] == '(' )
        s.push(exp[i]);
      if(exp[i] == ')')
        s.pop();
    }
    if(s.isEmpty())
    {
      System.out.println("\n\t\tGiven expression is balanced");
    }
    else
    {
      System.out.println("\n\t\tGiven expression is not balanced");
    }
  }
}
