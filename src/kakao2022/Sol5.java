package kakao2022;

import java.util.*;
import java.util.stream.Collectors;

public class Sol5 {
    Animal tmp = new Animal();
    public int solution(int[] info, int[][] edges) {
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        ArrayList<Animal> toGet = new ArrayList<>();
        for (int i = 0; i < info.length; i++) nodes.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) nodes.get(edges[i][0]).add(edges[i][1]);
        for (int i = 0; i < info.length; i++) {
            if(info[i]==0) {
                tmp = new Animal();
                go(0, i, info, 1, 0, nodes);
                toGet.add(tmp);
            }
        }
        List<Animal> collect = toGet.stream().sorted(Comparator.comparing(Animal::getCompare).reversed()).collect(Collectors.toList());
        int w = 0, s = 1;
        for (Animal animal : collect) {
            System.out.printf("%d: %d, %d", animal.index, animal.s, animal.w);
        }



        return s;
    }

    public void go(int now, int end, int[] info, int s, int w, ArrayList<ArrayList<Integer>> nodes) {
        System.out.println("now = " + now+" "+end);
        if (now == end){
            tmp.set(now, s, w);
            return;
        }
        ArrayList<Integer> next = nodes.get(now);
        for (Integer integer : next) {
            if (info[integer] == 0) {
                go(integer, end, info, s + 1, w, nodes);
            }
            else {
                go(integer, end, info, s, w + 1, nodes);
            }
        }
    }

    static class Animal {
        public int index;
        public int s;
        public int w;

        public Animal() {
            index = s = w = 0;
        }

        public void set(int i, int s, int w) {
            this.index = i;
            this.s = s;
            this.w = w;
        }

        public int getCompare() {
            return s - w;
        }
    }
}
