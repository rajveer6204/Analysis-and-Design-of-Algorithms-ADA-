import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

                    // Q5. Fraction Knapsack (Show Max Profit and Items Vector)

class Item {
    int value, weight;

    // Constructor to initialize item
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    // Function to calculate maximum profit
    static double knapsack(Item[] items, int capacity) {

        // Step 1: Sort items based on value/weight ratio (descending order)
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item i1, Item i2) {
                double r1 = (double) i1.value / i1.weight;
                double r2 = (double) i2.value / i2.weight;
                return Double.compare(r2, r1);
            }
        });

        double totalProfit = 0.0;  // To store maximum profit
        double[] fraction = new double[items.length]; // To store fraction of items taken

        // Step 2: Pick items one by one
        for (int i = 0; i < items.length; i++) {

            // If item can be fully taken
            if (capacity >= items[i].weight) {
                totalProfit += items[i].value;   // add full value
                capacity -= items[i].weight;     // reduce capacity
                fraction[i] = 1.0;               // full item taken
            } 
            else {
                // Take fractional part of item
                double frac = (double) capacity / items[i].weight;
                totalProfit += items[i].value * frac;
                fraction[i] = frac;              // store fraction taken
                break; // knapsack is full
            }
        }

        // Step 3: Display items vector
        System.out.println("\nItems Vector (Fractions of items taken):");
        for (int i = 0; i < fraction.length; i++) {
            System.out.println("Item " + (i + 1) + " -> " + fraction[i]);
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        // Input value and weight of each item
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            int value = sc.nextInt();

            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = sc.nextInt();

            items[i] = new Item(value, weight);
        }

        // Input knapsack capacity
        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Call function
        double maxProfit = knapsack(items, capacity);

        // Output result
        System.out.println("\nMaximum Profit = " + maxProfit);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD