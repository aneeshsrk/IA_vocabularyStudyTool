package game;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VocabTool {
    public ArrayList<String> terms;
    public ArrayList<String> definitions;
    public Scanner input;

    public void loadFlashcards(String filePath) {
        terms = new ArrayList<>();
        definitions = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    terms.add(parts[0].trim());
                    definitions.add(parts[1].trim());
                }
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
    public String getDefinition(String termToFind) {
        int index = terms.indexOf(termToFind);
        if (index != -1) {
            return definitions.get(index);
        } else {
            return "Term not found";
        }
    }
}
