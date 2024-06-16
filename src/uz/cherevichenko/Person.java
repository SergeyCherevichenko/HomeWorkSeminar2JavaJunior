package uz.cherevichenko;

import java.time.LocalDateTime;

public class Person {
    private String name;
    private String firstName;
    @RandomDate
    private LocalDateTime birthday;

    public Person() {
        name = "Sergey";
        firstName = "Cherevichenko";
        birthday = LocalDateTime.of(1981, 12, 10, 9, 10);
    }

    public Person(String name, String firstName, LocalDateTime birthday) {
        this.name = name;
        this.firstName = firstName;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
