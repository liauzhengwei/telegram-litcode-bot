package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class UserData {
    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("num_solved")
    private int numSolved;

    @JsonProperty("num_total")
    private int numTotal;

    @JsonProperty("ac_easy")
    private int acEasy;

    @JsonProperty("ac_medium")
    private int acMedium;

    @JsonProperty("ac_hard")
    private int acHard;

    @JsonProperty("stat_status_pairs")
    private List<StatStatusPair> statStatusPairs;

    private int frequency_high;
    private int frequency_mid;
    private String category_slug;

    public int getFrequency_high() {
        return frequency_high;
    }

    public int getFrequency_mid() {
        return frequency_mid;
    }

    public String getCategory_slug() {
        return category_slug;
    }

    public String getUserName() {
        return userName;
    }

    public int getNumSolved() {
        return numSolved;
    }

    public int getNumTotal() {
        return numTotal;
    }

    public int getAcEasy() {
        return acEasy;
    }

    public int getAcMedium() {
        return acMedium;
    }

    public int getAcHard() {
        return acHard;
    }

    public List<StatStatusPair> getStatStatusPairs() {
        return statStatusPairs;
    }
}