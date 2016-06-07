/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kgottis.mserv.deserializer.DateTimeDeserializer;
import com.kgottis.mserv.serializer.DateTimeSerializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author kostas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DrawDTO {

    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    Date drawTime;

    Long drawNo;

    List<Short> results;

    public DrawDTO() {
        results = new ArrayList<>();
    }

    public DrawDTO(String kinoDrawId, Date drawTime, Long drawNo, List<Short> results) {
        this.drawTime = drawTime;
        this.drawNo = drawNo;
        this.results = results;
    }

    public DrawDTO(String kinoDrawId, Date drawTime, Long drawNo, Short[] results) {
        this.drawTime = drawTime;
        this.drawNo = drawNo;
        this.results = Arrays.asList(results);
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
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DrawDTO other = (DrawDTO) obj;
        if (!Objects.equals(this.drawNo, other.drawNo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DrawDTO{" + "drawTime=" + drawTime + ", drawNo=" + drawNo + ", results=" + results + '}';
    }  
}
