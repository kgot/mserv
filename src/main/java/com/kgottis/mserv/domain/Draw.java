/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kgottis.mserv.deserializer.DateTimeDeserializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;

/**
 *
 * @author kostas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Draw {

    @Id
    String kinoDrawId;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    Date drawTime;

    Long drawNo;

    List<Short> results;

    public Draw() {
        results = new ArrayList<>();
    }

    public Draw(String kinoDrawId, Date drawTime, Long drawNo, List<Short> results) {
        this.kinoDrawId = kinoDrawId;
        this.drawTime = drawTime;
        this.drawNo = drawNo;
        this.results = results;
    }

    public Draw(String kinoDrawId, Date drawTime, Long drawNo, Short[] results) {
        this.kinoDrawId = kinoDrawId;
        this.drawTime = drawTime;
        this.drawNo = drawNo;
        this.results = Arrays.asList(results);
    }

    public String getKinoDrawId() {
        return kinoDrawId;
    }

    public void setKinoDrawId(String kinoDrawId) {
        this.kinoDrawId = kinoDrawId;
    }

    public Date getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(Date drawTime) {
        this.drawTime = drawTime;
    }

    public Long getDrawNo() {
        return drawNo;
    }

    public void setDrawNo(Long drawNo) {
        this.drawNo = drawNo;
    }

    public List<Short> getResults() {
        return results;
    }

    public void setResults(List<Short> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Draw{" + "kinoDrawId=" + kinoDrawId + ", drawTime=" + drawTime + ", drawNo=" + drawNo + ", results=" + results + '}';
    }
}
