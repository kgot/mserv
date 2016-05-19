/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.service.imp;

import com.kgottis.mserv.config.MongoDBConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.kgottis.mserv.domain.KinoDraw;
import com.kgottis.mserv.persistence.mongo.KinoRepository;
import com.kgottis.mserv.service.KinoService;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author kostas
 */
@Component
public class KinoServiceImp implements KinoService {

    @Autowired
    KinoRepository kinoRepository;

    private Logger logger = LogManager.getLogger(KinoServiceImp.class.getName());

    @Override
    public void saveDraw(KinoDraw kinoDraw) {
        if (kinoDraw != null) {
            try {
                kinoRepository.save(kinoDraw);
            } catch (DuplicateKeyException dkException) {
                logger.trace(dkException.getMessage());
            } catch (MongoException mongoException) {
                logger.trace(mongoException.getMessage());
            }
        }
    }

    @Override
    public KinoDraw getLastDraw() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoDBConfig.class);
        MongoOperations mongoOps = (MongoOperations) ctx.getBean("mongoTemplate");

        Query query = new Query();
        query.limit(1);
        query.with(new Sort(Sort.Direction.DESC, "draw.drawTime"));

        List<KinoDraw> kinoDraws = mongoOps.find(query, KinoDraw.class);
        return kinoDraws.get(0);
    }
}
