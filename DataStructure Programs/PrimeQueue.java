import java.util.*;

class QueueNode
{
  int data;
  QueueNode link;

  QueueNode(int val)
  {
    data = val;
    link = null;
  }
}
class QueueOperator
{
  QueueNode front,rear;
  int size;

  QueueOperator()
  {
    front = rear = null;
    size =0;
  }

  void enqueue(int val)
  {
    QueueNode newNode = new QueueNode(val);
    size++;

    if( rear == null)
    {
      front = rear = newNode;
      return;
    }

    rear.link = newNode;
    rear = newNode;
  }

  QueueNode dequeue()
  {
    if( front == null )
    {
        rear = null;
    }
    QueueNode temp = front;
    front = front.link;

    if(front == null)
      return null;

    return temp;
  }


  void display()
  {
    QueueNode temp = front;

    while(temp != null)
    {
      System.out.println(temp.data);
      temp = temp.link;
    }
  }

  int searchQueue(int val)
  {
    QueueNode temp = front;

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

  public static void findPrime(int low, int high, QueueOperator QO){
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
        QO.enqueue(i);
      flag = 0;
    }
  }

  public static void findAnagrams(QueueOperator QO)
  {
    int arr[] = new int[QO.size],i=0;
    int brr[] = new int[QO.size];

    QueueNode temp = QO.front;

    System.out.println("\nAnagrams are ");

    while(temp !=null )
    {
      arr[i] = temp.data;
      temp = temp.link;
      // System.out.println(""+arr[i]);
      i++;
    }

    for(i=0;i<QO.size;i++){

      String key = String.valueOf(arr[i]);
      char val[] = key.toCharArray();
      Arrays.sort(val);
      key = String.valueOf(val);
      int num = Integer.parseInt(key);
      brr[i] = num;
      //System.out.println(arr[i]+"   "+brr[i]);

    }

  for(i=0;i<QO.size;i++)
  {
    for(int j=i+1;j<QO.size;j++)
    {
      if(brr[i]==brr[j])
      {
        System.out.println(arr[i]+"---"+arr[j]);
        //flag = 1;
      }
    }
  }
}



  public static void main(String args[])
  {
    int arr[] = new int[100],low=0,high=200;
    QueueOperator QO = new QueueOperator();


    findPrime(low,high,QO);
    System.out.println("\nPrime numbers between "+low+" and "+high+"are ");
    QO.display();
    findAnagrams(QO);



  }
}
