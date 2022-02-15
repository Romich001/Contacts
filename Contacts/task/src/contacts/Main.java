package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        try (Scanner scanner = new Scanner(System.in)) {
            point: for (;;) {
                System.out.print("Enter action (add, remove, edit, count, list, exit): ");
                var action = scanner.nextLine();
                switch (action) {
                    case "add":
                        phoneBook.addContact(ContactRecorder.createContact(scanner));
                        break;
                    case "remove":
                        phoneBook.remove(scanner);
                        break;
                    case "edit":
                        phoneBook.edit(scanner);
                        break;
                    case "count":
                        phoneBook.count();
                        break;
                    case "list":
                        phoneBook.list();
                        break;
                    case "exit":
                        break point;
                    default:
                        System.out.println("Error Main ->switch");
                }

            }
        }

    }
}
