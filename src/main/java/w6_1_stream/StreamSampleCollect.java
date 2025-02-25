package w6_1_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSampleCollect {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList( -10, -20, -30, -40, -50, 0, 10, 20, 30, 40, 50 );
        List<Integer> negativeNums = numbers.stream().filter(x -> x < 0).collect(Collectors.toList());
        System.out.println(negativeNums);  // output = [-10, -20, -30, -40, -50]
    }
}
