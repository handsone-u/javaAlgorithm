package wtc;

public class Sol2 {
    public String solution(String[] log) {
        String answer = "";
        int len = log.length;
        int total = 0;

        for (int i = 0; i < len; i = i + 2) {
            String[] start = log[i].split(":");
            String[] end = log[i+1].split(":");

            int h = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
            int m = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);

            int time = m + (60) * h;
            if(time<5) time = 0;
            else if(time>105) time = 105;

            total += time;
        }
        int h = total / 60;
        int m = total % 60;
        if(h<10) answer = "0";
        answer += h + ":";
        if(m<10) answer += "0";
        answer += m;

        return answer;
    }
}
