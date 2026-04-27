import java.util.Scanner;

// Q9. Dijkstra Algorithm (Find Shortest Path from Source)

public class DijkstraAlgorithm {

    static final int INF = 999999;

    // Function to find vertex with minimum distance
    static int minDistance(int[] dist, boolean[] visited, int V) {
        int min = INF, minIndex = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Dijkstra Algorithm
    static void dijkstra(int[][] graph, int V, int src) {

        int[] dist = new int[V];      // shortest distances
        boolean[] visited = new boolean[V]; // visited set

        // Initialize
        for (int i = 0; i < V; i++) {
            dist[i] = INF;
            visited[i] = false;
        }

        dist[src] = 0;

        // Main loop
        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, visited, V);
            visited[u] = true;

            // Update distances
            for (int v = 0; v < V; v++) {

                if (!visited[v] && graph[u][v] != 0 &&
                    dist[u] != INF &&
                    dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Output
        System.out.println("\nVertex\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        // Input adjacency matrix
        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // Input source vertex
        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        // Call function
        dijkstra(graph, V, src);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD