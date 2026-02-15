// Task 3: Recursion and Recurrence Validation
package assignment01;

import java.util.HashMap;

public class RecursionValidation {

    // ---------- Call Counters ----------
    static int factCalls = 0;
    static int fibCalls = 0;
    static int fibDpCalls = 0;

    // ---------- Factorial ----------
    public static long factorial(int n) {
        factCalls++;

        if (n <= 1)
            return 1;

        return n * factorial(n - 1);
    }

    // ---------- Fibonacci (Naïve) ----------
    public static long fibonacci(int n) {
        fibCalls++;

        if (n <= 1)
            return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ---------- Fibonacci (DP Memoization) ----------
    public static long fibonacciDP(int n, HashMap<Integer, Long> memo) {
        fibDpCalls++;

        if (memo.containsKey(n))
            return memo.get(n);

        if (n <= 1)
            return (long) n;

        long value = fibonacciDP(n - 1, memo) + fibonacciDP(n - 2, memo);
        memo.put(n, value);
        return value;
    }

    public static void main(String[] args) {

        int[] sizes = {5, 10, 20, 30};

        System.out.printf("%-6s %-12s %-12s %-12s %-12s %-12s %-12s%n",
                "n", "FactCalls", "FactTime", "FibCalls", "FibTime",
                "FibDPCalls", "FibDPTime");

        for (int n : sizes) {

            factCalls = fibCalls = fibDpCalls = 0;

            // Factorial
            long start = System.nanoTime();
            factorial(n);
            long factTime = System.nanoTime() - start;

            // Fibonacci naive
            start = System.nanoTime();
            fibonacci(n);
            long fibTime = System.nanoTime() - start;

            // Fibonacci DP
            start = System.nanoTime();
            fibonacciDP(n, new HashMap<>());
            long fibDpTime = System.nanoTime() - start;

            System.out.printf("%-6d %-12d %-12d %-12d %-12d %-12d %-12d%n",
                    n, factCalls, factTime, fibCalls, fibTime, fibDpCalls, fibDpTime);
        }
    }
}

/*
n      FactCalls    FactTime     FibCalls     FibTime      FibDPCalls   FibDPTime   
5      5            1200         15           1000         9            61800       
10     10           1200         177          5200         19           29400       
20     20           1200         21891        295900       39           31700       
30     30           10300        2692537      3445500      59           53100 */