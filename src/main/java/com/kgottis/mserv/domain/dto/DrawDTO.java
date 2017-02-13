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

/**
 * @author kostas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DrawDTO {

    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date drawTime;

    private Long drawNo;

    private List<Short> results;

    public DrawDTO() {
        results = new ArrayList<>();
    }

    public DrawDTO(Date drawTime, Long drawNo, List<Short> results) {
        this.drawTime = drawTime;
        this.drawNo = drawNo;
        this.results = results;
    }

    public DrawDTO(Date drawTime, Long drawNo, Short[] results) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrawDTO drawDTO = (DrawDTO) o;

        return drawNo != null ? drawNo.equals(drawDTO.drawNo) : drawDTO.drawNo == null;
    }

    @Override
    public int hashCode() {
        return drawNo != null ? drawNo.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DrawDTO{" + "drawTime=" + drawTime + ", drawNo=" + drawNo + ", results=" + results + '}';
    }
}
