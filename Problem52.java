/*
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits,
but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

SOLVED
*/
class Problem52
{
  public static void main(String[] args)
  {
    //test
    boolean found = false;
    int num = 1;

    while(!found)
    {
      if(isEqual(num))
      {
        found = true;
      } else {
        num++;
      }
    }

    System.out.println(num);

  }

  public static boolean isEqual(int num)
  {
    String num1 = mergeSort(num + "");
    String num2 = mergeSort((num * 2) + "");
    String num3 = mergeSort((num * 3) + "");
    String num4 = mergeSort((num * 4) + "");
    String num5 = mergeSort((num * 5) + "");
    String num6 = mergeSort((num * 6) + "");

    return num1.equals(num2) && num1.equals(num3) && num1.equals(num4) &&
    num1.equals(num5) && num1.equals(num6);
  }

  private static String mergeSort(String str)
  {
    if(str.length() <= 1) return str;

    return mergeStrings(mergeSort(str.substring(0, str.length()/2)), mergeSort(str.substring(str.length()/2)));
  }

  private static String mergeStrings(String str1, String str2)
  {
    String result = "";
    int i = 0;
    int j = 0;
    while(i < str1.length() && j < str2.length())
    {
      if(Character.getNumericValue(str1.charAt(i)) < Character.getNumericValue(str2.charAt(j)))
      {
        result = result + str1.charAt(i);
        i++;
      } else {
        result = result + str2.charAt(j);
        j++;
      }
    }
    if(i < str1.length())
    {
      result = result + str1.substring(i);
    }
    if(j < str2.length())
    {
      result = result + str2.substring(j);
    }
    return result;
  }
}
