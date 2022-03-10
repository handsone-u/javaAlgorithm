package kakao2018_1;

import java.util.Arrays;

public class Sol2 {
    public int solution(String dartResult) {
        int answer = 0;
        int n = dartResult.length();
        int count = 0;
        char[] arr = dartResult.toCharArray();
        int[] result = new int[3];

        for (int i = 0; i < n; i++) {
            if(arr[i]<'0'||arr[i]>'9'||count>=3) continue;
            int num = parseInt(i, arr);
            boolean flag = num == 10;
            char s = parseSDT(i, flag, arr);
            int opt = parseOPT(i, flag, n, arr);

            if (s == 'S') {
                result[count] = num;
            } else if (s == 'D') {
                result[count] = num * num;
            } else {
                result[count] = num * num * num;
            }

            if(opt==2) result[count] = -result[count];
            else if (opt == 1) {
                result[count] *= 2;
                if(count>0) result[count - 1] *= 2;
            }

            System.out.printf("%d: %d\n", count, result[count]);
            if(flag) i++;
            count++;
        }

        System.out.printf("%d %d %d\n", result[0], result[1], result[2]);
        return Arrays.stream(result)
                .sum();
    }

    private int parseInt(int i, char[] arr) {
        int result = arr[i] - '0';
        if(arr[i+1]=='0') result = 10;

        return result;
    }

    private char parseSDT(int i, boolean f, char[] arr) {
        if (f) {
            i++;
        }
        return arr[i + 1];
    }

    private int parseOPT(int i, boolean f, int len,char[] arr) {
        if (f) {
            i++;
        }
        if(i+2>=len) return 0;
        if(arr[i+2]=='*') return 1;
        else if(arr[i+2]=='#') return 2;
        else return 0;
    }
}
