package model;

public class GameType {
    private String gameType;
    private int gamesCount;

    public GameType(String gameType, int gamesCount) {
        this.gameType = gameType;
        this.gamesCount = gamesCount;
    }

    public String getGameType() {
        return gameType;
    }

    public int getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(int gamesCount) {
        this.gamesCount = gamesCount;
    }
}
