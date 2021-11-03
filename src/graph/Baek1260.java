package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baek1260 {
    static int n, m, v;
    static boolean[][] graph;
    static ArrayList<Integer> dfsAns = new ArrayList<Integer>();
    static ArrayList<Integer> bfsAns = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ints = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = ints[0];
        m = ints[1];
        v = ints[2];
        graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            ints = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[ints[0]][ints[1]] = graph[ints[1]][ints[0]] = true;
        }
        reader.close();

        startDFS();
        startBFS();
        printAns(writer);

        writer.flush();
        writer.close();
    }

    public static void startDFS() {
        boolean[] visited = new boolean[n + 1];
        dfs(v, visited);
    }

    public static void startBFS() {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        // ==check==
        q.add(v);
        visited[v] = true;
        // =========

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Integer now = q.poll();
                bfsAns.add(now);
                for (int j = 1; j <= n ; j++) {
                    if(visited[j]||!graph[now][j]) continue;
                    // ==check==
                    q.add(j);
                    visited[j] = true;
                    // =========
                }
            }
        }
    }

    private static void dfs(int vertex, boolean[] visited) {
        // ==check==
        dfsAns.add(vertex);
        visited[vertex] = true;
        // =========
        for (int i = 1; i <= n; i++) {
            if(visited[i]||!graph[vertex][i]) continue;
            dfs(i, visited);
        }
    }

    public static void printAns(BufferedWriter writer) throws IOException {
        for (Integer i : dfsAns) writer.write(Integer.toString(i) + " ");
        writer.write("\n");
        for (Integer i : bfsAns) writer.write(Integer.toString(i) + " ");
    }
}
