import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import javax.print.DocFlavor.STRING;

import java.util.Random;

public class Implementation {

    public static Scanner in;

    public static void main(String[] args) {

        in = new Scanner(System.in);

        Encryption encrypiton = new Encryption();

        Decryption decrypiton = new Decryption();

        String cipher = "";

        // ENCRYPT/ DECRYPT OPTIONS:
        System.out.println("       Chose (1/2):");
        System.out.println();
        System.out.println("       1. ENCRYPT.");
        System.out.println();
        System.out.println("       2. DECRYPT.");
        int encryptOrDecryptOption = in.nextInt();
        switch (encryptOrDecryptOption) {
            case (1): { // ENCRYPTION
                in = new Scanner(System.in);
                // FOR EVERY LINE IN FILE...
                System.out.println("    Enter File Name To Be Encrypted (with extension): ");
                String fileName = in.nextLine();
                System.out.println(fileName);
                try {
                    File file = new File("PlainText.txt");
                    Scanner myReader = new Scanner(file);
                    while (myReader.hasNextLine()) {
                        in = new Scanner(System.in);
                        String plainText = myReader.nextLine();
                        plainText = ConvertStringToBinary(plainText);

                        // KEY OPTIONS:
                        System.out.println("       Chose (1/2):");
                        System.out.println();
                        System.out.println("       1. I Have My Key.");
                        System.out.println();
                        System.out.println("       2. Generate Key For Me.");

                        int withKeyWithoutKeyOption = in.nextInt();
                        String key = "";
                        if (withKeyWithoutKeyOption == 1) { // Key Given
                            System.out.println("    Enter the Key:");
                            in = new Scanner(System.in);
                            key = in.nextLine();
                            if (plainText.length() != key.length()) {
                                System.out.println("Try Again");
                                System.out.println("Sorry, But Lengths of plain text and key dont match.");

                            }
                            // SEND PLAIN TEXT AND KEY FOR ENCRYPTION
                            cipher = encrypiton.Encrypt(plainText, key);

                        } else if (withKeyWithoutKeyOption == 2) { // Key Will BE GENERATED

                            // generate key by calling Generate random
                            key = GenerateRandom(plainText.length());
                            // for alphabet keys
                            String strkey = setStringtoASCII(key);
                            System.out.println(
                                    "-----------------------------------------------------------");
                            System.out.println(" GENERATED  KEY = ");

                            System.out.println(strkey);

                            System.out.println();
                            // SEND PLAIN TEXT WITH GENERATED KEY FOR ENCRYPTION
                            cipher = encrypiton.Encrypt(plainText, key);

                        }
                        cipher = setStringtoASCII(cipher);
                        System.out.println(
                                "-----------------------------------------------------------");
                        // 0101 to A
                        System.out.println("   PLAIN TEXT = ");
                        plainText = setStringtoASCII(plainText);
                        System.out.println(plainText);
                        System.out.println();

                        System.out.println(
                                "------------------------------------------------------------");
                        System.out.println(" CIPHER TEXT = ");
                        System.out.println(cipher);
                        System.out.println();
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
            }
            case (2): { // DECRYPTIION
                in = new Scanner(System.in);
                // FOR EVERY LINE IN FILE...
                System.out.println("    Enter File Name To Be Decrypted (with extension): ");
                String fileName = in.nextLine();
                try {
                    File file = new File(fileName);
                    Scanner myReader = new Scanner(file);
                    while (myReader.hasNextLine()) {
                        String cipherText = myReader.nextLine();
                        // abc to 10101
                        cipherText = ConvertStringToBinary(cipherText);

                        // System.out.println(" Enter the Key:");
                        // in = new Scanner(System.in);

                        String key = in.nextLine();
                        key = "?|Y?|";
                        // abc to 10101
                        key = ConvertStringToBinary(key);

                        if (cipherText.length() != key.length()) {
                            System.out.println("Try Again");
                            System.out.println("Sorry, But Lengths of plain text and key dont match.");

                        }

                        // SEND CIPHER AND KEY FOR DECRYPTION
                        String decryptedText = decrypiton.Decrypt(cipherText, key);

                        System.out.println(
                                "------------------------------------------------------------");
                        System.out.println(" CIPHER TEXT = ");
                        // 10101 to abc
                        cipherText = setStringtoASCII(cipherText);
                        System.out.println(cipherText);
                        System.out.println();
                        System.out.println(
                                "-----------------------------------------------------------");
                        System.out.println(" DECRYPTED  PLAIN TEXT = ");
                        // 10101 to abc
                        cipherText = setStringtoASCII(decryptedText);
                        System.out.println(decryptedText);
                        System.out.println();
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static String GenerateRandom(int str_Length) {
        String randomNumberString = "";

        for (int index = 0; index < str_Length; index++) {

            Random rand = new Random();
            int int_random = rand.nextInt(2);
            String str_random = Integer.toString(int_random);
            randomNumberString += str_random;
        }
        return randomNumberString;
    }

    public static String ConvertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar)) // char -> int, auto-cast
                            .replaceAll(" ", "0") // zero pads
            );
        }
        return result.toString();

    }

    // Function to convert binary to decimal
    static int binaryToDecimal(String n) {
        String num = n;

        // Stores the decimal value
        int dec_value = 0;

        // Initializing base value to 1
        int base = 1;

        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {

            // If the current bit is 1
            if (num.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }

        // Return answer
        return dec_value;
    }

    // Function to convert binary to ASCII
    static String setStringtoASCII(String str) {

        // To store size of s
        int N = (str.length());

        // If given String is not a
        // valid String
        if (N % 8 != 0) {
            return "Not Possible!";
        }

        // To store final answer
        String res = "";

        // Loop to iterate through String
        for (int i = 0; i < N; i += 8) {
            int decimal_value = binaryToDecimal((str.substring(i, 8 + i)));

            // Apprend the ASCII character
            // equivalent to current value
            res += (char) (decimal_value);
        }

        // Return Answer
        return res;
    }
}
