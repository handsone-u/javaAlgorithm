package dataStructure;

public class Solution76501 {
    public int solution(int[] abs, boolean[] signs) {
        int answer = 0, len = abs.length;
        for (int i = 0; i < len; i++) answer += signs[i] ? abs[i] : -abs[i];
        return answer;
    }
}
