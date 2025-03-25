import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = getValidInt(scan, "Please enter a number: ");
        int power = getValidInt(scan, "Please enter to what power: ");
        scan.close();
        int result = 1;
        for(int i = 0; i < power; i++) {
            result *= num;
        }
        System.out.println("Result: " + result);
    }

    private static int getValidInt(Scanner scan, String prompt) {
        while (true) {
            System.out.print(prompt);
            if(scan.hasNextInt()) {
                return scan.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scan.next();
            }
        }
    }
}
