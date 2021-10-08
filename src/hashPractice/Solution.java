package hashPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String solution42576(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : participant) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            hashMap.put(s, hashMap.get(s) - 1);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            if(stringIntegerEntry.getValue()==1) {
                answer = stringIntegerEntry.getKey();
                break;
            }
        }

        return answer;
    }

    public boolean solution(String[] phone_book) {
        int len = phone_book.length;
        Arrays.sort(phone_book);

        for (int i = 0; i < len-1; i++) {
            String tmp = phone_book[i];
            if(phone_book[i + 1].startsWith(tmp)){
                return false;
            }
        }

        return true;
    }
}
