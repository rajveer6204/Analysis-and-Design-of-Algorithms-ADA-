import java.util.Scanner;

// Q10. Bellman-Ford Algorithm (Find Shortest Path and Detect Negative Cycle)

class Edge {
    int src, dest, weight;

    // Constructor
    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

public class BellmanFord {

    static final int INF = 999999;

    // Bellman-Ford function
    static void bellmanFord(Edge[] edges, int V, int E, int src) {

        int[] dist = new int[V];

        // Step 1: Initialize distances
        for (int i = 0; i < V; i++) {
            dist[i] = INF;
        }
        dist[src] = 0;

        // Step 2: Relax edges (V-1 times)
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;

                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Step 3: Check for negative weight cycle
        for (int j = 0; j < E; j++) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int w = edges[j].weight;

            if (dist[u] != INF && dist[u] + w < dist[v]) {
                System.out.println("\nGraph contains negative weight cycle!");
                return;
            }
        }

        // Step 4: Print result
        System.out.println("\nVertex\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input vertices and edges
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        Edge[] edges = new Edge[E];

        // Input edges
        for (int i = 0; i < E; i++) {
            System.out.print("Enter source, destination and weight: ");
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();

            edges[i] = new Edge(s, d, w);
        }

        // Input source
        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        // Call function
        bellmanFord(edges, V, E, src);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD