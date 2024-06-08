package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int amount = 10;
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        System.out.println("Loading the social network...");
        SocialNetwork sn = new SocialNetwork(new Scanner(new File("social_network.csv")));
        System.out.println("Network successfully loaded.");
        System.out.println("Total users: " + sn.getV());
        System.out.println("Total friendships: " + sn.getE());
        System.out.println("====================================\n");
        while (true) {
            System.out.print("Enter a name to recommend for, or -1 to exit: ");
            String choice = scanner.nextLine();

            if (choice.equals("-1")) {
                System.out.println("Thank you for using our friendship recommender algorithm.");
                break;
            }

            ArrayList<FriendshipRecommendation> recommendations = sn.recommendFriends(choice);

            if (recommendations == null) {
                System.out.println("User " + choice + " does not exist in the network.");
            } else {
                System.out.println("Total recommendations: " + recommendations.size());
                System.out.println("Top " + amount + " recommendations based on friendship strength:");
                for (int i = 0; i < amount; i++) {
                    System.out.println(recommendations.get(i).getUser() + ": " + recommendations.get(i).getRecommendationStrength());
                }
            }

        }


    }
}