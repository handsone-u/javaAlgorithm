package dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baek13549 {
    static int N, K;
    static int[] distance = new int[100001];
    static boolean[] v = new boolean[100001];

    static int[] X = {-1, 1};

    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator
            .comparing(Node::getSecond)
            .thenComparing(Node::getIndex));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        scanner.close();

        pq.add(new Node(N, 0));
        v[N] = true;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int nIndex = poll.index;
            int nSecond = poll.second;
            for (int i = 0; i < 3; i++) {
                int index, second;
                if (i == 2) {
                    index = nIndex * 2;
                    second = nSecond;
                } else {
                    index = nIndex + X[i];
                    second = nSecond + 1;
                }

                if(index<0||index>100000) continue;

                if (!v[index]) {
                    v[index] = true;
                    distance[index] = second;
                    pq.add(new Node(index, second));
                } else if(distance[index]>second) {
                    distance[index] = second;
                    pq.add(new Node(index, second));
                }
            }
        }
        System.out.println(distance[K]);
    }

    static class Node{
        private int index;
        private int second;

        public Node(int index, int second) {
            this.index = index;
            this.second = second;
        }

        public int getIndex() {
            return index;
        }

        public int getSecond() {
            return second;
        }
    }
}
