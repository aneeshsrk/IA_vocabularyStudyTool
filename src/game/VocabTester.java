package game;

import java.util.Scanner;
import java.util.ArrayList;

public class VocabTester extends VocabTool{
    public void testVocab() {
        ArrayList<String> wrongTerms = terms;
        ArrayList<String> wrongDefinitions = definitions;

        int numAnswered = 0;
        int scoreTotal = 0;
        boolean hasRanOnce = false;

        System.out.println("");
        System.out.println("Welcome to the 'Test' portion of the study tool!");
        System.out.println("Enter 'quit' if you would like to quit the test, and your score will be calculated based on the terms you have done.");
        System.out.println("Good luck!");
        System.out.println(""); 
        
        do {
            String term = "";
            String randomDef = "";
            Scanner input = new Scanner(System.in);
            int index = 0; 
            if(wrongTerms.size() == 0) {
                scoreTotal(scoreTotal, numAnswered);
                break; 
            }
            if (hasRanOnce == false) {
                System.out.println("[Term List]: ");
                System.out.println("-----------"); 
                for(int i = 0; i < terms.size(); i++) {
                    int number = i + 1;
                    System.out.println("| " + number + "." + terms.get(i));
                }
                System.out.println("-----------"); 
            }
            else{
                System.out.println(wrongTerms); 
            }
            index = (int) (Math.random() * terms.size());
            randomDef = wrongDefinitions.get(index);
            System.out.println("Definition: " + randomDef);

            System.out.println("Enter your answer here(type 'quit' to quit the test):");
            term = input.nextLine();
            if (term.equals("quit")) {
                System.out.println("You have quit the test.");
                if(numAnswered == 0) {
                    System.out.println("Since you have not answered any terms, your score is a 0.");
                }
                else{
                    scoreTotal(scoreTotal, numAnswered);
                }
                break;
            } 
            else {
                if (terms.indexOf(term) == definitions.indexOf(randomDef)) {
                    System.out.println("***********"); 
                    System.out.println(" Correct!! ");
                    System.out.println("***********"); 
                    scoreTotal += 100;
                    removeTerms(index, wrongTerms, wrongDefinitions);
                    numAnswered++;
                } 
                else if (terms.indexOf(term) != definitions.indexOf(randomDef)) {
                    System.out.println("***********"); 
                    System.out.println("Incorrect!!");
                    System.out.println("***********"); 
                    numAnswered++;
                }   
            }
            hasRanOnce = true;   
        } while(numAnswered != 0);
    }

    private void removeTerms(int index, ArrayList<String> cT, ArrayList<String> cD) {
        cT.remove(index);
        cD.remove(index);     
    }
    private void scoreTotal(int scoreTotal, int numAnswered) {
        double score = Math.round(scoreTotal / numAnswered);
        System.out.println("You have answered all the terms correctly! Your score is a " + score);
        if(score >= 90) {
            System.out.println("You got an A!");
        } else if (score >= 80) {
            System.out.println("You got a B!");
        } else if (score >= 70) {
            System.out.println("You got a C! It might be good to study the terms again.");
        } else if (score >= 60) {
            System.out.println("You did very poorly, you should DEFINETLY study the terms again.");
        }
    }
}
