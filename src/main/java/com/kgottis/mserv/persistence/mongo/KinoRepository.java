/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.persistence.mongo;

import com.kgottis.mserv.domain.KinoDraw;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author kostas
 */
public interface KinoRepository extends MongoRepository<KinoDraw, String> {

}
