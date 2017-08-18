package JSON;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;


class StockInventory
{
  public static void main(String arg[]) throws IOException
  {
    JSONParser parser = new JSONParser();
    int amount=0;
    String name;
    long qty;
    double price;


    try{
      JSONObject jobj = (JSONObject) parser.parse(new FileReader("Stock.json"));
      JSONArray jArray = (JSONArray)jobj.get("Stock");

      for(Object obj:jArray)
      {
        JSONObject type  = (JSONObject)(obj);
        name = (String) type.get("Stock Name");
        System.out.println("\nStock Name:"+name);

        qty = (long)type.get("No of Stocks");
        System.out.println("No of Stocks:"+qty);

        price = (double)type.get("Share Price");
        System.out.println("Share Price:"+price);
        double val =qty*price;
        amount += qty*price;
        System.out.println("Cost for "+qty+" Stocks of "+name+" is Rs."+val);
      }
      System.out.println("\nTotal cost Rs."+amount);



    }
    catch(Exception e)
    {
      System.out.println(e);
    }

  }
}
