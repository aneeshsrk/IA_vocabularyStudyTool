package game;
import java.util.Scanner;

public class VocabLearner extends VocabTool{
    public void learnVocab() {
        boolean hasRanOnce = false;
        while (true) {
            if (hasRanOnce == false) {
                System.out.println("[Term List]: ");
                System.out.println("-----------"); 
                for(int i = 0; i < terms.size(); i++) {
                    int number = i + 1;
                    System.out.println("| " + number + "." + terms.get(i));
                }
                System.out.println("-----------"); 
            }
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the term you would like to learn the definition of (type 'quit' to enter the test):");
            String term = input.nextLine();
            if (term.equals("quit")) {
                System.out.println("You have quit the learning tool.");
                break;
            }
            System.out.println("[Defintion]: " + getDefinition(term));
            System.out.println("-----------");   
            hasRanOnce = true;
        }
    }
}
