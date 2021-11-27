package etc;

public class Sol12911 {
    public int solution(int n) {
        int answer = n + 1;

        while (getBinNum1(answer) != getBinNum1(n)) answer++;

        return answer;
    }

    private int getBinNum1(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt += num % 2;
            num /= 2;
        }

        return cnt;
    }
}
