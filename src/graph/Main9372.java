package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 9372
 * MST ... V-1
 */
public class Main9372 {
    static int t, n, m;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        t = Integer.parseInt(br.readLine());
        while (t-->0) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = s[0]; m = s[1];
            for (int i = 0; i < m; i++) br.readLine();
            bw.write(Integer.toString(n - 1));
            bw.write("\n");
        }
        close();
    }

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }
}
