package com.zeropoint.homemaking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Speciality {
    private Integer id;

    private Integer categoryId;
    @JsonIgnore
    private Integer personnelId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Integer personnelId) {
        this.personnelId = personnelId;
    }
}