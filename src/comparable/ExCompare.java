package comparable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ExCompare {

    public static void main(String[] args) {
        int x = 10;
        ArrayList<TestSubject> list = new ArrayList<>();
        ArrayList<TestSubject2> list2 = new ArrayList<>();
        ArrayList<TestConclude>[] list3 = new ArrayList[2];
        list3[0] = new ArrayList<>();
        list3[1] = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(new TestSubject(random.nextInt(50), ""));
            list2.add(new TestSubject2(random.nextInt(50), ""));
            int val = random.nextInt(10);
            list3[0].add(new TestConclude(i, val));
            list3[1].add(new TestConclude(i, val));
        }

        list.sort(Comparator.reverseOrder());
        list2.sort(new Comparator<TestSubject2>() {
            @Override
            public int compare(TestSubject2 o1, TestSubject2 o2) {
                return o2.getA() - o1.getA();
            }
        });
        list3[0].sort(Comparator
                .comparing(TestConclude::getY, Comparator.reverseOrder())
                .thenComparing(TestConclude::getX,Comparator.reverseOrder()));
        list3[1].sort(Comparator
                .comparing(TestConclude::getY, Comparator.reverseOrder())
                .thenComparing(TestConclude::getX));

        System.out.println("----------");
        list.forEach(t-> System.out.printf("%d ",t.getA()));
        System.out.println("\n----------");
        list2.forEach(t -> System.out.printf("%d ", t.getA()));
        System.out.println("\n----------");
        list3[0].forEach(t-> System.out.printf("(%d,%d) ",t.getY(),t.getX()));
        System.out.println("\n----------");
        list3[1].forEach(t-> System.out.printf("(%d,%d) ",t.getY(),t.getX()));

    }
    static class TestConclude{
        int x;
        int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public TestConclude(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class TestSubject2{
        int a;
        String name;

        public int getA() {
            return a;
        }

        public String getName() {
            return name;
        }

        public TestSubject2(int x, String name) {
            this.a = x;
            this.name = name;
        }
    }

    static class TestSubject implements Comparable{
        private int a;
        private String name;

        public TestSubject(int a, String name) {
            this.a = a;
            this.name = name;
        }

        public int getA() {
            return a;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Object o) {
            return this.a - ((TestSubject) o).getA();
        }
    }
}
