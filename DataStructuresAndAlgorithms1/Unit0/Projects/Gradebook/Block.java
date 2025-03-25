import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Block {
    String letter;
    ArrayList<Student> roster = new ArrayList<Student>();
    ArrayList<GradeType> gradeTypes = new ArrayList<GradeType>();

    public Block(String tempLetter) {
        letter = tempLetter;
    }
    // Allows main to view letter
    public String getLetter() {
        return letter;
    }
    // Used when editing block
    public void editLetter(String newLetter) {
        letter = newLetter;
    }
    // Used when accessing block's data
// Starts next series of prompts
    public void enterBlock(Scanner Scan) {
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        while(true) {
            System.out.println("Here is your student roster: \n");
            for(int i = 0; i < roster.size(); i++) {
                System.out.println(roster.get(i).getName() + ": " + roster.get(i).getLetterAverage());
            }
            System.out.println("\nWould you like to add, edit, delete, or select a student? If you would like to edit assessment types, please enter \"assessment.\" Enter \"exit\" to go back. \n");
            String ans = Scan.nextLine();
            ans = ans.toUpperCase();
            if(ans.equals("EXIT")) {
                break;
            } else if(ans.equals("ADD")) {
                addStudent(gradeTypes, roster, Scan);
            } else if(ans.equals("EDIT")) {
                editStudent(roster, Scan);
            } else if(ans.equals("DELETE")) {
                deleteStudent(roster, Scan);
            } else if(ans.equals("SELECT")) {
                selectStudent(roster, Scan);
            } else if(ans.equals("ASSESSMENT")) {
                assessment(gradeTypes, roster, Scan);
            } else {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Please enter one of the following options:");
                System.out.println("add");
                System.out.println("edit");
                System.out.println("delete");
                System.out.println("select");
                System.out.println("assessment");
                System.out.println("exit \n");
            }
        }
    }
    // Adds student
    public static void addStudent(ArrayList<GradeType> gradeTypes, ArrayList<Student> roster, Scanner Scan) {
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        while(true) {
            System.out.println("Here is your student roster: \n");
            for(int i = 0; i < roster.size(); i++) {
                System.out.println(roster.get(i).getName() + ": " + roster.get(i).getLetterAverage());
            }
            System.out.println("\nPlease enter the name of the student you would like to add (Last, First). Enter \"cancel\" to exit. \n");
            String ans = Scan.nextLine().toUpperCase();
            if(ans.equals("CANCEL")) {
                System.out.println("———–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
                break;
            } else {
                boolean copy = false;
                for(int i = 0; i < roster.size(); i++) {
                    if(roster.get(i).getName().equals(ans)) {
                        copy = true;
                        break;
                    }
                }
                if(copy) {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter a name that isn't already used. \n");
                } else if(ans.contains(", ")) {
                    String[] names = ans.split("\\, +");
                    roster.add(new Student(names[0], names[1], gradeTypes));
                    System.out.println("———–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
                    break;
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter in format: Last, First");
                }
            }
        }
    }
    // Edits a student's name
    public static void editStudent(ArrayList<Student> roster, Scanner Scan) {
        if(roster.size() < 1) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no students to edit. \n");
        } else {
            String temp = "";
            boolean run = true;
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            while(run) {
                System.out.println("Here is your student roster: \n");
                for(int i = 0; i < roster.size(); i++) {
                    System.out.println(roster.get(i).getName() + ": " + roster.get(i).getLetterAverage());
                    temp += roster.get(i).getName() + " ";
                }
                System.out.println("\nPlease choose which student to edit. Enter \"cancel\" to exit. \n");
                String ans = Scan.nextLine().toUpperCase();
                if(ans.equals("CANCEL")) {
                    System.out.println("———–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
                    break;
                } else if(temp.contains(ans + " ")) {
                    int index = -1;
                    for(int i = 0; i < roster.size(); i++) {
                        if(roster.get(i).getName().equals(ans)) {
                            index = i;
                            break;
                        }
                    }
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("What would you like to change their name to (Last, First)? Enter \"cancel\" to go back. \n");
                    String ans1 = Scan.nextLine().toUpperCase();
                    if(ans1.equals("CANCEL")) {
                        System.out.println("———–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
                        break;
                    } else if(temp.contains(ans1 + " ")) {
                        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                        System.out.println("Please enter a name that is not already used. \n");
                    } else if(ans1.contains(", ")) {
                        String[] names = ans1.split("\\, +");
                        roster.get(index).editName(names[0], names[1]);
                        run = false;
                        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                        break;
                    } else {
                        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                        System.out.println("Please enter in format: Last, First");
                    }
                }
            }
        }
    }
    // Deletes student
    public static void deleteStudent(ArrayList<Student> roster, Scanner Scan) {
        if(roster.size() < 1) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no students to edit. \n");
        } else {
            boolean run = true;
            String temp = "";
            while(run) {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Here is your student roster: \n");
                for(int i = 0; i < roster.size(); i++) {
                    System.out.println(roster.get(i).getName() + ": " + roster.get(i).getLetterAverage());
                    temp += roster.get(i).getName();
                }
                System.out.println("\nChoose which student to delete or enter \"cancel\" to exit. \n");
                String ans = Scan.nextLine().toUpperCase();
                if(ans.equals("CANCEL")) {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    break;
                } else if(temp.contains(ans)) {
                    int index = -1;
                    for(int i = 0; i < roster.size(); i++) {
                        if(roster.get(i).getName().equals(ans)) {
                            roster.remove(i);
                            run = false;
                            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                            break;
                        }
                    }
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter a listed name or enter \"cancel.\"");
                }
            }
        }
    }
    // Allows user to access student's data
    public static void selectStudent(ArrayList<Student> roster, Scanner Scan) {
        if(roster.size() < 1) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no students to select. \n");
        } else {
            String temp = "";
            while(true) {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Here is your student roster: \n");
                for(int i = 0; i < roster.size(); i++) {
                    System.out.println(roster.get(i).getName() + ": " + roster.get(i).getLetterAverage());
                    temp += roster.get(i).getName() + " ";
                }
                System.out.println("\nSelect a student or enter \"cancel\" to exit. \n");
                String ans = Scan.nextLine().toUpperCase();
                if(ans.equals("CANCEL")) {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    break;
                } else if(temp.contains(ans)) {
                    for(int i = 0; i < roster.size(); i++) {
                        if(roster.get(i).getName().equals(ans)) {
                            roster.get(i).enterStudent(Scan);
                            break;
                        }
                    }
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter a listed name or enter \"cancel.\"");
                }
            }
        }
    }
    // Section for when user wants to access the assessment types
    public static void assessment(ArrayList<GradeType> gradeTypes, ArrayList<Student> roster, Scanner Scan) {
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        while(true) {
            System.out.println("Here are your current assessment types:");
            for(int i = 0; i < gradeTypes.size(); i++) {
                System.out.println(gradeTypes.get(i).getName() + ": " + (gradeTypes.get(i).getWeight() * 100) + "%");
            }
            System.out.println("\nWould you like to add, edit, or delete an assessment type? If you would like to edit the weighting, enter \"weight.\" Enter \"cancel\" to exit. \n");
            String ans = Scan.nextLine().toUpperCase();
            if(ans.equals("CANCEL")) {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                break;
            } else if(ans.equals("ADD")) {
                addType(gradeTypes, Scan);
                update(gradeTypes, roster);
            } else if(ans.equals("EDIT")) {
                editType(gradeTypes, Scan);
                update(gradeTypes, roster);
            } else if(ans.equals("DELETE")) {
                deleteType(gradeTypes, Scan);
                update(gradeTypes, roster);
            } else if(ans.equals("WEIGHT")) {
                editWeight(gradeTypes, Scan);
                update(gradeTypes, roster);
            } else {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Please enter one of the following:");
                System.out.println("add");
                System.out.println("edit");
                System.out.println("delete");
                System.out.println("weight");
                System.out.println("cancel \n");
            }
        }
    }
    // Adds assessment type
    public static void addType(ArrayList<GradeType> gradeTypes, Scanner Scan) {
        String temp = "";
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        while(true) {
            System.out.println("Here is your list of assessment types:");
            for(int i = 0; i < gradeTypes.size(); i++) {
                System.out.println(gradeTypes.get(i).getName());
                temp += gradeTypes.get(i).getName();
            }
            System.out.println("\nPlease enter the name of the new assessment type. Enter \"cancel\" to exit. \n");
            String ans = Scan.nextLine().toUpperCase();
            if(ans.equals("CANCEL")) {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                break;
            } else if(temp.contains(ans)) {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Please enter a name not already chosen. \n");
            } else {
                gradeTypes.add(new GradeType(ans));
                editWeight(gradeTypes, Scan);
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                break;
            }
        }
    }
    // Edit assessment type's name
    public static void editType(ArrayList<GradeType> gradeTypes, Scanner Scan) {
        if(gradeTypes.size() < 1) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no assessment types to edit. \n");
        } else {
            String temp = "";
            boolean run = true;
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            while(run) {
                System.out.println("Here are your assessment types:");
                for(int i = 0; i < gradeTypes.size(); i++) {
                    System.out.println(gradeTypes.get(i).getName());
                    temp += gradeTypes.get(i).getName() + " ";
                }
                System.out.println("\nWhich assessment type would you like to edit? Enter \"cancel\" to exit.  \n");
                String ans = Scan.nextLine().toUpperCase();
                if(ans.equals("CANCEL")) {
                    break;
                } else if(temp.contains(ans + " ")) {
                    int index = -1;
                    for(int i = 0; i < gradeTypes.size(); i++) {
                        if(gradeTypes.get(i).getName().equals(ans)) {
                            index = i;
                            break;
                        }
                    }
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    while(true) {
                        System.out.println("What would you like to change the name to? Enter \"cancel\" to go back. \n");
                        String ans1 = Scan.nextLine().toUpperCase();
                        if(ans1.equals("CANCEL")) {
                            break;
                        } else if(temp.contains(ans1 + " ")) {
                            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                            System.out.println("Please enter a name not already chosen. \n");
                        } else {
                            gradeTypes.get(index).editName(ans1);
                            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                            run = false;
                            break;
                        }
                    }
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter one of the listed name. \n");
                }
            }
        }
    }
    // Deletes assessment type
    public static void deleteType(ArrayList<GradeType> gradeTypes, Scanner Scan) {
        if(gradeTypes.size() < 1) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no assessment types to delete. \n");
        } else {
            boolean run = true;
            String temp = "";
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            while(run) {
                System.out.println("Here are your assessment types:");
                for(int i = 0; i < gradeTypes.size(); i++) {
                    System.out.println(gradeTypes.get(i).getName());
                    temp += gradeTypes.get(i).getName() + " ";
                }
                System.out.println("\nWhich assessment type would you like to delete. Enter \"cancel\" to exit. \n");
                String ans = Scan.nextLine().toUpperCase();
                if(ans.equals("CANCEL")) {
                    break;
                } else if(temp.contains(ans + " ")) {
                    for(int i = 0; i < gradeTypes.size(); i++) {
                        if(gradeTypes.get(i).getName().equals(ans)) {
                            gradeTypes.remove(i);
                            editWeight(gradeTypes, Scan);
                            run = false;
                            break;
                        }
                    }
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter a list name. \n");
                }
            }
        }
    }
    // Edit assessment types' weight curves
    public static void editWeight(ArrayList<GradeType> gradeTypes, Scanner Scan) {
        if(gradeTypes.size() < 1) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no assessment types to edit the weight of.");
        } else {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("Here are your current as types and their grade weight:");
            for(int i = 0; i < gradeTypes.size(); i++) {
                System.out.println(gradeTypes.get(i).getName() + ": " + (gradeTypes.get(i).getWeight() * 100) + "%");
            }
            System.out.println("\nPlease enter the new weight you would like for each prompted type. Enter as a percent, i.e. \"54\" \n");
            while(true) {
                double total = 0;
                for(int i = 0; i < gradeTypes.size(); i++) {
                    while(true) {
                        System.out.println(gradeTypes.get(i).getName() + ":");
                        String ans = Scan.nextLine();
                        boolean isNum = true;
                        for(int x = 0; x < ans.length(); x++) {
                            if(!(Character.isDigit(ans.charAt(x)) || ans.charAt(x) == '.')) {
                                isNum = false;
                            }
                        }
                        if(isNum) {
                            gradeTypes.get(i).editWeight(Double.parseDouble(ans) / 100);
                            total += Double.parseDouble(ans);
                            break;
                        } else {
                            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                            System.out.println("Please enter a number. \n");
                        }
                    }
                }
                if(total != 100) {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please make sure the percentages add up to 100. \n");
                } else {
                    break;
                }
            }
        }
    }
    // Updates assessment type for each student
    public static void update(ArrayList<GradeType> gradeTypes, ArrayList<Student> roster) {
        for(int i = 0; i < roster.size(); i++) {
            roster.get(i).updateGradeTypes(gradeTypes);
        }
    }
    // Allows blocks to access the roster
    public ArrayList<Student> getRoster() {
        return roster;
    }
    // Allows blocks to access the assessment types
    public ArrayList<GradeType> getGradeTypes() {
        return gradeTypes;
    }
}