package homework4;

public class Friendship {
    private String firstFriend, secondFriend;
    private int friendshipStrength;

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

    public int getFriendshipStrength() {
        return friendshipStrength;
    }

    public void setFriendshipStrength(int friendshipStrength) {
        this.friendshipStrength = friendshipStrength;
    }
}