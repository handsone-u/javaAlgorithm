package graph;

import java.io.*;
import java.util.*;

public class Main11404 {
    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static int n, m;
    static int[][] distance = new int[501][501];
    public static void main(String[] args) throws IOException {
        init();
        n = Integer.parseInt(bufferedReader.readLine());
        m = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int[] x = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            distance[x[0]][x[1]] = Integer.min(distance[x[0]][x[1]], x[2]);
        }
        floyd();

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(distance[i][j]==Integer.MAX_VALUE) bufferedWriter.write("0 ");
                else bufferedWriter.write(Integer.toString(distance[i][j]) + " ");
            }
        }

        closing();
    }
    private static void floyd() {
        for (int k = 1; k < n + 1; k++)
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++)
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE)
                        distance[i][j] = Integer.min(distance[i][j], distance[i][k] + distance[k][j]);
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void closing() throws IOException {
        bufferedReader.close();
        bufferedWriter.close();
    }
    static class Node {
        int index;
        int dist;
    }
}
