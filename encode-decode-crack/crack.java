import java.io.*;
import java.util.*;

public class crack {
  public static void main(String[] args) {
    String d = read_file("b");
    // load_array(d, 9);

    ArrayList<Integer> order = random_key_int(9);
    order = random_key(order);
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
      order[i] = (int) key.charAt(i);
    }
    System.out.println(Arrays.toString(order));
    return order;
  }

  public static ArrayList<Integer> random_key_int(int len) {
    ArrayList<Integer> order = new ArrayList<Integer>();
    for (int i = 0; i < len; i++) {
      order.add(i);
    }
    Collections.shuffle(order);
    System.out.println(order.toString());

    return order;
  }

  public static ArrayList<Integer> random_key(ArrayList<Integer> order) {
    Collections.swap(order, 1, 2);
    System.out.println(order.toString());

    return order;
  }
}
