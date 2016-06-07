/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

/**
 *
 * @author kostas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KinoDrawDTO {
      
    Long id;

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
        final KinoDrawDTO other = (KinoDrawDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KinoDrawDTO{" + "id=" + id + ", draw=" + draw + '}';
    }
  
}
