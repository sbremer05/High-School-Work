import java.util.*;
import java.util.Scanner;
public class Original {
	public static void main(String[] args) {
		ArrayList<Double> arrX = new ArrayList<Double>();
		ArrayList<Double> arrY = new ArrayList<Double>();
		Scanner Scan = new Scanner(System.in);
		Scanner Quit = new Scanner(System.in);
		int points = 0;
		double pi = 0;
		for(int x = 1; x > 0; x++) {
			System.out.println();
			System.out.println("********************************************************************************");
			System.out.println();
			System.out.println("                                  Monte Carlo");
			System.out.println();
			System.out.println("********************************************************************************");
			System.out.println();
			System.out.println("How many values do you want to calculate?");
			int ans = Scan.nextInt();
			if(ans < 1) {
				System.out.println("Invalid amount, choose again");
			} else {
				for(int i = 0; i < ans; i++) {
					arrX.add((Math.random() * 2) - 1);
					arrY.add((Math.random() * 2) - 1);
					System.out.println("(" + arrX.get(i) + ", " + arrY.get(i) + ")");
					if((arrX.get(i) * arrX.get(i)) + (arrY.get(i) * arrY.get(i)) <= 1) {
						points++;
					}
				}
				pi = (4.0 * points) / arrX.size();
				if(points == 1) {
					System.out.println(points + " point falls with the circle");
				} else {
					System.out.println(points + " points fall with the circle");
				}
				System.out.println("π ≈ " + pi);
				while(true) {
					System.out.println("Do you wish to quit (y/n)");
					String quit = Quit.nextLine();
					if(quit.equals("y") || quit.equals("Y")) {
						x = -1;
						break;
					} else if(quit.equals("n") || quit.equals("N")) {
						break;
					} else {
						System.out.println("Invalid response");
					}
				}
			}
		}
	}
}
