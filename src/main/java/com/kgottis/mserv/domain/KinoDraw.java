/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kgottis.mserv.deserializer.DateTimeDeserializer;
import com.kgottis.mserv.serializer.DateTimeSerializer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Example:
 * {"drawTime":"12-03-2016T20:30:00","drawNo":546098,"results":[63,46,20,68,40,50,8,7,23,1,13,9,38,35,34,54,17,66,61,31]}
 *
 * @author kostas
 */
@Entity
@Table(name = "kino_draw")
@JsonIgnoreProperties(ignoreUnknown = true)
public class KinoDraw implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "draw_time")
    Date drawTime;

    @Column(name = "draw_no")
    Long drawNo;
    
    @Column(name = "n01")
    Short n01;
    
    @Column(name = "n02")
    Short n02;
    
    @Column(name = "n03")
    Short n03;
    
    @Column(name = "n04")
    Short n04;
    
    @Column(name = "n05")
    Short n05;
    
    @Column(name = "n06")
    Short n06;
    
    @Column(name = "n07")
    Short n07;
    
    @Column(name = "n08")
    Short n08;
    
    @Column(name = "n09")
    Short n09;
    
    @Column(name = "n10")
    Short n10;
    
    @Column(name = "n11")
    Short n11;
    
    @Column(name = "n12")
    Short n12;
    
    @Column(name = "n13")
    Short n13;
    
    @Column(name = "n14")
    Short n14;
    
    @Column(name = "n15")
    Short n15;
    
    @Column(name = "n16")
    Short n16;
    
    @Column(name = "n17")
    Short n17;
    
    @Column(name = "n18")
    Short n18;
    
    @Column(name = "n19")
    Short n19;
    
    @Column(name = "n20")
    Short n20;

    @Transient
    List<Short> results = new ArrayList();
    
    public List<Short> getResults() {
        results.add(this.n01);
        results.add(this.n02);
        results.add(this.n03);
        results.add(this.n04);
        results.add(this.n05);
        results.add(this.n06);
        results.add(this.n07);
        results.add(this.n08);
        results.add(this.n09);
        results.add(this.n10);
        results.add(this.n11);
        results.add(this.n12);
        results.add(this.n13);
        results.add(this.n14);
        results.add(this.n15);
        results.add(this.n15);
        results.add(this.n16);
        results.add(this.n17);
        results.add(this.n18);
        results.add(this.n19);
        results.add(this.n20);
             
        return results;
    }
    
    public void setResults(List<Short> results) {
        resultsToNumbers(results);          
    }
    
    public void resultsToNumbers(List<Short> results) {
        this.n01 = results.get(0);
        this.n02 = results.get(1);
        this.n03 = results.get(2);
        this.n04 = results.get(3);
        this.n05 = results.get(4);
        this.n06 = results.get(5);
        this.n07 = results.get(6);
        this.n08 = results.get(7);
        this.n09 = results.get(8);
        this.n10 = results.get(9);
        this.n11 = results.get(10);
        this.n12 = results.get(11);
        this.n13 = results.get(12);
        this.n14 = results.get(13);
        this.n15 = results.get(14);
        this.n16 = results.get(15);
        this.n17 = results.get(16);
        this.n18 = results.get(17);
        this.n19 = results.get(18);
        this.n20 = results.get(19);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Short getN01() {
        return n01;
    }

    public void setN01(Short n01) {
        this.n01 = n01;
    }

    public Short getN02() {
        return n02;
    }

    public void setN02(Short n02) {
        this.n02 = n02;
    }

    public Short getN03() {
        return n03;
    }

    public void setN03(Short n03) {
        this.n03 = n03;
    }

    public Short getN04() {
        return n04;
    }

    public void setN04(Short n04) {
        this.n04 = n04;
    }

    public Short getN05() {
        return n05;
    }

    public void setN05(Short n05) {
        this.n05 = n05;
    }

    public Short getN06() {
        return n06;
    }

    public void setN06(Short n06) {
        this.n06 = n06;
    }

    public Short getN07() {
        return n07;
    }

    public void setN07(Short n07) {
        this.n07 = n07;
    }

    public Short getN08() {
        return n08;
    }

    public void setN08(Short n08) {
        this.n08 = n08;
    }

    public Short getN09() {
        return n09;
    }

    public void setN09(Short n09) {
        this.n09 = n09;
    }

    public Short getN10() {
        return n10;
    }

    public void setN10(Short n10) {
        this.n10 = n10;
    }

    public Short getN11() {
        return n11;
    }

    public void setN11(Short n11) {
        this.n11 = n11;
    }

    public Short getN12() {
        return n12;
    }

    public void setN12(Short n12) {
        this.n12 = n12;
    }

    public Short getN13() {
        return n13;
    }

    public void setN13(Short n13) {
        this.n13 = n13;
    }

    public Short getN14() {
        return n14;
    }

    public void setN14(Short n14) {
        this.n14 = n14;
    }

    public Short getN15() {
        return n15;
    }

    public void setN15(Short n15) {
        this.n15 = n15;
    }

    public Short getN16() {
        return n16;
    }

    public void setN16(Short n16) {
        this.n16 = n16;
    }

    public Short getN17() {
        return n17;
    }

    public void setN17(Short n17) {
        this.n17 = n17;
    }

    public Short getN18() {
        return n18;
    }

    public void setN18(Short n18) {
        this.n18 = n18;
    }

    public Short getN19() {
        return n19;
    }

    public void setN19(Short n19) {
        this.n19 = n19;
    }

    public Short getN20() {
        return n20;
    }

    public void setN20(Short n20) {
        this.n20 = n20;
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KinoDraw{" + "id=" + id + ", drawTime=" + drawTime + ", drawNo=" + drawNo + ", n01=" + n01 + ", n02=" + n02 + ", n03=" + n03 + ", n04=" + n04 + ", n05=" + n05 + ", n06=" + n06 + ", n07=" + n07 + ", n08=" + n08 + ", n09=" + n09 + ", n10=" + n10 + ", n11=" + n11 + ", n12=" + n12 + ", n13=" + n13 + ", n14=" + n14 + ", n15=" + n15 + ", n16=" + n16 + ", n17=" + n17 + ", n18=" + n18 + ", n19=" + n19 + ", n20=" + n20 + '}';
    }
    
    
}
