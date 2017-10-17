/*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
*/

class Problem34
{
  private static final int MAXIMUM = 100000;
  public static void main(String[] args) {
    int result = 0;
    for(int i = 3; i < MAXIMUM; i++)
    {
      if(i == sumOfFactOfDigit(i))
      {
        result += i;
      }
    }
    System.out.println(result);
  }

  public static int sumOfFactOfDigit(int num)
  {
    int result = 0;
    int temp = num; // to avoid changing num
    while(temp > 0)
    {
      result += factor(temp % 10);
      temp = temp / 10;
    }
    return result;
  }

  //assumes input is 1-9
  public static int factor(int num)
  {
    switch(num)
    {
      case 0:  return 1;
      case 1:  return 1;
      case 2:  return 2;
      case 3:  return 6;
      case 4:  return 24;
      case 5:  return 120;
      case 6:  return 720;
      case 7:  return 5040;
      case 8:  return 40320;
      default: return 362880;
    }
  }
}
