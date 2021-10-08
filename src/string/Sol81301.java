package string;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sol81301 {
    public int solution(String s) {
        int answer = 0;
        StringBuilder ss = new StringBuilder(s);
        String[] nums = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) s = s.replace(nums[i], Integer.toString(i));
        answer = Integer.parseInt(s);

        return answer;
    }
}
