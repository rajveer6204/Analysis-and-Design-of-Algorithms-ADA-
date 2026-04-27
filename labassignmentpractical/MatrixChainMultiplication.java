import java.util.Scanner;

// Q8. Matrix Chain Multiplication (Min Scalar Multiplications and Parenthesis Order)

public class MatrixChainMultiplication {

    // Function to find minimum multiplications and optimal parenthesis
    static void matrixChainOrder(int[] p, int n) {

        int[][] m = new int[n][n]; // cost table
        int[][] s = new int[n][n]; // split table

        // Step 1: Initialize diagonal as 0
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        // Step 2: Chain length
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }

        System.out.println("\nMinimum number of multiplications = " + m[1][n - 1]);

        System.out.print("Optimal Parenthesization = ");
        printOptimal(s, 1, n - 1);
        System.out.println();
    }

    // Function to print parenthesis
    static void printOptimal(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimal(s, i, s[i][j]);
            printOptimal(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of matrices
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int[] p = new int[n + 1];

        // Input dimensions
        System.out.println("Enter dimensions array (size " + (n + 1) + "): ");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        // Call function
        matrixChainOrder(p, n + 1);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD