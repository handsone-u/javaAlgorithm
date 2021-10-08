package graph;

import java.io.*;
import java.util.Arrays;

/**
 * 1976
 * Union-Find
 */
public class Main1976 {
    static int n, m;
    static int[] target;
    static int[] parents;
    static boolean[][] road;
    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;

    private static void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if(xp<yp) parents[yp] = parents[xp];
        else parents[xp] = parents[yp];
    }

    private static int find(int a) {
        if(a==parents[a]) return a;
        else return parents[a] = find(parents[a]);
    }

    public static void main(String[] args) throws IOException {
        init();
        n = Integer.parseInt(bufferedReader.readLine());
        m = Integer.parseInt(bufferedReader.readLine());
        road = new boolean[n + 1][n + 1];
        parents = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parents[i + 1] = i + 1;
            int[] s = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++)
                if (s[j] == 1) road[i+1][j+1] = true;
        }
        target = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (road[i+1][j+1]) union(i + 1, j + 1);

        boolean flag = true;
        int parent = parents[target[0]];
        for (int i : target) {
            if(parent==parents[i]) continue;
            else flag = false;
        }

        String ans = flag ? "YES" : "NO";
        bufferedWriter.write(ans);
        close();
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
