package com.kgottis.mserv.controller;

import com.kgottis.mserv.domain.dto.KinoDrawDTO;
import com.kgottis.mserv.service.KinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kostas
 */
@RestController
@RequestMapping("/kinodraws")
public class KinoController {

    @Autowired
    private KinoService kinoService;

    @RequestMapping(value = "/last", method = RequestMethod.GET)
    public KinoDrawDTO getLast() {
        return kinoService.getLastDraw();
    }
}
