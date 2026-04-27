import java.util.Scanner;

// Q7. Longest Common Subsequence (Show Length and Sequence)

public class LCS {

    // Function to find LCS
    static void findLCS(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        // Step 1: Create DP table
        int[][] dp = new int[m + 1][n + 1];

        // Step 2: Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Length of LCS
        int length = dp[m][n];

        // Step 3: Backtrack to find sequence
        String lcs = "";
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs = s1.charAt(i - 1) + lcs;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Output results
        System.out.println("\nLength of LCS = " + length);
        System.out.println("LCS Sequence = " + lcs);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input strings
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        // Call function
        findLCS(s1, s2);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD