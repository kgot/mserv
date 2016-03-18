/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.service.imp;

import com.kgottis.mserv.domain.KinoDraw;
import com.kgottis.mserv.persistence.KinoRepository;
import com.kgottis.mserv.service.KinoService;
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

    @Override
    public void saveKinoDraw(KinoDraw kinoDraw) {
        if (kinoDraw != null) kinoRepository.save(kinoDraw);
    }
}
