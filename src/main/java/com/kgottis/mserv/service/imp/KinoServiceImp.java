package com.kgottis.mserv.service.imp;

import com.kgottis.mserv.domain.KinoDraw;
import com.kgottis.mserv.domain.QKinoDraw;
import com.kgottis.mserv.domain.dto.DrawDTO;
import com.kgottis.mserv.domain.dto.KinoDrawDTO;
import com.kgottis.mserv.persistence.KinoRepository;
import com.kgottis.mserv.service.KinoService;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

/**
 * @author kostas
 */
@Component
class KinoServiceImp implements KinoService {

    @Autowired
    private KinoRepository kinoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private final Logger logger = LogManager.getLogger(KinoServiceImp.class.getName());

    @Override
    public KinoDraw tokinoDraw(KinoDrawDTO kinoDrawDTO) {
        KinoDraw kinoDraw = new KinoDraw();

        BeanUtils.copyProperties(kinoDrawDTO, kinoDraw);

        kinoDraw.setDrawNo(kinoDrawDTO.getDraw().getDrawNo());
        kinoDraw.setDrawTime(kinoDrawDTO.getDraw().getDrawTime());
        kinoDraw.setResults(kinoDrawDTO.getDraw().getResults());

        return kinoDraw;
    }

    @Override
    public KinoDrawDTO toKinoDrawDTO(KinoDraw kinoDraw) {
        KinoDrawDTO kinoDrawDTO = new KinoDrawDTO();
        DrawDTO drawDTO = new DrawDTO();

        BeanUtils.copyProperties(kinoDraw, kinoDrawDTO);
        BeanUtils.copyProperties(kinoDraw, drawDTO, "results");

        drawDTO.setResults(kinoDraw.getResults());
        kinoDrawDTO.setDraw(drawDTO);

        return kinoDrawDTO;
    }

    @Override
    @Transactional
    @CachePut(value = "kinodraws")
    public void saveDraw(KinoDraw kinoDraw) {
        if (kinoDraw == null) return;

        try {
            kinoRepository.save(kinoDraw);
        } catch (ConstraintViolationException | DataIntegrityViolationException ex) {
            logger.warn(ex.getMessage());
        }
    }

    @Override
    @Transactional
    @Cacheable(value = "kinodraws")
    public KinoDrawDTO getLastDraw() {
        QKinoDraw kinoDraw = QKinoDraw.kinoDraw;
        QKinoDraw kd = new QKinoDraw("kd");

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        KinoDraw kDraw = queryFactory.selectFrom(kinoDraw)
            .where(kinoDraw.drawTime.eq(
                JPAExpressions.select(kd.drawTime.max()).from(kd)
            ))
            .fetchOne();

        return toKinoDrawDTO(kDraw);
    }
}
