import java.util.Scanner;
public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        int len;
        boolean isNum = false;
        while(true) {
            System.out.println("How large would you like the list to be?");
            String ans = Scan.nextLine();
            for(int i = 0; i < ans.length(); i++) {
                if(!Character.isDigit(ans.charAt(i))) {
                    isNum = false;
                }
            }
            if(isNum) {
                len = Integer.parseInt(ans);
                break;
            } else {
                System.out.println("Please enter an integer.");
                isNum = true;
            }
        }
        int[] list = new int[len];
        for(int i = 0; i < len; i++) {
            while(true) {
                System.out.println("Enter a number:");
                if(Scan.hasNextInt()) {
                    list[i] = Scan.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    Scan.next();
                }
            }
        }
        System.out.println();
        printArray(list);
        sort(list, 0, len- 1);
        System.out.println("Sorted list:");
        printArray(list);
    }
    public static void merge(int[] list, int low, int m, int high) {
        // Find sizes of two subarrays to be merged
        int lowL = m - low + 1;
        int highL = high - m;

        /* Create temp arrays */
        int lowList[] = new int[lowL];
        int highList[] = new int[highL];

        /*Copy data to temp arrays*/
        for(int i = 0; i < lowL; i++) {
            lowList[i] = list[low + i];
        }
        for(int i = 0; i < highL; i++) {
            highList[i] = list[m + 1 + i];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int li = 0;
        int hi = 0;

        // Initial index of merged subarray array
        int mi = low;
        while(li < lowL && hi < highL) {
            if(lowList[li] <= highList[hi]) {
                list[mi] = lowList[li];
                li++;
            }
            else {
                list[mi] = highList[hi];
                hi++;
            }
            mi++;
        }

        /* Copy remaining elements of L[] if any */
        while(li < lowL) {
            list[mi] = lowList[li];
            li++;
            mi++;
        }

        /* Copy remaining elements of R[] if any */
        while(hi < highL) {
            list[mi] = highList[hi];
            hi++;
            mi++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int[] list, int low, int high) {
        if(low < high) {
            // Find the middle point
            int m = low + (high - low) / 2;

            // Sort first and second halves
            sort(list, low, m);
            sort(list, m + 1, high);

            // Merge the sorted halves
            merge(list, low, m, high);
        }
    }

    /* A utility function to print array of size n */
    public static void printArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}