package lt.vu.mif.jate.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamDemo01 {

    public static void main(String[] args) {
        
        int[] ia = new int[]{ 5, 2, 3, 4, 5, 5, 7, 8, 9, 10, 4, 3, 1, 5, 6, 20, 8, 9 };
        
        System.out.println("Sum");
        System.out.println(Arrays.stream(ia).sum());
        
        System.out.println("Sum * 2");
        System.out.println(Arrays.stream(ia).map(i -> i * 2).sum());
        
        System.out.println("Distinct and sorted");
        Arrays.stream(ia).distinct().sorted().forEach(System.out::println);
        
        System.out.println("Range 1..10");
        IntStream is = IntStream.range(1, 10);
        is.forEach(System.out::println);
        
        System.out.println("Distinct sorted elements 5..7 in string");
        System.out.println(
        Arrays.stream(ia)
            .distinct()
            .boxed()
            .sorted()
            .skip(5).limit(3)
            .map(i -> String.valueOf(i))
            .reduce("i", (x,y) -> x + y)
        );
        
        System.out.println("Count");
        System.out.println(Arrays.stream(ia).boxed().count());
        
        System.out.println("Count differently");
        System.out.println(Arrays.stream(ia).boxed().map(i -> 1L).reduce(0L, (i,j) -> i + j));
        
        
    }
    
}
