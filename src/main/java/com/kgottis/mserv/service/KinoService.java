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
 * @author kostas
 */
@Service
public interface KinoService {

    void saveDraw(KinoDraw kinoDraw);

    KinoDrawDTO getLastDraw();

    KinoDraw tokinoDraw(KinoDrawDTO kinoDrawDTO);

    KinoDrawDTO toKinoDrawDTO(KinoDraw kinoDraw);
}
