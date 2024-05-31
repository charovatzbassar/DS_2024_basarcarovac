package homework3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class FileUtils {
    public static RedBlackTree<Entry> readFile(String filePath) throws FileNotFoundException, IOException {
        RedBlackTree<Entry> rbt = new RedBlackTree<>();
        AtomicInteger c = new AtomicInteger();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        reader.lines().forEach(entry -> {
            String[] line = entry.split(";");
            Entry newEntry = new Entry(line[0], line[1], line[2], line[3], line[4], line[5]);
            rbt.put(line[0], newEntry);
            c.getAndIncrement();
            System.out.println(c.get());
        });
        reader.close();

        return rbt;
    }
}