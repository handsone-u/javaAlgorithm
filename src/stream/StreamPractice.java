package stream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamPractice {
    public static void main(String[] args) {
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
        Stream<Double> generate = Stream.generate(Math::random);
    }
}
