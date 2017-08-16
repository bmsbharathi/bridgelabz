import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.*;
class Regexx
{
  public static void main(String args[]){

    //Variable declaration
    String firstName[],contactNumber,fullName,nameMatcher,inputMessage,regexp = "\\d{10}",daate;
    Scanner read = new Scanner(System.in);
    inputMessage = "Hello <<name>>, We have your full " + "name as <<full name>> in our system. Your contact number is 91­xxxxxxxxxx. "
    + "Please, let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";
    nameMatcher = "<<name>>";
    boolean result,result2;

    //Getting User inputs
    System.out.println("\nEnter your full name");
    fullName = read.nextLine();
    firstName = fullName.split("\\s");

    System.out.println("\nEnter your Contact Number");
    contactNumber = read.next();

    //matching name
    result = Pattern.matches("\\D*",fullName);

    //matching Contact Number
    Pattern p = Pattern.compile(regexp);
    Matcher mat = p.matcher(contactNumber);
    result2 = mat.find();
    //validating Date
    Date date = new Date();
    SimpleDateFormat format;
    daate = new SimpleDateFormat("dd/MM/YYYY").format(date);

    if(!result2)
      System.out.println("\nInvalid Phone Number");

    if(!result)
        System.out.println("\nInvalid Name");

    //System.out.println(result + "  "+ result2);

        if(result2 && result)
        {
          System.out.println("\n"+inputMessage.replace(nameMatcher,firstName[0]).replace("<<full name>>",fullName).replace("xxxxxxxxxx",contactNumber).replace("01/01/2016",daate)+" Thank You!");
        }


  }
}
