import java.util.*;
import java.lang.*;
class Queue
{

	Node front,rear;
	int size=0;
	static int StartDay;
	int NumberOfDays;
  boolean leap;

	class Node
	{
		int data;
		Node link;

	}

	public Queue()
	{
		front=null;
		rear=null;
	}

	public boolean isEmpty()
	{
		return (size == 0);
 	}

	public void enqueue(int data)
	{
		Node newNode= rear;
		rear=new Node();
		rear.data=data;
		rear.link=null;

		if(isEmpty())
		{
			front=rear;
		}
		else
		{
			newNode.link=rear;
		}

		size++;
	}

	public void dequeue()
	{
		int data=front.data;
		front=front.link;

		if(isEmpty())
		{
			rear=null;
		}

		size--;

		NumberOfDays=data;
	}

	public void isLeapYear(int year)
	{
		if((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0))
		{
			 leap=true;
		}
    else
			leap=false;

	}


	public static void dayOfMonth(int month, int day, int year)
	{
		int y = year - (14 - month) / 12;
  		int x = y + y/4 - y/100 + y/400;
       		int m = month + 12 * ((14 - month) / 12) - 2;
       		int d = (day + x + (31*m)/12) % 7;
      	 	StartDay=d;
   	}


	void print()
	{
		int totaldays = NumberOfDays;
		if(leap)
		{
			totaldays=totaldays+1;
		}

		for(int i=0;i<StartDay;i++)
		{
			System.out.print("   ");
		}

		for(int i=1;i<=totaldays;i++)
		{
			System.out.printf("%3d",i);

			if(((i+StartDay)%7==0) || (i==totaldays))
			{
				System.out.println();
			}
		}
	}


}

class CalendarQueue{
	public static void main(String args[])
	{

	Queue date=new Queue();

	date.enqueue(31);
	date.enqueue(28);
	date.enqueue(31);
	date.enqueue(30);
	date.enqueue(31);
	date.enqueue(30);
	date.enqueue(31);
	date.enqueue(31);
	date.enqueue(30);
	date.enqueue(31);
	date.enqueue(30);
	date.enqueue(31);

	Scanner sc=new Scanner(System.in);
	System.out.println("Enter month ");
	int month=sc.nextInt();

	System.out.println("Enter year ");
	int year=sc.nextInt();

	date.dayOfMonth(month,1,year);
	date.isLeapYear(year);

	System.out.println();
	System.out.println("  S  M  Tu W Th  F  S ");

	for(int j=0;j<month;j++)
	{
		date.dequeue();
	}

	date.print();

	}

}
