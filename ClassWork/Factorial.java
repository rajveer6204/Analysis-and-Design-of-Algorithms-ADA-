
import java.util.Scanner;

public class Factorial{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
     System.out.print("Enter a number: ");

        int num = sc.nextInt();
        int count = 0;


        long factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
            count++;
            count++;
        }
        count++;
        
        System.out.println("Factorial of " + num + " is: " + factorial);
        System.out.println("Step count : " +count);
    }
}
