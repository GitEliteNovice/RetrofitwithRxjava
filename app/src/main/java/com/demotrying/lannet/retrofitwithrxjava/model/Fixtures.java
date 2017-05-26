package com.demotrying.lannet.retrofitwithrxjava.model;

/**
 * Created by pooja on 5/25/2017.
 */

public class Fixtures {

    private final String matchday;
    private final String homeTeamName;
    private final String awayTeamName;
    private final String status;
    private final String goalsAwayTeam;
    private final String goalsHomeTeam;

    public Fixtures(String matchday, String homeTeamName, String awayTeamName, String status, String goalsAwayTeam, String goalsHomeTeam) {
        this.matchday = matchday;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.status = status;
        this.goalsAwayTeam = goalsAwayTeam;
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public String getMatchday() {
        return matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public String getStatus() {
        return status;
    }

    public String getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public String getGoalsHomeTeam() {
        return goalsHomeTeam;
    }
}
