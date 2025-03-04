import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Gradebook {
    // Runs program, starts prompting for user
    public static void main(String[] args) {
        ArrayList<Block> blocks = new ArrayList<Block>();
        boolean cont = true;
        Scanner Scan = new Scanner(System.in);
        openWork(blocks);
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        while(true) {
            System.out.println("Here are your current blocks:");
            for(int i = 0; i < blocks.size(); i++) {
                System.out.println(blocks.get(i).getLetter());
            }
            System.out.println("\nDo you want to create, delete, edit, or enter a block? If you would like to save, enter \"save.\" If you would like to quit, enter \"quit.\" WARNING: QUITTING WILL NOT SAVE.\n");
            String ans = Scan.nextLine();
            ans = ans.toUpperCase();
            if(ans.equals("CREATE")) {
                createBlock(blocks, Scan);
            } else if(ans.equals("DELETE")) {
                deleteBlock(blocks, Scan);
            } else if(ans.equals("EDIT")) {
                editBlock(blocks, Scan);
            } else if(ans.equals("ENTER")) {
                enterBlock(blocks, Scan);
            } else if(ans.equals("QUIT")) {
                break;
            } else if(ans.equals("SAVE")) {
                saveWork(blocks);
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Your gradebook has been saved. \n");
            } else {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Please enter one of the following options: \n");
                System.out.println("create");
                System.out.println("delete");
                System.out.println("edit");
                System.out.println("enter");
                System.out.println("exit \n");
            }
        }
        Scan.close();
    }
    // Creates a block
    public static void createBlock(ArrayList<Block> blocks, Scanner Scan) {
        String temp = "";
        System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
        while(true) {
            System.out.println("Here are your current blocks:");
            for(int i = 0; i < blocks.size(); i++) {
                System.out.println(blocks.get(i).getLetter());
                temp += blocks.get(i).getLetter();
            }
            System.out.println("\nWhat letter block would you like to add? \n");
            System.out.println("Enter \"cancel\" to go back. \n");
            String ans = Scan.nextLine().toUpperCase();
            if(ans.equals("CANCEL")) {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                break;
            } else if(ans.length() > 1) {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Not a letter, please enter a letter. \n");
            } else if(temp.contains(ans)) {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("This letter has already been chosen, please choose a new one. \n");
            } else if(Character.isDigit(ans.charAt(0))) {
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                System.out.println("Not a letter, please enter a letter. \n");
            } else {
                blocks.add(new Block(ans));
                System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                break;
            }
        }
    }
    // Deletes a block
    public static void deleteBlock(ArrayList<Block> blocks, Scanner Scan) {
        if(blocks.size() == 0) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no blocks to delete. \n");
        } else {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            while(true) {
                String temp = "";
                System.out.println("Which block would you like to delete:");
                for(int i = 0; i < blocks.size(); i++) {
                    System.out.println(blocks.get(i).getLetter());
                    temp += blocks.get(i).getLetter();
                }
                System.out.println("\nIf you would like to go back please enter \"cancel.\" \n");
                String ans = Scan.nextLine().toUpperCase();
                if(ans.equals("CANCEL")) {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    break;
                } else if(ans.length() > 1) {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter a letter or enter \"cancel.\" \n");
                } else if(temp.contains(ans)) {
                    blocks.remove(temp.indexOf(ans));
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    break;
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please choose which block to delete or enter \"cancel.\" \n");
                }
            }
        }
    }
    // Edits a block's name
    public static void editBlock(ArrayList<Block> blocks, Scanner Scan) {
        boolean run = true;
        if(blocks.size() == 0) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no blocks to edit. \n");
        } else {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            while(run) {
                String temp = "";
                System.out.println("Which block would you like to edit:");
                for(int i = 0; i < blocks.size(); i++) {
                    System.out.println(blocks.get(i).getLetter());
                    temp += blocks.get(i).getLetter();
                }
                System.out.println("\nIf you would like to go back. Please enter \"cancel\" at anytime. \n");
                String ans = Scan.nextLine().toUpperCase();
                if(ans.equals("CANCEL")) {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    break;
                } else if(ans.length() > 1) {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter a letter or enter \"cancel\" \n");
                } else if(temp.contains(ans)) {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    while(true) {
                        System.out.println("What letter would you like to change the block to? \n");
                        String ans1 = Scan.nextLine().toUpperCase();
                        if(ans1.equals("CANCEL")) {
                            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                            break;
                        } else if(ans1.length() > 1) {
                            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                            System.out.println("Please enter a letter or \"cancel\" \n");
                        } else if(temp.contains(ans1)) {
                            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                            System.out.println("This letter has already been chosen. Please pick another. \n");
                        } else {
                            blocks.get(temp.indexOf(ans)).editLetter(ans1);
                            run = false;
                            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                            break;
                        }
                    }
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please choose one of the listed blocks to edit or enter \"cancel.\" \n");
                }
            }
        }
    }
    // Allows user to enter and access data within the block.
    public static void enterBlock(ArrayList<Block> blocks, Scanner Scan) {
        String temp = "";
        if(blocks.size() < 1) {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            System.out.println("There are no blocks to select from. \n");
        } else {
            System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
            while(true) {
                System.out.println("Which block would you like to enter:");
                for(int i = 0; i < blocks.size(); i++) {
                    System.out.println(blocks.get(i).getLetter());
                    temp += blocks.get(i).getLetter();
                }
                System.out.println("\nPress \"cancel\" to exit \n");
                String ans = Scan.nextLine();
                ans = ans.toUpperCase();
                if(ans.equals("CANCEL")) {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    break;
                } else if(ans.length() > 1) {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter a letter or enter \"cancel.\" \n");
                } else if(temp.contains(ans)) {
                    blocks.get(temp.indexOf(ans)).enterBlock(Scan);
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    break;
                } else {
                    System.out.println("———––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– \n");
                    System.out.println("Please enter a given letter or enter \"cancel.\" \n");
                }
            }
        }
    }
    // Saves user's work
    public static void saveWork(ArrayList<Block> blocks) {
        FileWriter fWriter = null;
        PrintWriter out = null;
        try {
            fWriter = new FileWriter("Gradebook.grbk");
            out = new PrintWriter(fWriter);
        } catch(IOException e) {
            System.out.println("Error opening output file " + e);
            System.exit(1);
        }

        for(int bi = 0; bi < blocks.size(); bi++) {
            out.println("Block: " + blocks.get(bi).getLetter());
            for(int ati = 0; ati < blocks.get(bi).getGradeTypes().size(); ati++) {
                out.println("AType: " + blocks.get(bi).getGradeTypes().get(ati).getName() + ";" + blocks.get(bi).getGradeTypes().get(ati).getWeight());
            }
            for(int si = 0; si < blocks.get(bi).getRoster().size(); si++) {
                out.println("Roste: " + blocks.get(bi).getRoster().get(si).getName());
                for(int gti = 0; gti < blocks.get(bi).getRoster().get(si).getGradeTypes().size(); gti++) {
                    out.println("GType: " + blocks.get(bi).getRoster().get(si).getGradeTypes().get(gti).getName() + ";" + blocks.get(bi).getRoster().get(si).getGradeTypes().get(gti).getWeight());
                    for(int gi = 0; gi < blocks.get(bi).getRoster().get(si).getGradeTypes().get(gti).getGradeList().size(); gi++) {
                        out.println("Grade: " + blocks.get(bi).getRoster().get(si).getGradeTypes().get(gti).getGradeList().get(gi).getName() + ";" + blocks.get(bi).getRoster().get(si).getGradeTypes().get(gti).getGradeList().get(gi).getGrade());
                    }
                }
            }
        }

        try {
            fWriter.close();
        } catch(IOException e) {
            System.out.println("Error closing files: " + e);
            System.exit(1);
        }
    }
    // Open's previously saved data
    public static void openWork(ArrayList<Block> blocks) {
        FileReader fReader = null;
        Scanner inData = null;
        ArrayList<String> data = new ArrayList<String>();
        try {
            fReader = new FileReader("Gradebook.grbk");
            inData = new Scanner(fReader);
        } catch(IOException e) {
            System.out.println("Error opening input file: " + e);
            System.exit(1);
        }

        while(inData.hasNextLine()) {
            String line = inData.nextLine();
            data.add(line);
        }

        for(int i = 0; i < data.size(); i++) {
            if(data.get(i).substring(0, 7).equals("Block: ")) {
                blocks.add(new Block(data.get(i).substring(7, data.get(i).length())));
            } else if(data.get(i).substring(0, 7).equals("AType: ")) {
                String[] temp = data.get(i).split("\\;+");
                blocks.get(blocks.size() - 1).getGradeTypes().add(new GradeType(temp[0].substring(7, temp[0].length()), Double.parseDouble(temp[1])));
            } else if(data.get(i).substring(0, 7).equals("Roste: ")) {
                String[] temp = data.get(i).split("\\, +");
                blocks.get(blocks.size() - 1).getRoster().add(new Student(temp[0].substring(7, temp[0].length()), temp[1]));
            } else if(data.get(i).substring(0, 7).equals("GType: ")) {
                String[] temp = data.get(i).split("\\;+");
                blocks.get(blocks.size() - 1).getRoster().get(blocks.get(blocks.size() - 1).getRoster().size() - 1).getGradeTypes().add(new GradeType(temp[0].substring(7, temp[0].length()), Double.parseDouble(temp[1])));
            } else if(data.get(i).substring(0, 7).equals("Grade: ")) {
                String[] temp = data.get(i).split("\\;+");
                blocks.get(blocks.size() - 1).getRoster().get(blocks.get(blocks.size() - 1).getRoster().size() - 1).getGradeTypes().get(blocks.get(blocks.size() - 1).getRoster().get(blocks.get(blocks.size() - 1).getRoster().size() - 1).getGradeTypes().size() - 1).getGradeList().add(new Assessment(temp[0].substring(7, temp[0].length()), Double.parseDouble(temp[1])));
            }
        }


        try {
            fReader.close();
        } catch(IOException e) {
            System.out.println("Error closing files: " + e);
            System.exit(1);
        }
    }
}