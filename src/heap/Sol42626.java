package heap;

import java.util.*;

public class Sol42626 {

    public int solution(int[] scoville, int k) {
        int answer = 0, len = scoville.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(pq::add);

        while (pq.peek() < k&&pq.size()>1) {
            answer++;
            int first = pq.poll(), second = pq.poll();
            int made = first + second * 2;
            pq.add(made);
        }

        return pq.size() > 1 || pq.peek() >= k ? answer : -1;
    }
}
