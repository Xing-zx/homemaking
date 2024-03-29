package com.zeropoint.homemaking.domain;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public class Faq {
    private Integer id;

    private String question;

    private String answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}