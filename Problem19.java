class Problem19 {
  public static void main(String[] args)
  {
    int result = 0;
    int month = 1;
    int year = 1900;
    int day = 2; // 2 = monday
    boolean isLeapYear = false;

    //get year to 1901
    while(month <= 12)
    {
      day += addMonth(month, isLeapYear);
      month++;
    }

    day = day % 7;
    month = 1;
    year++;

    while(year < 2001)
    {
      if(day % 7 == 1 && month == 10) // if it is a Sunday on the 1st of the month
      {
        result += 1;
      }

      //add a new month
      day += addMonth(month, isLeapYear);
      day = day % 7;
      month++;

      if(month > 12) // is it a new year
      {
        year++;
        month = 1;
        isLeapYear = isItALeapYear(year);
      }
    }
    System.out.println(result);
  }

  public static int addMonth(int month, boolean isLeapYear)
  {
    if(month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    if(month == 2) {
      if(isLeapYear) return 29;
      else return 28;
    }
    else return 31;
  }

  public static boolean isItALeapYear(int year)
  {
    if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
    {
      return true;
    }
    return false;
  }
}
