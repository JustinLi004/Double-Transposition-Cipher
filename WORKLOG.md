# Workload
Justin: Encode, decode, make the presentation, homework, etc  
Jason: Double transposition cracker.


# Justin Li
## 5/19
Worked on encode. Input/output works fine, moving on to the actual cipher itself.

## 5/20
(As of 5/19)Taking AP Calculus & AP Government Exam. Unsure at current time if able to work on 5/20.

## 5/21
Out travelling.

## 5/22
(12:25) Made progress with encode.java; specifically with the columnshift function. Now loads message into a double array properly. Hopefully by end of day I should have at least encode.java working properly; decode.java will follow easily and naturally from there.

(18:46) More work on encode.java, this time working on the way encode.java handles keys. After this it will then use the keys to 'strip' off columns from the double matrix, which would mean that encode.java is effectvely done.

(19:25) More work done on encode, most of it works, but ran into a bug that I have at the moment no idea how to fix. Essentially -- the double transposition cipher involves lining up the message under a key and then taking off the columns in the alphabetical order of the key's letters. I accomplished this by making two key arrays -- one that held the original key, one with all the letters arrayed. However, this failed to account for the fact that there can be multiple identical letters in a key, and this is handled by numbering the keys from left to right. I do not know a solution at the moment.

## 5/23
(15:15)Encode officially works, probably! Will test further throughout the day and begin work on decode.java.
(15:35)Modified to allow taking numbers in the message. Testing has revealed no problems so far.

## 5/24
(15:35)Worked on decode function. Somewhat lost. Essentially trying to populate a matrix in alphabetical order then pull from there.

## 5/25
Still no luck. Decode is genuinely baffling me somewhat. As far as I can tell I have to keep it on the same column, but it's going rowwise no matter what????

EDIT: also had encode.java add 'null' characters to potentially make decode.java easier to deal with down the line. still bashing my head against the wall re: decode.java though.
EDIT: Fixed the issue, tested it a few times! I may have a version of decode.java that works after all!

## 5/26
Worked on presentation - in particular encode/decode.

##5/27
Added a homework assignment in which students practice using the double transposition encode/decode. I consider cracking the cipher, at the moment, to be too long for a simple 15 minute assignment, while 2 decodes and 1 encode should be doable in 15-30 minutes.

# Jason Zhou
## 5/16 - 5/18
Researching double transposition ciphers and strategies to crack without keys

## 5/19
Worked on generating keys, and correctly populating the array based on randomly generated keys

## 5/20
Worked on testing a double decode given two random keys and outputting the resulting string

## 5/22
Testing a simple hill climbing method where the code searches for common bigrams, trigrams and scores the string. Code has a tendency towards strings with higher scores.

## 5/23
Worked on tweaking scoring and scoring strings higher if they contain expected words and a sufficiently large substring.

## 5/24
Worked on file inputs and cleaning up errors.

## 5/25
Worked on creating keys from English words and presentation.

## 5/26
Worked on brute-forcing keys from English and creating command interface

## 5/30
Tweaked project files, presentation, and assignment

# Sources
Initial information + encoding/decoding methodology
https://www.pbs.org/wgbh/nova/decoding/doubtrans.html#:~:text=Double%20Transposition%20consists%20of%20two,they%20may%20use%20different%20keys.&text=Now%20number%20the%20letters%20in%20the%20keyword%20in%20alphabetical%20order.

English bigrams & trigrams
https://www3.nd.edu/~busiforc/handouts/cryptography/Letter%20Frequencies.html

English wordlist
https://github.com/jnoodle/English-Vocabulary-Word-List/edit/master/Oxford%205000.txt
https://github.com/jnoodle/English-Vocabulary-Word-List/blob/master/Oxford%203000.txt

Source for the encode.java work
https://programsinengineering.blogspot.com/2016/10/implement-double-transposition-cipher.html

Source for general history of the cipher:
https://en.wikipedia.org/wiki/Transposition_cipher

Double transposition cracking:
https://www.tandfonline.com/doi/abs/10.1080/01611194.2014.915269
