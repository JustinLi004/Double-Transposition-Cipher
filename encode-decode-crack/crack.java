import java.io.*;
import java.util.*;

public class crack {
  public static void main(String[] args) {
    String d = read_file("b");
    key_to_int("describe");
    // load_array(d, 9);
  }

  public static String read_file(String fname) {
    String encoded = "";
    try {
      File f = new File("test.txt");
      Scanner s = new Scanner(f);

      while (s.hasNext()) {
        encoded += s.next();
      }

      return encoded.toUpperCase();
    }
    catch (IOException e) { return encoded; }
  }

  // public static void load_array(String c, String key) {
  //   String key = key.toUpperCase();
  //
  //   int a[][] = new int[(c.length() / keylen) + 1][keylen];
  //   if (c.length() % keylen == 0) {
  //     a = new int[c.length() / keylen][keylen];
  //   }
  //   System.out.println(a[0].length);
  //   System.out.println(a.length);
  // }

  public static int[] key_to_int(String key) {
    key = key.toUpperCase();
    int order[] = new int[key.length()];
    for (int i = 0; i < key.length(); i++) {
      System.out.println(key.charAt(i));
    }
    return order;
  }

  public static int[] random_key(int len) {
    List<Integer> order = new List<Integer>();
    for (int i = 0; i < order.length; i++) {
      order.get(i) = i;
    }
  }
}
