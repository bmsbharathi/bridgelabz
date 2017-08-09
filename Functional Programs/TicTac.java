import java.util.*;
import java.lang.*;
import java.io.*;

class TicTac
{
    public static void main(String args[])
    {
        Scanner scan =new Scanner(System.in);

        int row,col;
        int count=0;
        char a[][]=new char[3][3];
        char pos='x';
        TicTac t1=new TicTac();

        t1.initializeboard(a);
        boolean b1=false;
        while(count<9)
        {
       	System.out.println("Player "+pos+": Enter the row and col you want to enter");											//pos='x';
		    row=scan.nextInt();
        col=scan.nextInt();
        int flag=t1.placemark(a,row,col,pos);

      	if(flag==0)
      		{
            count--;
      		}
        if (flag ==-1) {
            count--;
            System.out.println("\nEnter a valid input");
          }
        b1=t1.checkForWin(a);

    		if(b1==true)
    		{
    			t1.printtable(a);
    			System.out.println("Player" + " " + pos + " has won the game");
    			break;
    		}

        pos=t1.changeplayer(pos);
        t1.printtable(a);
        count++;
        }

        /*b1=t1.checkForWin(a);
        if (count ==9 && !b1)
          System.out.println("Draw!");
        */
    }


    static void initializeboard(char a[][])
    {

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                {
                a[i][j]= '-' ;

                }
        }
    }

    static void printtable(char a[][])
    {
       System.out.println("\n \n-------------------------------------------------");
        for(int i=0;i<3;i++)
        {
            System.out.print("|\t" );
            for(int j=0;j<3;j++)
            {
                System.out.print(a[i][j]+"\t|\t");
            }

            System.out.println("\n \n-------------------------------------------------");
        }
    }

    static int placemark(char a[][],int row,int col,char pos)
    {
    	if((row>=0)&&(row<3))
    	{
    		if((col>=0)&&(col<3))
    		{
    			if(a[row][col]=='-')
    			{
    				a[row][col]=pos;
    				return 1;
    				//checkwin(a);
    			}
    			else
    			{
    				System.out.println("Already inserted in that position. Please choose another position");
    				return 0;
    			}
    		}
    	}
    	return -1;
    }

    static char changeplayer(char pos)
    {
    	if(pos=='x')
    	{
    		pos='o';
    		return pos;
    	}
    	else if(pos=='o')
    	{
    		pos='x';
    		return pos;
    	}
    	return pos;
    }


public boolean checkForWin(char a[][]) {
        return (checkRowsForWin(a) || checkColumnsForWin(a) || checkDiagonalsForWin(a));
    }



    public boolean checkRowsForWin(char a[][]) {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(a[i][0], a[i][1], a[i][2]) == true) {
                return true;
            }
        }
        return false;
    }



    public boolean checkColumnsForWin(char a[][]) {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(a[0][i], a[1][i], a[2][i]) == true) {
                return true;
            }
        }
        return false;
    }



    public boolean checkDiagonalsForWin(char a[][]) {
        return ((checkRowCol(a[0][0], a[1][1], a[2][2]) == true) || (checkRowCol(a[0][2], a[1][1], a[2][0]) == true));
    }



    public boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
}
}
