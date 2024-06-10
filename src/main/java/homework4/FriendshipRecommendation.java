package homework4;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    private String user;
    private double recommendationStrength;

    public FriendshipRecommendation(String user, double recommendationStrength) {
        this.user = user;
        this.recommendationStrength = recommendationStrength;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getRecommendationStrength() {
        return recommendationStrength;
    }

    public void setRecommendationStrength(double recommendationStrength) {
        this.recommendationStrength = recommendationStrength;
    }

    @Override
    public int compareTo(FriendshipRecommendation o) {
        return Double.compare(this.recommendationStrength, o.getRecommendationStrength());
    }

    @Override
    public String toString() {
        return "FriendshipRecommendation{" +
                "user='" + user + '\'' +
                ", recommendationStrength=" + recommendationStrength +
                '}';
    }
}