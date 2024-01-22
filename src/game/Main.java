package game;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the flashcard tool! Enter the file path of the file you would like to use (type 'none' if the default path is sufficient):");
        String filePath = input.nextLine();
        if (filePath.equals("none")) {
            filePath = "/Users/aneeshramakrishnan/VS Code Projects /Java School Projects/studyToolModified/src/game/data.txt";
        }

        VocabTester tester = new VocabTester();
        VocabLearner learner = new VocabLearner();

        learner.loadFlashcards(filePath);
        learner.learnVocab();
        tester.loadFlashcards(filePath);
        tester.testVocab();
        input.close();
    }

}
