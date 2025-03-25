import java.io.*;
import java.util.*;

public class TeacherFiles {
    public static void main(String[] args) {
        FileReader fReader = null;
        Scanner inData = null;
        FileWriter fWriter = null;
        PrintWriter out = null;
        double pay = 0;
        double hours = 0;
        double check = 0;
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        int index = -1;
// Connects to input file
        try {
            fReader = new FileReader("Employee.txt");
            inData = new Scanner(fReader);
        } catch(IOException e) {
            System.out.println("Error opening input file: " + e);
            System.exit(1);
        }
// Connects to output file
        try {
            fWriter = new FileWriter("EmployeePay.txt", true);
            out = new PrintWriter(fWriter);
        } catch(IOException e) {
            System.out.println("Error opening output file " + e);
            System.exit(1);
        }

// Takes words from file, separates them, takes out the hours and pay rate, and then prints out the info
        while(inData.hasNextLine()) {
            index++;
            String line = inData.nextLine();
            line = line.trim();
            String[] words = line.split("\\;+");
            teachers.add(new Teacher());
            teachers.get(index).calculateValues(words);
            out.println(teachers.get(index).getId() + ";" + teachers.get(index).getName() + "; " + teachers.get(index).getCheck() + ";");
        }
// Closes program
        try {
            fReader.close();
            fWriter.close();
        } catch(IOException e) {
            System.out.println("Error closing files: " + e);
            System.exit(1);
        }
    }
}