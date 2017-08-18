package JSON;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class StackNode
{
  StackNode link;
}
class QueueNode {
  QueueNode link;
}
class ListNode
{
  ListNode link;
  String stockSymbol;
  long noOfStocks;
  double sharePrice;

  ListNode(String symbol, long stocks, double price)
  {
    link = null;
    stockSymbol = symbol;
    noOfStocks = stocks;
    sharePrice = price;
  }
}

class Operator
{
  int listSize,queueSize,stackSize;
  ListNode start,end;

  Operator()
  {
    listSize=0;
    queueSize=0;
    stackSize=0;
    start = null;
    end = null;
  }

  void addToList(Operator O)
  {

    JSONObject jsonobj;
    JSONArray jArray = null;
    JSONParser jparser = new JSONParser();;

    try{
      File fName = new File("JSON/StockManagement.json");

      jsonobj = (JSONObject) jparser.parse(new FileReader(fName));
      jArray = (JSONArray)jsonobj.get("Stocks");

    for(Object obj : jArray)
    {
      JSONObject type  = (JSONObject)(obj);

      String temp = (String)type.get("Stock Name");
      long noStocks = (long)type.get("No of Stocks");
      double price = (double)type.get("Share Price");

      O.insertAtEnd(temp,noStocks,price);
    }
  }

  catch(Exception e){
    System.out.println(e+"Hello3");
}
  }

  void insertAtEnd(String val,long no,double price)
    {

        ListNode nptr = new ListNode(val,no,price);
        listSize++ ;

        if(start == null)
        {

            start = nptr;
            end = start;

        }

        else
        {
            end.link = nptr;
            end = nptr;
        }

    }

    public void deleteValue(String key)
    {
      ListNode temp = start, prev = null;

        if (temp != null && temp.stockSymbol.equals(key))
        {
            start = temp.link; // Changed head
            return;
        }

        while (temp != null && !temp.stockSymbol.equals(key))
        {
            prev = temp;
            temp = temp.link;
        }

        if (temp == null)
          return;

        prev.link = temp.link;

        }

    public void displayList()

    {

        System.out.print("\nLinked List = ");

        if (listSize == 0)

        {

            System.out.print("empty\n");

            return;

        }

        if (start.link == null)

        {
            System.out.print(start.stockSymbol+ " --> ");// +" No of Shares: "+start.noOfStocks+" Price of Stock "+start.sharePrice+"");
            return;
        }

        ListNode ptr = start;
        System.out.print(start.stockSymbol+" --> ");//" No of Shares: "+start.noOfStocks+" Price of Stock "+start.sharePrice+ " --> ");
        ptr = start.link;
        while (ptr.link != null)

        {

            System.out.print(ptr.stockSymbol+" --> ");//" No of Shares: "+ptr.noOfStocks+" Price of Stock "+ptr.sharePrice+ " --> ");
            ptr = ptr.link;
        }

        System.out.print(ptr.stockSymbol);//" No of Shares: "+ptr.noOfStocks+" Price of Stock "+ptr.sharePrice+ "\n");

}



}

class StockManagement{

  FileWriter fwriter;
  JSONObject jobj = new JSONObject();
  JSONArray jarray;
  JSONParser jparser = new JSONParser();
  String fileName = "JSON/StockManagement.json";
  File  fName;

  StockManagement()
  {
    try{
      File  fName = new File(fileName);
      jobj = (JSONObject) jparser.parse(new FileReader(fName));
      jarray = (JSONArray)jobj.get("Stocks");
      fName = new File(fileName);
    }
    catch(Exception e)
    {
      System.out.println(e+"Hell");
    }
  }

  void display()
  {

    jarray = (JSONArray)jobj.get("Stocks");
    System.out.println("Stock Report----------------------------\n");

    for(Object obj : jarray)
    {
      JSONObject type  = (JSONObject)(obj);

      System.out.println("Stock Name: "+type.get("Stock Name"));
      System.out.println("No of Stocks: "+type.get("No of Stocks"));
      System.out.println("Share Price: Rs."+type.get("Share Price")+"\n");
    }
    System.out.println("-------------------------------------------\n");


  }

  void buyStock(String stockSymbol, long amount)
  {
    int flag =0;
    Scanner scan = new Scanner(System.in);

    try{

    for(Object obj : jarray)
    {

      JSONObject type  = (JSONObject)(obj);
      long intialShares = (long) type.get("No of Stocks");
      String symbol = (String) type.get("Stock Name");

      if(symbol.equals(stockSymbol))
      {
        intialShares = intialShares + amount;
        System.out.println("Stocks Remaining  "+stockSymbol+": "+intialShares);
        type.put("No of Stocks", intialShares);
        flag =1;
      }

    }
    if(flag == 0)
    {
      System.out.println("\nDetails Doesn't Exist...Adding New Stock");
      JSONObject type  = new JSONObject();

      System.out.println("Enter the price of a Share");
      long temp = scan.nextLong();

      type.put("Stock Name",stockSymbol);
      type.put("No of Stocks", amount);
      type.put("Share Price",temp);

      jarray.add(type);
    }
  }
  catch(Exception e)
  {
    System.out.println(e);
  }


  }


    void sellStock(String stockSymbol, long amount)
    {
      for(Object obj : jarray)
      {
        JSONObject type  = (JSONObject)(obj);
        long intialShares = (long) type.get("No of Stocks");
        String symbol = (String) type.get("Stock Name");

      if(symbol.equals(stockSymbol))
      {
        if(intialShares > amount){
          intialShares = intialShares - amount;
          System.out.println("Stocks Remaining  "+stockSymbol+": "+intialShares);
          type.put("No of Stocks", intialShares);
      }
      else
      {
        System.out.println("Not enough shares remaining.\n");
      }
      }

    }
  }

  void save()
  {
    try{

      fwriter = new FileWriter("JSON/StockManagement.json");
      fwriter.write(jobj.toJSONString());


      fwriter.flush();
      fwriter.close();
      }
    catch(Exception e){
      System.out.println(e+"Hello2");
    }
  }

  public static void main(String args[]){

    Scanner scan = new Scanner(System.in);
    char choice;
    String symbol;
    long amount;
    StockManagement tempTest = new StockManagement();
    Operator list = new Operator();
    list.addToList(list);
    list.displayList();

do {

    System.out.println("\n\nEnter your choice:\nB: buy, S:sell, W:save, R:Report, Q: Quit");
    choice = scan.next().charAt(0);
    System.out.println("");

      switch(choice)
      {
        case 'B':
        System.out.println("Enter which stock to Buy");
        symbol = scan.next();
        System.out.println("Enter the No of Stock to buy");
        amount = scan.nextLong();
        tempTest.buyStock(symbol,amount);
        break;

        case 'S':
        System.out.println("Enter which stock to sell");
        symbol = scan.next();
        System.out.println("Enter the No of Stock to sell");
        amount = scan.nextLong();
        tempTest.sellStock(symbol,amount);
        break;

        case 'W':
        tempTest.save();
        System.out.println("Saved Successfully!");
        break;

        case 'R':
        tempTest.display();
        break;

        case 'Q':
        System.out.println("Thank You!");
        break;
  }
  tempTest.save();
} while (choice != 'Q');

  }
}
