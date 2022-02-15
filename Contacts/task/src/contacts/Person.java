package contacts;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements Comparable<Person>{

    private String name;
    private String surname;
    private String number;
    private Scanner scanner;


    Person(Scanner scanner) {
        this.scanner = scanner;
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

    public void setName() {
        System.out.print("Enter the name of the person: ");
        name = scanner.nextLine();
    }

    public void setSurname() {
        System.out.print("Enter the surname of the person: ");
        surname = scanner.nextLine();
    }

    public void setNumber() {
        System.out.print("Enter the number: ");
        var number = scanner.nextLine();
        this.number = hasNumber(number);
    }

    public static Person build(Scanner scanner) {
        Person person = new Person(scanner);
        person.setName();
        person.setSurname();
        person.setNumber();
        return person;
    }

    private String hasNumber(String number) {
        //regex. "+" at the start of number, "-", " " in the middle are optional for all variants of number
        //\+?(((((\(\w+\)((\s|-)?\w{2,}))*|        -> (2)-43234-234234     parentheses for first group
        //          (\w+(\s|-)?\(\w{2,}\)))((\s|-)?\w{2,})*))|     -> 23-(234)-234    parentheses for 2nd group
        //                  (\w+((\s|-)?\w{2,})*))                      -> 234234     without parentheses
        Pattern pattern = Pattern.compile("\\+?(((((\\(\\w+\\)((\\s|-)?\\w{2,})*)" +
                "|(\\w+(\\s|-)?\\(\\w{2,}\\)))((\\s|-)?\\w{2,})*))" +
                "|\\w+((\\s|-)?\\w{2,})*)");

        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) return number;
        System.out.println("Wrong number format!");
        return "";
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
