import java.io.*;
import java.util.*;

public class WorkingWithFiles {
    public static void main(String[] args) {
        FileReader fReader = null;
        Scanner inData = null;
        FileWriter fWriter = null;
        PrintWriter out = null;

        try {
            fReader = new FileReader("HelloWord.txt");
            inData = new Scanner(fReader);
        } catch(IOException e) {
            System.out.println("Error opening input file: " + e);
            System.exit(1);
        }
        try {
            fWriter = new FileWriter("WordsList.txt");
            out = new PrintWriter(fWriter, true);
        } catch(IOException e) {
            System.out.println("Error opening output file " + e);
            System.exit(1);
        }

        // Work with files will go
        while(inData.hasNextLine()) {
            String line = inData.nextLine();
            line = line.trim();
            String[] words = line.split("\\s+");
            for(int i = 0; i < words.length; i++) {
                out.println("#" + (i + 1) + ": " + words[i]);
            }
        }

        try {
            fReader.close();
            fWriter.close();
        } catch(IOException e) {
            System.out.println("Error closing files: " + e);
            System.exit(1);
        }
    }
}