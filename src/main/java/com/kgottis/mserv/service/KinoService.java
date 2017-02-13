/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.service;

import com.kgottis.mserv.domain.KinoDraw;
import com.kgottis.mserv.domain.dto.KinoDrawDTO;
import org.springframework.stereotype.Service;

/**
 * Kino game service.
 *
 * @author kostas
 */
@Service
public interface KinoService {

    /**
     * Saves Kino draw to cache and database.
     * Checks the cache before persisting.
     *
     * @param kinoDraw draw entity
     * @return saved entity - might be changed
     */
    KinoDraw save(KinoDraw kinoDraw);

    /**
     * Saves Kino draw to cache and database.
     *
     * @param kinoDraw draw entity
     * @return saved entity - might be changed
     */
    KinoDraw saveDraw(KinoDraw kinoDraw);

    /**
     * Retrieves last Kino draw from cache or database.
     *
     * @return latest draw
     */
    KinoDrawDTO getLast();

    /**
     * Retrieves last Kino draw database.
     *
     * @return latest draw
     */
    KinoDrawDTO getLastDraw();

    /**
     * Transform dto to entity.
     *
     * @param kinoDrawDTO dto
     * @return entity
     */
    KinoDraw tokinoDraw(KinoDrawDTO kinoDrawDTO);

    /**
     * Transform entity to dto.
     *
     * @param kinoDraw entity
     * @return dto
     */
    KinoDrawDTO toKinoDrawDTO(KinoDraw kinoDraw);
}
