// import Stack
import java.util.Stack;

public class DijkAlgorithm{
    private static final int Total_Vertices = 5;

    // Method to find the shortest path from the source vertex to all other vertices in the graph
    public void DijkAlgorithm(int[][] graph, int source){
        
        int[] distances = new int[Total_Vertices]; // store the distances from the source vertex to each vertex
        int[] parents = new int[Total_Vertices]; // to store the parent vertex for each vertex in the shortest path
        boolean[] visited = new boolean[Total_Vertices]; // track visited vertices

        // Initialize the distances, parents, and visited arrays with default values
        for (int j = 0; j < Total_Vertices; j++){
            distances[j] = Integer.MAX_VALUE; // Set the distance to infinity for all vertices
            visited[j] = false; // Mark all vertices as not visited
            parents[j] = -1; // Set the parent vertex to -1 for all vertices
        }

        distances[source] = 0; // Set the distance to the source vertex to 0

        // Iterate over all vertices in the graph and calculate the shortest path
        for (int i = 0; i < Total_Vertices - 1; i++){
            // Find the vertex with the shortest distance from the source unvisited vertices
            int u = MinDistance(distances, visited);
            visited[u] = true;

            // Update the distances and parents arrays for all adjacent unvisited vertices
            for (int v = 0; v < Total_Vertices; v++){
                if (!visited[v] && graph[u][v] != -1 && distances[u] != Integer.MAX_VALUE &&
                        distances[u] + graph[u][v] < distances[v]){
                    distances[v] = distances[u] + graph[u][v]; // Update the distance to the adjacent vertex
                    parents[v] = u; // Set the parent vertex for the adjacent vertex
                }
            }
        }
        show_solution(distances, parents); // Print the shortest path and distance
    }

    // Method to print the shortest path and distance
    private void show_solution(int[] distances, int[] parents){
        
        char[] nodes = {'A', 'B', 'C', 'D', 'E'}; // Array of vertex names

        // Iterate over all vertices and print the shortest path and distance
        for (char node : nodes){
            int index = node - 'A'; // Get the index of the vertex in the distances and parents arrays
            System.out.printf("To %c the shortest distance is: %d \n the path taken is: ", node, distances[index]);

            Stack<Integer> path = new Stack<>(); // Stack to track the path from the source vertex to current
            int current = index; // Start with the current vertex

            path.push(current); // Add the current vertex to the path stack

            // Iterate over the parent vertices and add them to the path stack
            while (parents[current] != -1){
                path.push(parents[current]);
                current = parents[current];
            }

            // Print the path in reverse order
            while (!path.empty()){
                System.out.print(nodes[path.pop()] + " ");
            }
            
            System.out.println();
        }
    }

    // Method to find the unvisited vertices with the shortest distance from the source vertex
    private int MinDistance(int[] distances, boolean[] visited){
        int MinDistance = Integer.MAX_VALUE, minIndex = -1;

        // Iterate over all vertices and find the vertex with the minimum distance
        for (int i = 0; i < Total_Vertices; i++){
            if (!visited[i] && distances[i] <= MinDistance){
                MinDistance = distances[i];
                minIndex = i;
            }
        }
        return minIndex; // Return the index of the vertex with the shortest distance
    }

    // Main method to create a new DijkAlgorithm object and run it on a graph
    public static void main(String[] args){
        int[][] graph = {
                {-1, 1, -1, 1, 1},
                {-1, -1, 1, -1, -1},
                {-1, -1, -1, -1, 1},
                {-1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1}
        }; // A 5x5 adjacency matrix that represent the graph
        DijkAlgorithm DijkAlgorithm = new DijkAlgorithm(); // Create a new DijkAlgorithm object
        DijkAlgorithm.DijkAlgorithm(graph, 0); // Run the shortest path algorithm with given parameters
    }
}