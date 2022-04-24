package model;

public class TeamScore {
    private String teamName;
    private int score;

    public TeamScore(String teamName, int score) {
        this.teamName = teamName;
        this.score = score;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getScore() {
        return score;
    }
}
