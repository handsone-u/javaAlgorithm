package kakao2022;

import java.util.*;

public class Sol3 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = new int[0];

        int rLen = records.length;
        HashMap<String, Ent> cars = new HashMap<>();

        for (int i = 0; i < rLen; i++) {
            String[] split = records[i].split(" ");
            Ent got = cars.getOrDefault(split[1], new Ent());
            if(split[2].equals("IN")) got.begin.add(split[0]);
            else got.end.add(split[0]);
            cars.put(split[1], got);
        }

        ArrayList<Car> sol = new ArrayList<>();
        for (Map.Entry<String, Ent> entSet : cars.entrySet()) {
            String key = entSet.getKey();
            Ent value = entSet.getValue();
            value.reBalance();
            value.calculate(fees);

            sol.add(new Car(key, value.fee));
        }
        int[] ints = sol.stream().sorted(Comparator.comparing(Car::getNumber)).mapToInt(Car::getFee).toArray();

        return ints;
    }

    static class Car {
        public String number;
        public int fee;

        public Car(String number, int fee) {
            this.number = number;
            this.fee = fee;
        }

        public int getFee() {
            return fee;
        }

        public String getNumber() {
            return number;
        }
    }

    static class Ent{
        public ArrayList<String> begin = new ArrayList<>();
        public ArrayList<String> end = new ArrayList<>();
        public int fee = 0;

        public Ent() {
        }

        public void reBalance() {
            if (begin.size() != end.size()) {
                end.add("23:59");
            }
        }

        public void calculate(int[] fees) {
            int len = begin.size();
            int total = 0;
            for (int i = 0; i < len; i++) {
                String[] e = end.get(i).split(":");
                String[] b = begin.get(i).split(":");
                int gap = (Integer.parseInt(e[0]) - Integer.parseInt(b[0])) * 60 +
                        (Integer.parseInt(e[1]) - Integer.parseInt(b[1]));
                total += gap;
            }

            fee += fees[1];
            if (total > fees[0]) {
                total -= fees[0];
                int m = total / fees[2];
                if(total%fees[2]!=0) m++;
                fee += m * fees[3];
            }
        }
    }
}
