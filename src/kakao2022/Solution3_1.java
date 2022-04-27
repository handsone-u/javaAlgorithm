package kakao2022;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution3_1 {
    HashMap<String, Integer> carTime = new HashMap<>();
    HashMap<String, String> carPresent = new HashMap<>();
    HashMap<String, Integer> fee = new HashMap<>();

    int calculateMin(String from, String to) {
        String[] f = from.split(":");
        String[] t = to.split(":");
        int result = 0;
        result += 60 * (Integer.parseInt(t[0]) - Integer.parseInt(f[0]));
        result += Integer.parseInt(t[1]) - Integer.parseInt(f[1]);
        return result;
    }

    public int[] solution(int[] fees, String[] records) {
        int basicMin = fees[0];
        int basicFee = fees[1];
        int unitMin = fees[2];
        int unitFee = fees[3];

        for (String record : records) {
            String[] str = record.split(" ");
            String time = str[0];
            String num = str[1];
            String info = str[2];

            if (info.equals("IN")) {
                carTime.put(num, carTime.getOrDefault(num, 0));
                carPresent.put(num, time);
                continue;
            }
            String inTime = carPresent.get(num);
            Integer total = carTime.get(num) + calculateMin(inTime, time);

            carPresent.remove(num);
            carTime.put(num, total);
        }
        for (String num : carPresent.keySet()) {
            String inTime = carPresent.get(num);
            Integer total = carTime.get(num) + calculateMin(inTime, "23:59");

            carTime.put(num, total);
        }

        for (String num : carTime.keySet()) {
            int result = basicFee;
            int time = carTime.get(num);
            time -= basicMin;

            if (time > 0) {
                int unit = time / unitMin;
                if(time%unitMin!=0) unit++;
                result += unit * unitFee;
            }

            fee.put(num, result);
        }

        ArrayList<Car> cars = new ArrayList<>();
        for (String num : fee.keySet()) {
            cars.add(new Car(Integer.parseInt(num), fee.get(num)));
        }

        return cars.stream()
                .sorted()
                .mapToInt(Car::getFee)
                .toArray();
    }

    static class Car implements Comparable<Car>{
        int num;
        int fee;

        public Car(int num, int fee) {
            this.num = num;
            this.fee = fee;
        }

        public int getFee() {
            return fee;
        }

        @Override
        public int compareTo(Car o) {
            return this.num - o.num;
        }
    }
}
