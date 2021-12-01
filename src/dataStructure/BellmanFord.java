package dataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    static int[] distance;
    static ArrayList<Road>[] roads;

    static boolean solution(int n,int start) {
        Arrays.fill(distance, 987654321);

        distance[start] = 0;
        for (int v = 1; v <= n; v++) {
            for (int i = 1; i <= n; i++) {
                for (Road road : roads[i]) {
                    if (distance[road.to] > distance[i] + road.weight) {
                        distance[road.to] = distance[i] + road.weight;
                        if(v==n) return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int[] nmw = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            distance = new int[nmw[0] + 1];
            roads = new ArrayList[nmw[0] + 1];
            for (int i = 1; i <= nmw[0]; i++) roads[i] = new ArrayList<>();

            for (int i = 0; i < nmw[1]; i++) {
                int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                roads[tmp[0]].add(new Road(tmp[1], tmp[2]));
                roads[tmp[1]].add(new Road(tmp[0], tmp[2]));
            }

            for (int i = 0; i < nmw[2]; i++) {
                int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                roads[tmp[0]].add(new Road(tmp[1], -tmp[2]));
            }

            if(solution(nmw[0], 1)) writer.write("YES\n");
            else writer.write("NO\n");
        }

        writer.flush();
        writer.close();
    }

    static class Road{
        int to;
        int weight;

        public Road(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
