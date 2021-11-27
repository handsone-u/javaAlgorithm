package dijkstra;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek1261 {
    static int n, m, ans;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] result;
    static int[][] wall;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        input(reader);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
        pq.offer(new Node(1, 1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int x = now.getX();
            int y = now.getY();
            int weight = now.getWeight();

            if(visited[x][y]) continue;
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(!isIn(nx,ny)) continue;
                if (weight + wall[nx][ny] < result[nx][ny]) {
                    result[nx][ny] = weight + wall[nx][ny];
                    pq.offer(new Node(nx, ny, result[nx][ny]));
                }
            }
        }

        printResult(writer);
    }

    static class Node{
        private int x,y;
        private int weight;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWeight() {
            return weight;
        }

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    private static boolean isIn(int x, int y) {
        if(x<1||y<1||x>n||y>m) return false;
        else return true;
    }

    private static void input(BufferedReader reader) throws IOException {
        String[] s = reader.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        result = new int[n + 1][m + 1];
        wall = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            char[] chars = reader.readLine().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                result[i + 1][j + 1] = Integer.MAX_VALUE;
                if(chars[j]=='0')
                    wall[i + 1][j + 1] = 0;
                else
                    wall[i + 1][j + 1] = 1;
            }
        }
        result[1][1] = 0;
        reader.close();
    }

    private static void printResult(BufferedWriter writer) throws IOException {
        writer.write(String.valueOf(result[n][m]));
        writer.flush();
        writer.close();
    }
}
