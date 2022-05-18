import java.io.*;
import java.util.*;
import java.lang.Math;
public class encode {
  public static void main(String[] args) throws FileNotFoundException {
    String message = wordsin(args[0]);
    String[] keys = keygrabber(args[1]);
    String newtext = vin(words, key);
    System.out.println(newtext);
    
    String messagepart1 = columnshift(message, keys[0]);
    String messagepart2 = columnshift(message, keys[1]);
    System.out.println(messagepart2);
    return messagepart2;
    
  }
  
  public static String columnshift(){
  	
  
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
  
}
