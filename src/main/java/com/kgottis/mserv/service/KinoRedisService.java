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
 * Kino game service for redis data store.
 *
 * @author kostas
 */
@Service
public interface KinoRedisService {

    /**
     * Saves draw to cache with last draw key.
     *
     * @param kinoDraw entity
     * @return kinoDraw entity
     */
    KinoDraw saveDraw(KinoDraw kinoDraw);

    /**
     * Retrieves last draw from cache if exists.
     *
     * @return latest Kino draw or null
     */
    KinoDraw getLast();

    /**
     * Checks if draw number is the latest in cache (by last draw key).
     *
     * @param drawNo draw number
     * @return true if is latest
     */
    Boolean isLast(Long drawNo);
}
