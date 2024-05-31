package Question1;

import java.time.Year;

public class Person implements Comparable<Person>{

    private Long id;

    private String name;

    private int birthYear;

    private static final int MIN_ID_LENGTH = 7;
    private static final int MIN_BIRTH_YEAR = 1900;

    public Person(String name, Long id, int birthYear) throws IllegalArgumentException{
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (id == null || String.valueOf(id).length() < MIN_ID_LENGTH) {
            throw new IllegalArgumentException("ID must be at least 7 digits");
        }

        int currentYear = Year.now().getValue();
        if (birthYear <= MIN_BIRTH_YEAR || birthYear >= currentYear) {
            throw new IllegalArgumentException("Birth year must be less than the current year and greater than 1900");
        }

        this.name = name;
        this.id = id;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(other.birthYear, this.birthYear);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Birth Year: " + birthYear;
    }

    public static void main(String[] args) {

        Person p1 = new Person("Alice", 123456789L, 1985);
        Person p2 = new Person("Bob", 987654321L, 1990);
        Person p3 = new Person("Charlie", 456789123L, 1980);
        Person p4 = new Person("Ashton", 123459876L, 1980);

        LinkedList<Person> people = new LinkedList<Person>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        System.out.println("People List:");
        System.out.println(people);

        System.out.println("Oldest Person in List: " + Max.max(people).getContent());

    }
}
