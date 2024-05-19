package homework1;

import java.io.*;
import java.util.Arrays;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Entry[] entries = reader.lines().map(entry -> {
            String[] line = entry.split(";");
            return new Entry(line[0], line[1], line[2], line[3], line[4], line[5]);
        }).toList().toArray(new Entry[0]);
        reader.close();
        return Arrays.copyOfRange(entries, 1, entries.length);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));



        Arrays.stream(entries).forEach(entry -> {
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