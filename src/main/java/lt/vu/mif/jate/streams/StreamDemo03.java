package lt.vu.mif.jate.streams;

import java.util.Arrays;
import java.util.List;

public class StreamDemo03 {
    
    public static void main(String[] args) {
        List<Person> persons = PersonList.getPersons();
        System.out.format("# Elements: %d%n", persons.size());
     
        System.out.println("# Persons for age:");
        int[] ages = new int[]{ 12, 23, 33, 43, 53 };
        Arrays.stream(ages)
            .mapToObj(a -> persons.stream().filter(p -> p.getAge() == a).findFirst().orElse(null))
            .forEach(System.out::println);
        
        System.out.println("# Persons for name:");
        String[] names = new String[]{ "ab", "bc", "cd", "de", "ef", "aaa" };
        Arrays.stream(names)
            .map(n -> persons.stream().filter(p -> p.getName().equals(n)).findFirst().orElse(null))
            .forEach(System.out::println);

    
    }
    
}
