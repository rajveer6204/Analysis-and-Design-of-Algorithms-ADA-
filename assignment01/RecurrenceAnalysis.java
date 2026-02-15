package assignment01;

public class RecurrenceAnalysis {

    // Call counters
    static int callsT1 = 0;
    static int callsT2 = 0;

    // ---------- Recurrence 1 ----------
    // T(n) = T(n/2) + n  → O(n)
    public static int T1(int n) {
        callsT1++;

        if (n <= 1)
            return 1;

        // linear work
        int work = 0;
        for (int i = 0; i < n; i++)
            work++;

        return T1(n / 2) + work;
    }

    // ---------- Recurrence 2 ----------
    // T(n) = 2T(n/2) + n  → O(n log n)
    public static int T2(int n) {
        callsT2++;

        if (n <= 1)
            return 1;

        int work = 0;
        for (int i = 0; i < n; i++)
            work++;

        return T2(n / 2) + T2(n / 2) + work;
    }

    public static void main(String[] args) {

        int[] sizes = {8, 16, 32, 64, 128, 256};

        System.out.printf("%-6s %-12s %-14s %-12s %-14s%n",
                "n", "CallsT1", "TimeT1(ns)", "CallsT2", "TimeT2(ns)");

        for (int n : sizes) {

            callsT1 = 0;
            callsT2 = 0;

            long start1 = System.nanoTime();
            T1(n);
            long time1 = System.nanoTime() - start1;

            long start2 = System.nanoTime();
            T2(n);
            long time2 = System.nanoTime() - start2;

            System.out.printf("%-6d %-12d %-14d %-12d %-14d%n",
                    n, callsT1, time1, callsT2, time2);
        }
    }
}


/*n      CallsT1      TimeT1(ns)     CallsT2      TimeT2(ns)    
8      4            1500           15           1100
16     5            1100           31           1700
32     6            1100           63           3100
64     7            2200           127          10300
128    8            3500           255          28000
256    9            4000           511          13300
 */
