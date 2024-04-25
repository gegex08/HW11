package gradeleveltest;

/****************************************************
 * Programmer: Geneiva Ocampo
 * Course CSCI 1471
 * Date 04/24/2024
 * Assignment: Homework #10
 * Environment Java with Netbeans
 * Files Included: GradeLevel and GradeLevelTest and File.txt
 * Purpose: Get the Gradelevel based on flesh Kincaid grade level formula 

* Input: File.txt, Gettysburg.txt, declaration.txt, and green_eggs_and_ham.txt
 * Preconditions/ Assumptions:the number of syllables for each word is the number of letters in the word divided by three Use integer math to calculate the number of syllables for each word
 * Output: number of words, number of sentences, number of syllables and Kincaid Grade Level
 * Postconditions/Assumptions: File Inputs
 * Contraints: This program requires two classes  GradeLevel and GradeLevelTest  GradeLevel will be the repository for all methods other than main, used in the grade level calculations Examples  processLine, wordCount, sentenceCount, numberSyllables, ,,,.  GradeLevelTest will have the main method.
 * Algorithm: 
 * 1.	Ask app to read file from file path
    2.	Get number of sentences 
    3.	Get number of line, length, syllables words total of Syllables and grade

 * 
 ****************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GradeLevel {
    public int NumLines = 0;
    public int WordsInLine = 0;
    public int NumWords = 0;
    public int NumSentences = 0;
    public int NumSyllables = 0;

    public void readFile() throws IOException {
        

        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("/Users/geneivaocampo/Desktop/declaration.txt"));
            String l;
            while ((l = inputStream.readLine()) != null) {
                printNums(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

        }
    }

    
    public void printNums(String sentence) {
        
        NumLines++;
        String[] sentences = sentence.split("[.!?]");
        NumSentences += sentences.length;

        String[] words = sentence.split(" ");
        NumWords += words.length;
        
        for (String word : words) {
            NumSyllables += countSyllables(word);
            System.out.println("Line " + NumLines + ": " + sentence);
            System.out.println("Length: " + word.length());
            System.out.printf("Syllable: %d\n", word.length() / 3);
        }
        
        
        
    }
    public int countSyllables(String word) {
    if (word.equals(0)) {
        return 0;
    }

    int syllables = word.length() / 3;

    if (word.length() % 3 != 0) {
        syllables++;
    }
    else
    {
        return syllables+1;
    }
    return syllables;
    
}
    


    public double calculateGradeLevel(double totalWords, double totalSentences, double totalSyllables) {

    double gradeLevel = 0.39 * (totalWords / totalSentences) + 11.8 * (totalSyllables / totalWords) - 15.59;
        return gradeLevel;
    }

    
    
    public int getNumWords() {
        return NumWords;
    }

    public int getNumSentences() {
        return NumSentences;
    }

    public int getNumSyllables() {
        return NumSyllables;
    }
}