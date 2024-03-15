package week3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {
    public static IPAddress[] readFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            List<String> lines = reader.lines().collect(Collectors.toList());

            List<IPAddress> ipAddresses = new ArrayList<>();

            for (String line : lines) {
                String[] data = line.split(";");
                ipAddresses.add(new IPAddress(Long.parseLong(data[0]), Long.parseLong(data[1]), data[2], data[3], data[4], data[5]));
            }

            reader.close();

            return ipAddresses.toArray(new IPAddress[0]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        } catch (IOException e) {
            System.out.println("Could not close file");
            return null;
        }
    }
}
