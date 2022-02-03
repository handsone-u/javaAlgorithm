package dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek18352 {
    static int N,M,K, X;
    static ArrayList<Node>[] vertex;
    static int[] distance;
    static boolean[] visited;

    private static void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getWeight));

        distance[k] = 0;
        pq.add(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int cIndex = poll.index;
            int cWeight = poll.weight;

            if(visited[cIndex]) continue;
            visited[cIndex] = true;

            ArrayList<Node> list = vertex[cIndex];
            for (Node node : list) {
                int nextWeight = cWeight + node.getWeight();
                if(distance[node.getIndex()]<= nextWeight) continue;
                distance[node.getIndex()] = nextWeight;
                pq.add(new Node(node.getIndex(), nextWeight));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reading(reader);

        dijkstra(X);

        writing();
    }

    private static void writing() {
        int count = 0;
        for (int i = 1; i < N+1; i++) {
            if(distance[i]==K){
                count++;
                System.out.println(i);
            }
        }

        if (count == 0) {
            System.out.println(-1);
        }
    }

    private static void reading(BufferedReader reader) throws IOException {
        int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0];
        M = tmp[1];
        K = tmp[2];
        X = tmp[3];
        vertex = new ArrayList[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            vertex[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            vertex[tmp[0]].add(new Node(tmp[1], 1));
        }
    }

    static class Node{
        private final int index;
        private final int weight;

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
