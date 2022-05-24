import java.io.*;
import java.util.*;

import java.lang.Math;
public class encode {
  public static void main(String[] args) throws FileNotFoundException {
    String message = wordsin(args[0]);
    String[] keys = keygrabber(args[1]);
    String messagepart1 = columnshift(message, keys[0]);
    //System.out.println(messagepart1);
    String messagepart2 = columnshift(messagepart1, keys[1]);
    System.out.println(messagepart2);

}
  public static String columnshift(String message, String key){
  	//System.out.println(message);
  	//System.out.println(key);
  	int columns = key.length();
  	int rows = 1 + (message.length()/columns);
  	int messagelength = message.length();
  	//System.out.println(columns);
  	//System.out.println(rows);
  	char[][] messagematrix = new char[columns][rows];

  	char[] messarray = message.toCharArray();

  	char[] keyarray = key.toCharArray();
    //char[] keyarray1 = keyarraymaker(keyarray);

  	char[] keyarray1 = new char[keyarray.length];
    for(int i = 0; i < keyarray1.length; i++){
  		keyarray1[i] = keyarray[i];
      System.out.print(keyarray[i] + " ");
  	}
    System.out.println();
  	Arrays.sort(keyarray1);
  	//for(int i = 0; i < keyarray1.length; i++){
  	//	System.out.print(keyarray1[i] + " ");
  	//}
  	//System.out.println();
  	//for(int i = 0; i < keyarray1.length; i++){
  	//	System.out.print(keyarray[i] + " ");
  	//}
  	//System.out.println();
  	//String messageshift = "";
  	int charnum = 0;
  	//populates charmatrix;
  	for(int i = 0; i < rows; i++){
  	  for(int k = 0; k < columns; k++){
  	  	if(charnum >= messagelength){
  	  		//messagematrix[k][i] = ' ';
			continue;
		}
		else{
  	  	messagematrix[k][i] = messarray[charnum];
  	  	charnum++;
  	  	}
  	  	System.out.print(messagematrix[k][i] + " ");

  	  }
  	  System.out.println();

  	}
  	charnum = 0;
  	int len = keyarray.length;
  	for(int i = 0; i < len; i++){
  		char current = keyarray1[i];
  		for(int k = 0; k < len; k++){
  			if(keyarray[k] == current){

  				String append = "";
  				for(int n = 0; n < messagematrix[k].length; n++){
  					if((int)messagematrix[k][n] != 0){
  						append = append + messagematrix[k][n];
            }

  					else{
  						continue;
  					}
  				}
          keyarray[k] = '*';
  				messageshift = messageshift + append;
  				//System.out.println(messageshift);
  			}
  		}
  	}

  	return messageshift;
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
  				if(((intchar >= 65)&(intchar <=90)) || ((intchar >= 48) & (intchar <= 57))) {

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
  		wordsin[0] = "";
  		wordsin[1] = "";
  		String holder = "";
      int keynum = 0;
    	while(s.hasNext()){

  			holder = s.next();
  			//System.out.println(holder);
  			int leng = holder.length();
  			for(int x = 0; x < leng; x++) {
  				char charatx = holder.charAt(x);
  				int intchar = (int)(charatx);
  				if(((intchar >= 65)&(intchar <=90)) || ((intchar >= 48) & (intchar <= 57))) {

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
