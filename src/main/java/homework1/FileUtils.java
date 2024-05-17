package homework1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Entry[] entries = reader.lines().map(entry -> {
            String[] line = entry.split(";");
            return new Entry(line[0], line[1], line[2], line[3], line[4], line[5]);
        }).toList().toArray(new Entry[0]);
        reader.close();
        return entries;
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        // implement the actual logic
    }
}