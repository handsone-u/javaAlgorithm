package etc;

import java.util.Arrays;

public class Sol77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {1,6};

        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        long zeros = Arrays.stream(lottos).filter(i -> i==0).count();
        long count = Arrays.stream(win_nums).filter(a -> Arrays.stream(lottos).anyMatch(b -> a == b))
                .count();
        answer[0] = (int)(7 - count - zeros);
        answer[1] = (int)(7 - count);

        return answer;
    }
}
