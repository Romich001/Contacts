package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneBook {

    private final List<Person> phoneBook = new ArrayList<>();
    //regex. "+" at the start of number, "-", " " in the middle are optional for all variants of number
    //\+?(((((\(\w+\)((\s|-)?\w{2,}))+|        -> (2)-43234-234234     parentheses for first group
    //          (\w+(\s|-)?\(\w{2,}\)))((\s|-)?\w{2,})+))|     -> 23-(234)-234    parentheses for 2nd group
    //                  (\w+((\s|-)?\w{2,})+))                      -> 234234     without parentheses
    public Pattern pattern;

    public PhoneBook() {
        pattern = Pattern.compile("\\+?(((((\\(\\w+\\)((\\s|-)?\\w{2,}))+" +
                "|(\\w+(\\s|-)?\\(\\w{2,}\\)))((\\s|-)?\\w{2,})+))" +
                "|(\\w+((\\s|-)?\\w{2,})+))");
    }


    public void addContact(Person person) {
        phoneBook.add(person);
        System.out.println("The record added.");
    }

    public void list() {
        for (int i = 0; i < phoneBook.size(); i++) {
            var contact = phoneBook.get(i);
            var name = contact.getName();
            var surname = contact.getSurname();
            var number = contact.getNumber();
            if (number.equals("")) number = "[no number]";
            System.out.printf("%d. %s %s, %s.%n", i + 1, name, surname, number);
        }
    }

    public void remove(Scanner scanner) {
        if (phoneBook.size() == 0) {
            System.out.println("No records to remove!");
            return;
        }
        list();
        System.out.print("Select a record: ");
        var index = scanner.nextInt() - 1;
        scanner.nextLine();
        phoneBook.remove(index);
        System.out.println("The record removed!");
    }
    public void count() {
        System.out.printf("The phonebook has %d records.%n", phoneBook.size());
    }

    public void edit(Scanner scanner) {
        if (phoneBook.size() == 0) {
            System.out.println("No records to edit!");
            return;
        }
        list();
        System.out.print("Select a record: ");
        var index = scanner.nextInt() - 1;
        scanner.nextLine();
        var contact = phoneBook.get(index);
        System.out.print("Select a field (name, surname, number): ");
        var field = scanner.nextLine();
        switch (field) {
            case "name":
                contact.setName();
                break;
            case "surname":
                contact.setSurname();
                break;
            case "number":
                contact.setNumber();
                break;
            default:
                System.out.println("wrong PhoneBook -> edit");
        }
        System.out.println("The record updated!");

    }



}
