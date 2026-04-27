import java.util.Scanner;

// Q13. Sum of Subsets (Print all subsets whose sum = given value)

public class SumOfSubsets {

    int[] set;        // input set
    int[] subset;     // store current subset (0/1 vector)
    int n, target;

    // Function to print subset
    void printSubset() {
        System.out.print("Subset: ");
        for (int i = 0; i < n; i++) {
            if (subset[i] == 1) {
                System.out.print(set[i] + " ");
            }
        }
        System.out.println();
    }

    // Backtracking function
    void sumOfSubsets(int sum, int k) {

        // If sum equals target → print solution
        if (sum == target) {
            printSubset();
            return;
        }

        // If sum exceeds or no elements left → stop
        if (k >= n || sum > target) {
            return;
        }

        // Include current element
        subset[k] = 1;
        sumOfSubsets(sum + set[k], k + 1);

        // Exclude current element
        subset[k] = 0;
        sumOfSubsets(sum, k + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SumOfSubsets obj = new SumOfSubsets();

        // Input number of elements
        System.out.print("Enter number of elements: ");
        obj.n = sc.nextInt();

        obj.set = new int[obj.n];
        obj.subset = new int[obj.n];

        // Input set elements
        System.out.println("Enter elements:");
        for (int i = 0; i < obj.n; i++) {
            obj.set[i] = sc.nextInt();
        }

        // Input target sum
        System.out.print("Enter target sum: ");
        obj.target = sc.nextInt();

        // Call function
        System.out.println("\nSubsets with given sum:");
        obj.sumOfSubsets(0, 0);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD