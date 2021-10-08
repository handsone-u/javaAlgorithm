package graph;

import java.util.*;

/**
 * Bin Tree ...
 * Build & Traversal
 */
public class Solution42892 {
    int preIndex, postIndex;
    public int[][] solution(int[][] nodeinfo) {
        int length = nodeinfo.length;
        int[][] answer = new int[2][length];
        Node[] nodes = new Node[length + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getY).reversed().thenComparing(Node::getX));
        Queue<Node> parent = new LinkedList<>(), child = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            nodes[i + 1] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
            pq.add(nodes[i + 1]);
        }
        Node head = pq.poll();
        parent.add(head);
        while (!parent.isEmpty()) {
            if(pq.isEmpty()) break;
            int parentSize = parent.size();
            int parentLevel = parent.peek().y;
            int childLevel = pq.peek().y;
            child.clear();
            // get child Queue
            while (!pq.isEmpty()) {
                if (pq.peek().y == childLevel) child.add(pq.poll());
                else break;
            }
            // child -> parent
            Queue<Node> saved = new LinkedList<>(child);
            while (!child.isEmpty()) insert(head, child.poll(), parentLevel);

            parent = saved;
        }

        preIndex = postIndex = 0;
        preOrder(head, nodes, answer[0]);
        postOrder(head, nodes, answer[1]);

        return answer;
    }

    void insert(Node prev, Node child, int pLevel) {
        if(prev==null) return;
        if(pLevel==prev.y){
            if(prev.left==null&&prev.x>child.x) prev.left = child;
            if(prev.right==null&&prev.x<child.x) prev.right = child;
            System.out.printf("%d : %d %d", prev.index,
                    prev.left==null? 0 : prev.left.index,
                    prev.right==null? 0: prev.right.index);
            return;
        }
        if(prev.x>child.x) insert(prev.left, child, pLevel);
        else if(prev.x<child.x) insert(prev.right, child, pLevel);
    }

    void preOrder(Node now, Node[] nodes, int[] pre) {
        pre[preIndex++] = now.index;
        if(now.left!=null) preOrder(now.left, nodes, pre);
        if(now.right!=null) preOrder(now.right, nodes, pre);
    }

    void postOrder(Node now, Node[] nodes, int[] post) {
        if(now.left!=null) postOrder(now.left, nodes, post);
        if(now.right!=null) postOrder(now.right, nodes, post);
        post[postIndex++] = now.index;
    }

    static class Node {
        public int index;
        public int x;
        public int y;
        public Node left;
        public Node right;

        public int getIndex() {
            return index;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Node(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
            left = right = null;
        }
    }
}
