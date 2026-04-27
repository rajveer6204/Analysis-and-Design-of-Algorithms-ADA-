import java.util.*;

// Q17. Activity Selection Problem (Select maximum activities)

class Activity {
    int start, finish;

    Activity(int s, int f) {
        start = s;
        finish = f;
    }
}

public class ActivitySelection {

    static void selectActivities(Activity[] arr, int n) {

        // Sort by finish time
        Arrays.sort(arr, Comparator.comparingInt(a -> a.finish));

        System.out.println("\nSelected Activities:");

        int i = 0;
        System.out.println("Activity: (" + arr[i].start + ", " + arr[i].finish + ")");

        // Select remaining activities
        for (int j = 1; j < n; j++) {
            if (arr[j].start >= arr[i].finish) {
                System.out.println("Activity: (" + arr[j].start + ", " + arr[j].finish + ")");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of activities
        System.out.print("Enter number of activities: ");
        int n = sc.nextInt();

        Activity[] arr = new Activity[n];

        // Input start and finish times
        for (int i = 0; i < n; i++) {
            System.out.print("Enter start and finish time: ");
            int s = sc.nextInt();
            int f = sc.nextInt();
            arr[i] = new Activity(s, f);
        }

        // Call function
        selectActivities(arr, n);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD