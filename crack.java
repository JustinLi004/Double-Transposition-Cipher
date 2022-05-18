import java.io.*;
import java.util.*;

public class crack {
  public static void main(String[] args) {
    System.out.println(read_file("b"));
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
}
