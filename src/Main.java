import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Example usage
        Graph graph = new Graph(5);    // Create a graph with a maximum size of 5
        graph.createGraph("g2.txt");    // Read graph data from a file
        System.out.println("Is graph empty? " + graph.isEmpty());
        if(graph.isConnected())
            System.out.println("connected");
        else
            System.out.println("not connected");
    }

    private static class Graph {
        private int[][] adjacencyMatrix;
        private int currentSize;
        private int maxSize;

        // Default constructor
        public Graph() {
            this.adjacencyMatrix = new int[10][10];
            this.currentSize = 0;
            this.maxSize = 10;
        }

        // Overloaded constructor
        public Graph(int maxSize) {
            this.adjacencyMatrix = new int[maxSize][maxSize];
            this.currentSize = 0;
            this.maxSize = maxSize;
        }

        // Check if the graph is empty
        public boolean isEmpty() {
            return currentSize == 0;
        }

        // Create the graph from a formatted file
        public void createGraph(String fileName) {
            try (Scanner scanner = new Scanner(new File(fileName))) {
                // Read the maximum size of the graph from the first line
                int maxSize = scanner.nextInt();

                // Initialize the adjacency matrix
                this.adjacencyMatrix = new int[maxSize][maxSize];
                this.currentSize = maxSize;
                this.maxSize = maxSize;

                // Process each line after the first as an edge and update the adjacency matrix
                scanner.nextLine();    // Move to the next line to start processing edges
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] values = line.trim().split(" ");

                    int startVertex = Integer.parseInt(values[0]);
                    for (int i = 1; i < values.length; i++) {
                        int endVertex = Integer.parseInt(values[i]);
                        // Assuming undirected graph, mark both entries in the matrix
                        this.adjacencyMatrix[startVertex - 1][endVertex - 1] = 1;
                        this.adjacencyMatrix[endVertex - 1][startVertex - 1] = 1;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }

        public boolean isConnected() {
            Boolean[] arr = new Boolean[maxSize];
            Arrays.fill(arr, false); // Initialize the array with false values
            for (int i = 0; i < maxSize; i++) {
                connectHelper(i, arr);
                if (Arrays.asList(arr).contains(false)) {
                    return false;
                }
                Arrays.fill(arr, false); // Reset the array for the next iteration
            }
            return true;
        }

        private void connectHelper(int startingIndex, Boolean[] arrayOfVisited) {
            arrayOfVisited[startingIndex] = true;
            for (int i = 0; i < arrayOfVisited.length; i++) {
                if (this.adjacencyMatrix[startingIndex][i] == 1 && !arrayOfVisited[i]) {
                    connectHelper(i, arrayOfVisited);
                }
            }
        }

    }

}
