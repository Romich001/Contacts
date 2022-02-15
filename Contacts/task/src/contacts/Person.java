package contacts;

import java.util.Objects;

public class Person implements Comparable<Person>{

    private String name;
    private String surname;
    private String number;



    Person(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public int compareTo(Person person) {

        if (name.equals(person.name) && surname.equals(person.surname)) return 0;
        else if (!surname.equals(person.surname)) return surname.compareTo(person.surname);
        else return name.compareTo(person.name);
    }



}
