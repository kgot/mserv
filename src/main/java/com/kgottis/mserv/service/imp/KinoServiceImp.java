/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.service.imp;

import com.kgottis.mserv.domain.KinoDraw;
import com.kgottis.mserv.domain.QKinoDraw;
import com.kgottis.mserv.domain.dto.DrawDTO;
import com.kgottis.mserv.domain.dto.KinoDrawDTO;
import com.kgottis.mserv.persistence.KinoRepository;
import com.kgottis.mserv.service.KinoService;
import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author kostas
 */
@Component
public class KinoServiceImp implements KinoService {

    @Autowired
    KinoRepository kinoRepository;

    @PersistenceContext
    EntityManager entityManager;

    private final Logger logger = LogManager.getLogger(KinoServiceImp.class.getName());

    @Override
    public void kinoDrawDTOtokinoDraw(KinoDrawDTO kinoDrawDTO, KinoDraw kinoDraw) {
        kinoDraw = kinoDraw == null ? new KinoDraw() : kinoDraw;

        BeanUtils.copyProperties(kinoDrawDTO, kinoDraw);
        
        kinoDraw.setDrawNo(kinoDrawDTO.getDraw().getDrawNo());
        kinoDraw.setDrawTime(kinoDrawDTO.getDraw().getDrawTime());
        kinoDraw.setResults(kinoDrawDTO.getDraw().getResults());
    }

    @Override
    public void kinoDrawToKinoDrawDTO(KinoDraw kinoDraw, KinoDrawDTO kinoDrawDTO) {
        kinoDrawDTO = kinoDrawDTO == null ? new KinoDrawDTO() : kinoDrawDTO;
        DrawDTO drawDTO = new DrawDTO();

        BeanUtils.copyProperties(kinoDraw, kinoDrawDTO);
        BeanUtils.copyProperties(kinoDraw, drawDTO, "results");

        drawDTO.setResults(kinoDraw.getResults());
        kinoDrawDTO.setDraw(drawDTO);
    }

    @Override
    @Transactional
    public void saveDraw(KinoDraw kinoDraw) {
        if (kinoDraw != null)  kinoRepository.save(kinoDraw);
    }

    @Override
    public KinoDrawDTO getLastDraw() {
        KinoDrawDTO kinoDrawDTO = new KinoDrawDTO();

        QKinoDraw kinoDraw = QKinoDraw.kinoDraw;
        QKinoDraw kd = new QKinoDraw("kd");

        JPAQuery query = new JPAQuery(entityManager);

        KinoDraw kDraw = query.from(kinoDraw)
                .where(kinoDraw.drawTime.eq(
                        new JPASubQuery()
                        .from(kd)
                        .unique(kd.drawTime.max())
                ))
                .uniqueResult(kinoDraw);

        kinoDrawToKinoDrawDTO(kDraw, kinoDrawDTO);

        return kinoDrawDTO;
    }
}
