import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/*
Each character on a computer is assigned a unique code and the preferred
standard is ASCII (American Standard Code for Information Interchange). For
example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.

A modern encryption method is to take a text file, convert the bytes to ASCII,
then XOR each byte with a given value, taken from a secret key. The advantage
with the XOR function is that using the same encryption key on the cipher text,
restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.

For unbreakable encryption, the key is the same length as the plain text
message, and the key is made up of random bytes. The user would keep the
encrypted message and the encryption key in different locations, and without
both "halves", it is impossible to decrypt the message.

Unfortunately, this method is impractical for most users, so the modified
method is to use a password as a key. If the password is shorter than the
message, which is likely, the key is repeated cyclically throughout the message.
The balance for this method is using a sufficiently long password key for
security, but short enough to be memorable.

Your task has been made easy, as the encryption key consists of three lower
case characters.

Using cipher.txt decrypt the message and find the sum of the ASCII values
in the original text.
*/
class Problem59
{
  public static void main(String[] args) throws FileNotFoundException
  {
    //lowercase letters are vals 97 - 122
    File file = new File("/Users/caitlincampbell/Documents/FunCoding/p059_cipher.txt");
    Scanner in = new Scanner(file);

    String fileText = in.next();

    int[] encrypted = convertToArray(fileText);

    for(int i = 97; i <= 97; i++)
    {
      for(int j = 97; j <= 122; j++)
      {
        for(int k = 97; k <= 122; k++)
        {
          System.out.print(i + " " + j + " " + k + ": ");
          int[] key = {i, j, k};
          char[] decrypted = convertToAscii(decrypt(encrypted, key));
          printArray(decrypted);
        }
      }
    }


  }

  public static int[] decrypt(int[] message, int[] key)
  {
    int[] result = new int[message.length];

    int k = 0; //index in key
    int m = 0; //index in message

    while(m < message.length)
    {
      while(k < key.length & m < message.length)
      {
        result[m] = message[m] ^ key[k];
        m++;
        k++;
      }
      k = 0;
    }

    return result;
  }

  public static char[] convertToAscii(int[] arr)
  {
    char[] result = new char[arr.length];

    for(int i = 0; i < arr.length; i++)
    {
      result[i] = (char) arr[i];
    }

    return result;
  }

  public static int[] convertToArray(String str)
  {
    //counts commas to find out how many items the array should halves
    int i = 0;
    int arraySize = 0;
    while(i + 1 < str.length())
    {
      arraySize++;
      i = str.indexOf(',', i + 1);
    }

    int[] result = new int[arraySize];

    int arrLoc = 1; //arrayLocation
    i = str.indexOf(',');
    result[0] = Integer.parseInt(str.substring(0, i));
    while(i + 1 < str.length())
    {
      int j = str.indexOf(',', i + 1);
      result[arrLoc] = Integer.parseInt(str.substring(i + 1, j));
      i = j;
      arrLoc++;
    }

    return result;
  }

  public static void printArray(int[] arr)
  {
    System.out.print(arr[0]);
    for(int i = 1; i < arr.length; i++)
    {
      System.out.print(", " + arr[i]);
    }
    System.out.println();
  }

  public static void printArray(char[] arr)
  {
    for(int i = 0; i < arr.length; i++)
    {
      System.out.print(arr[i]);
    }
    System.out.println();
  }
}
