package kakao2022;

public class Solution2_1 {
    private String toKNum(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int m = n % k;
            sb.append(m);
            n /= k;
        }
        return sb.reverse().toString();
    }

    private boolean isPrime(long x) {
        if(x==1) return false;
        for (int i = 2; i <= Math.sqrt(x) ; i++) {
            if(x%i==0) return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String number = toKNum(n, k);
        String[] nums = number.split("0");

        for (String num : nums) {
            if(num.isEmpty() || num.equals(" ")) continue;
            if(isPrime(Long.parseLong(num)))
                answer++;
        }

        return answer;
    }
}
