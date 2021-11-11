package etc;

import java.io.*;
import java.util.Arrays;

public class Baek2947 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int len = arr.length;
        reader.close();

        while (!isDone(arr)) {
            for (int i = 0; i < len - 1; i++) {
                if(arr[i]>arr[i+1]) {
                    swap(arr, i, i + 1);
                    print(arr);
                }
            }
        }

        writer.flush();
        writer.close();
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.printf("%d ", arr[i]);
        System.out.println();
    }

    static void swap(int[] arr,int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    static boolean isDone(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if(arr[i]!=i+1)
                return false;

        return true;
    }
}
