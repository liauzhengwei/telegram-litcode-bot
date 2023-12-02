package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stat {
    private int question_id;
    private boolean question__article__live;
    private String question__article__slug;
    private boolean question__article__has_video_solution;
    private String question__title;
    private String question__title_slug;
    private boolean question__hide;
    private int total_acs;
    private int total_submitted;
    private int frontend_question_id;
    private boolean is_new_question;

    @JsonProperty("question_id")
    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    @JsonProperty("question__title")
    public String getQuestion__title() {
        return question__title;
    }

    @JsonProperty("question__title_slug")
    public String getQuestion__title_slug() {
        return question__title_slug;
    }

    public boolean isQuestion__hide() {
        return question__hide;
    }

    public int getFrontend_question_id() {
        return frontend_question_id;
    }

    public boolean isQuestion__article__live() {
        return question__article__live;
    }

    public String isQuestion__article__slug() {
        return question__article__slug;
    }

    public boolean isQuestion__article__has_video_solution() {
        return question__article__has_video_solution;
    }

    public int getTotal_acs() {
        return total_acs;
    }

    public int getTotal_submitted() {
        return total_submitted;
    }

    public boolean isIs_new_question() {
        return is_new_question;
    }
}
