package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatStatusPair {
    private Stat stat;
    private Difficulty difficulty;
    private boolean status;
    private boolean paid_only;
    private boolean is_favor;
    private int frequency;
    private int progress;

    @JsonProperty("stat")
    public Stat getStat(){
        return stat;
    }

    public boolean isStatus() {
        return status;
    }

    @JsonProperty("difficulty")
    public Difficulty getDifficulty() {
        return difficulty;
    }

    public boolean isPaid_only() {
        return paid_only;
    }

    public boolean isIs_favor() {
        return is_favor;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getProgress() {
        return progress;
    }
}
