package JSON;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;


class Inventory
{
  public static void main(String arg[]) throws IOException
  {
    JSONParser parser = new JSONParser();
    int amount=0;
    String name;
    long qty,price;


    try{
      JSONObject jobj = (JSONObject) parser.parse(new FileReader("Inventory.json"));
      JSONArray jArray = (JSONArray)jobj.get("Inventory");

      for(Object obj:jArray)
      {
        JSONObject type  = (JSONObject)(obj);
        name = (String) type.get("Name");
        System.out.println("\nName:"+name);

        qty = (long)type.get("Weight");
        System.out.println("Weight:"+qty);

        price = (long)type.get("Price per Kg");
        System.out.println("Price:"+price);
        long val =qty*price;
        amount += qty*price;
        System.out.println("Cost for "+qty+" kgs is "+val);
      }
      System.out.println("\nTotal cost "+amount);



    }
    catch(Exception e)
    {
      System.out.println(e);
    }

  }
}
