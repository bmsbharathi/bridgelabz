import java.lang.*;
import java.io.*;
import java.util.*;
class Anagram
{
  public static void main(String args[])
  {
      String input1, input2;

      System.out.println("Enter the Strings: ");
      Scanner inp = new Scanner(System.in);
      input1 = inp.next();
      input2 = inp.next();

      Anagram a = new Anagram();
      a.checkAnagram(input1,input2);
}      //System.out.println(input1 + input2);
void checkAnagram(String input1, String input2)
{
  String s1,s2;
      char []temp = input1.toCharArray();
      char []temp2 = input2.toCharArray();

      //System.out.println(temp + "" + temp2);

      Arrays.sort(temp);
      Arrays.sort(temp2);

      //System.out.println(temp + "" + temp2);

      s1 = String.valueOf(temp);
      s2 = String.valueOf(temp2);

      if(s1.equals(s2))
      {
        System.out.println(input1+" and "+input2+" are Anagrams");
      }
      else
      {
        System.out.println(input1+" and "+input2+" are not Anagrams");
      }

  }
}

/*
  void checkAnagram(String input1, String input2)
  {

    computePermutations(input1,0,input1.length(),input2);

  }

  boolean computePermutations(String input1,int l, int r, String input2)
  {
    int i;
    if(l==r)
    {
      input1.equals(input2);
      System.out.println(input1);
      return true;
    }
    for( i=l; i<=r; i++)
    {
      input1 = swap(input1,l,i);
      computePermutations(input1,l+1,i,input2);
      input1 = swap(input1,l,i);
    }
    return false;
  }
  String swap(String input1,int i,int j)
  {
    char []charArray;
    char temp;

    charArray = input1.toCharArray();

    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;

    return String.valueOf(charArray);

  }

}
*/
