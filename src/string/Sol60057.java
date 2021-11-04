package string;

/**
 * String, subString()
 * [startIndex, endIndex), index bound 체크 필요
 * startIndex>=0, endIndex<=length
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class Sol60057 {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i < s.length(); i++) answer = Integer.min(answer, enc(s, i));

        return answer;
    }

    private int enc(String s, int size) {
        int count = 0;
        String result = "";
        String sub = s.substring(0, size);
        // count occurrence
        for (int i = 0; i < s.length(); i += size) {
            String candidate;
            if(i+size>=s.length()) candidate = s.substring(i, s.length());
            else candidate = s.substring(i, i + size);
            if (sub.equals(candidate)) count++;
            else {
                if (count != 1) result += count;
                result += sub;
                sub = candidate;
                count = 1;
            }
        }
        if(count!=1) result += count;
        result += sub;
//        System.out.println(size + ": " + "result = " + result +" "+result.length());
        return result.length();
    }
}
