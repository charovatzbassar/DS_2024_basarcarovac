package homework1;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookV1 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        String file = "raw_phonebook_data.csv";
        String sortedFile = "raw_phonebook_data_sorted.csv";
        System.out.println("Loading the entries...");
        Entry[] entries = FileUtils.readFile(file);
        System.out.println("Sorting the entries...");
        MergeSort.sort(entries);
        System.out.println("Saving the sorted file...");
        FileUtils.writeToFile(entries, sortedFile);
        System.out.println("============================");
        System.out.println("System is ready.\n");

        while (true) {
            System.out.println("Enter the name that you wish to search for, or -1 to exit: ");

            String searchTerm = scanner.nextLine();

            if (searchTerm.equals("-1")) {
                System.out.println("Thank you for using the phonebook.");
                break;
            }

            int[] search = BinarySearch.search(entries, searchTerm);

            int entriesFound = search[1] - search[0] + 1;

            System.out.println("Entries found: " + entriesFound + "\n");

            for (int i = search[0]; i <= search[1]; i++) {
                System.out.println(entries[i]);
            }

        }

    }
}