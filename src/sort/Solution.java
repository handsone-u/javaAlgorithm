package sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public int[] solution42748(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2] - 1];
        }

        return answer;
    }

    public String solution42746(int[] numbers) {
        String ans = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> -s1.concat(s2).compareTo(s2.concat(s1)))
                .collect(Collectors.joining());

        if(ans.charAt(0)=='0') return "0";
        else return ans;
    }
}
