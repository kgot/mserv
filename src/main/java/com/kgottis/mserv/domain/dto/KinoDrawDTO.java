/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author kostas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KinoDrawDTO {

    private Long id;

    private DrawDTO draw;

    public KinoDrawDTO() {
    }

    public KinoDrawDTO(Long id, DrawDTO draw) {
        this.id = id;
        this.draw = draw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DrawDTO getDraw() {
        return draw;
    }

    public void setDraw(DrawDTO draw) {
        this.draw = draw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KinoDrawDTO that = (KinoDrawDTO) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "KinoDrawDTO{" + "id=" + id + ", draw=" + draw + '}';
    }

}
