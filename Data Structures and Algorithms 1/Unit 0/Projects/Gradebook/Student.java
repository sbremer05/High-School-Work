import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Student {
    String lastName;
    String firstName;
    ArrayList<GradeType> gradeTypes = new ArrayList<GradeType>();
    double average = -1;
    String letterAverage;

    public Student(String tempLName, String tempFName, ArrayList<GradeType> tempgradeTypes) {
        lastName = tempLName;
        firstName = tempFName;
        gradeTypes = tempgradeTypes;
    }

    public Student(String tempLName, String tempFName) {
        lastName = tempLName;
        firstName = tempFName;
    }
    // Allows block to access student's name
    public String getName() {
        return lastName + ", " + firstName;
    }
    // Used for editing student's name by block
    public void editName(String newLName, String newFName) {
        lastName = newLName;
        firstName = newFName;
    }
    // Used to get average (easier to store the number than the letter, less error)
    public double getAverage() {
        calcAverage();
        return average;
    }
    // Used to get letter grade
    public String getLetterAverage() {
        calcAverage();
        return letterAverage;
    }
    // Calculates average and letter grade
    public void calcAverage() {
        double tempAverage = 0;
        double rebalance = 0;
        for(int i = 0; i < gradeTypes.size(); i++) {
            if(gradeTypes.get(i).getGradeList().size() > 0) {
                rebalance += gradeTypes.get(i).getWeight();
                tempAverage += gradeTypes.get(i).getAverage();
            }
        }
        average = tempAverage / rebalance;
        if(average >= .97) {
            letterAverage = "A+";
        } else if(average >= .93) {
            letterAverage = "A";
        } else if(average >= .90) {
            letterAverage = "A-";
        } else if(average >= .87) {
            letterAverage = "B+";
        } else if(average >= .83) {
            letterAverage = "B";
        } else if(average >= .80) {
            letterAverage = "B-";
        } else if(average >= .77) {
            letterAverage = "C+";
        } else if(average >= .73) {
            letterAverage = "C";
        } else if(average >= .70) {
            letterAverage = "C-";
        } else if(average >= .67) {
            letterAverage = "D+";
        } else if(average >= .63) {
            letterAverage = "D";
        } else if(average >= .60) {
            letterAverage = "D-";
        } else if(average >= 0) {
            letterAverage = "F";
        } else {
            letterAverage = "N/A";
        }
    }
    // Used by block to update student's assessment types and their weight
// Does not interfere with individual assessments, unless assessment type is deleted
    public void updateGradeTypes(ArrayList<GradeType> newGradeTypes) {
        if(gradeTypes.size() == newGradeTypes.size()) {
            for(int i = 0; i < gradeTypes.size(); i++) {
                gradeTypes.get(i).editName(newGradeTypes.get(i).getName());
                gradeTypes.get(i).editWeight(newGradeTypes.get(i).getWeight());
            }
        } else if(gradeTypes.size() < newGradeTypes.size()) {
            for(int i = 0; i < gradeTypes.size(); i++) {
                gradeTypes.get(i).editName(newGradeTypes.get(i).getName());
                gradeTypes.get(i).editWeight(newGradeTypes.get(i).getWeight());
            }
            for(int i = gradeTypes.size(); i < newGradeTypes.size(); i++) {
                gradeTypes.add(new GradeType(newGradeTypes.get(i).getName(), newGradeTypes.get(i).getWeight()));
            }
        } else {
            for(int i = 0; i < newGradeTypes.size(); i++) {
                gradeTypes.get(i).editName(newGradeTypes.get(i).getName());
                gradeTypes.get(i).editWeight(newGradeTypes.get(i).getWeight());
            }
            for(int i = newGradeTypes.size(); i < gradeTypes.size(); i++) {
                gradeTypes.remove(i);
            }
        }
    }
    // Allows block to access student data
// Next series of prompts
    public void enterStudent(Scanner Scan) {
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        while(true) {
            System.out.println("Here is " + firstName + " " + lastName + "'s average: " + getLetterAverage());
            System.out.println("\nWould you like to add grade, edit assessment/grade, delete grade, or view grades? Enter \"exit\" to go back. \n");
            String ans = Scan.nextLine().toUpperCase();
            if(ans.equals("EXIT")) {
                break;
            } else if(ans.equals("ADD")) {
                addGrade(Scan);
            } else if(ans.equals("EDIT")) {
                editGrade(Scan);
            } else if(ans.equals("DELETE")) {
                deleteGrade(Scan);
            } else if(ans.equals("VIEW")) {
                viewGrades(Scan);
            } else {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Please enter one of the following:");
                System.out.println("add");
                System.out.println("edit");
                System.out.println("delete");
                System.out.println("view");
                System.out.println("exit \n");
            }
        }
    }
    // Adds assessment -> will go to gradeType for given type of assessment
    public void addGrade(Scanner Scan) {
        if(gradeTypes.size() < 1) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no assessment types to choose from. \n");
        } else {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            boolean run = true;
            while(run) {
                String temp = "";
                System.out.println("What type of assessment would you like to add? Enter \"cancel\" to exit.");
                for(int i = 0; i < gradeTypes.size(); i++) {
                    System.out.println(gradeTypes.get(i).getName());
                    temp += gradeTypes.get(i).getName() + " ";
                }
                System.out.println();
                String ans = Scan.nextLine().toUpperCase();
                if(ans.equals("CANCEL")) {
                    break;
                } else if(temp.contains(ans + " ")) {
                    for(int i = 0; i < gradeTypes.size(); i++) {
                        if(gradeTypes.get(i).getName().equals(ans)) {
                            gradeTypes.get(i).createGrade(Scan);
                            run = false;
                            break;
                        }
                    }
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter one of the listed assessment types or enter \"cancel.\" \n");
                }
            }
        }
    }
    // Edits assessment -> will go to gradeType for given type of assessment
// Prompts to either edit assessment name or grade
    public void editGrade(Scanner Scan) {
        if(gradeTypes.size() < 1) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no assessment types to choose from. \n");
        } else {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            boolean run = true;
            while(run) {
                String temp = "";
                System.out.println("What type of assessment would you like to edit? Enter \"cancel\" to exit.");
                for(int i = 0; i < gradeTypes.size(); i++) {
                    System.out.println(gradeTypes.get(i).getName());
                    temp += gradeTypes.get(i).getName() + " ";
                }
                System.out.println();
                String ans = Scan.nextLine().toUpperCase();
                if(ans.equals("CANCEL")) {
                    break;
                } else if(temp.contains(ans + " ")) {
                    for(int i = 0; i < gradeTypes.size(); i++) {
                        if(gradeTypes.get(i).getName().equals(ans)) {
                            gradeTypes.get(i).editGrade(Scan);
                            run = false;
                            break;
                        }
                    }
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter one of the listed assessment types or enter \"cancel.\" \n");
                }
            }
        }
    }
    // Deletes assessment -> will go to gradeType for given type of assessment
    public void deleteGrade(Scanner Scan) {
        if(gradeTypes.size() < 1) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no assessment types to choose from. \n");
        } else {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            boolean run = true;
            while(run) {
                String temp = "";
                System.out.println("What type of assessment would you like to delete? Enter \"cancel\" to exit.");
                for(int i = 0; i < gradeTypes.size(); i++) {
                    System.out.println(gradeTypes.get(i).getName());
                    temp += gradeTypes.get(i).getName() + " ";
                }
                System.out.println();
                String ans = Scan.nextLine().toUpperCase();
                if(ans.equals("CANCEL")) {
                    break;
                } else if(temp.contains(ans + " ")) {
                    for(int i = 0; i < gradeTypes.size(); i++) {
                        if(gradeTypes.get(i).getName().equals(ans)) {
                            gradeTypes.get(i).deleteGrade(Scan);
                            run = false;
                            break;
                        }
                    }
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter one of the listed assessment types or enter \"cancel.\" \n");
                }
            }
        }
    }
    // Allows user to view all the grades
    public void viewGrades(Scanner Scan) {
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        System.out.println("Here are " + firstName + " " + lastName + "'s grades:");
        for(int i = 0; i < gradeTypes.size(); i++) {
            System.out.println(gradeTypes.get(i).getName() + ":");
            System.out.println("———–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
            for(int x = 0; x < gradeTypes.get(i).getGradeList().size(); x++) {
                System.out.println(gradeTypes.get(i).getGradeList().get(x).getName() + ": " + (gradeTypes.get(i).getGradeList().get(x).getGrade() * 100) + "%");
            }
            System.out.println();
        }
        System.out.println("Enter anything to quit.");
        while(true) {
            String ans = Scan.nextLine();
            if(ans.length() > 0) {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                break;
            }
        }
    }
    // Allows blocks to access the students assessment types
// Helpful when needing assessments
    public ArrayList<GradeType> getGradeTypes() {
        return gradeTypes;
    }
}