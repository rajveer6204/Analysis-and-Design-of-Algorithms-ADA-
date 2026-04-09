import java.util.*;

public class MatrixChainMultiplication {

    public static int matOrder(int array[], int n) {

        int[][] minMul = new int[n][n];

        // Initialize diagonal as 0
        for (int i = 1; i < n; i++) {
            minMul[i][i] = 0;
        }

        // Chain length
        for (int length = 2; length < n; length++) {
            for (int i = 1; i < n - length + 1; i++) {
                int j = i + length - 1;

                minMul[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {

                    int q = minMul[i][k] + minMul[k + 1][j]
                            + array[i - 1] * array[k] * array[j];

                    if (q < minMul[i][j]) {
                        minMul[i][j] = q;
                    }
                }
            }
        }

        return minMul[1][n - 1];
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4};
        int size = arr.length;

        System.out.println("Minimum number of matrix multiplications: " 
                            + matOrder(arr, size));
    }
}