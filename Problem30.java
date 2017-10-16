/*

SOLVED

Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 1^4 + 6^4 + 3^4 + 4^4
8208 = 8^4 + 2^4 + 0^4 + 8^4
9474 = 9^4 + 4^4 + 7^4 + 4^4
As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*/

class Problem30
{
  public static void main(String[] args)
  {
    int result = 0;
    for(int i = 10; i < 1000000; i++)
    {
      if(isSumofPowers(i)) result += i;
    }
    System.out.println("\n\n" + result);
  }

  public static boolean isSumofPowers(int num)
  {
    int tempNum = num;
    int result = 0;

    while(tempNum > 0)
    {
      result += fifthPow(tempNum % 10);
      tempNum = tempNum / 10;
    }

    if(result == num) System.out.println(result);

    return result == num;
  }

  public static int fifthPow(int digit)
  {
    switch(digit) {
      case 0: return 0;
      case 1: return 1;
      case 2: return 32;
      case 3: return 243;
      case 4: return 1024;
      case 5: return 3125;
      case 6: return 7776;
      case 7: return 16807;
      case 8: return 32768;
      default:return 59049;
    }
  }
}
