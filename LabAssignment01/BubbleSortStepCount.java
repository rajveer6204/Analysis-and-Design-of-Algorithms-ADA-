import java.util.Arrays;

public class BubbleSortStepCount {

    // Bubble Sort Ascending with step count
    public static int bubbleSortAscending(int[] arr) {
        int steps = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                steps++; // comparison

                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    steps++; // swap step
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] arr = {35, 12, 48, 7, 22};

        System.out.println("Input: " + Arrays.toString(arr));

        int stepCount = bubbleSortAscending(arr);

        System.out.println("Sorted Output (Ascending): " + Arrays.toString(arr));
        System.out.println("Step Count: " + stepCount);
    }
}