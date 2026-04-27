import java.util.*;

// Q11. BFS and DFS Traversal (Graph Traversal using Adjacency Matrix)

public class BFS_DFS {

    int V; // number of vertices
    int[][] adjMatrix;

    // Constructor
    BFS_DFS(int v) {
        V = v;
        adjMatrix = new int[V][V];
    }

    // Add edge
    void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // undirected graph
    }

    // BFS Traversal
    void BFS(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("\nBFS Traversal: ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 0; i < V; i++) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    // DFS Traversal (Recursive)
    void DFS(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("\nDFS Traversal: ");
        dfsUtil(start, visited);
    }

    void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 0; i < V; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input vertices and edges
        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        BFS_DFS g = new BFS_DFS(v);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        // Input edges
        for (int i = 0; i < e; i++) {
            System.out.print("Enter edge (u v): ");
            int u = sc.nextInt();
            int w = sc.nextInt();
            g.addEdge(u, w);
        }

        // Input starting node
        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        // Call BFS and DFS
        g.BFS(start);
        g.DFS(start);

        sc.close();
    }
}

// Badal  - 2501351020 - 4th Semester - B.Tech CSE FSD