/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.liveprojectspringsecurityadvicegenerator.model;

/**
 * @author jose
 */

public class Metric {
    private Integer id;
    private Double value;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
