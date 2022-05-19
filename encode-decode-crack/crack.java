import java.io.*;
import java.util.*;

public class crack {
  public static void main(String[] args) {
    String d = read_file("b");

    ArrayList<Integer> order = random_key_int(9);
    order = random_key(order);

    load_array(d, order);
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

  public static void load_array(String c, ArrayList<Integer> o) {
    char arr[][] = new char[o.size()][c.length() / o.size()];
    print_matrix(arr);
  }

  public static void print_matrix(char[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }

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
    int r1 = (int) (Math.random() * (float) order.size());
    int r2 = (int) (Math.random() * (float) order.size());
    while (r1 == r2) {
      r2 = (int) (Math.random() * (float) order.size());
    }
    Collections.swap(order, r1, r2);
    System.out.println(order.toString());

    return order;
  }
}
