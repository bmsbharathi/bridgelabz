import java.util.*;

class StackNode
{
  int data;
  StackNode link;

  StackNode(int val)
  {
    data = val;
    link = null;
  }
}
class StackOperator
{

  StackNode head;
  int stackSize;

  StackOperator()
  {

    head = null;
    stackSize = 0;

  }

  void push(int val)
  {
    StackNode newNode = new StackNode(val);
    newNode.link = head;
    head = newNode;
    stackSize++;
  }
  StackNode pop()
  {
    if(head == null)
      return null;
    StackNode temp = head;
    head = head.link;

    return temp;
  }

  void displayStack()
  {
    if(stackSize == 0)
      {
        System.out.println("Empty Stack");
        return ;
      }
    StackNode temp = head;

    while(temp != null)
    {
      System.out.println(temp.data);
      temp = temp.link;
    }
  }

  int searchQueue(int val)
  {
    StackNode temp = head;

    if(temp.data == val)
      {
        //System.out.println(val+" is an Anagram");
        return 1;
      }
    while(temp.link != null && temp.data != val)
    {
      temp = temp.link;
    }
    if(temp.data == val)
      {
        //System.out.println(val+" is an Anagram");
        return 1;
      }
    return 0;
  }
}

class PrimeQueue
{

  public static void findPrime(int low, int high, StackOperator QO){
    int i,flag=0;

    for (i=low+2;i<=high;i++ ) {
      for(int j=2;j<i;j++)
      {

        if( i % j == 0 )
        {
          flag = 1;
          break;
        }
      }
      if( flag == 0 )
        QO.push(i);
      flag = 0;
    }
  }

  public static void findAnagrams(StackOperator QO)
  {
    int arr[] = new int[QO.stackSize],i=0;
    int brr[] = new int[QO.stackSize];

    StackNode temp = QO.head;

    System.out.println("\nAnagrams are ");

    while(temp !=null )
    {
      arr[i] = temp.data;
      temp = temp.link;
      //System.out.println(""+arr[i]+"");
      i++;
    }
  //System.out.println("STACKSIZE:"+QO.stackSize+"");
  int count = 0;
    for(i=0;i<QO.stackSize;i++){

      String key = String.valueOf(arr[i]);
      char val[] = key.toCharArray();
      Arrays.sort(val);
      key = String.valueOf(val);
      int num = Integer.parseInt(key);
      brr[i] = num;
      count++;
    //  System.out.println(arr[i]+"   "+brr[i]);

    }
  //System.out.println(""+count+"");
  for(i=0;i<QO.stackSize;i++)
  {
    for(int j=i+1;j<QO.stackSize;j++)
    {
      if(brr[i]==brr[j])
      {
        System.out.println(arr[i]+"---"+arr[j]);

        // QO.push(arr[i]);
        // QO.push(arr[j]);

        //flag = 1;
      }
    }
  }
}

  public static void main(String args[])
  {
    int arr[] = new int[100],low=0,high=200;
    StackOperator QO = new StackOperator();

    System.out.println("\nPrime numbers between "+high+" and "+low+" are ");
    findPrime(low,high,QO);
    QO.displayStack();
    findAnagrams(QO);

    //QO.displayStack();

  }
}
