import java.io.*;
import java.util.*;

import java.lang.Math;
public class decode {
  public static void main(String[] args) throws FileNotFoundException {
    String message = wordsin(args[0]);
    String[] keys = keygrabber(args[1]);
    String messagepart1 = columnshift(message, keys[1]);
    System.out.println(messagepart1);
    String messagepart2 = columnshift(messagepart1, keys[0]);
    System.out.println(messagepart2);

}
  public static String columnshift(String message, String key){

  	//System.out.println(message);
  	//System.out.println(key);
  	int columns = key.length();
  	int rows = (message.length()/columns);
  	int messagelength = message.length();
  	System.out.println(columns);
  	System.out.println(rows);
  	char[][] messagematrix = new char[columns][rows];
  	char[] keyarray = key.toCharArray();
    //char[] keyarray1 = keyarraymaker(keyarray);
  	char[] keyarray1 = new char[keyarray.length];

  	for(int i = 0; i < keyarray1.length; i++){
  		keyarray1[i] = keyarray[i];
      System.out.print(keyarray[i] + " ");
  	}
    System.out.println();

    Arrays.sort(keyarray1);
    char[] messarray = message.toCharArray();


  	int charnum = 0;
  	//populates charmatrix;
  	charnum = 0;

    for(int i = 0; i < columns; i++){
  		char current = keyarray1[i];
  		for(int k = 0; k < columns; k++){
  			if(keyarray[k] == current){
  				for(int n = 0; n < rows; n++){
  					if(charnum < messarray.length){
  						messagematrix[k][n] = message.charAt(charnum);
              charnum++;
            }

  					else{
  						continue;
  					}
  				}
          keyarray[k] = '*';

  				//System.out.println(messageshift);
  			}
  		}
  	}



  for(int i = 0; i < rows; i++){
    for(int k = 0; k < columns; k++){
      System.out.print(messagematrix[k][i] + " ");
    }
    System.out.println();
  }



    charnum = 0;
    String append = "";
    //Pull message back out from the matrix.
    for(int i = 0; i < rows; i++){
      for(int k = 0; k < columns; k++){

        append = append + messagematrix[k][i];
        charnum++;

        //System.out.print(messagematrix[k][i] + " ");

      }
      //System.out.println();

    }

  	return append;
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
  				if(((intchar >= 65)&(intchar <=90)) || ((intchar >= 48) & (intchar <= 57)) || (intchar == 42)){

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
