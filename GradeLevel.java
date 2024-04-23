package gradeleveltest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class GradeLevel {
    int NumWords = 0;
    int NumSentences = 0;
    int NumSyllables = 0;

    public void readFile() throws IOException {
        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader("/Users/geneivaocampo/Desktop/Hello Genny.pdf"));
            String line;
            while ((line = inputStream.readLine()) != null) {
                processLine(line);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public void processLine(String line) {
        String[] sentences = line.split("[.!?] ");
        NumSentences += sentences.length;
        for (String sentence : sentences) {
            String[] words = sentence.trim().split("\\s+");
            NumWords += words.length;
            for (String word : words) {
                NumSyllables += word.length() / 3; //formula for syllables
                 
            }
        }
    }
    

    public double calculateGradeLevel() {
        return 0.39 * ((double) NumWords / NumSentences) + 11.8 * ((double) NumSyllables / NumWords) - 15.59;
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