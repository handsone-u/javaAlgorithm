package thread;

import java.util.Random;

import static java.lang.Thread.sleep;

public class TestThread {
    static Random random;
    public static void main(String[] args) {
        random = new Random();
        ThreadA a1 = new ThreadA("thread-A-1");
        ThreadA a2 = new ThreadA("thread-A-2");

        Thread x1 = new Thread(new Target("thread-X-1"));
        Thread x2 = new Thread(new Target("thread-X-2"));

        x1.start();
        x2.start();

        a1.start();
        a2.start();
    }

    static class Target implements Runnable{
        String getName;

        public Target(String getName) {
            this.getName = getName;
        }

        @Override
        public void run() {
            try {
                int millis = random.nextInt(10000);
                System.out.printf("%s :%d\n", getName, millis);
                sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this.getName() = " + getName);
        }
    }

    static class ThreadA extends Thread{
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                int millis = random.nextInt(10000);
                System.out.printf("%s :%d\n", getName(), millis);
                sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this.getName() = " + getName());
        }
    }
}
