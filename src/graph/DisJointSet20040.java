package graph;

import java.io.*;
import java.util.Arrays;

public class DisJointSet20040 {
    static int n, m, ans;
    static int[] parent;

    static int findParent(int a) {
        if(a==parent[a]) return a;
        else return parent[a] = findParent(parent[a]);
    }

    static boolean union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if(px==py) return false;

        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        solution(reader);

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }

    private static void solution(BufferedReader reader) throws IOException {
        int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = tmp[0];
        m = tmp[1];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        ans = 0;
        for (int i = 0; i < m; i++) {
            tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(!union(tmp[0],tmp[1])) {
                ans = i + 1;
                return;
            }
        }
    }
}
