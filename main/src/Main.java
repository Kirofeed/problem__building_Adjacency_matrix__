import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path inputFile = Paths.get("input.txt");
        Path outputFile = Paths.get("output.txt");
        int[][] adjacencyMatrix;
        int n;
        int m;
        try (BufferedReader br = Files.newBufferedReader(inputFile)) {
            String[] edge = br.readLine().split(" ");
            n = Integer.parseInt(edge[0]);
            m = Integer.parseInt(edge[1]);

            adjacencyMatrix = new int[n][n];

            for (int i = 0; i < m; i++) {
                edge = br.readLine().split(" ");
                int v1 = Integer.parseInt(edge[0]);
                int v2 = Integer.parseInt(edge[1]);

                adjacencyMatrix[v1 - 1][v2 - 1] = 1;
                adjacencyMatrix[v2 - 1][v1 - 1] = 1;
            }
        }

        try (PrintStream printStream = new PrintStream(Files.newOutputStream(outputFile))) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    printStream.print(adjacencyMatrix[i][j] + " ");
                }
                printStream.println();
            }
        }
    }
}
