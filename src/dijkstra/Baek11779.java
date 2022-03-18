package dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek11779 {
    static int n, m;
    static int[] d;
    static int[] pre;
    static int from, to;
    static ArrayList<Node>[] v;

    private static void solution() {
        d[from] = 0;
        pre[from] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
        pq.add(new Node(from, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(now.weight>d[now.target]) continue;

            ArrayList<Node> nodes = v[now.target];
            for (Node node : nodes) {
                int newWeight = now.weight + node.weight;
                if(d[node.target]<= newWeight) continue;

                d[node.target] = newWeight;
                pre[node.target] = now.target;
                pq.add(new Node(node.target, newWeight));
            }
        }
    }

    private static void dfs(BufferedWriter writer, int now, int num) throws IOException {
        if (now == 0) {
            writer.write(Integer.toString(num));
            writer.write('\n');
            return;
        }
        dfs(writer, pre[now], num + 1);
        writer.write(Integer.toString(now));
        writer.write(' ');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reading(reader);
        solution();

        writer.write(Integer.toString(d[to]));
        writer.write('\n');
        dfs(writer, to, 0);

        writer.flush();
        writer.close();
    }

    private static void reading(BufferedReader reader) throws IOException {
        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        d = new int[n + 1];
        pre = new int[n + 1];
        v = new ArrayList[n + 1];

        Arrays.fill(d, 1000 * 100000);
        for (int i = 0; i <= n; i++) v[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            v[tmp[0]].add(new Node(tmp[1], tmp[2]));
        }
        int[] tmp = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        from = tmp[0];
        to = tmp[1];
        reader.close();
    }

    static class Node{
        int target;
        int weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }
}
