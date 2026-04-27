import java.util.Scanner;

// Q15. Floyd-Warshall Algorithm (All Pairs Shortest Path)

public class FloydWarshall {

    static final int INF = 999999;

    // Function to apply Floyd-Warshall
    static void floydWarshall(int[][] graph, int V) {

        int[][] dist = new int[V][V];

        // Step 1: Initialize distance matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Step 2: Update distances using intermediate vertices
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {

                    if (dist[i][k] != INF && dist[k][j] != INF &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 3: Print result
        System.out.println("\nShortest Distance Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        // Input adjacency matrix
        System.out.println("Enter adjacency matrix (use 999999 for INF):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // Call function
        floydWarshall(graph, V);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD