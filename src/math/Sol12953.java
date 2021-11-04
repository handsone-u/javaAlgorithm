package math;

/**
 * LCM : n개 수의 최소공배수
 * LCM(x,y,z...) = LCM(...LCM(z,LCM(x,y)))...)
 * GCD
 */
public class Sol12953 {
    public int solution(int[] arr) {
        int answer = arr[0], len = arr.length;
        for (int i = 1; i < len; i++)
            answer = LCM(answer, arr[i]);

        return answer;
    }

    public int LCM(int x, int y) {
        return x * y / GCD(x, y);
    }

    public int GCD(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}
