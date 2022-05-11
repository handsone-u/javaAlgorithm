import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution4 {
    ArrayList<Node>[] vertex;
    HashMap<Integer, Integer> type = new HashMap<>();

    int ansSummit = Integer.MAX_VALUE;
    int ansIntensity = Integer.MAX_VALUE;
    int GATE = 1;
    int SUMMIT = 2;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        vertex = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) vertex[i] = new ArrayList<>();

        for (int gate : gates) type.put(gate, GATE);
        for (int summit : summits) type.put(summit, SUMMIT);
        for (int[] path : paths) {
            vertex[path[0]].add(new Node(path[1], path[2]));
            vertex[path[1]].add(new Node(path[0], path[2]));
        }

        init(n);
        answer[0] = ansSummit;
        answer[1] = ansIntensity;

        return answer;
    }

    void init(int n) {

        for (int i = 1; i <= n; i++) {
            Integer index = type.get(i);
            if(index==null||index==SUMMIT) continue;
            dijkstra(i, n);
        }
    }

    void dijkstra(int start,int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] v = new boolean[n + 1];
        int[] result = new int[n + 1];

        pq.add(new Node(start, 0));
        result[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            Integer nowT = type.getOrDefault(now.index, 0);
            if(now.weight>result[now.index]) continue;

            int index = now.index;
            int weight = now.weight;
            v[index] = true;

            for (Node next : vertex[index]) {
                int nextIndex = next.index;
                int nextWeight = next.weight;
                int nextT = type.getOrDefault(nextIndex, 0);

                int totalWeight = Integer.max(weight, nextWeight);
                if(totalWeight>ansIntensity) continue;
                if (result[nextIndex] == 0 || result[nextIndex] > totalWeight) {
                    result[nextIndex] = totalWeight;
                    if(nextT==SUMMIT||v[nextIndex]||nextT==GATE) continue;
                    pq.add(new Node(nextIndex, totalWeight));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            Integer t = type.getOrDefault(i, 0);
            if(result[i]==0) continue;
            if (t == SUMMIT) {
                if (ansIntensity > result[i]) {
                    ansIntensity = result[i];
                    ansSummit = i;
                } else if (ansIntensity == result[i]&&ansSummit>i) {
                    ansIntensity = result[i];
                    ansSummit = i;
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            int dw = this.weight - o.weight;
            if(dw==0) return this.index - o.index;
            return dw;
        }
    }
}