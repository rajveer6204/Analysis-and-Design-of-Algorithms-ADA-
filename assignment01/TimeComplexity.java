package assignment01;

public class TimeComplexity {

    // 1️⃣ Constant Time O(1)
    public static int getFirst(int[] arr) {
        return arr[0];
    }

    // 2️⃣ Linear Time O(n)
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // 3️⃣ Quadratic Time O(n^2)
    public static void printPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int x = arr[i] + arr[j]; // dummy work
            }
        }
    }

    // 4️⃣ Logarithmic Time O(log n)
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

    public static void main(String[] args) {

        int[] sizes = {10, 100, 500, 1000};

        for (int n : sizes) {

            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = i;

            // O(1)
            long start1 = System.nanoTime();
            getFirst(arr);
            long end1 = System.nanoTime();

            // O(n)
            long start2 = System.nanoTime();
            sumArray(arr);
            long end2 = System.nanoTime();

            // O(n^2)
            long start3 = System.nanoTime();
            printPairs(arr);
            long end3 = System.nanoTime();

            // O(log n)
            long start4 = System.nanoTime();
            binarySearch(arr, n - 1);
            long end4 = System.nanoTime();

            System.out.println("n = " + n);
            System.out.println("O(1) Time: " + (end1 - start1));
            System.out.println("O(n) Time: " + (end2 - start2));
            System.out.println("O(n^2) Time: " + (end3 - start3));
            System.out.println("O(log n) Time: " + (end4 - start4));
            System.out.println("----------------------");
        }
    }
}
