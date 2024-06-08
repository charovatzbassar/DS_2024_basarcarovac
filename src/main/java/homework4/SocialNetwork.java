package homework4;

import java.util.*;
import java.util.stream.Collectors;

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
        if (!this.adj.containsKey(user)) {
            return null;
        }

        ArrayList<FriendshipRecommendation> friendshipRecommendations = new ArrayList<>();

        HashMap<String, Double> recommendationStrengths = new HashMap<>();


        for (Friendship friendship : this.adj.get(user)) {
            String currentFriend = getOtherFriend(user, friendship);

            for (Friendship mutualFriendship : this.adj.get(currentFriend)) {
                String mutualFriend = getOtherFriend(currentFriend, mutualFriendship);
                Friendship foundFriendship = findFriendship(this.adj.get(user), user, mutualFriend);

                if (!isInFriendship(user, mutualFriendship) && foundFriendship == null) {
                    recommendationStrengths.putIfAbsent(mutualFriend, 0.0);

                    double strength = Math.min(friendship.getFriendshipStrength(), mutualFriendship.getFriendshipStrength());
                    double newStrength = recommendationStrengths.get(mutualFriend) + strength;
                    recommendationStrengths.put(mutualFriend, newStrength);
                }
            }
        }

        recommendationStrengths.forEach((friend, strength) -> {
            friendshipRecommendations.add(
                    new FriendshipRecommendation(friend, strength)
            );
        });

        return friendshipRecommendations.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
    }

    private String getOtherFriend(String user, Friendship friendship) {
        return friendship.getFirstFriend().equals(user) ? friendship.getSecondFriend() : friendship.getFirstFriend();
    }

    private boolean isInFriendship(String user, Friendship friendship) {
        return friendship.getSecondFriend().equals(user) || friendship.getFirstFriend().equals(user);
    }


    public Friendship findFriendship(ArrayList<Friendship> friendships, String firstFriend, String secondFriend) {
        for (Friendship friendship : friendships) {
            if ((friendship.getFirstFriend().equals(firstFriend) && friendship.getSecondFriend().equals(secondFriend)) || (friendship.getSecondFriend().equals(firstFriend) && friendship.getFirstFriend().equals(secondFriend))) {
                return friendship;
            }
        }
        return null;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

}