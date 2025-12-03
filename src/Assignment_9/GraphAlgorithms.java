package Assignment_9;

public class GraphAlgorithms {

    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            src = s; dest = d; weight = w;
        }
    }

    static class Graph {
        int V, E;
        Edge[] edges;
        int[][] adjMatrix;

        Graph(int v, int e) {
            V = v;
            E = e;
            edges = new Edge[e];
            adjMatrix = new int[v][v];
        }

        void addEdge(int index, int u, int v, int w) {
            edges[index] = new Edge(u, v, w);

            adjMatrix[u][v] = w;
            adjMatrix[v][u] = w;
        }
    }

    static void BFS(Graph g, int start) {
        boolean[] visited = new boolean[g.V];
        int[] queue = new int[g.V];
        int front = 0, rear = 0;

        visited[start] = true;
        queue[rear++] = start;

        System.out.print("BFS: ");

        while (front < rear) {
            int u = queue[front++];

            System.out.print(u + " ");

            for (int v = 0; v < g.V; v++) {
                if (g.adjMatrix[u][v] != 0 && !visited[v]) {
                    visited[v] = true;
                    queue[rear++] = v;
                }
            }
        }
        System.out.println();
    }

    static void DFS(Graph g, int start) {
        boolean[] visited = new boolean[g.V];
        System.out.print("DFS: ");
        dfsHelper(g, start, visited);
        System.out.println();
    }

    static void dfsHelper(Graph g, int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");

        for (int v = 0; v < g.V; v++) {
            if (g.adjMatrix[u][v] != 0 && !visited[v])
                dfsHelper(g, v, visited);
        }
    }

    static void Kruskal(Graph g) {
        for (int i = 0; i < g.E - 1; i++) {
            for (int j = 0; j < g.E - i - 1; j++) {
                if (g.edges[j].weight > g.edges[j+1].weight) {
                    Edge temp = g.edges[j];
                    g.edges[j] = g.edges[j+1];
                    g.edges[j+1] = temp;
                }
            }
        }

        int[] parent = new int[g.V];
        for (int i = 0; i < g.V; i++)
            parent[i] = i;

        System.out.println("Kruskal MST:");
        int count = 0;
        int total = 0;

        for (int i = 0; i < g.E && count < g.V - 1; i++) {

            int u = g.edges[i].src;
            int v = g.edges[i].dest;

            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu != pv) {
                System.out.println(u + " - " + v + "  (weight " + g.edges[i].weight + ")");
                total += g.edges[i].weight;
                parent[pu] = pv;
                count++;
            }
        }

        System.out.println("Total Weight: " + total);
        System.out.println();
    }

    static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    static void Prim(Graph g, int start) {

        boolean[] visited = new boolean[g.V];
        int[] key = new int[g.V];
        int[] parent = new int[g.V];

        for (int i = 0; i < g.V; i++)
            key[i] = Integer.MAX_VALUE;

        key[start] = 0;
        parent[start] = -1;

        for (int i = 0; i < g.V - 1; i++) {

            int u = minKey(key, visited, g.V);
            visited[u] = true;

            for (int v = 0; v < g.V; v++) {
                if (g.adjMatrix[u][v] != 0 && !visited[v] && g.adjMatrix[u][v] < key[v]) {
                    key[v] = g.adjMatrix[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.println("Prim MST:");
        int total = 0;

        for (int i = 1; i < g.V; i++) {
            System.out.println(parent[i] + " - " + i + "  (weight " + key[i] + ")");
            total += key[i];
        }

        System.out.println("Total Weight: " + total);
        System.out.println();
    }

    static int minKey(int[] key, boolean[] visited, int V) {
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && key[i] < min) {
                min = key[i];
                idx = i;
            }
        }
        return idx;
    }

    static void Dijkstra(Graph g, int start) {

        int[] dist = new int[g.V];
        boolean[] visited = new boolean[g.V];

        for (int i = 0; i < g.V; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[start] = 0;

        for (int c = 0; c < g.V - 1; c++) {

            int u = minDist(dist, visited, g.V);
            visited[u] = true;

            for (int v = 0; v < g.V; v++) {
                if (!visited[v] && g.adjMatrix[u][v] != 0 &&
                        dist[u] + g.adjMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + g.adjMatrix[u][v];
                }
            }
        }

        System.out.println("Dijkstra from " + start + ":");
        for (int i = 0; i < g.V; i++)
            System.out.println("Distance to " + i + " = " + dist[i]);
        System.out.println();
    }

    static int minDist(int[] dist, boolean[] visited, int V) {
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {

        Graph g = new Graph(6, 7);

        g.addEdge(0, 0, 1, 4);
        g.addEdge(1, 0, 2, 3);
        g.addEdge(2, 1, 2, 1);
        g.addEdge(3, 1, 3, 2);
        g.addEdge(4, 2, 3, 4);
        g.addEdge(5, 3, 4, 2);
        g.addEdge(6, 4, 5, 6);

        BFS(g, 0);
        DFS(g, 0);
        Kruskal(g);
        Prim(g, 0);
        Dijkstra(g, 0);
    }
}
