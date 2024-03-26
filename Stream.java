import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
    public static void main(String[] args) {
        Student[] students = {
                new Student("John",40),
                new Student("Alice",35),
                new Student("Michael",25),
                new Student("Emma",30),
                new Student("David",40),
                new Student("Olivia",35)
        };

        List<String> largestNames = Arrays.stream(students)
                .map(Student::getName) //transforms each Student object into their corresponding names. Student::getName
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .toList();

        List<Integer> oldestAges = Arrays.stream(students)
                .map(Student::getAge)
                .sorted(Comparator.reverseOrder())  // Sort ages in descending order
                .limit(3)  // Select the top 3 ages
                .collect(Collectors.toList());  // Collect them into a List

        System.out.println("Largest 3 names by length:");
        largestNames.forEach(System.out::println);
        /*
        Set<Address> addresses = user.getAddresses();
        return addresses.stream()
          .filter(a -> a.getState().equals(state))
          .collect(Collectors.toSet());

        int count = Stream.of(1, 2, 3, 4, 5)
                    .filter(i -> i <4) // Intermediate Operation filter
                    .count(); // Terminal Operation count
         */
    }
}
