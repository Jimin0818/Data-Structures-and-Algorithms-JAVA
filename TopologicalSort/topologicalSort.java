package Assignment4;

import java.util.*;

public class topologicalSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("The Number of Vertices: ");
        int V = scan.nextInt();
        System.out.print("The Number of Edges: ");
        int E = scan.nextInt();

        System.out.println("The Graph Coordinates: ");
        Graph graph = new Graph(V);

        for (int i = 0; i < E; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.isCyclic()) {
            System.out.println("Cycle detected.");
        } else {
            graph.topologicalSort();
        }
    }
}

class Graph {
    private int V; 							
    private List<List<Integer>> adjList; 

    //The Constructor: Assigns the vertices 
    //Time complexity of O(V) where V is the number of vertices
    public Graph(int vertices) { 
        this.V = vertices;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    //This method will add edges based on the given coordinates from user
    //Time Complexity of O(1)
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }
    //This method is used isCyclic
    //This method detects if the graph provided is a cycle using recursive function
    //The time complexity is O(V + E), where V is the vertices and E is the edges.
    public boolean cycles(int v, boolean[] visited, boolean[] recStack) {
        if (recStack[v])
            return true;

        if (visited[v])
            return false;

        visited[v] = true;
        recStack[v] = true;

        List<Integer> children = adjList.get(v);

        for (Integer c : children)
            if (cycles(c, visited, recStack))
                return true;

        recStack[v] = false;

        return false;
    }

    //This method uses the previous method cycles to determine if a cycle is present in a graph
    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++)
            if (cycles(i, visited, recStack))
                return true;

        return false;
    }

    //This method sorts the graph into topological order using recursive functions
    //The time complexity is O(V + E), where V is the vertices and E is the edges. 
    public void topoSort(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (Integer i : adjList.get(v)) {
            if (!visited[i]) {
            	topoSort(i, visited, stack);
            }
        }
        stack.push(v);
    }

    //This method utilizes the topoSort method to sort the graph.
    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
            	topoSort(i, visited, stack);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

  
}


