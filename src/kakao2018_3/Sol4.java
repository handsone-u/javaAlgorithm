package kakao2018_3;

public class Sol4 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = trim(m);
        int len = 0;

        for (String music : musicinfos) {
            String[] tmp = music.split(",");
            String name = tmp[2];
            String melody = trim(tmp[3]);
            int time = parseTime(tmp[0], tmp[1]);

            if(len>=time) continue;
            String cop = melody;
            if(time<cop.length())
                cop = cop.substring(0, time);
            while (cop.length() < time) {
                cop += melody;
            }
            if (cop.contains(m)) {
                answer = name;
                len = time;
            }
        }

        return answer;
    }

    private String trim(String str) {
        str = str.replaceAll("C#", "0");
        str = str.replaceAll("D#", "1");
        str = str.replaceAll("F#", "2");
        str = str.replaceAll("G#", "3");
        str = str.replaceAll("A#", "4");
        return str;
    }

    private int parseTime(String s, String e) {
        String[] t1 = s.split(":");
        String[] t2 = e.split(":");

        return 60 * (Integer.parseInt(t2[0]) - Integer.parseInt(t1[0]))
                + Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]);
    }
}
