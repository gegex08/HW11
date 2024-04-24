package gradeleveltest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GradeLevel {
    private int NumLines = 0;
    private int WordsInLine = 0;
    private int NumWords = 0;
    private int NumSentences = 0;
    private int NumSyllables = 0;

    public void readFile() throws IOException {
        

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("/Users/geneivaocampo/Desktop/File.txt"));
            outputStream = new PrintWriter(new FileWriter("/Users/geneivaocampo/Desktop/File1.txt"));
            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
                printNums(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    
    private void printNums(String sentence) {
        NumLines++;
        String[] sentences = sentence.split("[.!?] ");
        NumSentences += sentences.length;

        String[] words = sentence.split(" ");
        NumWords += words.length;
        
        for (String word : words) {
            System.out.println(word);
            System.out.println("Length: " + word.length());
            System.out.printf("Syllable: %d\n", word.length() / 3);
        }
    }


    public int calculateGradeLevel(int totalWords, int totalSentences, int totalSyllables) {
        double wordsPerSentence = (double) totalWords / totalSentences;
        int gradeLevel = (int) (0.39 * wordsPerSentence + 11.8 * totalSyllables / totalWords - 15.59);
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
