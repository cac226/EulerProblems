//SOLVED
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
containing over five-thousand first names, begin by sorting it into alphabetical
order. Then working out the alphabetical value for each name, multiply this
value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is
worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would
obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
*/

class Problem22
{
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("/Users/caitlincampbell/Documents/FunCoding/p022_names.txt");
    Scanner in = new Scanner(file);
    String namesString = in.next();
    ArrayList<String> names = convertToList(namesString);
    names = mergeSort(names);
    System.out.println(getScore(names));
  }

  public static int getScore(ArrayList<String> list)
  {
    int result = 0;
    for(int i = 0; i < list.size(); i++)
    {
      result += (nameScore(list.get(i)) * (i + 1));
    }
    return result;
  }

  public static ArrayList<String> convertToList(String str)
  {
    ArrayList<String> list = new ArrayList<String>();

    int i = str.indexOf("\"");

    while(i + 1 < str.length() && i >= 0)
    {
      if(str.charAt(i + 1) != ',')
      {
        int j = i;
        i = str.indexOf("\"", i + 1);
        if(i > 0) {
            list.add(str.substring(j + 1, i));
        } else {
            list.add(str.substring(j + 1));
        }

      } else if(str.indexOf("\"", i + 1) < 0) {
        i = -1;
      } else {
        i = str.indexOf("\"", i + 1);
      }
    }

    return list;
  }

  public static int nameScore(String name)
  {
    int score = 0;
    for(int i = 0; i < name.length(); i++)
    {
      int val = (int) name.charAt(i);
      score += (val - 'A' + 1);
    }
    return score;
  }


    private static ArrayList<String> mergeSort(ArrayList<String> list)
    {
      if(list.size() <= 1) return list;

      ArrayList<String> firstHalf  = new ArrayList(list.subList(0, list.size()/2));
      ArrayList<String> secondHalf = new ArrayList(list.subList(list.size()/2, list.size()));
      return mergeLists(mergeSort(firstHalf), mergeSort(secondHalf));
    }

    private static ArrayList<String> mergeLists(ArrayList<String> list1, ArrayList<String> list2)
    {
      ArrayList<String> result = new ArrayList<String>();
      int i = 0;
      int j = 0;
      while(i < list1.size() && j < list2.size())
      {
        if(list1.get(i).compareTo(list2.get(j)) < 0)
        {
          result.add(list1.get(i));
          i++;
        } else {
          result.add(list2.get(j));
          j++;
        }
      }
      while(i < list1.size())
      {
        result.add(list1.get(i));
        i++;
      }
      while(j < list2.size())
      {
        result.add(list2.get(j));
        j++;
      }
      return result;
    }
}
