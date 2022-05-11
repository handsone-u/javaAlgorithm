import java.util.HashMap;

class Solution1 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int len = survey.length;
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < len; i++) {
            if(choices[i]==4) continue;
            if (choices[i] < 4) {
                Integer v = map.get(survey[i].charAt(0));
                map.put(survey[i].charAt(0), v + disagree(choices[i]));
            } else {
                Integer v = map.get(survey[i].charAt(1));
                map.put(survey[i].charAt(1), v + choices[i] - 4);
            }
        }

        if(map.get('R')>=map.get('T')) answer += 'R';
        else answer += 'T';
        if(map.get('C')>=map.get('F')) answer += 'C';
        else answer += 'F';
        if(map.get('J')>=map.get('M')) answer += 'J';
        else answer += 'M';
        if(map.get('A')>=map.get('N')) answer += 'A';
        else answer += 'N';

        return answer;
    }

    int disagree(int x) {
        if(x==1) return 3;
        else if(x==3) return 1;
        else return 2;
    }
}