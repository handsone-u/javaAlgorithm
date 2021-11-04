package etc;

public class Sol12977 {
    int[] result;
    int[] numsG;
    int len, answer;

    public int solution(int[] nums) {
        answer = 0;
        len = nums.length;
        numsG = nums;
        result = new int[len];

        comb(0, 0, 3);

        return answer;
    }

    private boolean isPrime(int target) {
        int num = 0;
        for (int i = 0; i < target; i++)
            num += result[i];

        for (int i = 2; i*i <=num; i++) {
            if(num%i==0) return false;
        }
        System.out.println("num = " + num);
        return true;
    }

    private void comb(int from,int cnt, int target) {
        if (cnt == target) {
            if(isPrime(target))
                answer++;
            return;
        }
        for (int i = from; i < len; i++) {
            result[cnt] = numsG[i];
            comb(i + 1, cnt + 1, target);
        }
    }
}
