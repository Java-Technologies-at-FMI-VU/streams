package lt.vu.mif.jate.streams;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class StreamDemo02 {

    public static void sleep1Sek() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) { }
    }
    
    private static double checkTime(Stream<Person> ps) {
        long startTime = System.nanoTime();
        ps.forEach(e -> sleep1Sek());
        return TimeUnit.SECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
    }
    
    public static void main(String[] args) {
        
        List<Person> persons = PersonList.getPersons();
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("#of cores:" + cores);
        
        System.out.format("Default elapsed: %f%n", checkTime(persons.stream().limit(8)));
        System.out.format("Sequential elapsed: %f%n", checkTime(persons.stream().limit(8).sequential()));
        System.out.format("Parallel elapsed: %f%n", checkTime(persons.stream().limit(8).parallel()));
        
    }
    
}
