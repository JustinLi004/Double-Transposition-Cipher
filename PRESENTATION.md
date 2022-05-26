# Double Transposition Cipher
## History


## Encoding and Decoding
To encode, write your key out. Then write the message out, row-wise, with the number of letters to each row being the same as the number of letters in the key. Then pull out from this matrix by the columns, in the  alphabetical order of the keys. Block off unused spaces with some sort of null key. Form it into a single string. Repeat with the next key.

To decode, one reverses this process; one writes out the second key, writes in the matrix columnwise in alphabetical order of the key, pulls from it rowwise, etc.

## Attack Methods
1. Hill Climbing  

![One relative max and one absolute max](https://90percentofeverything.com/wp-content/uploads/2011/01/locmax.gif)
2. Guessing plaintext  
3. Restricting keyspace  
