package etc;

public class Palindrome {
    static int[][] dp;

    public int solution(String s) {
        int answer = 1;
        int len = s.length();
        char[] arr = s.toCharArray();
        dp = new int[len + 1][len + 1];
        
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            if(arr[i]==arr[i+1]) {
                dp[i][i + 1] = 1;
                answer = 2;
            }
        }

        for (int k = 3; k <= len; k++) {
            for (int i = 0; i <= len - k; i++) {
                int j = i + k-1;
                if(arr[i]==arr[j] && dp[i+1][j-1]==1){
                    dp[i][j] = 1;
                    answer = k;
                }
            }
        }

        return answer;
    }
}
