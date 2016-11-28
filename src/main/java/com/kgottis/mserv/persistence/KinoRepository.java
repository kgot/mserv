/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.persistence;

import com.kgottis.mserv.domain.KinoDraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author kostas
 */
public interface KinoRepository extends JpaRepository<KinoDraw, Long>, QueryDslPredicateExecutor<KinoDraw> {

}
