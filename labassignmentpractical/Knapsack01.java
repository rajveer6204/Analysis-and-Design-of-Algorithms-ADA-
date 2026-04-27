import java.util.Scanner;

// Q6. 0/1 Knapsack (Show Max Profit and Items Vector)

public class Knapsack01 {

    // Function to solve 0/1 Knapsack using DP
    static void knapsack(int[] value, int[] weight, int n, int capacity) {

        // DP table
        int[][] dp = new int[n + 1][capacity + 1];

        // Step 1: Build DP table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {

                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // base case
                } 
                else if (weight[i - 1] <= w) {
                    // include or exclude
                    dp[i][w] = Math.max(
                        value[i - 1] + dp[i - 1][w - weight[i - 1]],
                        dp[i - 1][w]
                    );
                } 
                else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int maxProfit = dp[n][capacity];

        // Step 2: Find items taken (backtracking)
        int w = capacity;
        int[] taken = new int[n]; // items vector (0 or 1)

        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                taken[i - 1] = 1; // item included
                w -= weight[i - 1];
            } else {
                taken[i - 1] = 0; // item not included
            }
        }

        // Step 3: Print results
        System.out.println("\nItems Vector (0 = not taken, 1 = taken):");
        for (int i = 0; i < n; i++) {
            System.out.println("Item " + (i + 1) + " -> " + taken[i]);
        }

        System.out.println("\nMaximum Profit = " + maxProfit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        // Input values and weights
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            value[i] = sc.nextInt();

            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weight[i] = sc.nextInt();
        }

        // Input capacity
        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Call function
        knapsack(value, weight, n, capacity);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD