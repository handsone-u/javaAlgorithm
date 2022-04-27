package kakao2022;

import java.util.ArrayList;

public class Solution5_1 {
    int answer = 1;
    Node[] nodes;
    boolean[] v;

    void dfs(int sheep, int wolf, int pos, ArrayList<Node> candidates) {
        if(sheep<=wolf) return;
        if(sheep>answer) answer = sheep;
        ArrayList<Node> newCandy = new ArrayList<>(candidates);

        if (nodes[pos].left != null) {
            newCandy.add(nodes[pos].left);
        }
        if (nodes[pos].right != null) {
            newCandy.add(nodes[pos].right);
        }

        for (Node next : newCandy) {
            if(v[next.index]) continue;
            v[next.index] = true;
            if(next.wolf) dfs(sheep, wolf + 1, next.index, newCandy);
            else dfs(sheep + 1, wolf, next.index, newCandy);
            v[next.index] = false;
        }
    }

    public int solution(int[] info, int[][] edges) {
        nodes = new Node[info.length];
        v = new boolean[info.length];
        for (int i = 0; i < info.length; i++) nodes[i] = new Node(i, 1 == info[i]);

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            nodes[parent].addChild(nodes[child]);
        }
        v[0] = true;
        dfs(1, 0, 0, new ArrayList<>());

        return answer;
    }

    static class Node{
        int index;
        boolean wolf;
        Node left;
        Node right;

        public void addChild(Node child) {
            if(left==null) left = child;
            else right = child;
        }

        public Node(int index, boolean wolf) {
            this.index = index;
            this.wolf = wolf;
            left = right = null;
        }
    }
}
