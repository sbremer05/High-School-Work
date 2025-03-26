import java.util.Scanner;

public class RandomizedDeliveryChecker {
    public static void main(String[] args) {
        int x;
        int y;
        Scanner Scan = new Scanner(System.in);
        while(true) {
            System.out.println("What would you like your x coordinate to be?");
            String ans = Scan.nextLine();
            if(checkNum(ans)) {
                x = Integer.parseInt(ans);
                break;
            } else {
                System.out.println("Please enter an integer");
            }
        }
        while(true) {
            System.out.println("What would you like your y coordinate to be?");
            String ans = Scan.nextLine();
            if(checkNum(ans)) {
                y = Integer.parseInt(ans);
                break;
            } else {
                System.out.println("Please enter an integer");
            }
        }
        runProgram(x,y);
    }

    public static int randint(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    public static boolean checkNum(String num) {
        for(int i = 0; i < num.length(); i++) {
            if(!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void runProgram(int x, int y) {
        int turns = 0;
        int locx = 0;
        int locy = 0;
        while(turns < 20 && !arrived(x, y, locx, locy)) {
            int temp = randint(1, 2);
            int tempm = randint(0, 1);
            if(temp == 1) {
                if(tempm == 1) {
                    locx++;
                } else {
                    locx--;
                }
            } else if(tempm == 1) {
                locy++;
            } else {
                locy--;
            }
            turns++;
            System.out.println("Location: [" + locx + ", " + locy + "] Turns: " + (20 - turns));
        }
        if(arrived(x, y, locx, locy)) {
            System.out.println("Package Delivered!");
        } else {
            System.out.println("Delivery Failed!");
        }
    }

    public static boolean arrived(int x, int y, int locx, int locy) {
        return x == locx && y == locy;
    }
}