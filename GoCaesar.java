package gocaesar;

/****************************************************
 * Programmer: Geneiva Ocampo
 * Course CSCI 1471
 * Date 04/24/2024
 * Assignment: Homework #10
 * Environment Java with Netbeans
 * Files Included: GoCaesar
 * Purpose: to encrypt and decrypt string inputs
* Input: workhard and JHRUJLDIRRWEDOOURFNV
 * Preconditions/ Assumptions:ser chooses to encrypt or decrypt, characters for string, and int for key
 * Output: My input plain text is: workhard
    My output cipher text is: zrunkdug
    My input cipher text is: zrunkdug
    My output plain text is: workhard

    And 

    My input cipher text is: JHRUJLDIRRWEDOOURFNV
    My output plain text is: GEORGIAFOOTBALLROCKS

 * Postconditions/Assumptions: user chooses to encrypt or decrypt, characters for string, and int for key
 * Contraints: characters for string, and int for key
 * Algorithm: 
 * i Choose to encrypt or decrypt
 * ii. input string
 * iii. choose key
 * iv. output decryption or encryption
 * 
 ****************************************************/
import java.util.Scanner;

public class GoCaesar {

    public static void main(String[] args) throws Exception {
        System.out.println("Enter 'encrypt' to encrypt or 'decrypt' to decrypt:");
        Scanner input = new Scanner(System.in);
        String action = input.nextLine().trim().toLowerCase();

        if (action.equals("encrypt")) {
            // Encryption process
            System.out.println("Enter String to encrypt:");
            String letters = input.nextLine();

            int key = 0;
            while (true) {
                try {
                    System.out.println("Enter Key Number:");
                    key = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Key must be an integer.");
                }
            }

            String encrypted = encrypt(letters, key);
            System.out.println("My input plain text is: " + letters);
            System.out.println("My output cipher text is: " + encrypted);

            // Decrypt the encrypted message
            String decrypted = decrypt(encrypted, key);
            System.out.println("My input cipher text is: " + encrypted);
            System.out.println("My output plain text is: " + decrypted);
        } else if (action.equals("decrypt")) {
            // Decryption process
            System.out.println("Enter String to decrypt:");
            String cipherText = input.nextLine();

            int key = 0;
            while (true) {
                try {
                    System.out.println("Enter Key Number:");
                    key = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Key must be an integer.");
                }
            }

            // Decrypt using decrypt1 method
            String decrypted = decrypt1(cipherText, key);
            System.out.println("My input cipher text is: " + cipherText);
            System.out.println("My output plain text is: " + decrypted);
        } else {
            System.out.println("Invalid action. Please enter 'encrypt' or 'decrypt'.");
        }
    }

    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        // For every letter in the sentence
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) ('a' + (ch - 'a' + key) % 26);
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        // For every letter in the text
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) ('a' + (ch - 'a' - key + 26) % 26);
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decrypt1(String text, int key) {
        StringBuilder result = new StringBuilder();

        // For every letter in the text
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) ('A' + (ch - 'A' - key + 26) % 26);
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
