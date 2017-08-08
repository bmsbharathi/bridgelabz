import java.util.*;
class TemperatureConversion
{
  public static void main(String args[])
  {
    String unit;
    float temperature;

    System.out.println("Enter the Temperature and unit (C for Celsius and F for Fahrenheit)");
    Scanner read = new Scanner(System.in);
    temperature = read.nextFloat();
    unit = read.next();

    //System.out.println(""+unit);

    TemperatureConversion tc = new TemperatureConversion();
    tc.convertTemperature(unit,temperature);

  }
  void convertTemperature(String unit, float temperature)
  {
    float result;
    if(unit.equalsIgnoreCase("C"))
    {
      result = (temperature * 9)/5 + 32;
      System.out.println("Temperature in Fahrenheit: "+result);
    }
    else if(unit.equalsIgnoreCase("F"))
    {
      result = (float)((temperature - 32) * ((float)5/9));
      System.out.println("Temperature in Celsius: "+result);
    }
    else{
      System.out.println("Invalid Input");
    }
  }


}
