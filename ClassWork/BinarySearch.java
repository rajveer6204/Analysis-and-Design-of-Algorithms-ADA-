import java.util.Scanner;

// class 17.02.2026

public class BinarySearch {

    static int stepCount = 0;   // counter variable

    public static int binarySearch(int[] arr, int low, int high, int key) {
        stepCount++;   // count each recursive call

        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == key)
            return mid;
        else if (key < arr[mid])
            return binarySearch(arr, low, mid - 1, key);
        else
            return binarySearch(arr, mid + 1, high, key);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // ---------- USER SEARCH ----------
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        stepCount = 0;
        int result = binarySearch(arr, 0, n - 1, key);
        int userSteps = stepCount;

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");

        System.out.println("User Search Step Count: " + userSteps);

        // ---------- BEST CASE ----------
        stepCount = 0;
        binarySearch(arr, 0, n - 1, arr[n / 2]);
        int bestSteps = stepCount;

        // ---------- AVERAGE CASE ----------
        stepCount = 0;
        binarySearch(arr, 0, n - 1, arr[n / 4]);
        int avgSteps = stepCount;

        // ---------- WORST CASE ----------
        stepCount = 0;
        binarySearch(arr, 0, n - 1, arr[n - 1]);
        int worstSteps = stepCount;

        System.out.println("\n----- Binary Search Cases -----");
        System.out.println("Best Case Steps: " + bestSteps);
        System.out.println("Average Case Steps: " + avgSteps);
        System.out.println("Worst Case Steps: " + worstSteps);

        sc.close();
    }
}
