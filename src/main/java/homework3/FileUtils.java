package homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileUtils {
    public static RedBlackTree<Entry> readFile(String filePath) throws IOException {
        RedBlackTree<Entry> rbt = new RedBlackTree<>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String[] entries = reader.lines().filter(entry -> !entry.equals("name;street_address;city;postcode;country;phone_number")).toList().toArray(new String[0]);

        Arrays.stream(entries).forEach(entry -> {
            String[] line = entry.split(";");
            Entry newEntry = new Entry(line[0], line[1], line[2], line[3], line[4], line[5]);
            rbt.put(line[0], newEntry);
        });

        reader.close();

        return rbt;
    }
}