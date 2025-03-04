import java.io.*;
import java.util.*;
import java.util.Scanner;

public class GradeType {
    String name;
    double weight;
    double average;
    ArrayList<Assessment> assessments = new ArrayList<Assessment>();

    public GradeType(String tempName) {
        name = tempName;
    }

    public GradeType(String tempName, double tempWeight) {
        name = tempName;
        weight = tempWeight;
    }
    // Allows student and block to access assessment type's name
    public String getName() {
        return name;
    }
    // Used to edit assessment type's name
    public void editName(String newName) {
        name = newName;
    }
    // Allows student and block to access weighting
    public double getWeight() {
        return weight;
    }
    // Used to edit weighting
    public void editWeight(double newWeight) {
        weight = newWeight;
    }
    // Used by student to receive each assessment type's omponent to the average (i.e.its 10% of grade)
    public double getAverage() {
        calcAverage();
        return average;
    }
    // Calculates assessment type's component to the average
    public void calcAverage() {
        double total = 0;
        for(int i = 0; i < assessments.size(); i++) {
            total += assessments.get(i).getGrade();
        }
        average = (total / assessments.size()) * weight;
    }
    // Creates assessment
    public void createGrade(Scanner Scan) {
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        boolean run = true;
        while(run) {
            String temp = "";
            System.out.println("Here are your current " + name + " assessments:");
            for(int i = 0; i < assessments.size(); i++) {
                System.out.println(assessments.get(i).getName() + ": " + (assessments.get(i).getGrade() * 100));
                temp += assessments.get(i).getName() + " ";
            }
            System.out.println("\nPlease enter the name of the new assessment. Enter \"cancel\" to exit. \n");
            String ans = Scan.nextLine().toUpperCase();
            if(ans.equals("CANCEL")) {
                break;
            } else if(temp.contains(ans + " ")) {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Please enter a name not already taken. \n");
            } else {
                while(run) {
                    int index = assessments.size() - 1;
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter the grade this student has received as a percent, i.e. \"80\" \n");
                    String ans1 = Scan.nextLine();
                    boolean isNum = true;
                    for(int i = 0; i < ans1.length(); i++) {
                        if(!(Character.isDigit(ans1.charAt(i)) || ans1.charAt(i) == '.')) {
                            isNum = false;
                            break;
                        }
                    }
                    if(isNum) {
                        assessments.add(new Assessment(ans, Double.parseDouble(ans1) / 100));
                        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                        run = false;
                        break;
                    } else {
                        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                        System.out.println("Please enter a number. \n");
                    }
                }
            }
        }
    }
    // Edits assessment, either the name or grade
    public void editGrade(Scanner Scan) {
        if(assessments.size() < 1 ) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no assessments to edit. \n");
        } else {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            while(true) {
                System.out.println("Here are your current " + name + " assessments:");
                for(int i = 0; i < assessments.size(); i++) {
                    System.out.println(assessments.get(i).getName() + ": " + (assessments.get(i).getGrade() * 100));
                }
                System.out.println("\nWould you like to edit an assessment's name or a grade? Enter \"cancel\" to exit. \n");
                String ans = Scan.nextLine().toUpperCase();
                if(ans.equals("CANCEL")) {
                    break;
                } else if(ans.equals("NAME")) {
                    editAssessmentName(Scan);
                    break;
                } else if(ans.equals("GRADE")) {
                    editAssessmentGrade(Scan);
                    break;
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter one of the following:");
                    System.out.println("name");
                    System.out.println("grade");
                    System.out.println("cancel \n");
                }
            }
        }
    }
    // Edits assessment's name
    public void editAssessmentName(Scanner Scan) {
        boolean run = true;
        String temp = "";
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        while(run) {
            System.out.println("Here are your assessments:");
            for(int i = 0; i < assessments.size(); i++) {
                System.out.println(assessments.get(i).getName());
                temp += assessments.get(i).getName() + " ";
            }
            System.out.println("\nWhich assessment's name would you like to edit? Enter \"cancel\" to exit. \n");
            String ans = Scan.nextLine().toUpperCase();
            if(ans.equals("CANCEL")) {
                break;
            } else if(temp.contains(ans + " ")) {
                int index = -1;
                for(int i = 0; i < assessments.size(); i++) {
                    if(assessments.get(i).getName().equals(ans)) {
                        index = i;
                        break;
                    }
                }
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                while(true) {
                    System.out.println("What would you like to change the assessment's name to? Enter \"cancel\" to go back. \n");
                    String ans1 = Scan.nextLine().toUpperCase();
                    if(ans1.equals("CANCEL")) {
                        break;
                    } else if(temp.contains(ans1 + " ")) {
                        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                        System.out.println("Please enter a name not already used. \n");
                    } else {
                        assessments.get(index).editName(ans1);
                        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                        run = false;
                        break;
                    }
                }
            } else {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Please enter one of the listed names or enter \"cancel.\" \n");
            }
        }
    }
    // Edits assessment's grade
    public void editAssessmentGrade(Scanner Scan) {
        boolean run = true;
        String temp = "";
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        while(run) {
            System.out.println("Here are your assessments and their grades:");
            for(int i = 0; i < assessments.size(); i++) {
                System.out.println(assessments.get(i).getName() + ": " + (assessments.get(i).getGrade() * 100));
                temp += assessments.get(i).getName() + " ";
            }
            System.out.println("\nWhich assessment's grade would you like to edit? Enter \"cancel\" to exit. \n");
            String ans = Scan.nextLine().toUpperCase();
            if(ans.equals("CANCEL")) {
                break;
            } else if(temp.contains(ans + " ")) {
                int index = -1;
                for(int i = 0; i < assessments.size(); i++) {
                    if(assessments.get(i).getName().equals(ans)) {
                        index = i;
                        break;
                    }
                }
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                while(true) {
                    System.out.println("What would you like to change the assessment's grade to? Enter \"cancel\" to go back. \n");
                    String ans1 = Scan.nextLine().toUpperCase();
                    if(ans1.equals("CANCEL")) {
                        break;
                    } else {
                        boolean isNum = true;
                        for(int i = 0; i < ans1.length(); i++) {
                            if(!(Character.isDigit(ans1.charAt(i)) || ans1.charAt(i) == '.')) {
                                isNum = false;
                            }
                        }
                        if(isNum) {
                            assessments.get(index).editGrade((Double.parseDouble(ans1) / 100));
                            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                            run = false;
                            break;
                        } else {
                            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                            System.out.println("Please enter a number or enter \"cancel.\"");
                        }
                    }
                }
            } else {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Please enter one of the listed names or enter \"cancel.\" \n");
            }
        }
    }
    // Deletes grade
    public void deleteGrade(Scanner Scan) {
        if(assessments.size() < 1) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no assessments to delete. \"");
        }
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        boolean run = true;
        while(run) {
            String temp = "";
            System.out.println("Here are your current " + name + " assessments:");
            for(int i = 0; i < assessments.size(); i++) {
                System.out.println(assessments.get(i).getName() + ": " + (assessments.get(i).getGrade() * 100));
                temp += assessments.get(i).getName() + " ";
            }
            System.out.println("\nPlease enter the name of the assessment you would like to delete. Enter \"cancel\" to exit. \n");
            String ans = Scan.nextLine().toUpperCase();
            if(ans.equals("CANCEL")) {
                break;
            } else if(temp.contains(ans + " ")) {
                for(int i = 0; i < assessments.size(); i++) {
                    if(assessments.get(i).getName().equals(ans)) {
                        assessments.remove(i);
                        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                        run = false;
                        break;
                    }
                }
            } else {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Please enter one of the listed names or enter \"cancel.\"");
            }
        }
    }
    // Allows student to access the assessments
    public ArrayList<Assessment> getGradeList() {
        return assessments;
    }
}