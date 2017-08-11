import java.util.Scanner;

class QueueNode
{
  protected QueueNode link;
  protected int data;

  QueueNode()
  {
    link = null;

  }

  QueueNode(int val)
    {

      data = val;
    }

}

class QueueTest
{
  private int size;
  private QueueNode front,rear;
  QueueTest(){
    front = null;
    rear = null;
    size = 0;
  }
  boolean isEmpty()
  {
    return (size == 1);
  }

  void enqueue(int val)
  {
    QueueNode temp = new QueueNode(val);
    size++;
    if( rear == null )
    {
      rear = front = temp;
      return ;
    }
    rear.link = temp;
    rear = temp;
  }

  QueueNode dequeue()
  {
    if(front == null)
      return null;

    QueueNode temp = front;
    front = front.link;

    if(front == null)
      rear = null;

    return temp;
  }

  QueueNode peak()
  {
    if(front == null)
      return null;

    QueueNode temp = front;

    if(front == null)
      rear = null;

    return temp;
  }



}
class QueueDemo
{
  public static void main(String args[])
  {
    QueueTest Q = new QueueTest();
    int noOfPeople;
    float amountInBank,amount;
    Scanner scan = new Scanner(System.in);
    String choice="";

    System.out.println("Enter the no of people in the queue and initial amount in the bank");
    noOfPeople = scan.nextInt();
    amountInBank = scan.nextInt();
    amount=0;
    for(int i=1;i<=noOfPeople;i++)
      Q.enqueue(i);

      System.out.println("\nCustomer "+Q.peak().data + " performing Transaction");
      System.out.println("Enter the transaction you want to perform: W--> Withdrawl, D-->Deposit, Q--> Quit from Queue");
      choice = scan.next();


    do{


      switch(choice.charAt(0))
      {

        case 'W':

        System.out.println("Enter the amount to withdraw");
        amount = scan.nextFloat();
        if(amountInBank < amount)
          System.out.println("Not Enoudh cash in bank..Sorry\n");
        else
          {
            amountInBank -= amount;
            System.out.println("Transaction completed");
            System.out.println("Cash available in bank "+amountInBank+"\n");
          }
        Q.dequeue();

        break;

        case 'D':

        System.out.println("Enter the amount to Deposit");
        amount = scan.nextFloat();
        amountInBank += amount;
        System.out.println("Transaction completed");
        System.out.println("Cash available in bank "+amountInBank+"\n");
        Q.dequeue();
        break;

        case 'Q':
        Q.dequeue();
        break;
      }

      noOfPeople--;
      if(noOfPeople > 0){
      System.out.println("\nCustomer "+Q.peak().data + " is performing Transaction");
      System.out.println("Enter the transaction you want to perform: W--> Withdrawl, D-->Deposit, Q--> Quit from Queue");
      choice = scan.next();
      }
      else{
        break;
      }


  }while(noOfPeople !=0);

      }
}
