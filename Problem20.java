//SOLVED
class Problem20 {
  public static void main(String[] args)
  {
    int result = 0;
    String facto = factorial(100);

    //computes sum of digits
    for(int i = 0; i < facto.length(); i++)
    {
      result += (Character.getNumericValue(facto.charAt(i)));
    }

    System.out.println(result);
  }

  public static String factorial(int num)
  {
    String result = "1";
    for(int i = 2; i <= num; i++)
    {
      result = stringXInt(result, i);
    }
    return result;
  }

  public static String stringXInt(String str, int num)
  {
    String result = "";
    int carry = 0;

    for(int i = str.length() - 1; i >= 0; i--)
    {
      int val = Character.getNumericValue(str.charAt(i));
      val = val * num;
      val += carry % 10;
      carry = (carry / 10) + (val / 10);
      int onesPlace = val % 10;
      result = onesPlace + "" + result;
    }
    if(carry != 0) {
      result = carry + "" + result;
    }
    return result;
  }
}
