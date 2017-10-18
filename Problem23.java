/*
IN PROGRESS

A perfect number is a number for which the sum of its proper divisors is exactly
 equal to the number. For example, the sum of the proper divisors of 28
 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than
n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
number that can be written as the sum of two abundant numbers is 24.
By mathematical analysis, it can be shown that all integers greater than 28123
can be written as the sum of two abundant numbers.

Find the sum of all the positive integers which cannot be written as the sum
of two abundant numbers.
*/
import java.util.ArrayList;

class Problem23
{
  private static final int MAXNUMBUER = 28123;

  public static void main(String[] args) {
    int result = 0;
    ArrayList<Integer> abundantNums = abundantNumbers(MAXNUMBUER);

    ArrayList<Integer> list = new ArrayList<Integer>();
    /*for(int i = 1; i <= MAXNUMBUER; i++)
    {
      if(!canBeSumOf(i, abundantNums))
      {
        list.add(i);
      }
    }*/

    for(int i = 0; i < list.size(); i++)
    {
      result += list.get(i);
    }

    System.out.println(result);
  }

  public static boolean canBeSumOf(int num, ArrayList<Integer> set)
  {
    boolean found = false;
    int i = 0;
    int j = 0;
    while(!found && i < set.size() && set.get(i) < num)
    {
      while(!found && j <= i && set.get(i) + set.get(j) < num)
      {
        if(set.get(i) + set.get(j) == num)
        {
          found = true;
        }
        j++;
      }
      j = 0;
      i++;
    }
    return found;
  }

  public static ArrayList<Integer> abundantNumbers(int lessThan)
  {
    ArrayList list = new ArrayList<Integer>();

    for(int i = 12; i < lessThan; i++)
    {
      if(i < sumOfFactors(i))
      {
        list.add(i);
      }
    }
    return list;
  }

  public static int sumOfFactors(int num)
  {
    int sum = 0;
    ArrayList<Integer> fact = factors(num);
    for(int i = 0; i < fact.size(); i++)
    {
      sum += fact.get(i);
    }

    return sum;
  }

  public static ArrayList<Integer> factors(int num)
  {
    ArrayList list = new ArrayList<Integer>();

    for(int i = 1; i < num; i++)
    {
      if(num % i == 0)
      {
        list.add(i);
      }
    }
    return list;
  }
}
