package kakao2018_1;

public class Sol1 {
    private boolean[] toBin(int n,int num) {
        boolean[] result = new boolean[n];
        int div = (int) Math.pow(2, n);

        for (int i = 0; i < n; i++) {
            div /= 2;
            result[i] = (num / div) > 0;
            num %= div;
        }

        return result;
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            boolean[] a1 = toBin(n, arr1[i]);
            boolean[] a2 = toBin(n, arr2[i]);
            for (int j = 0; j < n; j++) {
                sb.append(a1[j] || a2[j] ? '#' : ' ');
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}
