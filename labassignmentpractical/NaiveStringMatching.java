import java.util.Scanner;

// Q14. Naive String Matching (Find all occurrences of pattern in text)

public class NaiveStringMatching {

    // Function for naive pattern matching
    static void search(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        // Slide pattern over text one by one
        for (int i = 0; i <= n - m; i++) {

            int j;

            // Check for match
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            // If pattern found
            if (j == m) {
                System.out.println("Pattern found at index: " + i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input text and pattern
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine();

        // Call function
        search(text, pattern);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD