package etc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sol42892 {
    int n;

    public int solution(int[] food_times, long k) {
        int answer = 0;
        int gone = 0;
        Queue<Food> pq = new PriorityQueue<>(Comparator
                .comparing(Food::getRemain)
                .thenComparing(Food::getIndex));

        n = food_times.length;
        for (int i = 0; i < n; i++) pq.add(new Food(i + 1, food_times[i]));

        while (!pq.isEmpty()&&k>=0) {
            Food minFood = pq.peek();
            int remainSize = pq.size();
            int min = minFood.getRemain() - gone;
            long cycle = (long) remainSize * min;
            System.out.printf("%d %d : %d\n", k, min, cycle);

            if (cycle <= k) {
                gone += min;
                k -= cycle;
                pq.poll();
                continue;
            }

            int mod = (int) (k % remainSize);
            int[] indices = pq.stream().sorted(Comparator.comparing(Food::getIndex))
                    .mapToInt(Food::getIndex)
                    .toArray();
            return indices[mod];
        }

        return -1;
    }

    private int getIndex(int[] foods, int k,int min) {
        int result = 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(foods[i]>min) continue;
            cnt++;
            if (cnt >= k) {
                result = i + 1;
                break;
            }
        }

        return result;
    }

    static class Food{
        int index;
        int remain;

        public Food(int index, int remain) {
            this.index = index;
            this.remain = remain;
        }

        public int getIndex() {
            return index;
        }

        public int getRemain() {
            return remain;
        }
    }
}
