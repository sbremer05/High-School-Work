import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = 0;
        while(len <= 0) {
            System.out.println("How long would you like the list to be?");
            if(scan.hasNextInt()) {
                len = scan.nextInt();
                if(len <= 0) {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scan.next();
            }
        }
        int[] list = new int[len];
        for(int i = 0; i < len; i++) {
            while(true) {
                System.out.println("Enter a number:");
                if(scan.hasNextInt()) {
                    list[i] = scan.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scan.next();
                }
            }
        }
        scan.close();
        boolean swap = true;
        while(swap) {
            swap = false;
            for(int i = 0; i < len - 1; i++) {
                if(list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    swap = true;
                }
            }
        }
        for(int i = 0; i < len; i++) {
            System.out.print(list[i] + " ");
        }
    }
}