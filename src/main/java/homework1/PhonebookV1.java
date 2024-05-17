package homework1;

import java.io.IOException;
import java.util.Arrays;

public class PhonebookV1 {
    public static void main(String[] args) throws IOException {
        String file = "raw_phonebook_data.csv";
        Entry[] entries = FileUtils.readFile(file);

        MergeSort.sort(entries);

    }
}