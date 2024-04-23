package gradeleveltest;
import java.io.IOException;

public class GradeLevelTest {

    public static void main(String[] args) throws IOException {
        GradeLevel gradeLevel = new GradeLevel();
        gradeLevel.readFile();

        int WordsInLine = gradeLevel.getNumWords();
        int NumLines = gradeLevel.getNumSentences();
        int syllableCount = gradeLevel.getNumSyllables();
        int gradeLevelValue = gradeLevel.calculateGradeLevel(WordsInLine, NumLines, syllableCount);

        System.out.printf("Number of Words in all  %d lines are %d\n", NumLines, WordsInLine);
        System.out.println("Syllable count: " + syllableCount);
        System.out.println("Grade level: " + gradeLevelValue);
    }
}
