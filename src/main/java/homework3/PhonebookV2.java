package homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Loading the entries...");
        RedBlackTree<Entry> entries = FileUtils.readFile("raw_phonebook_data.csv");
        int[] edgeCount = entries.countRedAndBlackEdges();
        System.out.println("=======================");
        System.out.println("System is ready.");
        System.out.println("Total \033[0;31mred edges\033[0m in the tree: " + edgeCount[0]);
        System.out.println("Total black edges in the tree: " + edgeCount[1] + "\n");

        String searchTerm;

        while (true) {
            System.out.print("Enter a name that you wish to search for, or -1 to exit: ");
            searchTerm = scanner.nextLine();

            if (searchTerm.equals("-1")) {
                System.out.println("Thank you for using the phonebook.");
                break;
            }

            ArrayList<Entry> foundEntries = entries.get(searchTerm);

            if (foundEntries == null) {
                System.out.println("No entries with name " + searchTerm + " exists in the phonebook.");
            } else {
                System.out.println("Entries found: " + foundEntries.size());
                System.out.println("\033[0;31mRed edges\033[0m on the path: " + entries.getPath()[0]);
                System.out.println("Black edges on the path: " + entries.getPath()[1] + "\n");
                for (Entry entry : foundEntries) {
                    System.out.println(entry);
                }
            }
        }

    }
}