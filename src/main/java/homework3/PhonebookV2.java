package homework3;

import java.io.IOException;

public class PhonebookV2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Loading the entries...");
        RedBlackTree<Entry> entries = FileUtils.readFile("raw_phonebook_data.csv");
        int[] edgeCount = entries.countRedAndBlackEdges();
        System.out.println("=======================");
        System.out.println("System is ready.");
        System.out.println("Total \033[0;31mred edges\033[0m in the tree: " + edgeCount[0]);
        System.out.println("Total black edges in the tree: " + edgeCount[1]);


    }
}