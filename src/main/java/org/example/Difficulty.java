package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Difficulty {
    private int level;

    @JsonProperty("level")
    public int getLevel() {
        return level;
    }
}
