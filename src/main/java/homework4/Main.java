package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        SocialNetwork sn = new SocialNetwork(new Scanner(new File("social_network.csv")));
    }
}