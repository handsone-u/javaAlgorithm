package bin_search;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LIS4 {

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Solution object = new Solution();
        object.gateWay(reader, writer);

        writer.flush();
        writer.close();
    }
}

class Solution{
    int n,ans;
    int[] arr;
    ArrayList<Integer> lis = new ArrayList<>();

    private void solution() {
        lis.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
            } else {
                int index = lowerBound(arr[i]);
                lis.set(index, arr[i]);
            }
        }

        ans = lis.size();
    }

    int lowerBound(int value) {

        int index = Collections.binarySearch(lis, value);
        if(index>=0)
            return index;
        else
            return -index - 1;
    }

    public void gateWay(BufferedReader reader, BufferedWriter writer) throws IOException {
        n = Integer.parseInt(reader.readLine());
        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution();

        writer.write(String.valueOf(ans));
    }
}
