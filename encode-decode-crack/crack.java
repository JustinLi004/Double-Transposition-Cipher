import java.io.*;
import java.util.*;

public class crack {
  public static void main(String[] args) {
    String d = read_file("b");
    System.out.println(d.length());
    ArrayList<Integer> order = random_key_int(9);
    order = random_key(order);

    int set_key[] = {2, 7, 1, 8, 9, 5, 4, 6, 3};
    order = new ArrayList<Integer>();
    for (int i : set_key) {
      order.add(i-1);
    }

    String first_out = decode(d, order);

    set_key[] = {3, 4, 8, 2, 7, 6, 1, 5};
    order = new ArrayList<Integer>();
    for (int i : set_key) {
      order.add(i-1);
    }

    String second_out = decode(first_out, order);
    System.out.println(second_out);
  }

  public static String read_file(String fname) {
    String encoded = "";
    try {
      File f = new File("../test.txt");
      Scanner s = new Scanner(f);

      while (s.hasNext()) {
        encoded += s.next();
      }

      return encoded.toUpperCase();
    }
    catch (IOException e) { return encoded; }
  }

  public static String decode(String c, ArrayList<Integer> o) {

    // int set_key[] = {2, 7, 1, 8, 9, 5, 4, 6, 3};
    // o = new ArrayList<Integer>();
    // for (int i : set_key) {
    //   o.add(i-1);
    // }

    System.out.println(o.toString());

    char arr[][];
    System.out.println(c.length());

    int ind = 0;
    if (c.length() % o.size() == 0) {
      arr = new char[o.size()][c.length() / o.size()];
    }
    arr = new char[o.size()][(c.length() / o.size()) + 1];

    for (int i = 0; i < arr.length; i++) {
      int r = o.indexOf(i);
      for (int j = 0; j < arr[0].length; j++) {
        arr[r][j] = c.charAt(ind);
        ind++;

        if (j == arr[0].length - 1 && r >= c.length() % o.size()) {
          ind--;
          arr[r][j] = ' ';
        }
      }
    }

    print_matrix(arr);
    return stringify(arr);
  }

  public static String stringify(char[][] c) {
    String output = "";
    for (char[] r : c) {
      for (char ch : r) {
        output += ch;
      }
    }
    return output;
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

    return order;
  }

  public static ArrayList<Integer> random_key(ArrayList<Integer> order) {
    int r1 = (int) (Math.random() * (float) order.size());
    int r2 = (int) (Math.random() * (float) order.size());
    while (r1 == r2) {
      r2 = (int) (Math.random() * (float) order.size());
    }
    Collections.swap(order, r1, r2);

    return order;
  }
}
