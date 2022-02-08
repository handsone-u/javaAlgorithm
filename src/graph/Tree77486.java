package graph;

import java.util.*;

public class Tree77486 {
    int n;
    Map<String, Node> tree = new HashMap<>();

    public void traverse(Node node, int value) {
        if(value<=0) return;

        node.sum += value;
        node.sum -= value / 10;
        if (node.parent.equals("-") || node.name.equals("-")) {
            return;
        }

        traverse(tree.get(node.getParent()), value / 10);
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        n = enroll.length;
        int[] answer = new int[n];

        tree.put("-", null);
        for (int i = 0; i < n; i++) {
            Node node = new Node(enroll[i], referral[i]);
            tree.put(enroll[i], node);
        }

        int sellSize = seller.length;
        for (int i = 0; i < sellSize; i++) {
            Node node = tree.get(seller[i]);
            traverse(node, amount[i] * 100);
        }

        for (int i = 0; i < n; i++)
            answer[i] = tree.get(enroll[i]).getSum();

        return answer;
    }

    static class Node{
        private final String name;
        private final String parent;
        private int sum;

        public Node(String name, String parent) {
            this.name = name;
            this.parent = parent;
            sum = 0;
        }

        public String getName() {
            return name;
        }

        public String getParent() {
            return parent;
        }

        public int getSum() {
            return sum;
        }
    }
}
