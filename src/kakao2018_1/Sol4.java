package kakao2018_1;

import java.util.*;

public class Sol4 {
    Map<Integer, Schedule> map = new HashMap<>();
    List<Schedule> list = new ArrayList<>();

    private int findMax(int min,int m) {
        for (Schedule schedule : list) {
            if(schedule.size>=m) continue;
            if(schedule.min>=min) return schedule.min;
        }

        return 0;
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int len = timetable.length;
        int time = toMin("09:00");

        for (int i = 0; i < n; i++) {
            Schedule schedule = new Schedule(time);
            list.add(schedule);
            map.put(schedule.min, schedule);
            time += t;
        }

        int[] mins = Arrays.stream(timetable)
                .mapToInt(s -> toMin(s))
                .sorted()
                .toArray();
        for (int i = 0; i < len; i++) {
            int maxMin = findMax(mins[i], m);
            if(maxMin==0) continue;

            Schedule schedule = map.get(maxMin);

            schedule.add(mins[i]);
            map.put(maxMin, schedule);
        }

//        for (Schedule schedule : list) {
//            System.out.printf("%s %d\n", toTime(schedule.min), schedule.size);
//        }

        Collections.sort(list, Comparator.comparing(Schedule::getMinute, Comparator.reverseOrder()));
        Schedule schedule = list.get(0);
        if (schedule.size < m) {
            answer = toTime(schedule.min);
        } else {
            ArrayList<Integer> arr = schedule.mins;
            int maxMinute = schedule.getMaxMinute();
            answer = toTime(maxMinute - 1);
        }

        return answer;
    }

    static class Schedule{
        private int min;
        private int size;
        private ArrayList<Integer> mins = new ArrayList<>();

        public int getMinute() {
            return min;
        }

        public Schedule(int min) {
            this.min = min;
            this.size = 0;
        }

        public int getMaxMinute() {
            if(size>0) return mins.get(size - 1);
            else return min;
        }

        public void add(int min) {
            mins.add(min);
            size++;
        }
    }

    private int toMin(String time) {
        int result = 0;
        String[] hm = time.split(":");

        result += 60 * Integer.parseInt(hm[0]);
        result += Integer.parseInt(hm[1]);
        return result;
    }

    private String toTime(int min) {
        StringBuilder sb = new StringBuilder();
        int h = min / 60;
        min %= 60;
        if(h<10) sb.append('0');
        sb.append(h);
        sb.append(':');
        if(min<10) sb.append('0');
        sb.append(min);

        return sb.toString();
    }
}
