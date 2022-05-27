import java.io.*;
import java.util.*;
import java.util.regex.*;

public class crack {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("USAGE:");
      System.out.println("make crack ARGS=\"<flag> <filename path> <config file path>\"" + "\n");
      System.out.println("AVAILABLE FLAGS:");
      System.out.println("-D" + "\t" + "Dictionary Attack");
      System.out.println("-H" + "\t" + "Hill Climbing Attack");
      return;
    }

    String d = read_file(args[1]);
    if (args[0].equals("-D") || args[0].equals("-d")) {
      brute_crack(d);
    }

    if (args[0].equals("-H") || args[0].equals("-H")) {
      crack(d, args[2]);
    }
  }

  public static void brute_crack(String enc) {
    ArrayList<ArrayList<Integer>> wordlist = new ArrayList<ArrayList<Integer>>();

    try {
      File f = new File("english.txt");
      Scanner s = new Scanner(f);
      while (s.hasNext()) {
        wordlist.add(key_to_int(s.next()));
      }

      float highest = 0;
      for (int i = 0; i < wordlist.size(); i++) {
        for (int j = 0; j < wordlist.size(); j++) {
          ArrayList<Integer> key1 = wordlist.get(i);
          ArrayList<Integer> key2 = wordlist.get(j);

          String sol = decode(decode(enc, key1), key2);
          float score = score(sol);

          if (score > highest) {
            highest = score;
            System.out.println(score + "\t" + sol);
          }
        }
      }











    }
    catch (IOException e) { System.out.println("File not found"); }
  }

  public static void crack(String enc, String fname) {
    ArrayList<String> wordlist = read_into_array(fname);
    if (enc.length() == 0) return;

    ArrayList<Integer> key1 = random_key_int(6);

    String first_out = decode(enc, key1);

    ArrayList<Integer> key2 = random_key_int(6);
    ArrayList<Integer> high_key = new ArrayList<Integer>();
    float highest = 0;
    int counter = 0;

    for (int k = 0; k < 1000000; k++) {

      key2 = random_key(key2);
      String second_out = decode(first_out, key2);
      float s = score(second_out, wordlist);

      if (s > highest) {
        highest = s;
        high_key = key2;
        counter = 0;
        System.out.println(s + "\t" + second_out);
      }
      else {
        key2 = high_key;
        counter++;
      }

      if (counter > 5000) {
        k = k - 5000;
        counter = 0;
        key1 = random_key(key1);
        first_out = decode(enc, key1);
      }
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

      score += (1 * count);
    }

    for (String t: trigrams) {
      Pattern p = Pattern.compile(t);
      Matcher m = p.matcher(enc);

      int count = 0;
      while (m.find()) {
        count++;
      }

      score += (3.5 * count);
    }

    return score;
  }

  public static float score(String enc, ArrayList<String> wl) {
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

      score += (1 * count);
    }

    for (String t: trigrams) {
      Pattern p = Pattern.compile(t);
      Matcher m = p.matcher(enc);

      int count = 0;
      while (m.find()) {
        count++;
      }

      score += (3.5 * count);
    }

    for (String d: wl) {
      for (int i = 0; i < d.length() - 3; i++) {
        Pattern p = Pattern.compile(d.substring(i, i + 3));
        Matcher m = p.matcher(enc);
        int count = 0;
        while (m.find()) {
          count++;
        }
        score += (100 * count);
      }
    }

    return score;
  }

  public static ArrayList<String> read_into_array(String fname) {
    ArrayList<String> wordlist = new ArrayList<String>();
    try {
      File f = new File(fname);
      Scanner s = new Scanner(f);

      while (s.hasNext()) {
        wordlist.add(s.next().toUpperCase());
      }

      return wordlist;
    }
    catch (IOException e) {
      return wordlist;
    }
  }

  public static String read_file(String fname) {
    String encoded = "";
    try {
      File f = new File(fname);
      Scanner s = new Scanner(f);

      while (s.hasNext()) {
        encoded += s.next();
      }

      return encoded.toUpperCase();
    }
    catch (IOException e) { System.out.println("File Not Found");
      return encoded; }
  }

  public static String decode(String c, ArrayList<Integer> o) {

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

  public static ArrayList<Integer> key_to_int(String key) {
    key = key.toUpperCase();
    int order[] = new int[key.length()];
    for (int i = 0; i < key.length(); i++) {
      order[i] = (int) key.charAt(i);
    }

    for (int i = 0; i < key.length(); i++) {
      int low = lowest_index(order);
      order[low] = i;
    }

    ArrayList<Integer> output = new ArrayList<Integer>();
    for (int i : order) {
      output.add(i);
    }

    return output;
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

  public static int lowest_index(int[] arr) {
    int index = 0;
    int lowest = 100;
    int lowest_index = 0;
    for (int i : arr) {
      if (i >= 65 && i < 65 + 26 && i < lowest) {
        lowest_index = index;
        lowest = i;
      }
      index++;
    }
    return lowest_index;
  }
}
