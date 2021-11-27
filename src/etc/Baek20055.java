package etc;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Baek20055 {
    static int n, k, wear, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = reader.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        ans = wear = 0;
        LinkedList<Belt> belts = new LinkedList<>();

        Arrays.stream(reader.readLine().split(" "))
                .map(str -> new Belt(Integer.parseInt(str), false))
                .forEach(belts::addLast);
        reader.close();

        while (wear < k) {
            ans++;
            lev1(belts);
            lev2(belts);
            lev3(belts);
            lev4(belts);
        }

        writer.write(Integer.toString(ans));
        writer.flush();
        writer.close();
    }

    static boolean lev1(LinkedList<Belt> belts) {
        Belt last = belts.pollLast();
        belts.addFirst(last);
        return true;
    }

    static boolean lev2(LinkedList<Belt> belts) {
        for (int i = n - 1; i > 0; i--) {
            // i-1 -> i
            Belt belt = belts.get(i);
            if(belt.on||belt.num==0) continue;

            Belt prev = belts.get(i - 1);
            if(!prev.on) continue;

            belt.num--;
            belt.on = true;
            prev.on = false;
            if(belt.num==0) wear++;
        }
        Belt belt = belts.get(n - 1);
        belt.on = false;

        return wear < k;
    }

    static boolean lev3(LinkedList<Belt> belts) {
        Belt belt = belts.get(0);
        if (belt.num>0){
            belt.on = true;
            belt.num--;
            if(belt.num==0) wear++;
        }
        return wear < k;
    }

    static boolean lev4(LinkedList<Belt> belts) {
        return wear < k;
    }

    static class Belt{
        int num;
        boolean on;

        public Belt(int num, boolean on) {
            this.num = num;
            this.on = on;
        }
    }
}
