import java.util.Scanner;

public class FactorialFibonacci {

    // Factorial Iterative
    static int factIter(int n) {
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Factorial Recursive
    static int factRec(int n) {
        if(n == 0 || n == 1)
            return 1;
        return n * factRec(n - 1);
    }

    // Fibonacci Iterative
    static void fibIter(int n) {
        int a = 0, b = 1, c;
        for(int i = 0; i < n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }

    // Fibonacci Recursive
    static int fibRec(int n) {
        if(n <= 1)
            return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        System.out.println("\nFactorial (Iterative): " + factIter(n));
        System.out.println("Factorial (Recursive): " + factRec(n));

        System.out.print("\nFibonacci (Iterative): ");
        fibIter(n);

        System.out.print("\nFibonacci (Recursive): ");
        for(int i = 0; i < n; i++) {
            System.out.print(fibRec(i) + " ");
        }

        sc.close();
    }
}