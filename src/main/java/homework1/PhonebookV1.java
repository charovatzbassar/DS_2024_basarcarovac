package homework1;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

public class PhonebookV1 {
    private static final Scanner scanner = new Scanner(System.in);

    private static Comparator<Entry> getComparator(String field) {
        return switch (field) {
            case "name" -> Comparator.comparing(Entry::getName);
            case "country" -> Comparator.comparing(Entry::getCountry);
            case "phoneNumber" -> Comparator.comparing(Entry::getPhoneNumber);
            case "postcode" -> Comparator.comparing(Entry::getPostcode);
            case "city" -> Comparator.comparing(Entry::getCity);
            case "streetAddress" -> Comparator.comparing(Entry::getStreetAddress);
            default -> null;
        };
    }

    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchFieldException {
        String file = "raw_phonebook_data.csv";
        String sortedFile = "raw_phonebook_data_sorted.csv";
        System.out.println("Loading the entries...");
        Entry[] entries = FileUtils.readFile(file);
        Comparator<Entry> comparator = null;
        String field = "";

        while (comparator == null) {
            System.out.println("Which field you want to search by?");
            field = scanner.nextLine();
            comparator = getComparator(field);

            if (comparator == null) {
                System.out.println("The field " + field + " does not exist.");
            }
        }

        System.out.println("Sorting the entries...");
        MergeSort.sort(entries, comparator);
        System.out.println("Saving the sorted file...");
        FileUtils.writeToFile(entries, sortedFile);
        System.out.println("============================");
        System.out.println("System is ready.\n");

        while (true) {
            System.out.println("Enter the search term, or -1 to exit: ");

            String searchTerm = scanner.nextLine();

            if (searchTerm.equals("-1")) {
                System.out.println("Thank you for using the phonebook.");
                break;
            }

            int[] search = BinarySearch.search(entries, searchTerm, field);

            if (search[0] == -1 && search[1] == -1) {
                System.out.println("No entries found under that search term.");
                continue;
            }

            int entriesFound = search[1] - search[0] + 1;


            for (int i = search[0]; i <= search[1]; i++) {
                System.out.println(entries[i]);
            }

            System.out.println("Entries found: " + entriesFound + "\n");
        }

    }
}