class Calendar
{
  public static void main(String args[])
  {
    int m,d,y;

    m=Integer.parseInt(args[1]);
    d=Integer.parseInt(args[0]);
    y=Integer.parseInt(args[2]);

    Calendar c = new Calendar();
    c.dayOfWeek(d,m,y);
  }
  void dayOfWeek(int day,int month,int year)
  {
    int d,x,m,y;

    y = year - (14 - month)/12;
    x = y - y/4 - y/100 + y/400;
    m = month + 12 * (( 14 - month)/12) - 2;
    d = (day + x + (31*m)/12)%7;

    System.out.println(" "+d);

    switch (d) {
      case 1:
       System.out.println("It is a Monday "+d);
       break;
       case 2:
       System.out.println("It is a Tuesday ");
       break;
       case 3:
       System.out.println("It is a Wednesday ");
       break;
       case 4:
       System.out.println("It is a Thursday ");
       break;
       case 5:
       System.out.println("It is a Friday ");
       break;
       case 6:
       System.out.println("It is a Satday ");
       break;
       case 0:
       System.out.println("It is a Sunday");
       break;

    }
  }

}
