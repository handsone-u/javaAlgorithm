package etc;

public class Sol12899 {
    int[] nums = {4, 1, 2};
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while (n>0){
            int m = n % 3;
            answer.append(nums[m]);
            n /= 3;
            if (m == 0) {
                n--;
            }
        }

        return answer.reverse().toString();
    }
}
