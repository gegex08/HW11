package gocaesar;

import java.util.Scanner;

public class GoCaesar {

    public static void main(String[] args) throws Exception {
        System.out.println("Enter String:");
        Scanner input = new Scanner(System.in);
        String letters = input.nextLine();

        int key = 0;
        if (key == 0) {
            while (true) {
                try {
                    System.out.println("Enter Key Number:");
                    key = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Key must be an integer.");
                }
            }
        }


        String encrypted = encrypt(letters, key);
        System.out.println("My input plain text is: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("My output cipher text is: " + decrypted);
        
        String encrypted1 = encrypt(letters, key);
        System.out.println("My input plain text is: " + decrypted);

        String decrypted2 = decrypt(encrypted, key);
        System.out.println("My output cipher text is: " + encrypted);
    }

    public static String encrypt(String text, int key) {

        String result = "";//store your choice of words 
        
        //for every letter in the sentence
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);//each letter
            if (Character.isLetter(ch)) {//if it is a character
                char shifted = (char) ('a' + (ch - 'a' + key) % 26);//will keep each char at its ooriginal form
                result += shifted;//move to next char
            } else {
                result += ch;//move to next char
            }
        }

        return result;
    }

    public static String decrypt(String text, int key) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) ('a' + (ch - 'a' - key + 26) % 26);//move every letter to the user input key integer from the alphabet
                result += shifted;
            } else {
                result += ch;
            }
        }

        return result;
}
}