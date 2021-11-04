package combination;

public class Permutation {
    static int[] result;
    static boolean[] v;
    static int n;

    public static void main(String[] args) {
        n = 5;
        result = new int[n];
        v = new boolean[n];

        permutation(0);
    }

    private static void permutation(int cnt) {
        if (cnt == n) {
            for (int i : result) System.out.printf("%d ", i);
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            // 이미 골라진 것
            if(v[i]) continue;

            v[i] = true;
            result[cnt] = i;
            permutation(cnt + 1);
            v[i] = false;
        }
    }
}
