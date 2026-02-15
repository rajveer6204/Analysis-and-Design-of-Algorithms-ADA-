/*Task 2: Best, Average, and Worst Case Analysis
        Implement Linear Search and Binary Search*/

package assignment01;

import java.util.Arrays;
import java.util.Random;

public class SearchAnalysis {

    // ---------- Linear Search ----------
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    // ---------- Binary Search ----------
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // ---------- Generate Random Array ----------
    public static int[] generateArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n * 10);
        }
        return arr;
    }

    // ---------- Time Measurement ----------
    public static long measureLinear(int[] arr, int key) {
        long start = System.nanoTime();
        linearSearch(arr, key);
        long end = System.nanoTime();
        return end - start;
    }

    public static long measureBinary(int[] arr, int key) {
        long start = System.nanoTime();
        binarySearch(arr, key);
        long end = System.nanoTime();
        return end - start;
    }

    // ---------- Main ----------
    public static void main(String[] args) {

        int[] sizes = {10, 100, 500, 1000};

        // Table Header
        System.out.printf("%-6s %-12s %-12s %-12s %-12s %-12s %-12s%n",
                "Size", "LinearBest", "LinearAvg", "LinearWorst",
                "BinaryBest", "BinaryAvg", "BinaryWorst");

        for (int n : sizes) {

            int[] arr = generateArray(n);
            Arrays.sort(arr); // required for binary search

            int bestKey = arr[0];        // first element
            int avgKey = arr[n / 2];     // middle element
            int worstKey = -1;           // not present

            long lBest = measureLinear(arr, bestKey);
            long lAvg = measureLinear(arr, avgKey);
            long lWorst = measureLinear(arr, worstKey);

            long bBest = measureBinary(arr, bestKey);
            long bAvg = measureBinary(arr, avgKey);
            long bWorst = measureBinary(arr, worstKey);

            System.out.printf("%-6d %-12d %-12d %-12d %-12d %-12d %-12d%n",
                    n, lBest, lAvg, lWorst, bBest, bAvg, bWorst);
        }
    }
}

/* Size   LinearBest   LinearAvg    LinearWorst  BinaryBest   BinaryAvg    BinaryWorst 
10     700          200          200          800          300          200
100    400          600          1000         500          200          200         
500    600          4000         7700         800          500          400
1000   400          8100         14900        800          100          400  
 
    2501351020 
    Badal*/