package combination;

import java.util.ArrayList;

public class Combination {
    static int[] arr;
    static int n,r, combCnt;
    static ArrayList<int[]> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        n = 5;
        r = 3;
        combCnt = 0;

        arr = new int[r];

        comb(0, 0);

        System.out.println("combCnt = " + combCnt);
        System.out.println("arrayList.size() = " + arrayList.size());
        arrayList.stream().forEach(ar -> System.out.printf("%d %d %d\n", ar[0], ar[1], ar[2]));
    }

    private static void comb(int from,int cnt) {
        if (cnt == r) {
            arrayList.add(arr.clone());
            combCnt++;
            return;
        }
        for (int i = from; i < n; i++) {
            arr[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }
}
