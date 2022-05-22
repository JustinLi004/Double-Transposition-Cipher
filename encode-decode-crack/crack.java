import java.io.*;
import java.util.*;
import java.util.regex.*;

public class crack {
  public static void main(String[] args) {
    String d = read_file("b");
    // System.out.println(d.length());
    // ArrayList<Integer> order = random_key_int(9);
    // order = random_key(order);
    // int set_key[] = {3, 7, 5, 2, 4, 6, 1, 8};
    // ArrayList<Integer> key = new ArrayList<Integer>();
    // for (int i : set_key) {
    //   key.add(i-1);
    // }
    //
    // System.out.println(decode(d, key));

    crack(d);
  }

  public static void crack(String enc) {
    // int set_key[] = {2, 7, 1, 8, 9, 5, 4, 6, 3};
    // ArrayList<Integer> key = new ArrayList<Integer>();
    // for (int i : set_key) {
    //   key.add(i-1);
    // }

    ArrayList<Integer> key = random_key_int(9);

    String first_out = decode(enc, key);

    // int set_key2[] = {3, 4, 8, 2, 7, 6, 1, 5};
    // key = new ArrayList<Integer>();
    // for (int i : set_key2) {
    //   key.add(i-1);
    // }

    key = random_key_int(7);

    for (int k = 0; k < 10; k++) {

      key = random_key(key);
      String second_out = decode(first_out, key);
      float s = score(second_out);

      System.out.println(s + "\t" + second_out);
    }
  }

  public static float score(String enc) {
    String bigrams[] = {"TH", "HE", "IN", "EN", "NT", "RE", "ER", "AN", "TI", "ES", "ON", "AT", "SE", "ND", "OR", "AR", "AL", "TE", "CO", "DE", "TO", "RA", "ET", "ED", "IT", "SA", "EM", "RO"};
    String trigrams[] = {"THE", "AND", "THA", "ENT", "ING", "ION", "TIO", "FOR", "NDE", "HAS", "NCE", "EDT", "TIS", "OFT", "STH", "MEN"};

    float score = 0;
    for (String b: bigrams) {
      Pattern p = Pattern.compile(b);
      Matcher m = p.matcher(enc);

      int count = 0;
      while (m.find()) {
        count++;
      }

      score += 0.5 * count;
    }

    for (String t: trigrams) {
      Pattern p = Pattern.compile(t);
      Matcher m = p.matcher(enc);

      int count = 0;
      while (m.find()) {
        count++;
      }

      score += 2 * count;
    }

    return score;
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

    char arr[][];

    int ind = 0;
    if (c.length() % o.size() == 0) {
      arr = new char[o.size()][c.length() / o.size()];
    }
    arr = new char[o.size()][(c.length() / o.size()) + 1];

    for (int i = 0; i < arr.length; i++) {
      int r = o.indexOf(i);
      for (int j = 0; j < arr[0].length; j++) {
        if (ind != c.length()) {
          arr[r][j] = c.charAt(ind);
          ind++;
        }

        if (j == arr[0].length - 1 && r >= c.length() % o.size()) {
          ind--;
          arr[r][j] = ' ';
        }
      }
    }
    return stringify(arr, c.length());
  }

  public static String stringify(char[][] c, int len) {
    String output = "";
    for (int i = 0; i < len; i++) {
      output += c[i%c.length][i/c.length];
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
