import java.io.*;
import java.util.*;
import java.lang.Math;
public class encode {
  public static void main(String[] args) throws FileNotFoundException {
    String message = wordsin(args[0]);
    String[] keys = keygrabber(args[1]);
    String messagepart1 = columnshift(message, keys[0]);
    String messagepart2 = columnshift(message, keys[1]);
    System.out.println(messagepart2);

  }

  public static String columnshift(String message, String key){
  	System.out.println(message +" " + key);
  	return message;
  }


    public static String wordsin(String arg) throws FileNotFoundException{
  		//System.out.println(args);
  	  File text = new File(arg);
  	  Scanner s = new Scanner(text);
  		String wordsin = "";
  		String holder = "";
  		while(s.hasNext()){
  			holder = s.next();
  			//System.out.println(holder);
  			int leng = holder.length();
  			for(int x = 0; x < leng; x++) {
  				char charatx = holder.charAt(x);
  				int intchar = (int)(charatx);
  				if((intchar >= 65)&(intchar <=90)) {

  					wordsin = wordsin + String.valueOf(charatx);
  					//System.out.println(charatx);
  				}
  				else if((intchar >= 97)&(intchar <= 122)) {
  					wordsin = wordsin + String.valueOf(Character.toChars(intchar - 32));
  					//System.out.println(wordsin);
  				}
  			}
  		}
  		//System.out.println(wordsin);
  		return wordsin;
  		//System.out.println("We are Successful!");
}
    public static String[] keygrabber(String arg) throws FileNotFoundException{
  		//System.out.println(args);
  	  File text = new File(arg);
  	  Scanner s = new Scanner(text);
  		String[] wordsin = new String[2];
  		String holder = "";
      int keynum = 0;
    	while(s.hasNext()){

  			holder = s.next();
  			//System.out.println(holder);
  			int leng = holder.length();
  			for(int x = 0; x < leng; x++) {
  				char charatx = holder.charAt(x);
  				int intchar = (int)(charatx);
  				if((intchar >= 65)&(intchar <=90)) {

  					wordsin[keynum] = wordsin[keynum] + String.valueOf(charatx);
  					//System.out.println(charatx);
  				}
  				else if((intchar >= 97)&(intchar <= 122)) {
  					wordsin[keynum] = wordsin[keynum] + String.valueOf(Character.toChars(intchar - 32));
  					//System.out.println(wordsin);
  				}
  			}
        keynum ++;
      }

  		//System.out.println(wordsin);
  		return wordsin;
  		//System.out.println("We are Successful!");
}


}
