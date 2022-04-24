package model;
//id;match_url;match_id;team_A;team_B;score_tA;score_tB;competition;type_of_match
public class Match {
    private int id;
    private String matchUrl;
    private int matchId;
    private String teamA;
    private String teamB;
    private int scoreA;
    private int scoreB;
    private String competition;
    private String typeOfMatch;

    public Match(String [] components){
        id = Integer.parseInt(components[0]);
        matchUrl = components[1];
        matchId = Integer.parseInt(components[2]);
        teamA = components[3];
        teamB = components[4];
        scoreA = Integer.parseInt(components[5]);
        scoreB = Integer.parseInt(components[6]);
        competition = components[7];
        typeOfMatch = components[8];
    }

    public int getId() {
        return id;
    }

    public String getMatchUrl() {
        return matchUrl;
    }

    public int getMatchId() {
        return matchId;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public String getCompetition() {
        return competition;
    }

    public String getTypeOfMatch() {
        return typeOfMatch;
    }

    @Override
    public String toString() {
        return "CSMatches{" +
                "id=" + id +
                ", matchUrl='" + matchUrl + '\'' +
                ", matchId=" + matchId +
                ", teamA='" + teamA + '\'' +
                ", teamB='" + teamB + '\'' +
                ", scoreA=" + scoreA +
                ", scoreB=" + scoreB +
                ", competition='" + competition + '\'' +
                ", typeOfMatch='" + typeOfMatch + '\'' +
                '}';
    }
}
