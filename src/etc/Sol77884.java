package etc;

public class Sol77884 {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++)
            answer += getVal(i);

        return answer;
    }

    private int getVal(int x) {
        for (int i = 1; i*i <= x; i++)
            if(i*i==x) return -x;

        return x;
    }
}
