package wtc;

public class Sol6 {
    public String solution(double time, String[][] plans) {
        String answer = "";

        for (String[] plan : plans) {
            String dest = plan[0];
            String start = plan[1];
            String end = plan[2];

            double hourStart = toHour(start);
            double hourEnd = toHour(end);
            double togo = go(hourStart, hourEnd);

            if(togo>time) continue;
            answer = dest;
            time -= togo;
        }

        return answer;
    }


    private double go(double start, double end) {
        double cnt = 0;
        if(end>=13&&end<=18) cnt += end - 13;
        else if(end>=18) cnt += 5;
        if(start>=10&&start<=18) cnt += 18 - start;
        else if(start<10) cnt += 8.5;

        return cnt;
    }

    private double toHour(String s){
        if(s=="12PM") return 12;
        else if(s=="12AM") return 0;
        double h = 0;
        char[] arr = s.toCharArray();
        if (arr.length == 4) {
            if(arr[2]=='P') h += 12;
            h += (arr[0] - '0') * 10;
            h += arr[1] - '0';
        } else {
            if(arr[1]=='P') h += 12;
            h += arr[0] - '0';
        }
        return h;
    }
}
