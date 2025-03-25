import java.util.Scanner;

public class Modified {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n********************************************************************************");
            System.out.println("\n                                  Monte Carlo\n");
            System.out.println("********************************************************************************\n");
            System.out.println("How many values do you want to calculate?");

            int ans;
            while (true) {
                String input = scan.nextLine();
                try {
                    ans = Integer.parseInt(input);
                    if (ans < 1) {
                        System.out.println("Invalid amount, choose again");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter an integer");
                }
            }

            int points = 0;
            for (int i = 0; i < ans; i++) {
                double x = (Math.random() * 2) - 1;
                double y = (Math.random() * 2) - 1;
                System.out.println("(" + x + ", " + y + ")");
                if (x * x + y * y <= 1) {
                    points++;
                }
            }

            double pi = (4.0 * points) / ans;
            System.out.println(points + (points == 1 ? " point falls" : " points fall") + " within the circle");
            System.out.println("π ≈ " + pi);

            while (true) {
                System.out.println("Do you wish to quit (y/n)");
                String quit = scan.nextLine().trim().toLowerCase();
                if (quit.equals("y")) {
                    scan.close();
                    return;
                } else if (quit.equals("n")) {
                    break;
                } else {
                    System.out.println("Invalid response");
                }
            }
        }
    }
}