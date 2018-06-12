package lt.vu.mif.jate.streams;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import lombok.Getter;
import lombok.ToString;

@ToString
class Course {
    
    @Getter
    private final Set<Person> students = new HashSet<>();
    
    public Course() {
        System.out.println("Creating course!");
    }
    
}

public class StreamDemo05 {

    public static void main(String[] args) {
        List<Person> persons = PersonList.getPersons();
        
        Supplier<Course> supplier = () -> new Course();
        BiConsumer<Course,Person> accumulator = (c, p) -> c.getStudents().add(p);
        BiConsumer<Course, Course> combiner = (c1,c2) -> c1.getStudents().addAll(c2.getStudents());
        
        Course course = persons.parallelStream()
                .filter(p -> p.getAge() > 18)
                .filter(p -> p.getAge() < 22)
                .limit(100)
                .distinct()
                .collect(supplier, accumulator, combiner);
        
        System.out.println(course);
        
    }
    
}
