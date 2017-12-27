package com.kodilla.rps;

public class RpsRules {
    private String PlayerName;
    private int numberOfRounds;

    public String getPlayerName() {
        return PlayerName;
    }
    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }
    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }
}
