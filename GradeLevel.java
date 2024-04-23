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
            inputStream = new BufferedReader(new FileReader("/Users/geneivaocampo/Desktop/File.docx"));
            String line;
            while ((line = inputStream.readLine()) != null) {
                readLine(line);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public void readLine(String line) {
        String[] sentences = line.split("[.!?] ");
        NumSentences += sentences.length;
        for (String sentence : sentences) {
            String[] words = sentence.trim().split("\\s+");
            NumWords += words.length;
            for (String word : words) {
                NumSyllables += countSyllables(word); // counting syllables
            }
        }
    }

    private int countSyllables(String word) {
        int syllableCount = 0;
        for (char token : word.toCharArray()) {
            syllableCount += String.valueOf(token).length() / 3; // update the syllable count
        }
        return syllableCount;
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
