
  import java.util.Scanner;

public class FactorialStepCount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        long fact = 1;
        int stepCount = 0;

        stepCount++; // step: initialization

        for (int i = 1; i <= num; i++) {
            stepCount++;      // loop check
            fact = fact * i;
            stepCount++;      // multiplication
        }

        stepCount++; // print step

        System.out.println("Factorial = " + fact);
        System.out.println("Total Steps = " + stepCount);
    }
}

