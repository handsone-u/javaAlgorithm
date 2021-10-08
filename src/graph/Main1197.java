package graph;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1197
 * MST + union-find
 */
public class Main1197 {
    static BufferedReader br;
    static BufferedWriter bw;
    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
    static int v, e;
    static int[] parents = new int[10001];

    private static int find(int z) {
        if(z==parents[z]) return z;
        else return parents[z] = find(parents[z]);
    }

    private static void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if(xp<yp) parents[yp] = parents[xp];
        else parents[xp] = parents[yp];
    }

    public static void main(String[] args) throws IOException {
        init();
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        v = s[0];
        e = s[1];
        for (int i = 0; i < v; i++) parents[i + 1] = i + 1;
        for (int i = 0; i < e; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.add(new Node(tmp[0], tmp[1], tmp[2]));
        }
        int edges = 0, ans = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int first = poll.first;
            int second = poll.second;
            int weight = poll.weight;

            if(find(first)==find(second)) continue;
            edges++;
            ans += weight;
            union(first, second);
        }

        bw.write(Integer.toString(ans));
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

    static class Node {
        int first;
        int second;
        int weight;

        public Node(int first, int second, int weight) {
            this.first = first;
            this.second = second;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }
}
