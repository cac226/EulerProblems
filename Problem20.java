class Problem20 {
  public static void main(String[] args)
  {
    int result = 0;
    String facto = "";
    for(int i = 0; i < facto.length(); i++)
    {
      result += (Character.getNumericValue(facto.charAt(i)));
    }

    //testing
    System.out.println(stringXInt("102", 5));
    System.out.println(stringXInt("2", 1));
    System.out.println(stringXInt("16743", 20));
    System.out.println(stringXInt("1456", 11));
    System.out.println(stringXInt("3245023940293", 21));
    System.out.println(stringXInt("49328509328405", 45));
  }

  public static String factorial(int num)
  {
    String result = "";
    for(int i = 1; i <= 10; i++)
    {
    }
    return result;
  }

  public static String stringXInt(String str, int num)
  {
    String result = "";
    int carry = 0;

    for(int i = str.length() - 1; i >= 0; i--)
    {
      int val = Character.getNumericValue(str.charAt(i)) * num;
      val += carry % 10;
      carry = (carry / 10) + (val / 10);
      int onesPlace = val % 10;
      result = onesPlace + result;
      i--;
    }
    if(carry > 0) {
      result = carry + "" + result;
    }
    return result;
  }
}
