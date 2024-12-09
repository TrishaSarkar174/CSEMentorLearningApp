package com.hfad.csementorlearningapp.leaderboard;

public class ScoreData {
    private String name, image; // image URL
    private long score;

    public ScoreData() {
        // Default constructor for Firebase
    }

    public ScoreData(String image, String name, long score) {
        this.image = image;
        this.name = name;
        this.score = score;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
