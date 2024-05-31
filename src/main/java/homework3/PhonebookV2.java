package homework3;

import java.io.IOException;

public class PhonebookV2 {
    public static void main(String[] args) throws IOException {
        RedBlackTree<Entry> entries = FileUtils.readFile("raw_phonebook_data.csv");
    }
}