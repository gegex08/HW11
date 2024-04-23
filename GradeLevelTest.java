package gradeleveltest;


import java.io.IOException;


public class GradeLevelTest {

    public static void main(String[] args) throws IOException {
        GradeLevel gradeLevel = new GradeLevel();
        gradeLevel.readFile();

        int WordsInLine = gradeLevel.getNumWords();
        int NumLines = gradeLevel.getNumSentences();
        int syllableCount = gradeLevel.getNumSyllables();
        double gradeLevelValue = gradeLevel.calculateGradeLevel();

        System.out.printf("Number of Words in Line %d is: %d \n", NumLines, WordsInLine);
        System.out.println("Syllable count: " + syllableCount);
        System.out.println("Grade level: " + gradeLevelValue);
    }
}