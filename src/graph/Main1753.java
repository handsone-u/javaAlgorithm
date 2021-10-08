package graph;

import java.io.*;
import java.util.*;

public class Main1753 {
    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static int V, E, K;
    static int[] distance;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static PriorityQueue<Node> pq;

    static class Node{
        public int index;
        public int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        public int getDist() {
            return dist;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        String[] l1 = bufferedReader.readLine().split(" ");
        K = Integer.parseInt(bufferedReader.readLine());
        V = Integer.parseInt(l1[0]);
        E = Integer.parseInt(l1[1]);

        initCondition();
        dijkstra();

        for (int i = 1; i <= V; i++) {
            if(distance[i]==Integer.MAX_VALUE) bufferedWriter.write("INF\n");
            else bufferedWriter.write(Integer.toString(distance[i]) + "\n");
        }

        closing();
    }

    private static void dijkstra() {
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Node node : graph.get(now.index)) {
                if(distance[node.index]<=now.getDist()+node.getDist()) continue;
                distance[node.index] = now.getDist() + node.getDist();
                pq.add(new Node(node.index, distance[node.index]));
            }
        }
    }

    private static void initCondition() throws IOException {
        pq = new PriorityQueue<Node>(Comparator.comparing(Node::getDist));
        distance = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            String[] uvw = bufferedReader.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]), v = Integer.parseInt(uvw[1]), w = Integer.parseInt(uvw[2]);
            ArrayList<Node> tmp = graph.get(u);
            tmp.add(new Node(v, w));
        }
        distance[K] = 0;
        pq.add(new Node(K, 0));
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void closing() throws IOException {
        bufferedReader.close();
        bufferedWriter.close();
    }
}
