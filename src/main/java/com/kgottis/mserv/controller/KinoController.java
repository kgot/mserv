package com.kgottis.mserv.controller;

import com.kgottis.mserv.domain.dto.KinoDrawDTO;
import com.kgottis.mserv.service.KinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Kino draws.
 *
 * @author kostas
 */
@RestController
@RequestMapping("/kinodraws")
public class KinoController {

    @Autowired
    private KinoService kinoService;

    /**
     * Returns latest Kino draw.
     *
     * @return kinoDraw dto json
     */
    @RequestMapping(value = "/last", method = RequestMethod.GET)
    public KinoDrawDTO getLast() {
        return kinoService.getLastDraw();
    }
}
