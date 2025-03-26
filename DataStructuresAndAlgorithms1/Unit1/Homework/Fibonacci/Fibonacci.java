import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        boolean isNum = true;
        int len;
        while(true) {
            System.out.println("How long would you like the sequence to be?");
            String ans = Scan.nextLine();
            for(int i = 0; i < ans.length(); i++) {
                if(!Character.isDigit(ans.charAt(i))) {
                    isNum = false;
                }
            }
            if(isNum) {
                len = Integer.parseInt(ans);
                if(len > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive integer");
                }
            } else {
                System.out.println("Please enter a positive integer");
                isNum = true;
            }
        }
        int[] temp = fibSequence(len, 1, 0);
        if(len == 1) {
            System.out.println("[0]");
        } else {
            System.out.print("[");
            for(int i = 0; i < len - 1; i++) {
                System.out.print(temp[i] + ", ");
            }
            System.out.println(temp[len - 1] + "]");
        }
    }
    public static int[] fibSequence(int len, int last, int last1) {
        int save = 0;
        int[] temp = new int[len];
        if(len > 1) {
            if(len >= 2) {
                temp[1] = 1;
            }
            for(int i = 2; i < len; i++) {
                save = last + last1;
                temp[i] = save;
                last1 = last;
                last = save;
            }
        }
        return temp;
    }
}