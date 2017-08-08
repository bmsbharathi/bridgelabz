import java.lang.*;
import java.io.*;
import java.util.*;
class StopWatch
{
	public static void main(String args[])
	{
		String command;
		long v1=0,v2=0;
		System.out.println("Enter the Commands--- \n Start to start the Stop watch, \n Stop to stop the clock, \n End to end the program \n________________________________________________");

		Scanner inp = new Scanner(System.in);
		command = inp.next();
		do{ 
			if(command.equalsIgnoreCase("start"))
			{
				System.out.println("Clock started!");
				v1 = System.currentTimeMillis();
			}
			else if(command.equalsIgnoreCase("Stop"))
			{

				System.out.println("Clock stopped!\n\nElapsed Time is:");
				v2=System.currentTimeMillis();
				System.out.print(" "+(double)(v2-v1)/1000+" Seconds\n");
				
			}
			
			command = inp.next();

			if(command.equalsIgnoreCase("end"))
			{
				System.out.println("Thank You!");
			}

		}while(!command.equalsIgnoreCase("end"));
	}
}

/*import java.io.*;
import java.awt.*;
import javax.swing.*;
class StopWatch
{
	public static void main(String args[])
	{
		Watch obj = new Watch();

	}
}
class Watch extends Frame
{
	Watch()
	{
		Frame f = new Frame("StopWatch");
		Button start = new Button("Start the clock");
		Button stop = new Button("Stop the clock");
		Button elapse = new Button("Elapse");
		
		
		
		start.setBounds(50,50,50,50);
		stop.setBounds(80,150,50,50);
		elapse.setBounds(120,250,50,50);

		f.add(start);
		f.add(stop);
		f.add(elapse);



		setLayout(null);
		setVisible(true);
		setSize(400,400);
	}
}*/