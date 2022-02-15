package contacts;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactRecorder {


    public static Person createContact(Scanner scanner) {

        var name = receiveName(scanner);
        var surname = receiveSurname(scanner);
        var number = receiveNumber(scanner);
        return new Person(name, surname, number);

    }

    public static String receiveSurname(Scanner scanner) {
        System.out.print("Enter the surname of the person: ");
        return scanner.nextLine();
    }

    public static String receiveNumber(Scanner scanner) {
        System.out.print("Enter the number: ");
        var number = scanner.nextLine();
        return hasNumber(number);
    }

    public static String receiveName(Scanner scanner) {
        System.out.print("Enter the name of the person: ");
        return scanner.nextLine();
    }

    private static String hasNumber(String number) {
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
}
