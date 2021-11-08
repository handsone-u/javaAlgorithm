package dataStructure;

import java.io.*;
import java.util.Arrays;

public class SegmentTree {
    static int n,m, k;
    static long[] arr;
    static long[] segmentTree;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = line[0];
        m = line[1];
        k = line[2];

        arr = new long[n];
        segmentTree = new long[4 * n + 1];

        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(reader.readLine());

        init(0, n - 1, 1);

        for (int i = 0; i < m + k; i++) {
            String[] s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            long c = Long.parseLong(s[2]);
            if (a == 1) { // modify
                long diff = c - arr[b - 1];
                arr[b - 1] = c;
                modify(0, n - 1, 1, b - 1, diff);
            }
            else if (a == 2) { // sum
                long sum = range(0, n - 1, 1, b - 1, (int) c - 1);
                writer.write(Long.toString(sum) + "\n");
            }
        }

        writer.flush();
        writer.close();
    }

    private static void modify(int start, int end, int node, int target, long diff) {
        // 범위를 벗어남
        if(target<start||end<target) return;
        // 범위 안
        segmentTree[node] += diff;

        if(start>=end) return;
        int mid = (start + end) / 2;
        modify(start, mid, node * 2, target, diff);
        modify(mid + 1, end, node * 2 + 1, target, diff);
    }

    // [start, end] : 시작, 끝 index
    // [from, to] : 구하려고 하는 구간 합의 범위
    private static long range(int start, int end, int node, int from, int to) {
        // 범위 밖 (구간 합의 범위를 벗어난 index)
        if(from>end||to<start) return 0;
        // 범위 안
        else if(from<=start&&end<=to) return segmentTree[node];
        // 그외의 경우, 아래 노드로 이동
        int mid = (start + end) / 2;
        return range(start, mid, node * 2, from, to) + range(mid + 1, end, node * 2 + 1, from, to);
    }

    // [start, end] : 구간 합을 Node 번째에 초기화.
    private static long init(int start, int end, int node) {
        if(start==end) return segmentTree[node] = arr[start];
        int mid = (start + end) / 2;

        return segmentTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }
}
