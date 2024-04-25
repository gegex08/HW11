package gradeleveltest;

/****************************************************
 * Programmer: Geneiva Ocampo
 * Course CSCI 1471
 * Date 04/24/2024
 * Assignment: Homework #10
 * Environment Java with Netbeans
 * Files Included: GradeLevel and GradeLevelTest File.txt
 * 
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
import java.io.IOException;

public class GradeLevelTest {

        public static void main(String[] args) throws IOException {
        GradeLevel gradeLevel = new GradeLevel();
        gradeLevel.readFile();

        int WordsInLine = gradeLevel.getNumWords();
        int NumLines = gradeLevel.getNumSentences();
        int syllableCount = gradeLevel.getNumSyllables();
        double gradeLevelValue = gradeLevel.calculateGradeLevel(WordsInLine, NumLines, syllableCount);

        
        System.out.println("");
        System.out.printf("Number of Words in all  %d lines are %d\n", NumLines, WordsInLine);
        System.out.println("Syllable count: " + syllableCount);
        System.out.printf("Grade level: %.0f\n", gradeLevelValue);
    }

}