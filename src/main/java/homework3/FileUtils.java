package homework3;

import java.io.*;
import java.util.ArrayList;
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

    public static void writeToFile(ArrayList<Entry> entries, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        entries.forEach(entry -> {
            try {
                String newEntryString = "\n";
                newEntryString = newEntryString.concat(entry.getName()).concat(";")
                        .concat(entry.getStreetAddress()).concat(";")
                        .concat(entry.getCity()).concat(";")
                        .concat(entry.getPostcode()).concat(";")
                        .concat(entry.getCountry()).concat(";")
                        .concat(entry.getPhoneNumber());

                writer.write(newEntryString);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

        writer.close();
    }
}