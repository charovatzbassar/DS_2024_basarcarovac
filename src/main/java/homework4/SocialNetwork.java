package homework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SocialNetwork {
    private int V;
    private int E;

    private HashMap<String, ArrayList<Friendship>> adj;

    public SocialNetwork() {
        this.V = 0;
        this.E = 0;
        this.adj = new HashMap<>();
    }

    public SocialNetwork(Scanner in) {
        this();
        while (in.hasNextLine()) {
            if (in.nextLine().contains("friendship_strength")) continue;
            String[] line = in.nextLine().split(";");
            Friendship friendship = new Friendship(line[0], line[1], Integer.parseInt(line[2]));
            addUser(line[0]);
            addUser(line[1]);
            addFriendship(friendship);
        }
    }

    public void addUser(String user) {
        if (adj.containsKey(user)) return;

        adj.put(user, new ArrayList<>());
        this.V++;
    }

    public void addFriendship(Friendship f) {
        if (!adj.containsKey(f.getFirstFriend()) || !adj.containsKey(f.getSecondFriend())) return;

        adj.get(f.getFirstFriend()).add(f);
        adj.get(f.getSecondFriend()).add(f);
        this.E += 2;
    }

    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {
        // implement the actual logic (remove next line)
        return null;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }
}