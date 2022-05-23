package kakao2018_3;

public class Sol1 {
    public String solution(int n, int t, int m, int p) {
        String str = getString(n, t, m);
        char[] arr = str.toCharArray();
        return String.valueOf(getAns(arr, t, m, p));
    }

    private char[] getAns(char[] arr, int t, int m, int p) {
        char[] result = new char[t];
        int pos = p - 1;
        for (int i = 0; i < t; i++) {
            result[i] = arr[pos];
            pos += m;
        }
        return result;
    }

    private String getString(int n, int t, int m) {
        StringBuilder q = new StringBuilder();
        int req = (m + 1) * t;
        int count = 0;
        int num = 0;

        while (count < req) {
            String str = toNum(n, num++);
            q.append(str);
            count += str.length();
        }
        return q.toString();
    }

    public String toNum(int n, int x) {
        StringBuilder sb = new StringBuilder();
        if(x==0) return "0";
        while (x > 0) {
            int mod = x % n;
            if(mod<10)
                sb.append(mod);
            else
                sb.append((char)('A' + mod - 10));
            x /= n;
        }

        return sb.reverse().toString();
    }
}
