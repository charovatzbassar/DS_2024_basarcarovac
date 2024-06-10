package homework4;

public class Friendship {
    private String firstFriend, secondFriend;
    private double friendshipStrength;

    public Friendship(String firstFriend, String secondFriend, int friendshipStrength) {
        this.firstFriend = firstFriend;
        this.secondFriend = secondFriend;
        this.friendshipStrength = friendshipStrength;
    }

    public String getFirstFriend() {
        return firstFriend;
    }

    public void setFirstFriend(String firstFriend) {
        this.firstFriend = firstFriend;
    }

    public String getSecondFriend() {
        return secondFriend;
    }

    public void setSecondFriend(String secondFriend) {
        this.secondFriend = secondFriend;
    }

    public double getFriendshipStrength() {
        return friendshipStrength;
    }

    public void setFriendshipStrength(double friendshipStrength) {
        this.friendshipStrength = friendshipStrength;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "firstFriend='" + firstFriend + '\'' +
                ", secondFriend='" + secondFriend + '\'' +
                ", friendshipStrength=" + friendshipStrength +
                '}';
    }
}