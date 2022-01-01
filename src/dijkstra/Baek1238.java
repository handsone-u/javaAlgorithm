package dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek1238 {
    static int INF = 10000000;
    static int N, M, X;
    private static int[] distance, reverse;
    private static ArrayList<Node>[] v, rv;

    static void dijkstra(int[] arr, ArrayList<Node>[] vertex,int num) {
        boolean[] v = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
        pq.offer(new Node(num, 0));

        arr[num] = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int cIndex = poll.getIndex();

            if(v[cIndex]) continue;
            v[cIndex] = true;

            ArrayList<Node> cVertex = vertex[cIndex];
            for (Node node : cVertex) {
                if (node.getWeight() + arr[cIndex] < arr[node.getIndex()]) {
                    arr[node.getIndex()] = node.getWeight() + arr[cIndex];
                    pq.offer(new Node(node.getIndex(), arr[node.getIndex()]));
                }
            }
        }
    }

    static int getAns() {
        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            int result = distance[i] + reverse[i];
            if(result>max)
                max = result;
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        read();
        dijkstra(distance, v, X);
        dijkstra(reverse, rv, X);
        System.out.println(getAns());
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] tmp = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = tmp[0];
        M = tmp[1];
        X = tmp[2];
        distance = new int[N + 1];
        reverse = new int[N + 1];
        Arrays.fill(distance, INF);
        Arrays.fill(reverse, INF);

        v = new ArrayList[N + 1];
        rv = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            v[i] = new ArrayList<>();
            rv[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            tmp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            v[tmp[0]].add(new Node(tmp[1], tmp[2]));
            rv[tmp[1]].add(new Node(tmp[0], tmp[2]));
        }
    }

    static class Node{
        private int index;
        private int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        public int getIndex() {
            return index;
        }

        public int getWeight() {
            return weight;
        }
    }
}
