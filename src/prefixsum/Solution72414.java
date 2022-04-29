package prefixsum;

public class Solution72414 {
    int[] arr;
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toSecond(play_time);
        int advTime = toSecond(adv_time);
        arr = new int[playTime + 1];

        for (String log : logs) {
            String[] times = log.split("-");
            int from = toSecond(times[0]);
            int to = toSecond(times[1]);
            arr[from]++;
            arr[to]--;
        }
        for (int i = 0; i < playTime; i++) {
            arr[i + 1] += arr[i];
        }

        int start = 0;
        int end = advTime;
        long sum = 0;
        for (int i = 0; i < end; i++) sum += arr[i];

        long max = sum;
        int ansTime = 0;
        while (end <= playTime) {
            sum -= arr[start++];
            sum += arr[end++];
            if (sum > max) {
                max = sum;
                ansTime = start;
            }
        }

        return toTime(ansTime);
    }

    String toTime(long second) {
        StringBuilder sb = new StringBuilder();
        long h = second / (60 * 60);
        second = second % (60 * 60);
        long m = second / 60;
        second = second % 60;
        long s = second;
        if(h<10) sb.append('0');
        sb.append(h).append(':');
        if(m<10) sb.append('0');
        sb.append(m).append(':');
        if(s<10) sb.append('0');
        sb.append(s);
        return sb.toString();
    }

    int toSecond(String p) {
        int result = 0;
        String[] time = p.split(":");
        result += Integer.parseInt(time[0]) * 60 * 60;
        result += Integer.parseInt(time[1]) * 60;
        result += Integer.parseInt(time[2]);
        return result;
    }
}
