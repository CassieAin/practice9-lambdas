package task9_5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jane", 21, "female"));
        people.add(new Person("James", 22, "male"));
        people.add(new Person("Andrew", 21, "male"));
        people.add(new Person("Angie", 15, "female"));
        people.add(new Person("Jared", 32, "male"));
        people.add(new Person("Matthew", 18, "male"));
        people.add(new Person("Mary", 29, "female"));
        people.add(new Person("Jessica", 33, "female"));
        people.add(new Person("Sergio", 26, "male"));
        people.add(new Person("Antony", 17, "male"));

        List<Person> warDutyPeople = people.stream()
                .filter(p -> (p.getSex().equals("male") && p.getAge() >= 18 && p.getAge() <= 27))
                .collect(Collectors.toList());
        warDutyPeople.forEach(System.out::println);

        double averageWomenAge = people.stream()
                .filter(p -> p.getSex().equals("female"))
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println("Average women age: " + averageWomenAge);
    }
}
