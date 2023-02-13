SNAPSHOTS/ SCREENSHOTS ARE MADE AVAILABLE FOR REFERENCING AT EASE

This jAVA One Time Pad Cipher pakage code consist of 3 files mainly:
1. ENCRYPT---------------------------------------------------------------

dedicated to implement the encrypt class for the pakage 
(the algorithm used is provided in the comments of this file 
It takes 
-'plaintext' of string type ( the string that is needed to be ciphered)(the string as binary values like '10101').
-a number 'key'(with which it generates the cipher)
as input

2. DECRYPT---------------------------------------------------------------

dedicated to implement the decrypt class for the pakage 

(the algorithm used is provided in the comments of this file 
It takes 
-'ciphertext' of string type ( the string that is needed to be ciphered)(the string as binary values like '10101').
-a number 'key'(with which it generates the plaintext)
as input

3. RUNNER---------------------------------------------------------------

-this file is the center of the pakage
-it takes plaintexts, ciphertexts as input from seperate text files
-asks if a key should be automatically generated or the user will provide 
-then provides the cipher text 
-Handles file not found error through 'try and catch' statements
-takes file name as input in console
-has a randon function dedicated to generate random values
