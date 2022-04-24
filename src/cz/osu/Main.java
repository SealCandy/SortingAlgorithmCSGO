package cz.osu;

import dataProcessing.CSMatchesManager;
import model.GameType;
import model.TeamScore;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        CSMatchesManager csMatchesManager = new CSMatchesManager();
        csMatchesManager.loadFromCsv();
        HashMap<String,Integer> teamsScore = csMatchesManager.getTotalTeamScore();

        System.out.println("#######################");

        for (String key: teamsScore.keySet()){
            System.out.println(key + ": " + teamsScore.get(key));
        }
        System.out.println("#######################");

        ArrayList<GameType> mostPlayedGameTypes = csMatchesManager.getMostPlayedTypes();
        for (GameType type : mostPlayedGameTypes){
            System.out.println(type.getGameType() + ": " + type.getGamesCount());
        }
        System.out.println("#######################");

        ArrayList<TeamScore> topTeams = csMatchesManager.getBestTeams(50);
        for (TeamScore score : topTeams){
            System.out.println(score.getTeamName() + ": " + score.getScore());
        }
    }
}
