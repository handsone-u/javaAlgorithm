import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Sol2 {

    HashMap<String, Integer> recipe = new HashMap<String, Integer>();

    public int solution(int n, String[] recipes, String[] orders) {
        int answer = 0;
        PriorityQueue<Time> pq = new PriorityQueue<>(Comparator.comparing(Time::getTodo).thenComparing(Time::getFrom));

        for (String r : recipes) {
            String[] tmp = r.split(" ");
            recipe.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        int currentTime = 0;
        for (String order : orders) {
            String[] tmp = order.split(" ");
            String name = tmp[0];
            int from = Integer.parseInt(tmp[1]);
            int todo = recipe.get(name);

            currentTime = from;
            if (pq.size() < n) {
                pq.add(new Time(from, todo));
                continue;
            }

            while (!pq.isEmpty()) {
                if (currentTime - pq.peek().from >= pq.peek().todo) {
                    pq.poll();
                } else {
                    break;
                }
            }
            if (pq.size() < n) {
                pq.add(new Time(from, todo));
                continue;
            }
            currentTime = pq.peek().from + pq.peek().todo;
            pq.poll();
            pq.add(new Time(currentTime, todo));
        }

        while (!pq.isEmpty()) {
            Time poll = pq.poll();
            if (answer < poll.from + poll.todo) {
                answer = poll.from + poll.todo;
            }
        }

        return answer;
    }

    static class Time{
        int from;
        int todo;

        public int getFrom() {
            return from;
        }

        public int getTodo() {
            return todo;
        }

        public Time(int from, int todo) {
            this.from = from;
            this.todo = todo;
        }
    }
}
