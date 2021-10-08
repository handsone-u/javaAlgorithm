package lamdaAndStream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class FunctionPackage {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random()*100)+1;
        Consumer<Integer> c = i -> System.out.print(i + " ");
        Predicate<Integer> p = i -> (i % 2) == 0;
        Predicate<Integer> p2 = i -> i < 100;
        Predicate<Integer> p3 = i -> i > 20;
        Function<String, Integer> f1 = Integer::parseInt;
        Function<Integer, String> f2 = Integer::toBinaryString;

        Function<String, String> sToS = f1.andThen(f2);
        Function<Integer, Integer> iToI = f1.compose(f2);

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println("list = " + list);
        printEvenNum(p.and(p3).or(p2), c, list);
        System.out.println();

//        list.stream().map(iToI).forEach(System.out::println);
//        System.out.println(Integer.parseInt("FF", 16));
        methodRef();
        comparingForEach();
    }

    static void methodRef() {
        Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);
        Function<String, Integer> f2 = Integer::parseInt;
        System.out.println("f1.apply(\"1235\") = " + f1.apply("1235"));
        System.out.println("f2.apply(\"1234\") = " + f2.apply("1234"));


    }

    static void comparingForEach() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        IntStream.range(0,20).forEach(i -> integerArrayList.add(i));

        System.out.println("Collection forEach");
        integerArrayList.forEach(System.out::println);
        System.out.println("Stream forEach");
        integerArrayList.stream().forEach(System.out::println);
        System.out.println("ParallelSteam forEach");
        integerArrayList.parallelStream().forEach(System.out::println);
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> l) {
        for (int i = 0; i < 15; i++) l.add(s.get());
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        list.stream().filter(p).forEach(c);
    }
}