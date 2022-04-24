package dataProcessing;

import model.GameType;
import model.Match;
import model.TeamScore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CSMatchesManager {
    private ArrayList<Match> csMatches;
    public CSMatchesManager(){
        csMatches = loadFromCsv();}

    public ArrayList<Match> loadFromCsv(){
        ArrayList<Match> ret = new ArrayList<>();
        ArrayList<String> lines = FileReader.readCSV("HLTV_CSGO_results.csv");
        for(String line : lines){
            String[] components = line.split(";");
            if (components.length != 9) {
                continue;
            }
                try{
                    ret.add(new Match(components));
                }catch (Exception ex){

                }
        }
        return ret;
    }

    public HashMap<String, Integer> getTotalTeamScore(){
        HashMap<String,Integer> ret = new HashMap<>();

        for (Match match : csMatches){
            addTeamScore(match.getTeamA(), match.getScoreA(), ret);
            addTeamScore(match.getTeamB(), match.getScoreB(), ret);
        }

        return ret;
    }

    private void addTeamScore(String teamName, int score, HashMap<String, Integer> map){
        if (map.containsKey(teamName)){
            score += map.get(teamName);
        }
        map.put(teamName,score);
    }

    public ArrayList<GameType> getMostPlayedTypes(){
        ArrayList<GameType> ret = new ArrayList<>();

        for(Match match : csMatches){
            GameType newType = null;
            for (GameType type : ret){
                if (match.getTypeOfMatch().equals(type.getGameType())){
                    newType = type;
                    break;
                }
            }
            if(newType == null){
                newType = new GameType(match.getTypeOfMatch(),0);
                ret.add(newType);
            }
            newType.setGamesCount(newType.getGamesCount() + 1);
        }
        for (int i = 0; i < ret.size(); i++) {
            for (int j = 0; j < ret.size() - 1; j++) {
                if(ret.get(j).getGamesCount() < ret.get(j + 1).getGamesCount()){
                    Collections.swap(ret,j,j+1);
                }
            }
        }
        return ret;
    }
    private int partition (ArrayList<TeamScore> list, int start, int end)
    {
        TeamScore pivot = list.get(end);
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {
            if (list.get(j).getScore() > pivot.getScore()) {
                i++;
                Collections.swap(list,i,j);
            }
        }
        Collections.swap(list,i+1,end);
        return (i + 1);
    }

    private void quick(ArrayList<TeamScore> list, int start, int end) {
        if (start < end) {
            int p = partition(list, start, end);
            quick(list, start, p - 1);
            quick(list, p + 1, end);
        }
    }

    public ArrayList<TeamScore> getBestTeams(int count){
        HashMap<String ,Integer> data = getTotalTeamScore();
        ArrayList<TeamScore> ret = new ArrayList<>();
        for(String key : data.keySet()){
            ret.add(new TeamScore(key,data.get(key)));
        }
        quick(ret,0,ret.size()-1);
        return new ArrayList<>(ret.subList(0,count));
    }
}