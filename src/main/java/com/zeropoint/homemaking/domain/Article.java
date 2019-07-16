package com.zeropoint.homemaking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Article {
    private Integer id;

    private String title;

    private String author;

    private Date time;

    private Integer state;

    private Integer views;
    @JsonIgnore
    private String coverImg1;
    @JsonIgnore
    private String coverImg2;
    @JsonIgnore
    private String coverImg3;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getCoverImg1() {
        return coverImg1;
    }

    public void setCoverImg1(String coverImg1) {
        this.coverImg1 = coverImg1;
    }

    public String getCoverImg2() {
        return coverImg2;
    }

    public void setCoverImg2(String coverImg2) {
        this.coverImg2 = coverImg2;
    }

    public String getCoverImg3() {
        return coverImg3;
    }

    public void setCoverImg3(String coverImg3) {
        this.coverImg3 = coverImg3;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getCoverImgs(){
        String[] imgs = {coverImg1,coverImg2,coverImg3};
        return imgs;
    }
}