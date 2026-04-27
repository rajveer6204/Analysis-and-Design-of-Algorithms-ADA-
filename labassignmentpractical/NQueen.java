import java.util.Scanner;

// Q12. N-Queen Problem (Backtracking - Print All Solutions)

public class NQueen {

    int N; // size of board

    // Function to print solution
    void printSolution(int[][] board) {
        System.out.println("\nSolution:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if safe to place queen
    boolean isSafe(int[][] board, int row, int col) {

        // Check left side
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Lower diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Solve using backtracking
    boolean solveNQUtil(int[][] board, int col) {

        // Base case: all queens placed
        if (col >= N) {
            printSolution(board);
            return true;
        }

        boolean res = false;

        // Try placing queen in all rows
        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {
                board[i][col] = 1; // place queen

                // Recur
                res = solveNQUtil(board, col + 1) || res;

                board[i][col] = 0; // backtrack
            }
        }

        return res;
    }

    // Main function
    void solveNQ(int n) {
        N = n;
        int[][] board = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.println("No solution exists");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        int n = sc.nextInt();

        NQueen obj = new NQueen();
        obj.solveNQ(n);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD