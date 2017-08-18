import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class StockAccount{

  File fName = null;
  FileWriter fwriter;
  JSONObject jobj;
  JSONArray jarray;
  JSONParser jparser = new JSONParser();;

  StockAccount(String fileName)
  {
    try{
      fName = new File(fileName);
      jobj = (JSONObject) jparser.parse(new FileReader(fName));

      }
    catch(Exception e){
      System.out.println(e);
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
    jarray = (JSONArray)jobj.get("Stocks");

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
        flag =0;
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


    void sellStock(String stockSymbol, long amount)
    {
        jarray = (JSONArray)jobj.get("Stocks");
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

      fwriter = new FileWriter(fName);
      fwriter.write(jobj.toJSONString());


      fwriter.flush();
      fwriter.close();
      }
    catch(Exception e){
      System.out.println(e);
    }
  }

  public static void main(String args[]){

    StockAccount tempTest = new StockAccount("stock.json");
    Scanner scan = new Scanner(System.in);
    char choice;
    String symbol;
    long amount;

do {

    System.out.println("\nEnter your choice:\nB: buy, S:sell, W:save, R:Report, Q: Quit");
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
