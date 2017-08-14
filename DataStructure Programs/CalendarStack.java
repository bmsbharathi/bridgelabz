import java.util.*;
import java.lang.*;
class Stack
{

	Stack stack1,stack2;
	static int StartDay;
	boolean leap;
	int NumberOfDays;
	static int day;
	static Node head;

	static class Node
	{
		int data;
		Node next;
		Node(int val)
		{
			data = val;
			next = null;
		}
	}

	public static void push(int new_data)
	{
		Node new_node= new Node(new_data);
		new_node.next=head;
		head=new_node;
	}

	public static  int pop()
	{
		Node temp=head,prev=null;

		if(temp!=null)
		{
		day = temp.data;
		head = temp.next;

		}
	return day;

	}

	public void printList()
	{
		Node temp=head;
		if(temp==null)
		{
			System.out.println("stack is empty ");

		}
		while(temp != null)
		{
		System.out.print("stack is not empty and data in stack is : "+temp.data+"  ");

		temp=temp.next;

		}


	}

	public void enqueue(int data)
	{

		stack1.push(data);
	}

	public void dequeue()
	{


		stack2.push(stack1.pop());
		NumberOfDays=stack2.pop();

	}


	public void isLeapYear(int year)
	{
		if((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0))
		{
			 leap = true;
		}
       	else
			leap = false;

	}


	public static void dayStart(int month, int day, int year)
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

class CalendarStack{
	public static void main(String args[])
	{


	Stack date=new Stack();

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

	date.dayStart(month,1,year);
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
