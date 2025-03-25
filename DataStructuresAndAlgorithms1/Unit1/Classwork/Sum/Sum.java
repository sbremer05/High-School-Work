import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int num1;
        int num2;
        while(true) {
            System.out.println("Please enter a number:");
            if(scan.hasNextInt()) {
                num1 = scan.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scan.next();
            }
        }
        while(true) {
            System.out.println("Please enter a number:");
            if(scan.hasNextInt()) {
                num2 = scan.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scan.next();
            }
        }
        sum = num1 + num2;
        System.out.println(sum);
        scan.close();
    }
}
