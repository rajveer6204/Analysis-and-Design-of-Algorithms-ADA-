import java.util.Scanner;
                                 // Practical 3: Binary Search Analysis
public class SearchingAlgorithms {

    static int binarySearch(int[] arr, int n, int key) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (key < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9};
        int n = arr.length;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int result = binarySearch(arr, n, key);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");

        sc.close();
    }
}
// 2501351020 - Badal - 4th Semester - B.Tech CSE FSD