/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.service;

import com.kgottis.mserv.domain.KinoDraw;
import org.springframework.stereotype.Service;

/**
 *
 * @author kostas
 */
@Service
public interface KinoService {
    
    public void saveKinoDraw(KinoDraw kinoDraw);
}
