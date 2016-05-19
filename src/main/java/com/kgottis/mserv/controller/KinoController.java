/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.controller;

import com.kgottis.mserv.domain.KinoDraw;
import com.kgottis.mserv.service.KinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kostas
 */
@RestController
@RequestMapping("/kinodraws")
public class KinoController {

    @Autowired
    KinoService kinoService;

    @RequestMapping(value = "/last", method = RequestMethod.GET)
    public KinoDraw getLast() {
        return kinoService.getLastDraw();
    }
}
