package lt.vu.mif.jate.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamDemo04 {
    
    public static void main(String[] args) {
        List<Person> persons = PersonList.getPersons();
        System.out.format("# Elements: %d%n", persons.size());
     
        Function<Integer, Person> peronByAge = a -> {
            Person pp = persons.stream().filter(p -> p.getAge() == a).findFirst().orElse(null);
            System.out.println("Looking for person by age " + a + ", found " + pp);
            return pp;
        };

        Predicate<Person> peronByName = p -> {
            System.out.println("Looking for person by name a in " + p);
            return p.getName().startsWith("a");
        };
        
        int[] ages = new int[]{ 12, 23, 33, 43, 53 };
        
        Arrays.stream(ages).boxed()
              .map(peronByAge)
              //.filter(peronByName)
              .forEach(System.out::println);
        
        Person p = Arrays.stream(ages).boxed()
              .map(peronByAge)
              .filter(peronByName)
              .findAny()
              .orElse(null);
        
        System.out.println(p);
    }
    
}
