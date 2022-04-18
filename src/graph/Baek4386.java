package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baek4386 {
    static int n;
    static Point[] points;
    static int[] parent;
    static PriorityQueue<Distance> pq;

    static double distance(Point p1, Point p2) {
        double x = p1.x - p2.x;
        double y = p1.y - p2.y;
        return Math.sqrt(x * x + y * y);
    }

    static int findParent(int x) {
        if(x==parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);

        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        points = new Point[n];
        parent = new int[n];
        pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            double[] p = Arrays.stream(reader.readLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            points[i] = new Point(i, p[0], p[1]);
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                pq.add(new Distance(i, j, distance(points[i], points[j])));
            }
        }

        double answer = 0;
        while (!pq.isEmpty()) {
            Distance poll = pq.poll();
            int px = findParent(poll.p1);
            int py = findParent(poll.p2);
            if(px==py) continue;

            double d = poll.d;
            answer += d;
            union(px, py);
        }

        writer.write(Double.toString(answer));
        writer.flush();
        writer.close();
    }

    static class Distance implements Comparable<Distance> {
        int p1;
        int p2;
        double d;

        public Distance(int p1, int p2, double d) {
            this.p1 = p1;
            this.p2 = p2;
            this.d = d;
        }

        @Override
        public int compareTo(Distance o) {
            return (int) (this.d - o.d);
        }
    }


    static class Point {
        int index;
        double x;
        double y;
        double c;

        public Point(int index, double x, double y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }
}
