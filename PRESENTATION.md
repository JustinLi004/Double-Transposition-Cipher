# Double Transposition Cipher
## History


## Encoding and Decoding
To encode, write your key out. Then write the message out, row-wise, with the number of letters to each row being the same as the number of letters in the key. Then pull out from this matrix by the columns, in the  alphabetical order of the keys. Block off unused spaces with some sort of null key. Form it into a single string. Repeat with the next key.

To decode, one reverses this process; one writes out the second key, writes in the matrix columnwise in alphabetical order of the key, pulls from it rowwise, etc.

### Key Generation
 D | I | V | I | D | E | N | D
 --- | --- | --- | --- | --- | --- | --- | ---
 1 | 5 | 8 | 6 | 2 | 4 | 7 | 3

I | N | T | E | R | F | A | C | E
--- | --- | --- | --- | --- | --- | --- | --- | ---
6 | 7 | 9 | 3 | 8 | 5 | 1 | 2 | 4
### Example Encoding
#### First Transposition
D | I | V | I | D | E | N | D
--- | --- | --- | --- | --- | --- | --- | ---
1 | 18 | 31 | 23 | 6 | 14 | 27 | 10
2 | 19 | 32 | 24 | 7 | 15 | 28 | 11
3 | 20 | 33 | 25 | 8 | 16 | 29 | 12
4 | 21 | 34 | 26 | 9 | 17 | 30 | 13
5 | 22 | | | | | |
**Output (broken in groups for readability):**  
1, 18, 31, 23, 6,  
14, 27, 10, 2, 19,  
32, 24, 7, 15, 28,  
11, 3, 20, 33, 25,  
8, 16, 29, 12, 4,  
21, 34, 26, 9, 17,  
30, 13, 5, 22
#### Second Transposition
T | A | B | L | E
--- | --- | --- | --- | ---
26 | 1 | 10 | 8 | 28
9 | 18 | 2 | 16 | 11
17 | 31 | 19 | 29 | 3
30 | 23 | 32 | 12 | 20
13 | 6 | 24 | 4 | 33
5 | 14 | 7 | 21 | 25
22 | 27 | 15 | 34 |
**Encoded String:**  
26, 1, 10, 8, 28,   
9, 18, 2, 16, 11,   
17, 31, 19, 29, 3,  
30, 23, 32, 12, 20,  
13, 6, 24, 4, 33,  
5, 14, 7, 21, 25,  
22, 27, 15, 34
## Attack Methods
1. Hill Climbing  

![One relative max and one absolute max](https://90percentofeverything.com/wp-content/uploads/2011/01/locmax.gif)
2. Guessing plaintext  
3. Restricting keyspace  
