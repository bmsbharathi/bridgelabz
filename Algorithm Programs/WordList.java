import java.io.*;
import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;
class WordList
{
  public static void main(String args[])
  {
    String []str;
    int i,len;

    WordList wl = new WordList();

    wl.writeTofile();
    wl.searchFile();



  }

  void writeTofile()
  {
    Scanner read = new Scanner(System.in);
    int i;
    String str = new String();
    File file1 = new File("bmsbharathi.txt");
    System.out.println("Enter String");

    try{
      PrintWriter pw = new PrintWriter(file1);
      str = read.next();
      pw.print(str);

      /*for(i=0;i<len;i++)
      {
        str[i] = read.next();
        pw.println(str[i]);

        pw.flush();

      }*/
      pw.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e);
    }

  }

  void searchFile()
  {
    String key;
    Scanner read = new Scanner(System.in);
    ArrayList<String> str = new ArrayList<String>();

    System.out.println("Enter the word to search in File");
    key = read.next();

//    System.out.println("Contents of the File...\n");
    try{
      //FileReader fr = new FileReader("bmsbharathi.txt");
      //BufferedReader br = new BufferedReader(fr);
      File file1 = new File("bmsbharathi.txt");
      Scanner scan = new Scanner(file1).useDelimiter(",");



      while(scan.hasNext())
      {

        str.add(scan.next());


      }
    }
    catch(IOException e)
    {
      System.out.println(e);
    }



    String []str1 = str.toArray(new String[str.size()]);

    str1 = Utility.bubbleSort(str1,str1.length);

    int result = Utility.binarySearch(str1,0,str1.length,key);

    System.out.println("");
    if(result!=-1)
      System.out.println(key + " is found in the file");
    else
      System.out.println(key +" is not found in the file");

  }



}
