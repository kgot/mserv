/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Example:
 * {"drawTime":"12-03-2016T20:30:00","drawNo":546098,"results":[63,46,20,68,40,50,8,7,23,1,13,9,38,35,34,54,17,66,61,31]}
 *
 * @author kostas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "kinoDraws")
public class KinoDraw {

    private Draw draw;

    public Draw getDraw() {
        return draw;
    }

    public void setDraw(Draw draw) {
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
        final KinoDraw other = (KinoDraw) obj;
        if (!Objects.equals(this.draw, other.draw)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KinoDraw{" + "draw=" + draw + '}';
    }  
}
